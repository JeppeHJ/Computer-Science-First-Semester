package Opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Kombiner navne");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName2 = new TextField();
    private final TextField txfName1 = new TextField();
    private final TextField txfName3 = new TextField();
    private final TextField txfName4 = new TextField();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        pane.add(txfName1, 0, 0);

        pane.add(txfName2, 1, 0);
        pane.add(txfName3, 0, 1, 2, 3);

        Button combine = new Button("Combine names");
        pane.add(combine, 0, 4);
        combine.setOnAction(event -> combineName());


        // CheckBox to indicate upper / lower case
    }

    // -------------------------------------------------------------------------

    private void combineName() {
        StringBuilder name = new StringBuilder();
        name.append(txfName1.getText().trim() + " ");
        name.append(txfName2.getText().trim());
        txfName3.setText(name.toString());
    }

    private void lowerCaseAction() {
        String name = txfName2.getText().trim();
        txfName2.setText(name.toLowerCase());
    }
}
