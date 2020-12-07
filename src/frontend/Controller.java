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

public class Controller extends Application {

    Stage window;
    Scene home,main;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("creating combo box ");
        Label description_label =
                new Label("Combo madam president");
        String fushie[] =
                { "One fish", "Two fish", "Red fish",
                        "Blue fish", "SARDINE" };

        ComboBox chombo = new ComboBox(FXCollections.observableArrayList(fushie));

        TilePane tile_pane = new TilePane(chombo);

        Scene scene = new Scene(tile_pane, 200, 200);

        // Set the scene
        window.setScene(scene);

        window.show();

    }
}