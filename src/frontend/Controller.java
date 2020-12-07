package frontend;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;

public class Controller extends Application {

    Stage window;
    Scene home,main;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Button btn1 = new Button();
        Button btn2 = new Button();

        btn1.setText("I'm a cat john");
        btn1.setOnAction(e -> window.setScene(main));

        btn2.setText("I eat, it's what I do");
        btn2.setOnAction(e -> window.setScene(home));

        VBox l1 = new VBox(20);
        l1.getChildren().add(btn1);

        VBox l2 = new VBox(20);
        l2.getChildren().add(btn2);

        home = new Scene(l1, 1250, 800);
        home.getStylesheets().add("test.css");
        main = new Scene(l2, 1250, 800);
        main.getStylesheets().add("test.css");


        primaryStage.setTitle("Test");
        primaryStage.setScene(home);
        primaryStage.show();
    }
}