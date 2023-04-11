/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class ProyectoFX extends Application {

    public ProyectoFX() {
    }
    
     @Override
    public void init(){
        System.out.println("metodo init");
    }   
    
    @Override
    public void start(Stage primaryStage) {
        
        System.out.println("metodo start ");
        
        Button btn1 = new Button("azul");
        Button btn2 = new Button("rojo");
        Button btn3 = new Button("verde");
        Button btn4 = new Button("amarillo");
        Button btn5 = new Button("morado");
        
       
        
        //StackPane root = new StackPane();
        BorderPane root = new BorderPane();
        root.setCenter(btn1);
        btn1.setMaxWidth(Double.MAX_VALUE);
        btn1.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(btn1, new Insets(5,5,5,5));
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón 1 clickeado");
                // codigo para ejecutar
            }
        });

        
        root.setTop(btn2);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxHeight(Double.MAX_VALUE);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón 2 clickeado");
                // codigo para ejecutar
            }
        });
        
        root.setBottom(btn3);
        btn3.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxHeight(Double.MAX_VALUE);
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón 3 clickeado");
                // codigo para ejecutar
            }
        });
        
        root.setLeft(btn4);
        btn4.setMaxWidth(Double.MAX_VALUE);
        btn4.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(btn1, new Insets(5,0,5,0));
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón 4 clickeado");
                // codigo para ejecutar
            }
        });
        
        root.setRight(btn5);
        btn5.setMaxWidth(Double.MAX_VALUE);
        btn5.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(btn1, new Insets(5,0,5,0));
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón 6 clickeado");
                // codigo para ejecutar
            }
        });
        
        
       
        
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void stop(){
        System.out.println("metodo stop");
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
