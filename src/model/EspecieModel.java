package model;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecieModel {

    public String obtenerDescripcionEspecie(int especieId) {
        String descripcion = "";
        String query = "SELECT descripcion FROM especie WHERE id = ?";

        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, especieId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                descripcion = resultSet.getString("descripcion");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return descripcion;
    }
}
