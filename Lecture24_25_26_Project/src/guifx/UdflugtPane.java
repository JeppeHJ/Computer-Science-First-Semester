package guifx;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import src.Controller.Controller;
import javafx.scene.control.ListView;

import src.Model.*;


public class UdflugtPane extends GridPane {


    //--------------------------------------------------------------------------------------------------------------


    private final ListView<Udflugt> lvwUdflugter = new ListView<>();
    private final ListView<Ledsager> lvwUdflugtTilmelder = new ListView<>();

    private OpretUdflugtPanes nyUdflugtVindue;
    private Stage stage;

    public UdflugtPane(){
        this.setGridLinesVisible(true);
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);



        this.add(lvwUdflugter, 0, 0);
        lvwUdflugter.setPrefHeight(200);
        lvwUdflugter.setPrefWidth(200);
        lvwUdflugter.getItems().setAll(Controller.getUdflugter());

        this.add(lvwUdflugtTilmelder, 1, 0);


        HBox buttonBox = new HBox(20);
        Button sletKnap = new Button("Slet");
        Button opretKnap = new Button("Opret");
        opretKnap.setOnAction(event -> this.opretNyUdflugt());
        sletKnap.setOnAction(event -> this.sletUdflugt());
        buttonBox.getChildren().add(sletKnap);
        buttonBox.getChildren().add(opretKnap);
        this.add(buttonBox, 0, 2);

        ChangeListener<Udflugt> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwUdflugter.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwUdflugter.getSelectionModel().clearSelection();


    }

    //-------BUTTON ACTION---------

    private void opretNyUdflugt() {
        nyUdflugtVindue = new OpretUdflugtPanes("Opret Udflugt", stage);
        nyUdflugtVindue.showAndWait();
        lvwUdflugter.getItems().setAll(Controller.getUdflugter());

    }
    private void sletUdflugt() {
        Udflugt selected = lvwUdflugter.getSelectionModel().getSelectedItem();
        Controller.deleteUdflugt(selected);
        lvwUdflugter.getItems().setAll(Controller.getUdflugter());

    }

    //-------SELECTION--------
    private void selectionChanged() {
        Udflugt selected = lvwUdflugter.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lvwUdflugtTilmelder.getItems().setAll(Controller.getUdflugtTilmeldinger(selected));
        }
    }
}
