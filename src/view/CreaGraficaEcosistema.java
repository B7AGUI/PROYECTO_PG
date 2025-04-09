package view;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;

import javafx.scene.chart.XYChart;
import javafx.util.Pair;
import model.EcosistemaModel;

import java.util.List;

public class CreaGraficaEcosistema {

    private EcosistemaModel ecosistemaModel;

    public CreaGraficaEcosistema() {
        this.ecosistemaModel = new EcosistemaModel();
    }
    public LineChart<String, Number> crearGrafico(int ecosistemaId) {
        // Crear los ejes del gráfico
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Temperatura (°C)");
    
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Meses");
    
        LineChart<String, Number> grafico = new LineChart<>(xAxis, yAxis);
        grafico.setTitle("Temperatura Promedio Mensual");
    
        // Obtener los datos desde el modelo
        List<Pair<String, Double>> datos = ecosistemaModel.obtenerDatosTemperatura(ecosistemaId);
    
        // Crear la serie de datos
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Temperatura Mensual");
    
        for (Pair<String, Double> dato : datos) {
            series.getData().add(new XYChart.Data<>(dato.getKey(), dato.getValue()));
        }
    
        // Añadir la serie al gráfico
        grafico.getData().add(series);
        return grafico;
    }
    
}



