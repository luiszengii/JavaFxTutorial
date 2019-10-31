package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
            "water",
            "MandM",
            "BBQ",
            "chicken"
        );
        comboBox.setPromptText("What do you want to add?");
        comboBox.setEditable(true);
        comboBox.setOnAction( e -> System.out.println("user selected a new product"));


        button = new Button("add to shopping cart");
        button.setOnAction(e -> addProduct(comboBox));

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBox, button);


        window.setTitle("带menu的新窗口");
        window.setScene(new Scene(layout, 300, 275));
        window.show();
    }

    public void addProduct(ComboBox<String> choiceBox){
        String p = choiceBox.getValue();
        System.out.println(p + " has been added to shopping cart");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
