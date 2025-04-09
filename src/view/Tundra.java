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
import model.EcosistemaModel;

public class Tundra {
    private Stage stage;
    private EcosistemasController controlador;

    // Constructor que recibe el Stage y el controlador de Ecosistemas
    public Tundra(Stage stage, EcosistemasController controlador) {
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
        volver.setOnAction(event -> controlador.mostrarEcosistemas()); // Reutiliza el controlador existente
        GridPane.setHalignment(volver, HPos.LEFT); // Alinearlo hacia la izquierda
        grid.add(volver, 0, 0);

        // Título del Ecosistema
        Label nombre = new Label("TUNDRA");
        nombre.setFont(javafx.scene.text.Font.font("Arial", 24));
        grid.add(nombre, 0, 1, 3, 1);

        // Descripción Título
        Label descripcionLabel = new Label("DESCRIPCIÓN");
        descripcionLabel.setFont(javafx.scene.text.Font.font("Arial", 24));
        grid.add(descripcionLabel, 1, 1, 3, 1);

        // Imagen Principal del Ecosistema
        ImageView img_1 = crearImageView("file:imagenes/ecosistema_1.png", 400, 400);
        grid.add(img_1, 0, 2);

        // Descripción del ecosistema desde la base de datos
        EcosistemaModel modelo = new EcosistemaModel();
        String descripcionTundra = modelo.obtenerDescripcionEcosistema("TUNDRA");

        TextArea text = crearTextArea(descripcionTundra);
        text.setStyle("-fx-background-color: #eaf6ff; -fx-text-fill: black; -fx-font-size: 18px;");

     
        GridPane.setMargin(text, new Insets(10)); // Márgenes alrededor del área
        grid.add(text, 1, 2, 3, 1); // Añádelo al GridPane (fila 3, ocupa 3 columnas)

        CreaGraficaEcosistema creaGrafico = new CreaGraficaEcosistema();
        LineChart<String, Number> grafico = creaGrafico.crearGrafico(1);
        grafico.setPrefSize(400, 400);
        grid.add(grafico, 0, 3); // Añádelo al GridPane (fila 4, ocupa 3 columnas)
        

        // Crear la escena y mostrarla
        Scene scene = new Scene(grid, 1080, 600);
        stage.setScene(scene);
        stage.setTitle("Ventana Ecosistema - Tundra");
        stage.show();
    }

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

    private TextArea crearTextArea(String inf) {
        TextArea areaTexto = new TextArea(inf);
        areaTexto.setWrapText(true); // Ajustar texto automáticamente al ancho del área
        areaTexto.setEditable(false); // Deshabilitar edición
        areaTexto.setPrefSize(500, 300); // Tamaño preferido del área
        areaTexto.setStyle("-fx-font-size: 14px; -fx-text-fill: #333333;"); // Estilo de texto
        return areaTexto;
    }
}
