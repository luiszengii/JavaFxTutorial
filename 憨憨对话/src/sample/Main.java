package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.invoke.SwitchPoint;

public class Main extends Application {

    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{

        button = new Button("@醉酒行为大赏");
        button.setOnAction(e -> {
            boolean result = Controller.display("@醉酒行为实录", "今天你喝了吗？");
            if (result == true) {
                System.out.println("喝了啥？\n");
            } else {
                System.out.println("准备喝点啥？\n");
            }

        });

        VBox layout = new VBox(20);
        layout.getChildren().add(button);
        layout.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Hello alcoholic");
        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
