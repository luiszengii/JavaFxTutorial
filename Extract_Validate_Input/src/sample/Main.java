package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        //User Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("乖乖打个数字给我");

        //confirm input
        button = new Button("确认");
        button.setOnAction(e -> isNumber(nameInput, nameInput.getText()));

        //Layout
        GridPane grid = new GridPane();
        GridPane.setConstraints(button, 1,2);
        GridPane.setConstraints(nameInput, 1,1);
        grid.setPadding(new Insets(10,10,10,10));
        grid.getChildren().addAll(button, nameInput);


        window.setTitle("反省反省");
        window.setScene(new Scene(grid, 300, 275));
        window.show();
    }

    public boolean isNumber(TextField input, String message){
        try{
            int age = Integer.parseInt(input.getText());
            System.out.println("你的长度是： " + age);
        } catch (NumberFormatException e) {
            System.out.println("傻逼");
        }
        return true;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
