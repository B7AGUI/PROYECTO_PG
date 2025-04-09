package controller;

import javafx.stage.Stage;
import view.BosqueTemplado;
import view.Tundra;
import view.Desierto;
import view.Pastizales;
import view.SelvaTropical;
import view.Matorrales;
import view.BosqueConiferas;

public class EcosistemasController {
    private Stage stage;

    public EcosistemasController(Stage stage) {
        this.stage = stage;
    }
    

    public void mostrarEcosistemas() {
        try {
            VentanaPrincipalController controladorprincipal = new VentanaPrincipalController(stage);
            controladorprincipal.manejarBotonEcosistemas();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarTundra() {
        try {
            Tundra tundra = new Tundra(stage, this);
            tundra.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarBosqueTemplado() {
    try {
        BosqueTemplado bosqueTemplado = new BosqueTemplado(stage, this);
        bosqueTemplado.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void mostrarDesierto(){
        try {
            Desierto desierto = new Desierto(stage, this);
            desierto.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPastizales(){
        try {
            Pastizales pastizales = new Pastizales(stage, this);
            pastizales.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void mostrarSelvaTropical(){
        try {
            SelvaTropical selvaTropical = new SelvaTropical(stage, this);
            selvaTropical.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarMatorral(){
        try {
            Matorrales matorrales = new Matorrales(stage, this);
            matorrales.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarBosqueConiferas() {
        try {
            BosqueConiferas bosqueConiferas = new BosqueConiferas(stage, this);
            bosqueConiferas.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
