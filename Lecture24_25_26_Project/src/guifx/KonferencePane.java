package guifx;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import src.Controller.Controller;
import src.Model.Konference;
import javafx.scene.control.ListView;

import src.Model.*;


public class KonferencePane extends GridPane {
    private final ListView<Konference> lvwKonference = new ListView<>();
    private final ListView<Tilmelding> lvwKonferenceTilmeldinger = new ListView<>();
    private final ListView<Udflugt> lvwUdflugter = new ListView();
    private final ListView<Hotel> lvwHoteller = new ListView();

    private final TextField txfKonference = new TextField();

    private OpretKonferencePane nytKonferenceVindue;
    private Stage stage;

    public KonferencePane(){
        //this.setGridLinesVisible(true);
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

        this.add(lvwKonferenceTilmeldinger, 1, 0);


        HBox buttonBox = new HBox(20);
        Button sletKnap = new Button("Slet");
        Button opretKnap = new Button("Opret");
        opretKnap.setOnAction(event -> this.opretNyKonference());
        sletKnap.setOnAction(event -> this.sletKonference());
        buttonBox.getChildren().add(sletKnap);
        buttonBox.getChildren().add(opretKnap);
        this.add(buttonBox, 0, 2);

        ChangeListener<Konference> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwKonference.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwKonference.getSelectionModel().clearSelection();


    }



    //-------BUTTON ACTION---------

    private void opretNyKonference() {
        nytKonferenceVindue = new OpretKonferencePane("Opret Konference", stage);
        nytKonferenceVindue.showAndWait();
        lvwKonference.getItems().setAll(Controller.getKonference());

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
            lvwKonferenceTilmeldinger.getItems().setAll(Controller.getKonferenceTilmeldinger(selected));
            lvwHoteller.getItems().setAll(Controller.getKonferenceHoteller(selected));
            lvwUdflugter.getItems().setAll(Controller.getKonferenceUdflugter(selected));
        }
        }
}
