package controller;

import javafx.stage.Stage;
import view.Ecosistemas;
import view.VentanaEspecies;
import view.ConservacionVidaSalvaje;

public class VentanaPrincipalController {
    private Stage stage;

    public VentanaPrincipalController(Stage stage) {
        this.stage = stage;
    }

    public void iniciar() {
        try {
            view.Ventana_principal ventanaPrincipal = new view.Ventana_principal(this);
            ventanaPrincipal.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manejarBotonEcosistemas() {
        try {
            Ecosistemas ecosistemas = new Ecosistemas(stage, this);
            ecosistemas.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manejarBotonEspecies() {
        try {
            VentanaEspeciesController controladorEspecies = new VentanaEspeciesController(stage);
            VentanaEspecies ventanaEspecies = new VentanaEspecies(stage, controladorEspecies);
            ventanaEspecies.start(stage); // Reutiliza el mismo Stage
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarConservacionVidaSalvaje() {
        try {
            ConservacionVidaSalvaje conservacion = new ConservacionVidaSalvaje(stage, this);
            conservacion.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    
}

