package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import controller.VentanaPrincipalController;

public class ConservacionVidaSalvaje extends Application {
    private Stage stage;
    private VentanaPrincipalController controller;
    public ConservacionVidaSalvaje(Stage stage, VentanaPrincipalController controller) {
        this.stage = stage;
        this.controller = controller;
    }

    @Override
    public void start(Stage stage) {
        // Configuración del GridPane principal
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(20);
        gridPane.setStyle("-fx-background-color: #ADD8E6;"); // Fondo azul claro

        // Crear el contenido principal
        VBox contenido = crearContenido(stage);
        gridPane.add(contenido, 0, 0);

        // Crear y mostrar la escena
        Scene scene = new Scene(gridPane, 900, 800);
        stage.setScene(scene);
        stage.setTitle("Conservación de la Vida Salvaje");
        stage.show();
    }

    private VBox crearContenido(Stage stage) {
        // Título
        Text titulo = new Text("Conservación de la vida salvaje");
        titulo.setFont(new Font("Arial", 28));
        titulo.setFill(Color.DARKBLUE);

        // Texto descriptivo
        Text descripcion = new Text(
            "\"La biodiversidad de nuestro planeta está en peligro. Cada día, más de 100 especies desaparecen debido a la actividad humana. "
            + "Desde los majestuosos tigres hasta los pequeños insectos polinizadores, cada ser vivo juega un papel vital en mantener el equilibrio de nuestros ecosistemas. "
            + "Los cambios climáticos, la deforestación y la contaminación están destruyendo los hábitats naturales, poniendo en riesgo el futuro de miles de especies. "
            + "Pero aún podemos marcar la diferencia. Con pequeñas acciones, como reducir el uso de plásticos, apoyar programas de conservación y educar a otros, "
            + "podemos proteger la rica diversidad de vida que nos rodea.\n"
            + "¡Actuemos ahora por un planeta más saludable!\""
        );
        descripcion.setFont(new Font("Arial", 16));
        descripcion.setWrappingWidth(700);
        descripcion.setFill(Color.BLACK);

        // Imágenes con recuadros
        VBox recuadros = new VBox(30, 
            imagenYTexto("file:imagenes/tigre.jpg", obtenerTextoTigre()),
            imagenYTexto("file:imagenes/elefante.jpg", obtenerTextoElefante())
        );
        recuadros.setAlignment(Pos.CENTER);

        // Botón de "Volver"
        Button botonVolver = new Button("Volver");
        botonVolver.setStyle("-fx-background-color: #FFB6C1; -fx-font-size: 14px; -fx-text-fill: black;");
        botonVolver.setOnAction(e -> controller.iniciar());

        // Contenedor principal
        VBox contenidoBox = new VBox(20, titulo, descripcion, recuadros, botonVolver);
        contenidoBox.setAlignment(Pos.CENTER);
        return contenidoBox;
    }

    private HBox imagenYTexto(String rutaImagen, String textoRecuadro) {
        // Imagen
        ImageView imagen = new ImageView(new Image(rutaImagen));
        imagen.setFitWidth(200);
        imagen.setFitHeight(150);

        // Recuadro de texto
        Text texto = new Text(textoRecuadro);
        texto.setFont(new Font("Arial", 14));
        texto.setWrappingWidth(300);
        texto.setFill(Color.BLACK);
        texto.setStyle("-fx-background-color: #D8BFD8; -fx-padding: 10;");

        // Organizar en un HBox
        HBox contenedor = new HBox(20, imagen, texto);
        contenedor.setAlignment(Pos.CENTER_LEFT);
        return contenedor;
    }

    private String obtenerTextoTigre() {
        return "Tigre de bengala\n"
            + "Estado: En peligro\n"
            + "Amenazas: Pérdida de hábitat, caza furtiva, conflicto humano-animal.\n"
            + "Dato interesante: Solo quedan alrededor de 3,900 tigres salvajes en todo el mundo.";
    }

    private String obtenerTextoElefante() {
        return "Elefante Africano (Loxodonta africana)\n"
            + "Estado: En peligro\n"
            + "Amenazas: Caza furtiva por el marfil, destrucción del hábitat.\n"
            + "Dato interesante: Son fundamentales para mantener los ecosistemas de sabana.";
    }
}