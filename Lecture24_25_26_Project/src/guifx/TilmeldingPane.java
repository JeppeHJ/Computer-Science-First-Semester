package guifx;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import src.Controller.Controller;
import src.Model.Udflugt;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import src.Model.*;


public class TilmeldingPane extends GridPane {

    private final ListView<Konference> lvwKonference = new ListView<>();
    private final TextArea beskrivelse = new TextArea();
    private final ListView<Udflugt> lvwUdflugter = new ListView();
    private final ListView<Hotel> lvwHoteller = new ListView();
    private TilmeldingPaneDeltagerInfo deltagerInfoVindue;
    private Stage stage;

    public TilmeldingPane() {
        this.stage = new Stage();
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);


        this.add(lvwKonference, 0, 0);
        lvwKonference.setPrefHeight(100);
        lvwKonference.setPrefWidth(100);
        lvwKonference.getItems().setAll(Controller.getKonference());

        this.add(lvwHoteller, 0, 1);
        lvwHoteller.setPrefHeight(50);
        lvwHoteller.setPrefWidth(50);

        this.add(lvwUdflugter, 1, 1);
        lvwUdflugter.setPrefHeight(50);
        lvwUdflugter.setPrefWidth(50);

        this.add(beskrivelse, 1, 0);


        HBox buttonBox = new HBox(20);
        Button tilmeldKnap = new Button("Tilmeld");
        tilmeldKnap.setOnAction(event -> this.tilmeldKonference());
        buttonBox.getChildren().add(tilmeldKnap);
        this.add(buttonBox, 0, 2);

        ChangeListener<Konference> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwKonference.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwKonference.getSelectionModel().clearSelection();


    }


    //-------BUTTON ACTION---------

    private void tilmeldKonference() {
        Konference selected = lvwKonference.getSelectionModel().getSelectedItem();
        if (!(selected == null)) {
            deltagerInfoVindue = new TilmeldingPaneDeltagerInfo("Deltageroplysninger", stage, selected);
            deltagerInfoVindue.showAndWait();
            lvwKonference.getItems().setAll(Controller.getKonference());
        }
    }

    private void sletKonference() {
        Konference selected = lvwKonference.getSelectionModel().getSelectedItem();
        Controller.deleteKonference(selected);
        lvwKonference.getItems().setAll(Controller.getKonference());

    }

    //-------SELECTION--------
    private void selectionChanged() {
        Konference selected = lvwKonference.getSelectionModel().getSelectedItem();
        if (selected != null) {
            beskrivelse.setText(selected.getBeskrivelse());
            lvwHoteller.getItems().setAll(Controller.getKonferenceHoteller(selected));
            lvwUdflugter.getItems().setAll(Controller.getKonferenceUdflugter(selected));
        }
    }
}
