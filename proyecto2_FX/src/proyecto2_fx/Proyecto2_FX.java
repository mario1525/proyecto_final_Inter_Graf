package proyecto2_fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Proyecto2_FX extends Application {

    
    @Override
    public void start(Stage primaryStage) {

        
        //carga la imagen 
        ImageView imgn = new ImageView("imagenes/images.jpeg");
        
        //root Node
        StackPane root = new StackPane();
        
        //monta la imagen en el stack
        root.getChildren().addAll(imgn);
        
        //monta el stack en la scena
        Scene scene = new Scene(root);
        
        //monta la scene en la stage
        primaryStage.setTitle("Visualizador de Imágenes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    

    public static void main(String[] args) {
        launch(args);
    }
}
