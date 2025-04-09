package view;

import controller.LoginController;
import controller.RegistroController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Registro {
    private Stage stage;
    private RegistroController registroController;

    public Registro(Stage stage) {
        this.stage = stage;
        this.registroController = new RegistroController();
    }

    public void start() {
        // Crear el GridPane principal
        GridPane gridPane = creaPane();

        // Agregar componentes de texto e imágenes
        agregarTitulo(gridPane);

        // Crear campos de entrada
        TextField nombre = new TextField();
        nombre.setPromptText("Nombre");

        TextField apellidoPaterno = new TextField();
        apellidoPaterno.setPromptText("Apellido Paterno");

        TextField apellidoMaterno = new TextField();
        apellidoMaterno.setPromptText("Apellido Materno");

        TextField usuario = new TextField();
        usuario.setPromptText("Usuario");

        TextField contraseña = new TextField();
        contraseña.setPromptText("Contraseña");

        TextField correo = new TextField();
        correo.setPromptText("Correo electrónico");

        TextField dia = new TextField();
        dia.setPromptText("Día");
        dia.setPrefWidth(50);

        TextField mes = new TextField();
        mes.setPromptText("Mes");
        mes.setPrefWidth(50);

        TextField año = new TextField();
        año.setPromptText("Año");
        año.setPrefWidth(60);

        // Botones de selección de género
        ToggleGroup grupoSexo = new ToggleGroup();
        RadioButton masculino = new RadioButton("Masculino");
        masculino.setToggleGroup(grupoSexo);
        masculino.setTextFill(Color.WHITE);

        RadioButton femenino = new RadioButton("Femenino");
        femenino.setToggleGroup(grupoSexo);
        femenino.setTextFill(Color.WHITE);

        // Botón para registrar usuario
        Button registrarButton = new Button("Registrar");
        registrarButton.setOnAction(e -> {
            String fechaNacimiento = año.getText() + "-" + mes.getText() + "-" + dia.getText();
            String sexoText = masculino.isSelected() ? "Masculino" : "Femenino";

            registroController.registrarUsuario(
                nombre.getText(), apellidoPaterno.getText(), apellidoMaterno.getText(),
                usuario.getText(), contraseña.getText(), correo.getText(),
                fechaNacimiento, sexoText
            );
        });

        // Botón para volver al Login
        Button volverButton = new Button("Volver");
        volverButton.setOnAction(e -> {
            LoginController loginController = new LoginController(stage);
            Login login = new Login(stage, loginController);
            login.start();
        });

        // Agregar elementos al GridPane
        gridPane.add(new Text("Nombre:"), 0, 1);
        gridPane.add(nombre, 1, 1);
        gridPane.add(new Text("Apellido Paterno:"), 0, 2);
        gridPane.add(apellidoPaterno, 1, 2);
        gridPane.add(new Text("Apellido Materno:"), 0, 3);
        gridPane.add(apellidoMaterno, 1, 3);
        gridPane.add(new Text("Usuario:"), 0, 4);
        gridPane.add(usuario, 1, 4);
        gridPane.add(new Text("Contraseña:"), 0, 5);
        gridPane.add(contraseña, 1, 5);
        gridPane.add(new Text("Correo:"), 0, 6);
        gridPane.add(correo, 1, 6);
        gridPane.add(new Text("Fecha de Nacimiento:"), 0, 7);
        gridPane.add(dia, 1, 7);
        gridPane.add(mes, 2, 7);
        gridPane.add(año, 3, 7);
        gridPane.add(new Text("Sexo:"), 0, 8);
        gridPane.add(masculino, 1, 8);
        gridPane.add(femenino, 2, 8);
        gridPane.add(registrarButton, 0, 9, 2, 1);
        gridPane.add(volverButton, 0, 10, 2, 1);

        // Crear y mostrar la escena
        Scene scene = new Scene(gridPane, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Registro de Usuario");
        stage.show();
    }

    private void agregarTitulo(GridPane gridPane) {
        Text titulo = new Text("Registro de Usuario");
        titulo.setFont(new Font("Arial", 24));
        titulo.setFill(Color.WHITE);

        gridPane.add(titulo, 0, 0, 3, 1);
    }

    private GridPane creaPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-background-color: #87CEFA;"); // Fondo azul claro
        return gridPane;
    }
}
