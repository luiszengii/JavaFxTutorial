# Luis's javafx Tutorial

## Day1笔记
### javafx实现窗口架构: 
  - window (primaryStage) 
    - Scene 一个场面
      - layout (.xml, VBox, StackPane...), 设置格局
        - components (label, button)
      - components 放进 layout
    - layout 放进 scene
  - scene 放进 window
  - window.show()
  
### 按钮实现功能: 
  1. 切换scene，仍然在同一个window
  ```java
  button1.setOnAction(actionEvent -> window.setScene(scene1));
  button2.setOnAction(e -> window.setScene(scene1));
  ```
  2. 触发另一个window，在另一个class下的一个static method
  ```java
  //In Main:
  button = new Button("@醉酒行为大赏");
  button.setOnAction(e -> {
      boolean result = Controller.display("@醉酒行为实录", "今天你喝了吗？");
      if (result == true) {
          System.out.println("喝了啥？\n");
      } else {
          System.out.println("准备喝点啥？\n");
      }
      
  //in another class:
  static boolean answer;
  
  public static boolean display(String title, String message) {
    Button yesButton = new Button("喝了");
    Button noButton = new Button("准备喝");
    yesButton.setOnAction(e -> {
        answer = true;
        window.close();
    });
    noButton.setOnAction(e -> {
        answer = false;
        window.close();
    });
    
    window.showAndWait();//wait for click
    return answer;
  }
  ```
  3. call a method
  ```java
  //掌管关闭按钮 consume actionEvent
  window.setOnCloseRequest(e -> {
      e.consume();//tell system we are taking control
      howManyDaysLeft();//自己的function
  });
  
  private void howManyDaysLeft() {
    Boolean answer = Controller.display("几天", "不     行， 只      有");
    if (answer) {
        window.close();
    }
  }
```
--- 
## Day2 笔记
### 排版
  1. 利用BorderPane
    - HBox for top/bottom menu
    - VBox for left/right menu
    ```java
    BorderPane.setTop(topMenu);
    BorderPane.setLeft(leftMenu);
    ```
 2. 利用GridPane：格局化layout
    ```java
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));//padding 就是周围空白距离
    grid.setVgap(8);//行间距
    grid.setHgap(10);//列间距
    ```
    - 设置children坐标, **column 和 row 是相对的,视具体各自的坐标而在窗口中显示**
    ```java
    Label passwdLabel = new Label("Password: ");
    GridPane.setConstraints(passwdLabel, 0, 1);
    ```
    - 设置文本选中隐藏不选中淡色显示
    ```java
    TextField passwdInput = new TextField();
    passwdInput.setPromptText("password");
    ```
### INPUT
  1. 利用TextField和Button.setOnAction(e -> urmethod())
  ```java
  button.setOnAction(e -> isNumber(nameInput, nameInput.getText()));//同时获取input因为可以有跟多操作
  ```
### Check Box & Choice Box (drop down menu)
![image](https://media.github.sydney.edu.au/user/3246/files/51f33080-fc31-11e9-9ad6-5fa5860947fb)
  - Check Box, can be ticked, has boolean value of is selected
  ```java
  CheckBox box1 = new CheckBox("Bacon");
  if box1.isSelected(){
    balabalabala;
  }
  ```
  - Drop Down Menu
  ```java
  ChoiceBox<String> choiceBox = new ChoiceBox<>();
  //get items returns the list
  choiceBox.getItems().addAll("water", "Mars", "MandM");
  //set a default value会显示在菜单空位
  choiceBox.setValue("water");
  ```
  - Drop Down Menu Listener: 可以获取menu里面发生的改变
  ```java
  //set choiceBox listener, listen for selection changes, v for observable
  choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue));
  ```
### ComboBox: 比checkbox牛逼一点
![image](https://media.github.sydney.edu.au/user/3246/files/34be6200-fc31-11e9-845b-d11c85445990)
  - Basiclly same as checkbox except that:
  ```java
  //不用加listener！！！！
  comboBox.setOnAction( e -> System.out.println("user selected a new product"));
  ```
  - 更牛逼的：**Editable**:
  ```java
  comboBox.setEditable(true);
  ```
--- 
## Day3

### List View 可供多选的直接全部列出menu
![image](https://media.github.sydney.edu.au/user/3246/files/4ba68980-fc1c-11e9-8601-a511976c4fa6)
- 设置selectionModel来添加多选功能
```java
  listView = new ListView<>();
  listView.getItems().addAll("water", "BBQ", "chicken", "MandM");
  listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
```
- getselectedItems来获得list veiw里面的被选中项目
```java
  String p = "";
  ObservableList<String> products;
  products = listView.getSelectionModel().getSelectedItems();
  for (String s : products){
      System.out.println(s + " has been added to shopping cart");
  } 
```
### Tree View 
![image](https://media.github.sydney.edu.au/user/3246/files/5d3e6000-fc21-11e9-9394-a4c8b1d9fd84)
  - Initialization: A Root, Childrens
  ```java
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
  tree = new TreeView<>(Product);//ONLY need root as the parametter;
  tree.setShowRoot(false);
  tree.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
      System.out.println(newValue.getValue());
  });
  tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
  ```
  - makeBranch: returns a TreeItem that with the title and parent given
  ```java
  public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
  ```
### Table View
![image](https://media.github.sydney.edu.au/user/3246/files/6c291080-fc29-11e9-9896-625fbe6afd67)
- PropertyValueFactory<>("name")里的“name”**必须**与Product.java里的property名字"name"一致
  ```java
  //Name column
  TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
  nameColumn.setMinWidth(200);
  nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

  //Price column
  TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
  priceColumn.setMinWidth(100);
  priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

  //Quantity column
  TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
  quantityColumn.setMinWidth(100);
  quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

  table = new TableView<>();
  table.setItems(getProduct());
  table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
  ```
#### Editable Table
![image](https://media.github.sydney.edu.au/user/3246/files/a3e48800-fc2a-11e9-873e-2c4c4d0c2946)
![image](https://media.github.sydney.edu.au/user/3246/files/9813e400-fe2b-11e9-831f-8c957bdd6646)
