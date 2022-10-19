
package ciclo_vida_fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Ciclo_vida_FX extends Application {

    public Ciclo_vida_FX() {
        System.out.println("constructor");
    }
    
    @Override
    public void init(){
        System.out.println("metodo init");
    }   
    
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        System.out.println("metodo start ");
    }
    
    @Override
    public void stop(){
        System.out.println("metodo stop ");
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
