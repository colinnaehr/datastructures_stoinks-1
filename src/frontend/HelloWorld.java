package frontend;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Toggle;

//import javafx.fxml.FXMLLoader;


public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();


        Scene scene = new Scene(root, 1250, 800);



        Scene scene2 = new Scene(new Group());
        scene2.getStylesheets().add(getClass().getResource("stylesheets/stylesheet1.css").toExternalForm());
        Rectangle rect = new Rectangle(1250,800);
        rect.setLayoutX(0);
        rect.setLayoutY(0);
        rect.getStyleClass().add("my-rect");
        ((Group)scene2.getRoot()).getChildren().add(rect);

        Rectangle rect2 = new Rectangle(1250,150);
        rect2.setLayoutX(0);
        rect2.setLayoutY(0);
        rect2.getStyleClass().add("my-rect2");
        ((Group)scene2.getRoot()).getChildren().add(rect2);

        Rectangle rect3 = new Rectangle(1250,20);
        rect3.setLayoutX(0);
        rect3.setLayoutY(150);
        rect3.getStyleClass().add("my-rect3");
        ((Group)scene2.getRoot()).getChildren().add(rect3);

        primaryStage.setTitle("Sardine");
        primaryStage.setScene(scene2);
        primaryStage.show();

        Text t = new Text();
        t.setText("Sardine");
        t.setLayoutX(440);
        t.setLayoutY(105);
        t.getStyleClass().add("title");
        //t.setFill(Color.WHITE);
        ((Group)scene2.getRoot()).getChildren().add(t);

        Button btn = new Button();
        btn.setText("Fetch Data");
        btn.setMinSize(500, 85);
        btn.setLayoutX(18);
        btn.setLayoutY(190);
        btn.getStyleClass().add("button1");
        ((Group)scene2.getRoot()).getChildren().add(btn);

        ToggleButton btn2 = new ToggleButton();



        btn2.setText("Retrieval Method");
        btn2.setMinSize(500, 85);
        btn2.setLayoutX(18);
        btn2.setLayoutY(300);
        if(!btn2.isSelected()) {
            btn2.getStyleClass().add("button1");
        }
        if(btn2.isSelected()){
            btn2.getStyleClass().add("button2");
        }
        ((Group) scene2.getRoot()).getChildren().add(btn2);



        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });



        //comment
    }
    public static void main(String[] args) {
        launch(args);
    }
}