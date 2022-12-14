package guifx;

import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import src.Controller.Controller;
import src.Model.Hotel;
import src.Model.Service;
import src.Model.Tilmelding;
import src.Model.Udflugt;


public class TilmeldingPaneHotel extends Stage {

    private Tilmelding tilmelding;
    private TilmeldingPaneDeltagerInfo deltagerInfo;

    private boolean ledsager;
    private TilmeldingPaneBekraeft nytBekraeftVindue;
    private CheckBox wifi;
    private CheckBox bad;
    private CheckBox mad;
    private CheckBox enkeltVærelse;
    private CheckBox doubleVærelse;
    private boolean wifiYes;
    private boolean badYes;
    private boolean madYes;
    private boolean enkeltVærelseYes;
    private boolean doubleVærelseYes;
    private Label lblWifi;
    private Label lblBad;
    private Label lblMad;
    private Label lblEnkeltVærelse;
    private Label lvlDoubleVærelse;
    private TilmeldingPaneUdflugt udflugt;

    public TilmeldingPaneHotel(String title, Stage owner, Tilmelding tilmelding, TilmeldingPaneUdflugt udflugt) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.udflugt = udflugt;
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);
        this.tilmelding = tilmelding;

        this.setTitle("Vælg hotel");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public TilmeldingPaneHotel(Stage owner, Tilmelding tilmelding, TilmeldingPaneDeltagerInfo deltagerInfo) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);
        this.tilmelding = tilmelding;
        this.deltagerInfo = deltagerInfo;

        this.setTitle("Vælg hotel");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private final ListView<Hotel> lvwHoteller = new ListView<>();
    private Stage stage;

    private void initContent(GridPane pane) {
        pane.add(lvwHoteller, 0, 0);
        lvwHoteller.setPrefHeight(400);
        lvwHoteller.setPrefWidth(400);
        lvwHoteller.getItems().setAll(tilmelding.getKonference().getHoteller());

        this.lblWifi = new Label();
        this.lblBad = new Label();
        this.lblMad = new Label();
        this.lblEnkeltVærelse = new Label();
        this.lvlDoubleVærelse = new Label();

        this.wifi = new CheckBox();
        this.bad = new CheckBox();
        this.mad = new CheckBox();
        this.enkeltVærelse = new CheckBox();

        pane.add(lblWifi, 0, 2);
        pane.add(lblBad, 0, 3);
        pane.add(lblMad, 0, 4);
        pane.add(lblEnkeltVærelse, 0, 5);
        pane.add(lvlDoubleVærelse, 0, 6);

        pane.add(wifi, 1, 2);
        pane.add(bad, 1, 3);
        pane.add(mad, 1, 4);
        pane.add(enkeltVærelse, 1, 5);


        HBox buttonBox = new HBox(20);
        Button sletKnap = new Button("Cancel");
        Button opretKnap = new Button("Næste");
        opretKnap.setOnAction(event -> this.okVaelgHotel());
        buttonBox.getChildren().add(sletKnap);
        buttonBox.getChildren().add(opretKnap);
        pane.add(buttonBox, 0, 7);

        wifi.setOnAction(event -> {
            if (wifi.isSelected()) {
                this.wifiYes = true;
            } else {
                this.wifiYes = false;
            }});

        bad.setOnAction(event -> {
            if (bad.isSelected()) {
                this.badYes = true;
            } else {
                this.badYes = false;
            }});

        mad.setOnAction(event -> {
            if (mad.isSelected()) {
                this.madYes = true;
            } else {
                this.madYes = false;
            }});

        enkeltVærelse.setOnAction(event -> {
            if (enkeltVærelse.isSelected()) {
                this.enkeltVærelseYes = true;
            } else {
                this.enkeltVærelseYes = false;
            }});

        ChangeListener<Hotel> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwHoteller.getSelectionModel().clearSelection();


    }


    //-------BUTTON ACTION---------

    private void okVaelgHotel() {
        Hotel selected = lvwHoteller.getSelectionModel().getSelectedItem();
        tilmelding.addHotel(selected);
        Service service = new Service(wifiYes, badYes, madYes, selected, enkeltVærelseYes);
        tilmelding.addService(service);
        nytBekraeftVindue = new TilmeldingPaneBekraeft(tilmelding, stage, this);
        if (!(udflugt == null)) {
            udflugt.close();
        }
        if (!(deltagerInfo == null)) {
            deltagerInfo.close();
        }
        nytBekraeftVindue.showAndWait();

    }

    //-------SELECTION--------
    private void selectionChanged() {
        Hotel selected = lvwHoteller.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lblWifi.setText("Wifi " + "(" + String.valueOf(selected.getPrisNetflix()) + ")");
            lblBad.setText("Bad " + "(" + String.valueOf(selected.getPrisBad()) + ")");
            lblMad.setText("Mad " + "(" + String.valueOf(selected.getPrisMad()) + ")");
            lblEnkeltVærelse.setText("Enkeltværelse " + "(" + String.valueOf(selected.getTotalPrisDage()) + ")");
            lvlDoubleVærelse.setText("Doubleværelse " + "(" + String.valueOf(selected.getTotalPrisDageDouble()) + ")");
        }
    }
}


