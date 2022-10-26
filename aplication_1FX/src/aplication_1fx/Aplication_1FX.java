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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aplication_1FX extends Application {

    public Aplication_1FX() {
    }

    public void init(Stage primaryStage) {

    }

    @Override
    public void start(Stage primaryStage) {

        //root Node 
        BorderPane root = new BorderPane();

        //text NOde 
        Text txtNode = new Text("selection");
        txtNode.setFont(Font.font("Comic sans MS", 18));
        txtNode.setFill(Color.BLUE);

        VBox vbox1 = new VBox(10);

        Text txtAlumno = new Text("Estudiantes");
        txtAlumno.setFont(Font.font("Comic sans MS", 18));
        txtAlumno.setFill(Color.GREEN);

        ListView<String> ListAlumno = new ListView<String>();
        ObservableList<String> alumnos = FXCollections.observableArrayList(
                "mario",
                "madhe",
                "roberth",
                "alex",
                "sebastian",
                "orlay",
                "heider");
        ListAlumno.setItems(alumnos);
        ListAlumno.setMaxHeight(250);

        vbox1.getChildren().addAll(txtAlumno, ListAlumno);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setPadding(Insets.EMPTY);

        VBox vbox2 = new VBox(10);
        Text txtMode = new Text("Selection Mode");
        txtMode.setFont(Font.font("Comic Sans MS", 18));
        txtMode.setFill(Color.GOLD);

        ListView<String> listMode = new ListView<String>();
        listMode.setOrientation(Orientation.HORIZONTAL);

        ObservableList<String> mode = FXCollections.observableArrayList(
                "Single",
                "Mulriple");
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
                    ListAlumno.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                } else {
                    ListAlumno.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
                    if (ListAlumno.getSelectionModel().isEmpty()) {
                        txtNode.setText("Select an Alumno");
                    } else {
                        //If ListView for Alumnos is in Single selection mode...
                        if (listMode.getSelectionModel().getSelectedItem().equals("Single")) {

                            txtNode.setText((ListAlumno.getSelectionModel().getSelectedIndex())
                                    + "-"
                                    + ListAlumno.getSelectionModel().getSelectedItem() + "");
                            //If ListView for Alumnos is in Multiple selection mode...
                        } else {
                            String txtSelect = "";
                            ObservableList<String> select = ListAlumno.getSelectionModel().getSelectedItems();
                            for (Object o : select) {
                                txtSelect = txtSelect + alumnos.indexOf(0) + "-" + o + " ";

                            }
                            txtNode.setText(txtSelect);
                        }
                    }
                    ListAlumno.getSelectionModel().clearSelection();
                }
            }

        });

        Scene scene = new Scene(root, 600, 350);

        primaryStage.setTitle("lista de alumnos!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void stop(Stage primaryStage) {

    }

    public static void main(String[] args) {
        launch(args);
    }

}
