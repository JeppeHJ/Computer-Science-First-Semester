package guifx;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import src.Controller.Controller;

import src.Model.*;

public class HotelPane extends GridPane {

    private final ListView<Hotel> lvwHotel = new ListView<>();

    private final TextArea txfHotel = new TextArea();
    private final ListView<Tilmelding> lvwHotelTilmeldinger = new ListView<>();

    private OpretHotelPane nytHotelVindue;
    private Stage stage;



    public HotelPane() {
        //this.setGridLinesVisible(true);
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);

        this.add(lvwHotel, 0, 0);
        lvwHotel.setPrefHeight(200);
        lvwHotel.setPrefWidth(200);
        lvwHotel.getItems().setAll(Controller.getHotels());

        this.add(lvwHotelTilmeldinger, 1, 0);


        HBox buttonBox = new HBox(20);
        Button sletKnap = new Button("Slet");
        Button opretKnap = new Button("Opret");
        opretKnap.setOnAction(event -> this.opretNytHotel());
        sletKnap.setOnAction(event -> this.sletHotel());
        buttonBox.getChildren().add(sletKnap);
        buttonBox.getChildren().add(opretKnap);
        this.add(buttonBox, 0, 2);

        ChangeListener<Hotel> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwHotel.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwHotel.getSelectionModel().clearSelection();
    }

        //-------BUTTON ACTION---------

        private void opretNytHotel() {
            nytHotelVindue = new OpretHotelPane("Opret Hotel", stage);
            nytHotelVindue.showAndWait();
            lvwHotel.getItems().setAll(Controller.getHotels());
            }
        private void sletHotel() {
            Hotel selected = lvwHotel.getSelectionModel().getSelectedItem();
            Controller.deleteHotel(selected);
            lvwHotel.getItems().setAll(Controller.getHotels());
        }

        //-------SELECTION--------
        private void selectionChanged() {
            Hotel selected = lvwHotel.getSelectionModel().getSelectedItem();
            if (selected != null) {
                lvwHotelTilmeldinger.getItems().setAll(Controller.getHotelTilmeldinger(selected));

            }
        }
}



