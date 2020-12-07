package frontend;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
//import javafx.fxml.FXMLLoader;


public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();


        Scene scene = new Scene(root, 1250, 800);

        //((Group)scene.getRoot()).getChildren().add(rect);






        Scene scene2 = new Scene(new Group());
        scene2.getStylesheets().add(getClass().getResource("stylesheets/stylesheet1.css").toExternalForm());
        Rectangle rect = new Rectangle(1250,800);
        rect.setLayoutX(0);
        rect.setLayoutY(0);
        rect.getStyleClass().add("my-rect");
        ((Group)scene2.getRoot()).getChildren().add(rect);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene2);
        primaryStage.show();

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        root.getChildren().add(btn);
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