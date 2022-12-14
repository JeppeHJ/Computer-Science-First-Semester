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

public class OpretKonferencePane extends Stage {

    public OpretKonferencePane(String title, Stage owner) {

        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle("Opret Konference");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfNavn = new TextField();
    private final TextField txfLokation = new TextField();
    private final TextField txfDato = new TextField();
    private final TextField txfBeskrivelse = new TextField();
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

        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 0, 2);

        Label lblBeskrivelse = new Label("Beskrivelse:");
        pane.add(lblBeskrivelse, 0, 3);


        pane.add(txfNavn, 1, 0, 2, 1);

        pane.add(txfLokation, 1, 1, 2, 1);

        pane.add(txfDato, 1, 2, 2, 1);

        txfBeskrivelse.setPrefHeight(100);
        pane.add(txfBeskrivelse, 1, 3, 2, 1);

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
        txfDato.clear();
        txfBeskrivelse.clear();
        actualMovie = null;
        OpretKonferencePane.this.hide();
    }

    private void okAction() {
        String navn = txfNavn.getText().trim();
        String lokation = txfLokation.getText().trim();
        String dato = txfDato.getText().trim();
        String beskrivelse = txfBeskrivelse.getText().trim();

        if (navn.length() > 0 && lokation.length() > 0 && dato.length() > 0 && beskrivelse.length() > 0) {
            actualMovie = new Movie(navn, lokation);
            txfNavn.clear();
            txfLokation.clear();
            txfDato.clear();
            txfBeskrivelse.clear();
            txfNavn.requestFocus();
            OpretKonferencePane.this.hide();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Opret Konference");
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

