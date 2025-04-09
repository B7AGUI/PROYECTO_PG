import javafx.application.Application;
import javafx.stage.Stage;
import controller.LoginController;
import view.Login;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        LoginController controlador = new LoginController(primaryStage);
        Login login = new Login(primaryStage, controlador);

        try {
            login.start(); // Inicia la ventana de Login
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
