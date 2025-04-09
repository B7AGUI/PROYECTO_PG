package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/manejologin"; // Cambia "nombre_base_datos"
    private static final String USUARIO = "postgres"; // Cambia "tu_usuario"
    private static final String CONTRASEÑA = "4282"; // Cambia "tu_contraseña"

    static {
        try {
            // Registrar el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al registrar el driver de PostgreSQL: " + e.getMessage());
        }
    }

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}
