package org.example.juegoporturnos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    Label vidaPrincipal;
    Label vidaEnemigo;
    VBox root;
    Scene scene;
    Persona p1 = new Persona("Protagonista", 5);
    Persona p2 = new Persona("Archienemigo", 5);
    @Override
    public void start(Stage stage) throws IOException {
        Label pPrincipal = new Label("Personaje 1: "+p1.nombre);
        vidaPrincipal = new Label("PV: "+p1.vida+" / "+p1.vidaMax);
        Label enemigo = new Label("Personaje 2: "+p2.nombre);
        vidaEnemigo = new Label("PV: "+p2.vida+" / "+p2.vidaMax);
        Button atacar = new Button("Atacar");
        atacar.setOnAction(e -> atacar(p1,p2));
        root = new VBox();
        root.getChildren().addAll(pPrincipal,vidaPrincipal,enemigo,vidaEnemigo,atacar);
        //root.getChildren().addAll()
        scene = new Scene(root, 500, 300);
        stage.setTitle("Juego por turnos");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * metodo que se usa para hacer daño a ambos personajes.
     * este metodo accede al metodo hacer tirada de persona para
     * sacar el valor de las tiradas de quien inicia el ataque y el defensor
     *
     * despues, reduce la vida del perderor en 1
     * @param atacante
     * @param defensor
     */
    public void atacar(Persona atacante, Persona defensor) {
        System.out.println(atacante.nombre + " Atacando a " + defensor.nombre);
        System.out.println("tiradas:");
        int tirada2;
        int tirada1;
        //conseguir que sean distintos valores de tirada para evitar empates
        do {
            tirada1 = atacante.hacerTirada();
            tirada2 = defensor.hacerTirada();
        } while (tirada2 == tirada1);
        System.out.println(atacante.nombre + ":" + tirada1);
        System.out.println(defensor.nombre + ":" + tirada2);
        if (tirada2>tirada1) {
            System.out.println("gana " + defensor.nombre);
            atacante.vida--;
        } else {
            System.out.println("gana " + atacante.nombre);
            defensor.vida--;
        }
        actualizar(atacante,defensor);
    }

    public void actualizar(Persona p1,Persona p2) {
        vidaPrincipal.setText("PV: " + p1.vida + " / " + p1.vidaMax);
        vidaEnemigo.setText("PV: " + p2.vida + " / " + p2.vidaMax);
        if (!p1.estaVivo() || !p2.estaVivo()) {
            Label derrota;
            if(!p1.estaVivo()) {
                //derrota de p1
                vidaPrincipal.setTextFill(Color.RED);
                derrota = new Label("Victoria del "+p2.nombre+ ". Fin del juego");
            } else {
                //derrota de p2
                vidaEnemigo.setTextFill(Color.RED);
                derrota = new Label("Victoria del "+p2.nombre+ ". Fin del juego");
            }
            root.getChildren().add(derrota);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}