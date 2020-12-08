package frontend;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorMSG {


    public static void msg(String name,String error){

    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(error);
    window.setMinWidth(500);
    Label label = new Label();
    label.setText(name);
    Button close = new Button("Close");
    close.setOnAction(e -> window.close());

    VBox layout = new VBox(10);
    layout.getChildren().addAll(label,close);
    layout.setAlignment(Pos.CENTER);

    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
    }

}
