package edu.diego.quiroz.actividad1.ui;

import edu.diego.quiroz.actividad1.process.GestorIdiomas;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * Diálogo de selección de idioma.
 * Se muestra al inicio de la aplicación.
 */
public class DialogoSeleccionIdioma extends Stage {
    private String idiomaSeleccionado = "es"; // español por defecto
    private boolean seleccionConfirmada = false;
    
    public DialogoSeleccionIdioma() {
        initModality(Modality.APPLICATION_MODAL);
        setTitle("TecmiNuevos - Language / Langue");
        setResizable(false);
        
        VBox contenedor = new VBox(25);
        contenedor.setPadding(new Insets(40));
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setStyle("-fx-background-color: #FFFFFF;");
        
        // Logo o título
        Label titulo = new Label("🚗 TECMINUEVOS");
        titulo.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #CC0000;");
        
        // Mensaje de bienvenida
        VBox mensajes = new VBox(10);
        mensajes.setAlignment(Pos.CENTER);
        
        Label bienvenida = new Label("Welcome! / ¡Bienvenido! / Bienvenue!");
        bienvenida.setStyle("-fx-font-size: 18px; -fx-text-fill: #333333; -fx-font-weight: bold;");
        
        Label instruccion = new Label("Please select your language / Seleccione su idioma / Sélectionnez votre langue");
        instruccion.setStyle("-fx-font-size: 13px; -fx-text-fill: #666666;");
        
        mensajes.getChildren().addAll(bienvenida, instruccion);
        
        // Separador
        Separator separador = new Separator();
        separador.setMaxWidth(400);
        
        // Botones de idioma
        VBox botonesIdioma = new VBox(15);
        botonesIdioma.setAlignment(Pos.CENTER);
        botonesIdioma.setPrefWidth(350);
        
        Button btnEspanol = crearBotonIdioma("🇪🇸 Español", "es");
        Button btnIngles = crearBotonIdioma("🇬🇧 English", "en");
        Button btnFrances = crearBotonIdioma("🇫🇷 Français", "fr");
        
        botonesIdioma.getChildren().addAll(btnEspanol, btnIngles, btnFrances);
        
        // Pie de página
        Label pie = new Label("© 2026 TecmiNuevos. Your best choice in vehicles.");
        pie.setStyle("-fx-font-size: 11px; -fx-text-fill: #999999; -fx-padding: 20 0 0 0;");
        
        contenedor.getChildren().addAll(titulo, mensajes, separador, botonesIdioma, pie);
        
        Scene scene = new Scene(contenedor, 500, 550);
        setScene(scene);
        
        // Centrar en pantalla
        centerOnScreen();
    }
    
    private Button crearBotonIdioma(String texto, String codigoIdioma) {
        Button btn = new Button(texto);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setPrefHeight(60);
        btn.setStyle("-fx-background-color: #F5F5F5; -fx-text-fill: #333333; " +
                    "-fx-font-size: 18px; -fx-font-weight: bold; " +
                    "-fx-border-color: #E0E0E0; -fx-border-width: 2; " +
                    "-fx-background-radius: 10; -fx-border-radius: 10; " +
                    "-fx-cursor: hand; -fx-padding: 15;");
        
        // Efectos hover
        btn.setOnMouseEntered(e -> {
            btn.setStyle("-fx-background-color: #CC0000; -fx-text-fill: white; " +
                        "-fx-font-size: 18px; -fx-font-weight: bold; " +
                        "-fx-border-color: #CC0000; -fx-border-width: 2; " +
                        "-fx-background-radius: 10; -fx-border-radius: 10; " +
                        "-fx-cursor: hand; -fx-padding: 15; -fx-scale-x: 1.02; -fx-scale-y: 1.02;");
        });
        
        btn.setOnMouseExited(e -> {
            btn.setStyle("-fx-background-color: #F5F5F5; -fx-text-fill: #333333; " +
                        "-fx-font-size: 18px; -fx-font-weight: bold; " +
                        "-fx-border-color: #E0E0E0; -fx-border-width: 2; " +
                        "-fx-background-radius: 10; -fx-border-radius: 10; " +
                        "-fx-cursor: hand; -fx-padding: 15;");
        });
        
        btn.setOnAction(e -> {
            idiomaSeleccionado = codigoIdioma;
            GestorIdiomas.setIdioma(codigoIdioma);
            seleccionConfirmada = true;
            close();
        });
        
        return btn;
    }
    
    /**
     * Obtiene el idioma seleccionado por el usuario.
     * @return Código del idioma seleccionado
     */
    public String getIdiomaSeleccionado() {
        return idiomaSeleccionado;
    }
    
    /**
     * Verifica si el usuario confirmó su selección.
     * @return true si se confirmó, false si se cerró sin seleccionar
     */
    public boolean isSeleccionConfirmada() {
        return seleccionConfirmada;
    }
}
