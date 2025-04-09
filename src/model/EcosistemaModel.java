package model;

import database.ConexionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Pair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EcosistemaModel {

    // Método para obtener la descripción de un ecosistema
    public String obtenerDescripcionEcosistema(String nombreEcosistema) {
        String descripcion = "";
        String query = "SELECT descripcion FROM ecosistemas WHERE nombre = ?";

        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nombreEcosistema);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                descripcion = resultSet.getString("descripcion");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return descripcion;
    }

    // Método para obtener datos de temperatura para un ecosistema
    public List<Pair<String, Double>> obtenerDatosTemperatura(int ecosistemaId) {
        List<Pair<String, Double>> datos = new ArrayList<>();
        String query = "SELECT mes, temperatura FROM grafico_ecosistemas WHERE ecosistema_id = ? ORDER BY id";
    
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement statement = connection.prepareStatement(query)) {
    
            statement.setInt(1, ecosistemaId); // Usa el ID del ecosistema
            ResultSet resultSet = statement.executeQuery();
    
            while (resultSet.next()) {
                String mes = resultSet.getString("mes");
                double temperatura = resultSet.getDouble("temperatura");
                datos.add(new Pair<>(mes, temperatura));
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return datos;
    }
    

}


