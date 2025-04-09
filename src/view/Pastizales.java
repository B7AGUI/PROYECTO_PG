package view;

import controller.EcosistemasController;
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
import javafx.stage.Stage;

public class Pastizales {
    private Stage stage;
    private EcosistemasController controlador;

    // Constructor que recibe el Stage y el controlador
    public Pastizales(Stage stage, EcosistemasController controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void start() {
        // Crear el GridPane principal
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(50));
        grid.setHgap(50);
        grid.setVgap(20);
        grid.setStyle("-fx-background-color: #e0e0e0;");

        // Botón Volver
        Button volver = new Button("Volver");
        volver.setOnAction(event -> controlador.mostrarEcosistemas());
        GridPane.setHalignment(volver, HPos.LEFT);
        grid.add(volver, 0, 0);

        // Título del Ecosistema
        Label nombre = new Label("Pastizales");
        nombre.setFont(javafx.scene.text.Font.font("Arial", 24));
        grid.add(nombre, 0, 1, 3, 1);

        // Descripción Título
        Label descripcionLabel = new Label("DESCRIPCIÓN");
        descripcionLabel.setFont(javafx.scene.text.Font.font("Arial", 24));
        grid.add(descripcionLabel, 1, 1, 3, 1);

        // Descripción del ecosistema
        TextArea descripcion = new TextArea("Cargando descripción...");
        descripcion.setWrapText(true);
        descripcion.setEditable(false);
        descripcion.setPrefSize(500, 300);
        descripcion.setStyle("-fx-font-size: 14px; -fx-text-fill: #333333;");
        grid.add(descripcion, 1, 2, 3, 1);

        // Obtener descripción desde la base de datos
        model.EcosistemaModel model = new model.EcosistemaModel();
        String descripcionTexto = model.obtenerDescripcionEcosistema("Pastizales");
        descripcion.setText(descripcionTexto);

        // Imagen Principal del Ecosistema
        ImageView img_1 = crearImageView("file:imagenes/pastizales.png", 400, 400);
        grid.add(img_1, 0, 2);

        // Gráfico del Ecosistema
        view.CreaGraficaEcosistema grafica = new view.CreaGraficaEcosistema();
        LineChart<String, Number> grafico = grafica.crearGrafico(3);
        grid.add(grafico, 1, 3, 3, 1);

        // Crear la escena y mostrarla
        Scene scene = new Scene(grid, 1080, 600);
        stage.setScene(scene);
        stage.setTitle("Ventana Ecosistema - Pastizales");
        stage.show();
    }

    private ImageView crearImageView(String ruta, int width, int height) {
        try {
            Image imagen = new Image(ruta);
            ImageView imageView = new ImageView(imagen);
            if (width > 0) imageView.setFitWidth(width);
            if (height > 0) imageView.setFitHeight(height);
            imageView.setPreserveRatio(true);
            return imageView;
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + e.getMessage());
            return null;
        }
    }
}
