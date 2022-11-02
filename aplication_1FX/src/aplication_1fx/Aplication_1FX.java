package aplication_1fx;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Aplication_1FX extends Application {

    @Override
    public void start(Stage primaryStage) {
        //root Node
        BorderPane root = new BorderPane();
        //final ImageView ImageView = new ImageView();

        //llamado de el background 
        //Text Node
        Text txtNode = new Text("Selection");
        txtNode.setFont(Font.font("Comic Sans Ms", 30));
        txtNode.setFill(Color.CYAN);

        //listView for Alumnos
        VBox vbox1 = new VBox(10);

        Text txtAlumno = new Text("estudiantes");
        txtAlumno.setFont(Font.font("Comic sans Ms", 18));
        txtAlumno.setFill(Color.CHARTREUSE);

        ListView<String> listAlumnos = new ListView<String>();
        ObservableList<String> alumnos = FXCollections.observableArrayList(
                "Mario",
                "Valentina",
                "Madheleyn",
                "Orlay",
                "Alexander",
                "Heider",
                "Sebastian");
        listAlumnos.setItems(alumnos);
        listAlumnos.setMaxHeight(250);

        vbox1.getChildren().addAll(txtAlumno, listAlumnos);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setPadding(new Insets(10));

        //ListView for selection Mode
        VBox vbox2 = new VBox(10);

        Text txtMode = new Text("Selection Mode");
        txtMode.setFont(Font.font("Comic Sans MS", 18));
        txtMode.setFill(Color.GOLD);

        ListView<String> listMode = new ListView<String>();
        listMode.setOrientation(Orientation.HORIZONTAL);

        ObservableList<String> mode = FXCollections.observableArrayList(
                "Single",
                "Multiple"
        );
        listMode.setItems(mode);
        listMode.setMaxHeight(250);

        vbox2.getChildren().addAll(txtMode, listMode);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setPadding(new Insets(10));

        // List Mode Change Listener
        listMode.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                if (t1.equals("Single")) {
                    listAlumnos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                } else {
                    listAlumnos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                }
            }
        });

        //Button and Action
        Button btnShow = new Button("Show");
        btnShow.setMinWidth(100);
        BorderPane.setAlignment(btnShow, Pos.CENTER);
        BorderPane.setMargin(btnShow, new Insets(10));

        //setOnAction
        btnShow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                //Check if isMode ListView has a selected Item
                if (listMode.getSelectionModel().isEmpty()) {

                    txtNode.setText("Select a ListView Selection Mode");
                } else {
                    //Check if isMode ListView has a selected Item
                    if (listAlumnos.getSelectionModel().isEmpty()) {
                        txtNode.setText("Select an Alumno");
                    } else {
                        //If ListView for Alumnos is in Single selection mode...
                        if (listMode.getSelectionModel().getSelectedItem().equals("Single")) {

                            txtNode.setText((listAlumnos.getSelectionModel().getSelectedIndex())
                                    + "-"
                                    + listAlumnos.getSelectionModel().getSelectedItem() + "");
                            //If ListView for Alumnos is in Multiple selection mode...
                        } else {
                            String txtSelect = "";
                            ObservableList<String> select = listAlumnos.getSelectionModel().getSelectedItems();
                            for (Object o : select) {
                                txtSelect = txtSelect + alumnos.indexOf(0) + "-" + o + " ";

                            }
                            txtNode.setText(txtSelect);
                        }
                    }
                    listAlumnos.getSelectionModel().clearSelection();
                }
            }
        });
        
         //imagen
        //esta linea carga la imagen en el proyecto 
        //Image img = new Image("/images.jpeg"); 
        
       //ImageView.setImage(img);
       
        

        root.setRight(btnShow);
        root.setCenter(vbox1);
        root.setLeft(vbox2);
        root.setBottom(txtNode);        
       
        

        Scene scene = new Scene(root, 600, 350);
        primaryStage.setTitle("javafx8-listview");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void setPrefSize(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
