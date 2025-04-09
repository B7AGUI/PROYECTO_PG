package view;

import controller.VentanaEspeciesController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.EspecieModel;

public class Especie_4 {
    private Stage stage;
    private VentanaEspeciesController controlador;

    public Especie_4(Stage stage, VentanaEspeciesController controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void start() {
        // Crear el GridPane principal
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setStyle("-fx-background-color: #eaf6ff;"); // Fondo azul claro

        // **Encabezado**
        Label titulo = crearLabel("Ciervo Común (Cervus elaphus)", 24, "-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #2a4d69; -fx-padding: 10;");
        GridPane.setHalignment(titulo, HPos.CENTER); // Centrar horizontalmente
        gridPane.add(titulo, 0, 0, 3, 1); // Ocupa 3 columnas en la fila 0

        // **Botón Volver**
        Button botonVolver = crearBoton("Volver", 100, 40, "#fddde6", "black");
        botonVolver.setOnAction(event -> controlador.mostrarVentanaEspecie());
        gridPane.add(botonVolver, 0, 0); // Esquina superior izquierda

        // **Imagen Principal**
        ImageView imagenEspecie = crearImageView("file:imagenes/venado.png", 400, 0); // Tamaño ajustado grande
        gridPane.add(imagenEspecie, 0, 1); // Columna 0, fila 1

        // **Descripción**
        Label descripcion = crearLabel("Descripción", 25, "-fx-font-weight: bold; -fx-text-fill: #2a4d69;");
        EspecieModel model = new EspecieModel();
        String model_descripcion = model.obtenerDescripcionEspecie(4);
        TextArea descripcionField = new TextArea(model_descripcion);
        descripcionField.setEditable(false); // Evitar edición
        descripcionField.setPrefWidth(600); // Ancho preferido del TextField
        descripcionField.setPrefHeight(600);
        descripcionField.setStyle("-fx-background-color: #eaf6ff; -fx-text-fill: black; -fx-font-size: 14px;");



        VBox vboxDescripcion = new VBox();
        vboxDescripcion.setSpacing(20);
        vboxDescripcion.getChildren().addAll(descripcion, descripcionField);

        gridPane.add(vboxDescripcion, 1, 1, 1, 2); // Columna 1, fila 1, ocupa 2 filas

        // **Categoría de Riesgo y Gráfica de Población**
        ImageView categoriaRiesgo = crearImageView("file:imagenes/categoria_riesgo_4.png", 300, 300);

        // Crear el gráfico dinámico (sin label de gráfico)
        CreaGrafico creaGrafico = new CreaGrafico();
        LineChart<Number, Number> grafico = creaGrafico.crearGrafico(4); // ID de especie: 1 para Oso
        
        HBox hboxContent = new HBox(50);
        hboxContent.getChildren().addAll(categoriaRiesgo, grafico);

        gridPane.add(hboxContent, 0, 3, 6, 1); // Fila 3, ocupa 3 columnas

        // Crear la escena y mostrarla
        Scene scene = new Scene(gridPane, 1250, 800);
        stage.setTitle("Especie - Ciervo");
        stage.setScene(scene);
        stage.show();
    }

    // Método para crear botones
    private Button crearBoton(String texto, int width, int height, String backgroundColor, String textColor) {
        Button boton = new Button(texto);
        boton.setPrefWidth(width);
        boton.setPrefHeight(height);
        boton.setStyle("-fx-background-color: " + backgroundColor + "; -fx-text-fill: " + textColor + "; -fx-border-color: black;");
        return boton;
    }

    // Método para crear etiquetas (Label)
    private Label crearLabel(String texto, int fontSize, String extraStyles) {
        Label label = new Label(texto);
        label.setFont(new Font("Arial", fontSize));
        label.setStyle(extraStyles);
        return label;
    }

    // **Método para crear una vista de imagen**
    private ImageView crearImageView(String ruta, int width, int height) {
        try {
            Image imagen = new Image(ruta);
            ImageView imageView = new ImageView(imagen);
            if (width > 0) imageView.setFitWidth(width); // Ajustar ancho si se especifica
            if (height > 0) imageView.setFitHeight(height); // Ajustar alto si se especifica
            imageView.setPreserveRatio(true); // Mantener proporción
            return imageView;
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + e.getMessage());
            return null;
        }
    }
}