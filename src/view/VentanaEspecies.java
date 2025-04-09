package view;

import controller.VentanaEspeciesController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VentanaEspecies extends Application {
    private Stage stage;
    private VentanaEspeciesController controladorEspecie;

    // Constructor que recibe el Stage y el controlador
    public VentanaEspecies(Stage stage, VentanaEspeciesController controladorEspecie) {
        this.stage = stage;
        this.controladorEspecie = controladorEspecie;
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-background-color: #eaf6ff;"); // Fondo azul cielo claro

        // Título
        Label label = new Label("SELECCIONE UNA OPCIÓN");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20)); // Negritas y tamaño 20

        // Botón de volver
        Button back = new Button("Volver");
        back.setOnAction(event -> controladorEspecie.iniciar()); // Regresa a la ventana principal

        // Imágenes
        ImageView imagen1 = crearImageView("file:imagenes/ciervo.png");
        ImageView imagen2 = crearImageView("file:imagenes/marmota.JPG");
        ImageView imagen3 = crearImageView("file:imagenes/muskrat.png");

        gridPane.add(imagen1, 1, 1); // Imagen izquierda superior
        gridPane.add(imagen2, 2, 1); // Imagen derecha superior
        gridPane.add(imagen3, 1, 3); // Imagen izquierda inferior

        gridPane.add(back, 0, 0); // Botón volver
        gridPane.add(label, 1, 0); // Título

        // Lista de botones
        VBox lista = crearBotones();
        gridPane.add(lista, 0, 1, 1, 4);

        // Mostrar la ventana
        Scene scene = new Scene(gridPane, 600, 600);
        stage.setTitle("Especies");
        stage.setScene(scene);
        stage.show();
    }

    // Método para crear una lista de botones
    private VBox crearBotones() {
        VBox lista = new VBox(10); // Espacio entre botones
        lista.setPadding(new Insets(10));
        String[] animales = { "animal_1", "animal_2", "animal_3", "animal_4" };
    
        for (String animal : animales) {
            Button boton = new Button(animal);
            boton.setPrefWidth(100);
    
            if (animal.equals("animal_1")) {
                boton.setOnAction(event -> controladorEspecie.mostrarEspecie1());
            }
            if (animal.equals("animal_2")) {
                boton.setOnAction(event -> controladorEspecie.mostrarEspecie2());
            }
            if (animal.equals("animal_3")) {
                boton.setOnAction(event -> controladorEspecie.mostrarEspecie3());
            }
            if (animal.equals("animal_4")) {
                boton.setOnAction(event -> controladorEspecie.mostrarEspecie4());
            }
            
    
            lista.getChildren().add(boton);
        }
        return lista;
    }

    // Método para crear una vista de imagen ajustada
    private ImageView crearImageView(String ruta) {
        try {
            Image imagen = new Image(ruta);
            ImageView imageView = new ImageView(imagen);
            imageView.setFitWidth(250);
            imageView.setFitHeight(250);
            imageView.setPreserveRatio(true);
            return imageView;
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + ruta);
            return new ImageView(); // Devuelve un ImageView vacío si falla
        }
    }
}
