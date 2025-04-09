package view;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.collections.ObservableList;
import model.GraficoModel;

public class CreaGrafico {

    public LineChart<Number, Number> crearGrafico(int especieId) {
        // Crear ejes del gráfico
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Meses");
        yAxis.setLabel("Población");

        // Crear el gráfico de líneas
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Gráfica de Población");

        // Obtener los datos del modelo
        GraficoModel modelo = new GraficoModel();
        ObservableList<Double> datos = modelo.obtenerDatosGrafico(especieId);

        // Crear una serie y agregar los datos
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Población");

        for (int i = 0; i < datos.size(); i++) {
            series.getData().add(new XYChart.Data<>(i + 1, datos.get(i)));
        }

        lineChart.getData().add(series);
        return lineChart;
    }
}
