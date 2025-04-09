package view;

import controller.VentanaPrincipalController;
import controller.EcosistemasController;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ecosistemas extends Application {
    private Stage stage;
    private VentanaPrincipalController controladorPrincipal;
    private EcosistemasController controladorEcosistemas;

    // Constructor que recibe Stage y controladores
    public Ecosistemas(Stage stage, VentanaPrincipalController controladorPrincipal) {
        this.stage = stage;
        this.controladorPrincipal = controladorPrincipal;
        this.controladorEcosistemas = new EcosistemasController(stage); // Inicializa el controlador
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        // Crear el GridPane principal
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setStyle("-fx-background-color: #eaf6ff;");

        // **Encabezado**
        Label titulo = new Label("Selección de Ecosistemas");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; "
                + "-fx-background-color: #2a4d69; -fx-padding: 10;");
        GridPane.setHalignment(titulo, HPos.CENTER);
        gridPane.add(titulo, 0, 0, 2, 1);

        // **Icono Principal**
        Image image = new Image("file:imagenes/icono.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(500);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);
        gridPane.add(imageView, 0, 1, 2, 2);

        // **Zona de Botones de Ecosistemas**
        GridPane botonesEcosistemas = crearBotones();
        gridPane.add(botonesEcosistemas, 2, 1);

        // **Texto Informativo**
        Text textoInformativo = new Text(
                "Un ecosistema es una comunidad de organismos vivos que interactúan entre sí y con su entorno. "
                        + "Existen diversos tipos de ecosistemas, como los terrestres y acuáticos, cada uno con características "
                        + "únicas que permiten la vida en diferentes formas.");
        textoInformativo.setWrappingWidth(800);
        textoInformativo.setStyle("-fx-font-size: 14px; -fx-text-fill: black;");
        GridPane.setHalignment(textoInformativo, HPos.CENTER);
        gridPane.add(textoInformativo, 0, 3, 3, 1);

        // Botón para volver a la ventana principal
        Button botonVolver = new Button("Volver");
        botonVolver.setOnAction(event -> controladorPrincipal.iniciar()); // Evento de botón
        GridPane.setHalignment(botonVolver, HPos.LEFT);
        gridPane.add(botonVolver, 0, 4);

        // Crear la escena y mostrarla
        Scene scene = new Scene(gridPane, 1080, 720);
        stage.setTitle("Página de Ecosistemas");
        stage.setScene(scene);
        stage.show();
    }

    // Método para cargar imágenes
    private ImageView cargarImageView(String ruta, int ancho, int alto) {
        try {
            Image imagen = new Image(ruta);
            ImageView imageView = new ImageView(imagen);
            imageView.setFitWidth(ancho);
            imageView.setFitHeight(alto);
            imageView.setPreserveRatio(true);
            return imageView;
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + ruta);
            return new ImageView(); // Devuelve un ImageView vacío si falla
        }
    }

    // Método para crear los botones de ecosistemas con imágenes
    private GridPane crearBotones() {
        GridPane eco = new GridPane();
        eco.setPadding(new Insets(25));
        eco.setHgap(20);
        eco.setVgap(10);

        // Definir los ecosistemas y sus rutas de imágenes
        String[] ecosistemas = { "TUNDRA", "BOSQUE TEMPLADO", "SELVA TROPICAL", "PASTIZALES", "MATORRALES", "DESIERTO",
                "BOSQUE DE CONÍFERAS" };
        String[] rutasImagenes = { "file:imagenes/imagen1.png", "file:imagenes/imagen2.png", "file:imagenes/imagen3.png",
                "file:imagenes/imagen4.png", "file:imagenes/imagen5.png", "file:imagenes/imagen6.png",
                "file:imagenes/imagen7.png" };

        int columnas = 2;
        int fila = 0;
        int col = 0;

        // Crear los botones para los ecosistemas
        for (int i = 0; i < ecosistemas.length; i++) {
            String ecosistema = ecosistemas[i]; // Copia la variable en una nueva variable local
            Button boton = new Button(ecosistema);
            boton.setPrefWidth(200);
            boton.setPrefHeight(150);
        
            // Agregar funcionalidad para los botones
            switch (ecosistema) {
                case "TUNDRA":
                    boton.setOnAction(event -> controladorEcosistemas.mostrarTundra());
                    break;
                case "BOSQUE TEMPLADO":
                    boton.setOnAction(event -> controladorEcosistemas.mostrarBosqueTemplado());
                    break;
                // Puedes agregar más casos para otros ecosistemas en el futuro
                case "DESIERTO":
                    boton.setOnAction(event -> controladorEcosistemas.mostrarDesierto());
                    break;
                case "PASTIZALES":
                    boton.setOnAction(event -> controladorEcosistemas.mostrarPastizales());
                    break;
                    // Puedes agregar más casos para otros ecosistemas en el futuro
                case "SELVA TROPICAL":
                    boton.setOnAction(event -> controladorEcosistemas.mostrarSelvaTropical());
                    break;   

                default:
                    boton.setOnAction(event -> System.out.println("Funcionalidad no implementada para " + ecosistema));
                    break;
                
                case "MATORRALES":
                    boton.setOnAction(event -> controladorEcosistemas.mostrarMatorral()); break; 
                
                case "BOSQUE DE CONÍFERAS":   
                    boton.setOnAction(event -> controladorEcosistemas.mostrarBosqueConiferas()); break;
            }
        
            try {
                ImageView imageView = cargarImageView(rutasImagenes[i], 50, 50);
                boton.setGraphic(imageView);
            } catch (Exception e) {
                System.err.println("Error al cargar la imagen: " + rutasImagenes[i]);
            }
        
            eco.add(boton, col, fila);
            col++;
            if (col == columnas) {
                col = 0;
                fila++;
            }
        }
        
        

        return eco;
    }
}
