package view;

import controller.LoginController;
import controller.VentanaPrincipalController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ventana_principal extends Application {
    private VentanaPrincipalController controlador;

    public Ventana_principal(VentanaPrincipalController controlador) {
        this.controlador = controlador;
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPanePrincipal = new GridPane();
        gridPanePrincipal.setPadding(new Insets(20));
        gridPanePrincipal.setHgap(20);
        gridPanePrincipal.setVgap(20);
        gridPanePrincipal.setAlignment(Pos.CENTER);
        gridPanePrincipal.setStyle("-fx-background-color: linear-gradient(#87ceeb, #b0e0e6);"
                + "-fx-border-color: #4682b4;"
                + "-fx-border-width: 2;"
                + "-fx-background-radius: 15;"
                + "-fx-border-radius: 15;"
                + "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 10, 0, 5, 5);");

        // Crear elementos
        ImageView ecosistemasImg = crearImageView("file:imagenes/imagen_1.png");
        ImageView faunaImg = crearImageView("file:imagenes/fauna.png");
        ImageView ecologiaImg = crearImageView("file:imagenes/ecologia.png");

        Button botonEcosistemas = new Button("ECOSISTEMAS");
        botonEcosistemas.setOnAction(event -> controlador.manejarBotonEcosistemas());
        

        Button botonEspecies = new Button("ESPECIES");
        botonEspecies.setOnAction(event -> controlador.manejarBotonEspecies());

        Button botonConservacion = new Button("CONSERVACIÓN DE LA VIDA SALVAJE");
        botonConservacion.setOnAction(event -> controlador.mostrarConservacionVidaSalvaje());
        

 


        Button botonSalir = new Button("SALIR");
        
        botonSalir.setOnAction(e -> {
            LoginController loginController = new LoginController(stage);
            Login login = new Login(stage, loginController);
            login.start();
        });

        // Agregar elementos al GridPane
        gridPanePrincipal.add(ecosistemasImg, 0, 0);
        gridPanePrincipal.add(botonEcosistemas, 0, 1);
        gridPanePrincipal.add(faunaImg, 1, 0);
        gridPanePrincipal.add(botonEspecies, 1, 1);
        gridPanePrincipal.add(ecologiaImg, 0, 2);
        gridPanePrincipal.add(botonConservacion, 0, 3);
        gridPanePrincipal.add(botonSalir, 1, 3);

        Scene escena = new Scene(gridPanePrincipal, 600, 600);
        stage.setScene(escena);
        stage.setTitle("Ventana Principal");
        stage.show();
    }

    private ImageView crearImageView(String ruta) {
        try {
            Image imagen = new Image(ruta);
            ImageView imageView = new ImageView(imagen);
            imageView.setFitWidth(150);
            imageView.setFitHeight(150);
            return imageView;
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + ruta);
            return new ImageView(); // Devuelve un ImageView vacío si falla
        }
    }
}
