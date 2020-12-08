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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Pair;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import javafx.scene.control.TextField;
//import javafx.fxml.FXMLLoader;



//yessir
public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException{

        GridPane root = new GridPane();
        BackendController bc = new BackendController();


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



        Text dataMethod = new Text();
        dataMethod.setText("Data Method");
        dataMethod.setLayoutX(205);
        dataMethod.setLayoutY(335);
        dataMethod.getStyleClass().add("datamethod");
        //t.setFill(Color.WHITE);
        ((Group)scene2.getRoot()).getChildren().add(dataMethod);

        ToggleGroup TheGroup = new ToggleGroup();
        ToggleButton button_1 = new ToggleButton("Total Volume");
        //ToggleButton button_1 = new ToggleButton("option 1");
        ToggleButton button_2 = new ToggleButton("RSI for Date");
        //ToggleButton button_3 = new ToggleButton("option 3");
        button_1.setToggleGroup(TheGroup);
        button_2.setToggleGroup(TheGroup);
        //button_3.setToggleGroup(TheGroup);
        button_1.setLayoutX(18);
        button_1.setLayoutY(350);
        button_2.setLayoutX(18);
        button_2.setLayoutY(450);
        //button_3.setLayoutX(18);
        //button_3.setLayoutY(550);
        button_1.setMinSize(500, 85);
        button_2.setMinSize(500, 85);
        //button_3.setMinSize(500, 85);
        button_1.getStyleClass().add("button1");
        button_2.getStyleClass().add("button1");
        //button_3.getStyleClass().add("button1");
        ((Group) scene2.getRoot()).getChildren().addAll(button_1, button_2);

        ToggleButton highLowButton = new ToggleButton();
        highLowButton.setText("Highest Values");
        highLowButton.setLayoutX(18);
        highLowButton.setLayoutY(595);
        highLowButton.setMinSize(500, 85);
        highLowButton.getStyleClass().add("highlow");
        ((Group)scene2.getRoot()).getChildren().add(highLowButton);





        highLowButton.setOnAction(new EventHandler<ActionEvent>() {
            boolean dataType = true;
            @Override
            public void handle(ActionEvent event) {

                if(dataType) {
                    highLowButton.setText("Lowest Values");
                }
                else{
                    highLowButton.setText("Highest Values");
                }
                dataType ^= true;
            }
        });

        ToggleButton btn2 = new ToggleButton();
        btn2.setText("Retrieval Method 1");
        btn2.setMinSize(500, 85);
        btn2.setLayoutX(18);
        btn2.setLayoutY(700);
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

        String date = "";
        TextField field = new TextField();
        field.setPromptText("enter date mm/dd/yyyy for RSI");
        field.setFocusTraversable(false);
        Text dateOutput = new Text();
        Button submission = new Button("Submit");

        field.setLayoutX(18);
        field.setLayoutY(550);
        field.setMinSize(442,20);
        submission.setLayoutX(460);
        submission.setLayoutY(550);
        submission.setMinSize(40,20);
        submission.getStyleClass().add("submits");
        ((Group)scene2.getRoot()).getChildren().addAll(field,dateOutput,submission);
        submission.setOnAction(e-> {
            System.out.println(field.getText());
        });



        Button fetchButton = new Button();
        fetchButton.setText("Fetch Data");
        fetchButton.setMinSize(500, 85);
        fetchButton.setLayoutX(18);
        fetchButton.setLayoutY(195);
        fetchButton.getStyleClass().add("button1");
        ((Group)scene2.getRoot()).getChildren().add(fetchButton);
        fetchButton.setOnAction(e ->  bc.fetchStocks());

        Image image = new Image(getClass().getResource("f.PNG").toExternalForm());
        ImageView iv = new ImageView(image);
        iv.setX(0);
        iv.setY(0);
        iv.setFitWidth(300);
        iv.setPreserveRatio(true);
        ((Group)scene2.getRoot()).getChildren().add(iv);

        Button btn = new Button();
        btn.setText("Start");
        btn.setMinSize(500, 85);
        btn.setLayoutX(635);
        btn.setLayoutY(700);
        btn.getStyleClass().add("button2");
        ((Group)scene2.getRoot()).getChildren().add(btn);


        /////////////////////////////////////////////////////////////
        Text stock1T = new Text();
        stock1T.setLayoutX(860);
        stock1T.setLayoutY(240);
        stock1T.getStyleClass().add("valuez");
        ((Group) scene2.getRoot()).getChildren().add(stock1T);

        Text stock2T = new Text();
        stock2T.setLayoutX(860);
        stock2T.setLayoutY(340);
        stock2T.getStyleClass().add("valuez");
        ((Group) scene2.getRoot()).getChildren().add(stock2T);

        Text stock3T = new Text();

        stock3T.setLayoutX(860);
        stock3T.setLayoutY(440);
        stock3T.getStyleClass().add("valuez");
        ((Group) scene2.getRoot()).getChildren().add(stock3T);

        Text stock4T = new Text();

        stock4T.setLayoutX(860);
        stock4T.setLayoutY(540);
        stock4T.getStyleClass().add("valuez");
        ((Group) scene2.getRoot()).getChildren().add(stock4T);

        Text stock5T = new Text();

        stock5T.setLayoutX(860);
        stock5T.setLayoutY(640);
        stock5T.getStyleClass().add("valuez");
        ((Group) scene2.getRoot()).getChildren().add(stock5T);




        //////////////////////////////////////////////////////////////

        btn.setOnAction(e -> {
            // Shaddy's List Function
            boolean buttonSel = false;
            ArrayList<Pair<String,Long>> goombi = new ArrayList<>();
            if(button_1.isSelected()){
                goombi = bc.volumeQuery(btn2.isSelected(),!highLowButton.isSelected());
                buttonSel = true;
            }
            else if(button_2.isSelected()){
                goombi = bc.relativeStrength(field.getText(),btn2.isSelected(),!highLowButton.isSelected(),14);
                buttonSel = true;
            }
            else{
                System.out.println("Better luck next time goombi");
            }
            if(buttonSel) {
                ArrayList<Text> googoo = new ArrayList<>();


                for (int i = 0; i < 5; i++) {
                    Text name = new Text();
                    Text val = new Text();
                    String temp = "" + goombi.get(i).getValue();
                    googoo.add(name);
                    googoo.add(val);
                }


                Button stock1 = new Button();
                stock1.setText("1. " + goombi.get(0).getKey());
                stock1.setMinSize(200, 75);
                stock1.setLayoutX(635);
                stock1.setLayoutY(190);
                stock1.getStyleClass().add("stockbox");
                ((Group) scene2.getRoot()).getChildren().add(stock1);

                stock1T.setText(goombi.get(0).getValue().toString());


                Button stock2 = new Button();
                stock2.setText("2. " + goombi.get(1).getKey());
                stock2.setMinSize(200, 75);
                stock2.setLayoutX(635);
                stock2.setLayoutY(290);
                stock2.getStyleClass().add("stockbox");
                ((Group) scene2.getRoot()).getChildren().add(stock2);

                stock2T.setText(goombi.get(1).getValue().toString());

                Button stock3 = new Button();
                stock3.setText("3. " + goombi.get(2).getKey());
                stock3.setMinSize(200, 75);
                stock3.setLayoutX(635);
                stock3.setLayoutY(390);
                stock3.getStyleClass().add("stockbox");
                ((Group) scene2.getRoot()).getChildren().add(stock3);

                stock3T.setText(goombi.get(2).getValue().toString());

                Button stock4 = new Button();
                stock4.setText("4. " + goombi.get(3).getKey());
                stock4.setMinSize(200, 75);
                stock4.setLayoutX(635);
                stock4.setLayoutY(490);
                stock4.getStyleClass().add("stockbox");
                ((Group) scene2.getRoot()).getChildren().add(stock4);

                stock4T.setText(goombi.get(3).getValue().toString());

                Button stock5 = new Button();
                stock5.setText("5. " + goombi.get(4).getKey());
                stock5.setMinSize(200, 75);
                stock5.setLayoutX(635);
                stock5.setLayoutY(590);
                stock5.getStyleClass().add("stockbox");
                ((Group) scene2.getRoot()).getChildren().add(stock5);

                stock5T.setText(goombi.get(4).getValue().toString());


                //Set the scene
                for (int i = 0; i < googoo.size(); i++) {
                    ((Group) scene2.getRoot()).getChildren().add(googoo.get(i));
                }
            }
        });


    }
    public static void main(String[] args) {
        launch(args);
    }
}