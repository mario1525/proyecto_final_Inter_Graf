
package listaview;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListaView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        //Root Node
        BorderPane root = new BorderPane();

        //como se carga la imagen
       Image img = new Image(getClass().getResourceAsStream("/imagenView/descarga.jpg"),1200,1000,true,true);
       ImageView imgView = new ImageView(img);

       //se le da el posicionamiento espacia a la imagen
       imgView.setLayoutX(0);
       imgView.setLayoutY(0);

       //para cambiar el color de fondo
        root.setStyle("-fx-text-fill: red; -fx-background-color: C7CEEA");

        //Text Node
        Text txtNode = new Text("Selection:");
        txtNode.setFont(Font.font(java.awt.Font.SERIF, 25));
        txtNode.setFill(Color.BLUE);

        //parte del text node
        Text txtAlumno = new Text("Estudiantes");
        txtAlumno.setFont(Font.font(java.awt.Font.SERIF, 25));
        txtAlumno.setFill(Color.BLUE);

        //vbox1
        VBox vbox1 = new VBox(10);

        //listView de alumnos
        ListView<String> listAlumnos =new ListView<>();
        ObservableList<String> alumnos = FXCollections.observableArrayList(
                "Mario",
                "Valentina",
                "Madheleyn",
                "Sebastion",
                "Alexander",
                "Robert",
                "Heider",
                "Orlay");
        listAlumnos.setItems(alumnos);
        listAlumnos.setMaxHeight(250);
        listAlumnos.setPadding(new Insets(2));
        listAlumnos.setCursor(Cursor.HAND);
        listAlumnos.setStyle("-fx-text-fill: red; -fx-background-color: black");
        primaryStage.show();

        vbox1.getChildren().addAll(txtAlumno, listAlumnos);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setPadding(new Insets(10));

        //Vbox2
        VBox vbox2 = new VBox(10);

        Text txtMode = new Text("Selection Mode");
        txtMode.setFont(Font.font("Comic Sans Ms", 50));
        txtMode.setFill(Color.BLUE);
        txtMode.setFont(Font.font(java.awt.Font.SERIF, 25));

        ListView<String>listMode = new ListView<>();
        listMode.setOrientation(Orientation.HORIZONTAL);


        ObservableList<String> mode = FXCollections.observableArrayList(
                "Single",
                "Multiple");
        listMode.setItems(mode);
        listMode.setMaxHeight(250);
        listMode.setPadding(new Insets(2));
        listMode.setCursor(Cursor.HAND);
        listMode.setStyle("-fx-text-fill: red; -fx-background-color: black");
        primaryStage.show();


        //partes del vbox 2
        vbox2.getChildren().addAll(txtMode, listMode);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setPadding(new Insets(10));



        listMode.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String t, String t1) -> {
            if(t1.equals("Single"))

                listAlumnos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            else
                listAlumnos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        });
        //crear y estilizar el boton
        Button btnShow = new Button("Show");
        btnShow.setMinWidth(100);
        btnShow.setCursor(Cursor.HAND);
        btnShow.setFont(Font.font(java.awt.Font.SERIF, 18));
        btnShow.setPadding(new Insets(8));
        BorderPane.setAlignment(btnShow, Pos.CENTER);
        BorderPane.setMargin(btnShow, new Insets(20));
        btnShow.setStyle("-fx-text-fill: black; -fx-<background-color: DEE2D9");
        primaryStage.show();

        //logica del boton
        btnShow.setOnAction((ActionEvent t) -> {
            if(listMode.getSelectionModel().isEmpty()){

                txtNode.setText("Select a listView Selectipon Mode");

            }else{
                if(listAlumnos.getSelectionModel().isEmpty()){
                    txtNode.setText("Select an Alumno");

                }else{
                    if(listMode.getSelectionModel().getSelectedItem().equals("Single")){
                        txtNode.setText((listAlumnos.getSelectionModel().getSelectedIndex())+
                                " - " +
                                listAlumnos.getSelectionModel().getSelectedItem() + "");
                    }else{

                        String txtSelect = "";

                        ObservableList<String> Select = listAlumnos.getSelectionModel().getSelectedItems();
                        for (Object o : Select){
                            txtSelect = txtSelect +alumnos.indexOf(o) +" - " + o + " ";

                        }
                        txtNode.setText(txtSelect);
                    }
                }
                listAlumnos.getSelectionModel().clearSelection();
            }
        });


        //llamadas a el root
        root.getChildren().add(imgView);
        root.setRight(btnShow);
        root.setCenter(vbox1);
        root.setLeft(vbox2);
        root.setBottom(txtNode);

        //creacion de la scene y cargado del root
        Scene scene = new Scene(root, 800, 450);

        //estilo del stage
        primaryStage.setTitle("proyecto Login ");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
