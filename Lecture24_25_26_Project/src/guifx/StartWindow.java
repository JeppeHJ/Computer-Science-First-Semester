package guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import src.Controller.Controller;


public class StartWindow extends Application {


//        @Override
//        public void init() {
//            Controller.initStorage();
//        }

    @Override
    public void start(Stage stage) {
        Controller.initStorage();
        stage.setTitle("Arcitecture Demo");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();

        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }


    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabKonference = new Tab("Konference");
        tabPane.getTabs().add(tabKonference);
        tabKonference.setContent(new KonferencePane());
        tabPane.getSelectionModel().isEmpty();

        Tab tabHotel = new Tab("Hotel");
        tabHotel.setContent(new HotelPane());
        tabPane.getTabs().add(tabHotel);

        Tab tabUdflugt =new Tab("Udflugt");
        tabUdflugt.setContent(new UdflugtPane());
        tabPane.getTabs().add(tabUdflugt);

        Tab tabTilmeld = new Tab("Tilmeld");
        tabTilmeld.setContent(new TilmeldingPane());
        tabPane.getTabs().add(tabTilmeld);


    }

}




