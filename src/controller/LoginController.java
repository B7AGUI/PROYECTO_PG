package controller;

import database.ConexionDB;
import javafx.stage.Stage;
import view.Login;
import view.Registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    private Stage stage;

    public LoginController(Stage stage) {
        this.stage = stage;
    }

    public void manejarInicioSesion(String usuario, String contraseña) {
        if (validarCredenciales(usuario, contraseña)) {
            VentanaPrincipalController controladorPrincipal = new VentanaPrincipalController(stage);
            controladorPrincipal.iniciar();
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos.");
        }
    }
    public void mostrarRegistro(Stage stage) {
        try {
            Registro registro = new Registro(stage);
            registro.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validarCredenciales(String usuario, String contraseña) {
        String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, usuario);
            stmt.setString(2, contraseña);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Si existe un resultado, las credenciales son correctas.

        } catch (Exception e) {
            System.err.println("Error al validar las credenciales: " + e.getMessage());
            return false;
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    
}
