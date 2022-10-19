
package estructurajava;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class EstructuraJava extends Application {
    
    public static void main(String[] args) {
       launch(args);
       
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("aprendiendo fx");
        StackPane root = new StackPane();
        
        root.getChildren().add(label);
        
        Scene scene = new Scene(root,300,250);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFX");
        primaryStage.show();
    }
    
}
