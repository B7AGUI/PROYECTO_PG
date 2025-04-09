package model;

import database.ConexionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GraficoModel {

    public ObservableList<Double> obtenerDatosGrafico(int especieId) {
        ObservableList<Double> datos = FXCollections.observableArrayList();
        String query = "SELECT poblacion FROM grafico_datos WHERE especie_id = ? ORDER BY mes_orden";

        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, especieId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                datos.add(resultSet.getDouble("poblacion"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener datos del gráfico: " + e.getMessage());
        }

        return datos;
    }
}
