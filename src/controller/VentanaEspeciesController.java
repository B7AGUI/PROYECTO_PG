package controller;

import javafx.stage.Stage; // Para manejar la ventana principal (Stage)
import view.Especie_1; // Para manejar la ventana de la especie específica
import view.Especie_2;
import view.Especie_3;
import view.Especie_4;
import view.VentanaEspecies; // La ventana de selección de especies
//import controller.VentanaPrincipalController; // Para interactuar con el controlador de la ventana principal

public class VentanaEspeciesController {
    private Stage stage;

    public VentanaEspeciesController(Stage stage) {
        this.stage = stage;
    }

    public void iniciar() {
        // Regresar a la ventana principal
        if (stage != null) {
            try {
                VentanaPrincipalController controladorPrincipal = new VentanaPrincipalController(stage);
                controladorPrincipal.iniciar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Stage no inicializado correctamente.");
        }
    }

    public void mostrarVentanaEspecie() {
        // Mostrar la ventana de selección de especies
        try {
            VentanaEspecies ventanaEspecie = new VentanaEspecies(stage, this);
            ventanaEspecie.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarEspecie1() {
        // Mostrar la ventana específica de la especie (Especie_1)
        try {
            Especie_1 especie1 = new Especie_1(stage, this);
            especie1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarEspecie2() {
        // Mostrar la ventana específica de la especie (Especie_2)
        try {
            Especie_2 especie2 = new Especie_2(stage, this);
            especie2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarEspecie3() {
        // Mostrar la ventana específica de la especie (Especie_3)
        try {
            Especie_3 especie3 = new Especie_3(stage, this);
            especie3.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarEspecie4(){
        // Mostrar la ventana específica de la especie (Especie_4)
        try {
            Especie_4 especie4 = new Especie_4(stage, this);
            especie4.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
