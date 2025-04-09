package view;

import controller.LoginController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login {
    private Stage stage;
    private LoginController controlador;

    public Login(Stage stage, LoginController controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void start() {
        // Crear el GridPane
        GridPane gridPane = creaPane();
        agregaControles(gridPane);

        // Configurar el fondo
        gridPane.setStyle("-fx-background-color: blue;");

        // Crear y configurar la escena
        Scene scene = new Scene(gridPane, 600, 400);
        gridPane.requestFocus();

        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    private GridPane creaPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setVgap(20);
        gridPane.setHgap(10);
        return gridPane;
    }

    private void agregaControles(GridPane gridPane) {
        Image imagen = new Image("file:imagenes/gren.jpg");
        ImageView imagenView = new ImageView(imagen);
        imagenView.setFitWidth(150);
        imagenView.setFitHeight(150);

        Text texto = new Text("Pixel Green");
        texto.setFont(new Font(30));
        texto.setFill(Color.WHITE);

        TextField nombreUsuario = new TextField();
        nombreUsuario.setPromptText("Introduce tu nombre de usuario o email");

        PasswordField contraseña = new PasswordField();
        contraseña.setPromptText("Contraseña");

        Button buttonInicio = new Button("Iniciar sesión");
        buttonInicio.setOnAction(event -> controlador.manejarInicioSesion(nombreUsuario.getText(), contraseña.getText()));

        Button buttonRegistro = new Button("Registrarte");
        buttonRegistro.setStyle("-fx-background-color: #FFB6C1; -fx-font-size: 14px; -fx-text-fill: black;");
        buttonRegistro.setOnAction(event -> controlador.mostrarRegistro(stage));

        gridPane.add(imagenView, 0, 0, 2, 1);
        gridPane.add(texto, 0, 1, 2, 1);
        gridPane.add(nombreUsuario, 0, 2, 2, 1);
        gridPane.add(contraseña, 0, 3, 2, 1);
        gridPane.add(buttonInicio, 0, 4, 1, 1);
        gridPane.add(buttonRegistro, 1, 4, 1, 1);
    }
}
