package edu.diego.quiroz.actividad1.process;

import edu.diego.quiroz.actividad1.ui.DialogoSeleccionIdioma;
import edu.diego.quiroz.actividad1.ui.VentanaPrincipal;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación TecmiNuevos.
 * Punto de entrada de la aplicación JavaFX.
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) {
        // Primero mostrar el diálogo de selección de idioma
        DialogoSeleccionIdioma dialogoIdioma = new DialogoSeleccionIdioma();
        dialogoIdioma.showAndWait();
        
        // Si el usuario cerró el diálogo sin seleccionar, cerrar la aplicación
        if (!dialogoIdioma.isSeleccionConfirmada()) {
            Platform.exit();
            return;
        }
        
        // Continuar con la ventana principal
        VentanaPrincipal ventana = new VentanaPrincipal(stage);
        ventana.mostrar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
