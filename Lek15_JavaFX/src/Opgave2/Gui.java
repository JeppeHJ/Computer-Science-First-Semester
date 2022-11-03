package Opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Swap frame");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName2 = new TextField();
    private final TextField txfName1 = new TextField();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        pane.add(txfName1, 0, 0);

        pane.add(txfName2, 0, 1);

        Button combine = new Button("Swap");
        pane.add(combine, 0, 2);
        combine.setOnAction(event -> swapFrame());


        // CheckBox to indicate upper / lower case
    }

    // -------------------------------------------------------------------------

    private void swapFrame() {
        String temp = txfName1.getText().trim();
        txfName1.setText(txfName2.getText());
        txfName2.setText(temp);

    }

    private void lowerCaseAction() {
        String name = txfName2.getText().trim();
        txfName2.setText(name.toLowerCase());
    }
}
