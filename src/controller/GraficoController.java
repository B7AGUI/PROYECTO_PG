package controller;

import javafx.collections.ObservableList;
import model.GraficoModel;

public class GraficoController {
    private GraficoModel modelo;

    public GraficoController() {
        this.modelo = new GraficoModel();
    }

    public ObservableList<Double> obtenerDatosGrafico(int especieId) {
        return modelo.obtenerDatosGrafico(especieId);
    }
}
