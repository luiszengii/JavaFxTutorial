package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    Stage window = new Stage();
    Label label = new Label("今天我们，吃点好的");

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;


        //layout embedded-----------------------------------------------------------------
        HBox topMenu = new HBox(20);
        Button buttonA = new Button("请宁点一点");
        Button buttonB = new Button("请宁点两点");
        Button buttonC = new Button("请宁点3点");
        topMenu.getChildren().addAll(buttonA, buttonB, buttonC);
        topMenu.setAlignment(Pos.TOP_CENTER);

        VBox leftMenu = new VBox(20);
        Button buttonD = new Button("请宁点D点");
        Button buttonE = new Button("请宁点E点");
        Button buttonF = new Button("请宁点F点");
        leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);
        leftMenu.setAlignment(Pos.BASELINE_LEFT);

        BorderPane broderpane = new BorderPane();
        broderpane.setTop(topMenu);
        broderpane.setLeft(leftMenu);


        //GRID---------------------------------------------------------------------------
        //grid pane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name label
        Label nameLabel = new Label("Username: ");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField("Luis(Default)");
        GridPane.setConstraints(nameInput, 1,0);

        //Passwd label
        Label passwdLabel = new Label("Password: ");
        GridPane.setConstraints(passwdLabel, 0, 1);

        //Passwd Input
        TextField passwdInput = new TextField();
        passwdInput.setPromptText("password");
        GridPane.setConstraints(passwdInput, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1,2);

        grid.getChildren().addAll(nameLabel, nameInput, passwdInput, passwdLabel, loginButton);
//---------------------------------------------------------------------------------------------------------


        Scene scene = new Scene(grid,300,200);

        window.setTitle("好看的排版谁不爱呢");
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
