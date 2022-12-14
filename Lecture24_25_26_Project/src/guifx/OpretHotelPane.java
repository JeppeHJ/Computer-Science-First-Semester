package guifx;

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
import src.Controller.Controller;
import src.Model.Hotel;

public class OpretHotelPane extends Stage {

    public OpretHotelPane(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }

    // -------------------------------------------------------------------------

    private final TextField txfNavn = new TextField();
    private final TextField txfLokation = new TextField();
    private final TextField txfPrisPerDagEnkel = new TextField();
    private final TextField txfPrisPerDagDouble = new TextField();
    private final TextField txfWifiPris = new TextField();
    private final TextField txfBadPris = new TextField();
    private final TextField txfMadPris = new TextField();

    private Hotel nytHotel;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 0);

        Label lblLokation = new Label("Lokation:");
        pane.add(lblLokation, 0, 1);

        Label lblPrisPerDag = new Label("Enkeltværelse pris:");
        pane.add(lblPrisPerDag, 0, 2);

        Label lblPrisPerDagDouble = new Label("Doubleværelse pris:");
        pane.add(lblPrisPerDagDouble, 0, 3);

        Label lblWifiPris = new Label("WiFi pris:");
        pane.add(lblWifiPris, 0, 4);

        Label lblBadPris = new Label("Bad pris:");
        pane.add(lblBadPris, 0, 5);

        Label lblMadPris = new Label("Mad pris:");
        pane.add(lblMadPris, 0, 6);

        pane.add(txfNavn, 1, 0, 2, 1);

        pane.add(txfLokation, 1, 1, 2, 1);

        pane.add(txfPrisPerDagEnkel, 1, 2, 2, 1);
        txfPrisPerDagEnkel.setText("0");

        pane.add(txfPrisPerDagDouble, 1, 3, 2, 1);
        txfPrisPerDagDouble.setText("0");

        pane.add(txfWifiPris, 1, 4, 2, 1);
        txfWifiPris.setText("0");

        pane.add(txfBadPris, 1, 5, 2, 1);
        txfBadPris.setText("0");

        pane.add(txfMadPris, 1, 6, 2, 1);
        txfMadPris.setText("0");

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 7);
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
        txfPrisPerDagEnkel.clear();
        txfPrisPerDagDouble.clear();
        txfWifiPris.clear();
        txfBadPris.clear();
        txfMadPris.clear();
        nytHotel = null;
        OpretHotelPane.this.hide();
    }

    private void okAction() {
        String navn = txfNavn.getText().trim();
        String lokation = txfLokation.getText().trim();
        double prisPerDagEnkelt = Double.parseDouble(txfPrisPerDagEnkel.getText().trim());
        double prisPerDagDouble = Double.parseDouble(txfPrisPerDagDouble.getText().trim());
        double wifiPris = Double.parseDouble(txfWifiPris.getText().trim());
        double badPris = Double.parseDouble(txfBadPris.getText().trim());
        double madPris = Double.parseDouble(txfMadPris.getText().trim());


        if (navn.length() > 0 && !navn.isBlank() &&
                lokation.length() > 0 && !lokation.isBlank() && wifiPris >= 0
                && badPris >= 0 && madPris >= 0 && prisPerDagDouble >= 0 && prisPerDagEnkelt >= 0)
        {
            Controller.createHotel(navn, lokation, prisPerDagEnkelt, prisPerDagDouble ,wifiPris, badPris, madPris);
            txfNavn.clear();
            txfLokation.clear();
            txfPrisPerDagEnkel.clear();
            txfPrisPerDagDouble.clear();
            txfWifiPris.clear();
            txfBadPris.clear();
            txfMadPris.clear();
            txfNavn.requestFocus();
            OpretHotelPane.this.hide();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Opret Hotel");
            alert.setHeaderText("Information mangler");
            alert.setContentText("Alle felter skal være udfyldt!");
            alert.show();
        }
    }

    // -------------------------------------------------------------------------

    public Hotel getNytHotel() {
        return nytHotel;
    }

    public void clearNytHotel() {
        nytHotel = null;
    }
}

