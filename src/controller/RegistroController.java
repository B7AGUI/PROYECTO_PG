package controller;

import model.UsuarioModel;

public class RegistroController {
    private UsuarioModel usuarioModel;

    public RegistroController() {
        this.usuarioModel = new UsuarioModel();
    }

    public void registrarUsuario(String nombre, String apellidoPaterno, String apellidoMaterno, 
                                 String usuario, String contraseña, String correo, 
                                 String fechaNacimiento, String sexo) {
        if (nombre.isEmpty() || apellidoPaterno.isEmpty() || usuario.isEmpty() || 
            contraseña.isEmpty() || correo.isEmpty() || fechaNacimiento.isEmpty() || sexo.isEmpty()) {
            System.out.println("Por favor, completa todos los campos.");
            return;
        }

        if (!validarFormatoFecha(fechaNacimiento)) {
            System.out.println("El formato de la fecha de nacimiento es incorrecto. Debe ser 'YYYY-MM-DD'.");
            return;
        }

        boolean exito = usuarioModel.insertarUsuario(
            nombre, apellidoPaterno, apellidoMaterno, usuario, contraseña, correo, fechaNacimiento, sexo
        );

        if (exito) {
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.out.println("Hubo un error al registrar el usuario.");
        }
    }

    private boolean validarFormatoFecha(String fecha) {
        return fecha.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    


}
