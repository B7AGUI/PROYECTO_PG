package model;

import database.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioModel {

    public boolean insertarUsuario(String nombre, String apellidoPaterno, String apellidoMaterno, 
                                   String usuario, String contraseña, String correo, 
                                   String fechaNacimiento, String sexo) {
        String query = "INSERT INTO usuarios (nombre, apellido_paterno, apellido_materno, username, " +
                       "password, correo, fecha_nacimiento, sexo) VALUES (?, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";

        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, nombre);
            stmt.setString(2, apellidoPaterno);
            stmt.setString(3, apellidoMaterno);
            stmt.setString(4, usuario);
            stmt.setString(5, contraseña);
            stmt.setString(6, correo);
            stmt.setString(7, fechaNacimiento); // Debe ser formato 'YYYY-MM-DD'
            stmt.setString(8, sexo);

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0; // Retorna true si se insertó al menos una fila
        } catch (Exception e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }
}
