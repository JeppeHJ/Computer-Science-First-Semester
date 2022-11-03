package Opgave5;

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
    private final TextField txfName2 = new TextField();


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        pane.add(txfName1, 0, 0);
        txfName1.setText("Celsius");

        pane.add(txfName2, 1, 0);
        txfName2.setText("Fahrenheit");

        Button add = new Button("Celsius -> Fahrenheit");
        pane.add(add, 0, 1);
        add.setOnAction(event -> celsiusToFahrenheit());

        Button subtract = new Button("Fahrenheit -> Celsius");
        pane.add(subtract, 0, 2);
        subtract.setOnAction(event -> fahrenheitToCelsius());


        // CheckBox to indicate upper / lower case
    }

    // -------------------------------------------------------------------------

    private void celsiusToFahrenheit() {
        double temp = Double.parseDouble(txfName1.getText());
        temp = 9.0 / 5.0 * temp + 32;
        String fahrenheit = String.valueOf(temp);
        txfName2.setText(fahrenheit);
    }

    private void fahrenheitToCelsius() {
        double temp = Double.parseDouble(txfName2.getText());
        temp = 5.0/9.0 * (temp - 32);
        String fahrenheit = String.valueOf(temp);
        txfName1.setText(fahrenheit);
    }
}
