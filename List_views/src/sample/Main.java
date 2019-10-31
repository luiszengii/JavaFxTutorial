package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;
//    ListView<String> listView;
    TreeView<String> tree;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        button = new Button("add to shopping cart");
//        button.setOnAction( e -> addProduct(listView));

//        listView = new ListView<>();
//        listView.getItems().addAll("water", "BBQ", "chicken", "MandM");
//        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TreeItem<String> Product, drink, chips;

        //Root
        Product = new TreeItem<>();
        Product.setExpanded(true);//setting it has children

        //drink
        drink = makeBranch("Drink", Product); //the value of it self and set its parent
        makeBranch("coke", drink);
        makeBranch("vanilla", drink);
        makeBranch("water", drink);

        //chips
        chips = makeBranch("Chips", Product); //the value of it self and set its parent
        makeBranch("chicken", chips);
        makeBranch("BBQ", chips);
        makeBranch("chilly", chips);

        //create Tree
        tree = new TreeView<>(Product);//ONly need root as the parametter;
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
            System.out.println(newValue.getValue());
        });
        tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(tree, button);

        window.setTitle("带List View的新窗口");
        window.setScene(new Scene(layout, 300, 275));
        window.show();
    }

    public void addProduct(ListView<String> listView){
        String p = "";
        ObservableList<String> products;
        products = listView.getSelectionModel().getSelectedItems();

        for (String s : products) {
            System.out.println(s + " has been added to shopping cart");
        }
    }


    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
