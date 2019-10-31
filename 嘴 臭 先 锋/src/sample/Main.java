package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import java.awt.*;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Label label1 = new Label("听点劝");
        Label label2 = new Label("贱不贱呐");
        Button button1 = new Button("别点");
        Button button2 = new Button("滚回去");

        button1.setOnAction(e -> window.setScene(scene2));
        button2.setOnAction(e -> window.setScene(scene1));

        VBox layout1 = new VBox(20);
        label1.setAlignment(Pos.TOP_CENTER);
        button1.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200,200);

        VBox layout2 = new VBox(80);
//        label2.setAlignment(Pos.TOP_CENTER);
//        button2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layout2, 200, 200);

        window.setScene(scene1);
        window.setTitle("嘴臭先锋");
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
