package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

public class Controller {

    private static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(150);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label label = new Label(message);
        Button button3 = new Button("3 天");
        Button button4 = new Button("4 天");
        button3.setOnAction(e -> {
            answer = true;
            window.close();
        });
        button4.setOnAction(e -> {
            answer = false;
            window.close();
        });

        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, button3, button4);

        Scene scene = new Scene(layout, 200, 200);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

}
