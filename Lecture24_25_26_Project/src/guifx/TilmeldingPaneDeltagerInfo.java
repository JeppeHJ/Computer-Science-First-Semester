package guifx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import src.Controller.Controller;
import src.Model.Konference;
import src.Model.Ledsager;
import src.Model.Tilmelding;

public class TilmeldingPaneDeltagerInfo extends Stage {

    public TilmeldingPaneDeltagerInfo(String title, Stage owner, Konference konference) {

        this.initOwner(owner);
        this.stage = owner;
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);
        this.konference = konference;

        this.setTitle("Deltageroplysninger");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private boolean firma;

    private Konference konference;
    private boolean foredragsholder;
    private boolean ledsager;

    private Stage stage;
    private TilmeldingPaneHotel paneHotel;

    private TilmeldingPaneUdflugt nytPaneUdflugt;
    private final TextField txfNavn = new TextField();
    private final TextField txfAdresse = new TextField();
    private final TextField txfTelefonNummer = new TextField();
    private final TextField txfEmail = new TextField();
    private final CheckBox radioButtonFirma = new CheckBox();
    private final CheckBox radioButtonForedragsholder = new CheckBox();
    private final CheckBox radioButtonLedsager = new CheckBox();
    private final TextField txfLedsagerNavn = new TextField();

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 0);

        Label lblLokation = new Label("Lokation:");
        pane.add(lblLokation, 0, 1);

        Label lblDato = new Label("Telefonnummer:");
        pane.add(lblDato, 0, 2);

        Label lblPris = new Label("Email:");
        pane.add(lblPris,0,3);

        Label lblBeskrivelse = new Label("Firma:");
        pane.add(lblBeskrivelse, 0, 4);

        Label lblForedragsholder = new Label("Foredragsholder");
        pane.add(lblForedragsholder, 0, 5);

        Label lblLedsager = new Label("Ledsager");
        pane.add(lblLedsager, 0, 6);


        pane.add(txfNavn, 1, 0, 2, 1);

        pane.add(txfAdresse, 1, 1, 2, 1);

        pane.add(txfTelefonNummer, 1, 2, 2, 1);

        pane.add(txfEmail,1,3,2,1);

        pane.add(radioButtonFirma, 1, 4, 2, 1);

        pane.add(radioButtonForedragsholder, 1, 5, 2, 1);

        pane.add(radioButtonLedsager, 1, 6, 2, 1);

        pane.add(txfLedsagerNavn, 2, 6, 2, 1);


        radioButtonFirma.setOnAction(event -> {
                    if (radioButtonFirma.isSelected()) {
                        this.firma = true;
                    } else {
                        this.firma = false;
                    }});

        radioButtonForedragsholder.setOnAction(event -> {
            if (radioButtonForedragsholder.isSelected()) {
                this.foredragsholder = true;
            } else {
                this.foredragsholder = false;
            }});

        radioButtonLedsager.setOnAction(event -> {
            if (radioButtonLedsager.isSelected()) {
                this.ledsager = true;
            } else {
                this.ledsager = false;
            }});


        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 7);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.TOP_RIGHT);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("Næste");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void cancelAction() {
        txfNavn.clear();
        txfNavn.requestFocus();
        txfAdresse.clear();
        txfTelefonNummer.clear();
        TilmeldingPaneDeltagerInfo.this.hide();
    }

    //Funktion der kaldes, når man trykker på OK knappen. Trækker info ud fra tekstfelterne.
    //Opretter et ledsager-objekt, hvis der er checkmarket ledsager
    //Opretter derefter et Tilmelding-objekt, HVIS alle tekstfelter er udfyldt
    private void okAction() {
        String navn = txfNavn.getText().trim();
        String adresse = txfAdresse.getText().trim();
        String telefonNummer = txfTelefonNummer.getText().trim();
        String email = txfEmail.getText().trim();

        Ledsager ledsagerObjekt = null;
        if (ledsager) {
            ledsagerObjekt = Controller.createLedsager(txfLedsagerNavn.getText().trim());
        }

        if (navn.length() > 0 && adresse.length() > 0 && telefonNummer.length() > 0) {
            Tilmelding tilmelding = Controller.createTilmelding(navn, adresse, telefonNummer, email, firma, foredragsholder,null, ledsagerObjekt, null, konference);
            txfNavn.clear();
            txfAdresse.clear();
            txfTelefonNummer.clear();
            if (ledsager) {
                nytPaneUdflugt = new TilmeldingPaneUdflugt("Opret Hotel", stage, tilmelding, ledsager, this);
                nytPaneUdflugt.showAndWait();
            } else {
                paneHotel = new TilmeldingPaneHotel(stage,tilmelding,this);
                paneHotel.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Opret Konference");
            alert.setHeaderText("Information mangler");
            alert.setContentText("Alle felter skal være udfyldt!");
            alert.show();
        }
    }

    // -------------------------------------------------------------------------

    //public Movie getActualMovie() {
    //return actualMovie;
    //}

    //public void clearActualMovie() {
    //actualMovie = null;
    //}
}



