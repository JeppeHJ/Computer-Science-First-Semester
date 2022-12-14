package guifx;

import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import src.Controller.Controller;
import javafx.scene.control.ListView;

import src.Model.*;



public class TilmeldingPaneUdflugt extends Stage {

    private Tilmelding tilmelding;
    private TextArea textArea = new TextArea();
    private boolean ledsager;
    private TilmeldingPaneDeltagerInfo deltagerInfo;

    public TilmeldingPaneUdflugt(String title, Stage owner, Tilmelding tilmelding, boolean ledsager, TilmeldingPaneDeltagerInfo deltagerInfo) {
        this.stage = owner;
        this.deltagerInfo = deltagerInfo;
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);
        this.tilmelding = tilmelding;
        this.ledsager = ledsager;

        this.setTitle("Vælg udflugt");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private final ListView<Udflugt> lvwUdflugter = new ListView<>();

    private TilmeldingPaneHotel nyUdflugtHotelVindue;
    private Stage stage;

    private void initContent(GridPane pane) {
        pane.add(lvwUdflugter, 0, 0);
        lvwUdflugter.setPrefHeight(200);
        lvwUdflugter.setPrefWidth(200);
        lvwUdflugter.getItems().setAll(Controller.getUdflugter());

        pane.add(textArea, 0, 1);


        HBox buttonBox = new HBox(20);
        Button sletKnap = new Button("Cancel");
        Button opretKnap = new Button("Næste");
        opretKnap.setOnAction(event -> this.okVaelgUdflugt());
        buttonBox.getChildren().add(sletKnap);
        buttonBox.getChildren().add(opretKnap);
        pane.add(buttonBox, 0, 2);

        ChangeListener<Udflugt> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwUdflugter.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwUdflugter.getSelectionModel().clearSelection();


    }


    //-------BUTTON ACTION---------

    private void okVaelgUdflugt() {
        Udflugt selected = lvwUdflugter.getSelectionModel().getSelectedItem();
        if (ledsager) {
            tilmelding.getLedsager().addUdflugter(selected);
        }
        nyUdflugtHotelVindue = new TilmeldingPaneHotel("Opret Udflugt", stage, tilmelding, this);
        deltagerInfo.close();
        nyUdflugtHotelVindue.showAndWait();
        lvwUdflugter.getItems().setAll(Controller.getUdflugter());

    }

    //-------SELECTION--------
    private void selectionChanged() {
        Udflugt selected = lvwUdflugter.getSelectionModel().getSelectedItem();
        if (selected != null) {
            textArea.setText(selected.getBeskrivelse());
        }
    }
}


