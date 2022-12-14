package guifx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import src.Model.Tilmelding;

public class TilmeldingPaneBekraeft extends Stage {

    private Tilmelding tilmelding;
    private TextField pris;
    private TilmeldingPaneHotel hotels;

    public TilmeldingPaneBekraeft(Tilmelding tilmelding, Stage owner, TilmeldingPaneHotel hotels) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);
        this.hotels = hotels;
        this.tilmelding = tilmelding;
        this.pris = new TextField();

        this.setTitle("Vælg hotel");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        Button bekraeft = new Button("Bekraeft tilmelding");
        pane.add(bekraeft, 0, 1);
        bekraeft.setOnAction(event -> this.tilmeldingBekræftet());

        pane.add(pris, 1, 1);
        pris.setText(String.valueOf(this.tilmelding.getSamletPris()));
        pris.setEditable(false);

    }

    private void tilmeldingBekræftet() {
        this.close();
        hotels.close();

    }
}
