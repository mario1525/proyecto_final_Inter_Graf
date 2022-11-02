package proyecto2_fx;

import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class Proyecto2_FX extends Application {
    
    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Realice las inicializaciones necesarias aquí.");
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        final ImageView imageView = new ImageView();
        
        Button button = new Button("Seleccione Imagen");
        button.setOnAction(value ->  {
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Buscar Imagen");
                fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Archivos Imagen", "*.png", "*.jpg"));
                File selectedFile = fileChooser.showOpenDialog(primaryStage);
                
                if (selectedFile != null) {
                    FileInputStream input = new FileInputStream(selectedFile);
                    Image image = new Image(input);
                    imageView.setImage(image);
                }
            } catch (Exception e) {
                System.out.println("Debes manejar el error: " + e.getMessage());
            }
        });        
        
        VBox vbox = new VBox(button, imageView);
        Scene scene = new Scene(vbox, 900, 600);
        
        primaryStage.setTitle("Visualizador de Imágenes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Destruye los recursos. Realice limpieza.");
    }
    public static void main(String[] args) {
        launch(args);
    }
}