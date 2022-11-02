package proyecto_login;

import java.awt.TextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Proyecto_login extends Application {

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("iniciando aplicacion ");
    }

    @Override
    public void start(Stage primaryStage) {
        //root 
        BorderPane root = new BorderPane();

        //recuadro del login 
        VBox vbox1 = new VBox(10);
        VBox vbox2 = new VBox(10);
        vbox1.borderProperty();

        //cargado de imagen
        Image image1 = new Image(getClass().getResourceAsStream("/images.jpeg"));
        ImageView imageView1 = new ImageView(image1);
        //medidas de imagen 
        imageView1.setX(50);
        imageView1.setY(50);

        //crear texto
        Text txtUser = new Text("hello world");
        txtUser.setFont(Font.font("Comic sans Ms", 18));
        txtUser.setFill(Color.CHARTREUSE);

        Text txtPswd = new Text("hello world 2");
        txtPswd.setFont(Font.font("Comic sans Ms", 18));
        txtPswd.setFill(Color.AQUA);

        //crear cuadro de texto 
        TextField txtf1 = new TextField("name user");
        TextField txtf2 = new TextField("pasword");

        //agregar el texto a el vbox
        vbox1.getChildren().addAll(txtUser, txtPswd);
        vbox2.getChildren().add(imageView1);

        //agregar partes a el root 
        root.setCenter(vbox1);
        root.setCenter(vbox2);

        //planteado de la escena 
        Scene scene = new Scene(root, 1250, 650);
        primaryStage.setTitle("login support");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("fin del login ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
