package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //getItems() returns the list which you can choose
        choiceBox.getItems().addAll("water", "Mars", "MandM");
        //set a default value
        choiceBox.setValue("water");
        //set choiceBox listener, listen for selection changes, v for observable
        choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue));


        button = new Button("add to shopping cart");
        button.setOnAction(e -> addProduct(choiceBox));

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox, button);

        window.setTitle("带menu的新窗口");
        window.setScene(new Scene(layout, 300, 275));
        window.show();
    }

    public void addProduct(ChoiceBox<String> choiceBox){
        String p = choiceBox.getValue();
        System.out.println(p + " has been added to shopping cart");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
