package Opgave4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Count");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName1 = new TextField();


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        pane.add(txfName1, 1, 1);
        txfName1.setText("50");


        Label number = new Label("Number:");
        pane.add(number, 0, 1);

        Button add = new Button("+");
        pane.add(add, 2, 0);
        add.setOnAction(event -> add());

        Button subtract = new Button("-");
        pane.add(subtract, 2, 2);
        subtract.setOnAction(event -> subtract());


        // CheckBox to indicate upper / lower case
    }

    // -------------------------------------------------------------------------

    private void add() {
        int count = Integer.parseInt(txfName1.getText());
        count += 1;
        String newCount = String.valueOf(count);
        txfName1.setText(newCount);
    }

    private void subtract() {
        int count = Integer.parseInt(txfName1.getText());
        count -= 1;
        String newCount = String.valueOf(count);
        txfName1.setText(newCount);
    }
}
