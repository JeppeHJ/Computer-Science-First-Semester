package demoopenwindow;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OpretHotelPane extends Stage {

    public OpretHotelPane(String title, Stage owner) {

        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle("Opret Hotel");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfNavn = new TextField();
    private final TextField txfLokation = new TextField();
    private final TextField txfWifiPris = new TextField();
    private final TextField txfBadPris = new TextField();
    private final TextField txfMadPris = new TextField();
    private Movie actualMovie;

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 0);

        Label lblLokation = new Label("Lokation:");
        pane.add(lblLokation, 0, 1);

        Label lblWifiPris = new Label("WiFi pris:");
        pane.add(lblWifiPris, 0, 2);

        Label lblBadPris = new Label("Bad pris:");
        pane.add(lblBadPris, 0, 3);

        Label lblMadPris = new Label("Mad pris:");
        pane.add(lblMadPris, 0, 4);

        pane.add(txfNavn, 1, 0, 2, 1);

        pane.add(txfLokation, 1, 1, 2, 1);

        pane.add(txfWifiPris, 1, 2, 2, 1);

        pane.add(txfBadPris, 1, 3, 2, 1);

        pane.add(txfMadPris, 1, 4, 2, 1);

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 6);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.TOP_RIGHT);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void cancelAction() {
        txfNavn.clear();
        txfNavn.requestFocus();
        txfLokation.clear();
        txfWifiPris.clear();
        txfBadPris.clear();
        txfMadPris.clear();
        actualMovie = null;
        //OpretKonferencePane.this.hide();
    }

    private void okAction() {
        String navn = txfNavn.getText().trim();
        String lokation = txfLokation.getText().trim();
        int wifiPris = Integer.parseInt(txfWifiPris.getText().trim());
        int badPris = Integer.parseInt(txfBadPris.getText().trim());
        int madPris = Integer.parseInt(txfLokation.getText().trim());


        if (navn.length() > 0 && lokation.length() > 0 && wifiPris >= 0 && badPris >= 0 && madPris >= 0) {
            actualMovie = new Movie(navn, lokation);
            txfNavn.clear();
            txfLokation.clear();
            txfWifiPris.clear();
            txfBadPris.clear();
            txfMadPris.clear();
            txfNavn.requestFocus();
            //OpretKonferencePane.this.hide();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Opret Hotel");
            alert.setHeaderText("Information mangler");
            alert.setContentText("Alle felter skal være udfyldt!");
            alert.show();
        }
    }

    // -------------------------------------------------------------------------

    public Movie getActualMovie() {
        return actualMovie;
    }

    public void clearActualMovie() {
        actualMovie = null;
    }
}

