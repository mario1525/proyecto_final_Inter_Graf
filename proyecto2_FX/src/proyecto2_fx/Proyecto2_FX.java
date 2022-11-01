package proyecto2_fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Proyecto2_FX extends Application {

    @Override
    public void start(Stage primaryStage) {

        //root 
        BorderPane root = new BorderPane();

        Label helloWorldLabel = new Label("Hello world!");
        helloWorldLabel.setAlignment(Pos.CENTER);
        Scene primaryScene = new Scene(helloWorldLabel);

        //scene 
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
