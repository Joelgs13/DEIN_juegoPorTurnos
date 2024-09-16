package org.example.juegoporturnos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Label pPrincipal = new Label("Personaje Principal: ");
        Label enemigo = new Label("Enemigo:");

        VBox root = new VBox();
        root.setPadding(new Insets(2020));
        root.setSpacing(20);
        //root.getChildren().addAll()
        Scene scene = new Scene(root);
        stage.setTitle("Juego por turnos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}