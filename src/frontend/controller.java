package frontend;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.util.ArrayList;
//
public class Controller extends Application {

    Stage window;
    Scene home,main;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("creating combo box ");
        Label description_label =
                new Label("Combo madam president");
        String fushie[] =
                { "One fish", "Two fish", "Red fish",
                        "Blue fish", "SARDINE" };
        ComboBox chombo = new ComboBox(FXCollections.observableArrayList(fushie));

        ArrayList<Pair<String,Long>> goombi = new ArrayList<>();
        goombi.add(new Pair<String,Long>("TSLA",(long)100));
        goombi.add(new Pair<String,Long>("GOOM",(long)1000));
        goombi.add(new Pair<String,Long>("STNK",(long)0));
        goombi.add(new Pair<String,Long>("FMCI",(long)-100));
        goombi.add(new Pair<String,Long>("GAGG",(long)80085));


        ArrayList<Text> googoo = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Text name = new Text();
            Text val = new Text();
            name.setX(20);
            name.setY(i*40 +40);
            name.setText(goombi.get(i).getKey());
            val.setX(60);
            val.setY(i*40 + 40);
            String temp = "" + goombi.get(i).getValue();
            val.setText(temp);
            googoo.add(name);
            googoo.add(val);
        }



        // Set the scene
        Group root = new Group(googoo.get(0),googoo.get(1),googoo.get(2),googoo.get(3),googoo.get(4),googoo.get(5),googoo.get(6),googoo.get(7),googoo.get(8),googoo.get(9),chombo);
        Scene scene = new Scene(root, 200, 200);

        window.setScene(scene);

        window.show();

    }
}