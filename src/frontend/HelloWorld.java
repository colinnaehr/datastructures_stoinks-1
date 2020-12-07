package frontend;

import backend.BackendController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Toggle;
import javafx.util.Pair;

import java.util.ArrayList;

//import javafx.fxml.FXMLLoader;



//yessir
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

        ToggleButton btn2 = new ToggleButton();
        btn2.setText("Retrieval Method 1");
        btn2.setMinSize(500, 85);
        btn2.setLayoutX(18);
        btn2.setLayoutY(185);
        btn2.getStyleClass().add("button1");

        ((Group) scene2.getRoot()).getChildren().add(btn2);

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            boolean dataType = true;
            @Override
            public void handle(ActionEvent event) {

                if(dataType) {
                    btn2.setText("Retrieval Method 2");
                }
                else{
                    btn2.setText("Retrieval Method 1");
                }
                dataType ^= true;
            }
        });

        ToggleGroup TheGroup = new ToggleGroup();
        ToggleButton button_1 = new ToggleButton("option 1");
        ToggleButton button_2 = new ToggleButton("option 2");
        ToggleButton button_3 = new ToggleButton("option 3");
        button_1.setToggleGroup(TheGroup);
        button_2.setToggleGroup(TheGroup);
        button_3.setToggleGroup(TheGroup);
        button_1.setLayoutX(18);
        button_1.setLayoutY(350);
        button_2.setLayoutX(18);
        button_2.setLayoutY(450);
        button_3.setLayoutX(18);
        button_3.setLayoutY(550);
        button_1.setMinSize(500, 85);
        button_2.setMinSize(500, 85);
        button_3.setMinSize(500, 85);
        button_1.getStyleClass().add("button1");
        button_2.getStyleClass().add("button1");
        button_3.getStyleClass().add("button1");
        ((Group) scene2.getRoot()).getChildren().addAll(button_1, button_2, button_3);


        Button btn = new Button();
        btn.setText("Fetch Data");
        btn.setMinSize(500, 85);
        btn.setLayoutX(18);
        btn.setLayoutY(700);
        btn.getStyleClass().add("button1");
        ((Group)scene2.getRoot()).getChildren().add(btn);
        btn.setOnAction(e -> {
            // Shaddy's List Function
            BackendController bc = new BackendController();
            bc.fetchStocks();
            System.out.println(btn2.isSelected());
            ArrayList<Pair<String,Long>> goombi = bc.volumeQuery(btn2.isSelected());

            ArrayList<Text> googoo = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                Text name = new Text();
                Text val = new Text();
                name.setX(600);
                name.setY(i*40 +300);
                name.setText(goombi.get(i).getKey());
                val.setX(900);
                val.setY(i*40 + 300);
                String temp = "" + goombi.get(i).getValue();
                val.setText(temp);
                googoo.add(name);
                googoo.add(val);
            }



            //Set the scene
            for(int i = 0; i < googoo.size(); i++) {
                ((Group) scene2.getRoot()).getChildren().add(googoo.get(i));
            }
        });


    }
    public static void main(String[] args) {
        launch(args);
    }
}