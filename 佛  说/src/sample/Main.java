package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Button button;
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        VBox layout = new VBox(20);

        window.setOnCloseRequest(e -> {
            e.consume();//tell system we are taking control
            howManyDaysLeft();
        });

        button = new Button("佛说");
        button.setOnAction(actionEvent -> howManyDaysLeft());

        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(button);

        window.setTitle("我向佛祖许愿");
        window.setScene(new Scene(layout, 300, 275));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void howManyDaysLeft() {
        Boolean answer = Controller.display("几天", "不     行， 只      有");
        if (answer) {
            window.close();
        }
    }
}
