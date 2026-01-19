package edu.diego.quiroz.actividad1.ui;

import edu.diego.quiroz.actividad1.process.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.util.*;

public class DialogoExtras extends Stage {
    private List<Extra> extrasSeleccionados;
    private List<CheckBox> checkBoxes;
    
    private static List<Extra> getExtrasDisponibles() {
        return Arrays.asList(
            new Extra("ext1", GestorIdiomas.t("extras_quemacocos"), GestorIdiomas.t("extras_quemacocos_desc"), 5000.0, GestorIdiomas.t("extras_confort")),
            new Extra("ext2", GestorIdiomas.t("extras_asientos"), GestorIdiomas.t("extras_asientos_desc"), 3500.0, GestorIdiomas.t("extras_confort")),
            new Extra("ext3", GestorIdiomas.t("extras_navegacion"), GestorIdiomas.t("extras_navegacion_desc"), 2500.0, GestorIdiomas.t("extras_tecnologia")),
            new Extra("ext4", GestorIdiomas.t("extras_camara"), GestorIdiomas.t("extras_camara_desc"), 1500.0, GestorIdiomas.t("extras_seguridad")),
            new Extra("ext5", GestorIdiomas.t("extras_sensores"), GestorIdiomas.t("extras_sensores_desc"), 1200.0, GestorIdiomas.t("extras_seguridad")),
            new Extra("ext6", GestorIdiomas.t("extras_crucero"), GestorIdiomas.t("extras_crucero_desc"), 3000.0, GestorIdiomas.t("extras_seguridad")),
            new Extra("ext7", GestorIdiomas.t("extras_carplay"), GestorIdiomas.t("extras_carplay_desc"), 800.0, GestorIdiomas.t("extras_tecnologia")),
            new Extra("ext8", GestorIdiomas.t("extras_audio"), GestorIdiomas.t("extras_audio_desc"), 2800.0, GestorIdiomas.t("extras_entretenimiento")),
            new Extra("ext9", GestorIdiomas.t("extras_rines"), GestorIdiomas.t("extras_rines_desc"), 1800.0, GestorIdiomas.t("extras_estetica")),
            new Extra("ext10", GestorIdiomas.t("extras_led"), GestorIdiomas.t("extras_led_desc"), 2200.0, GestorIdiomas.t("extras_estetica"))
        );
    }
    
    public DialogoExtras() {
        extrasSeleccionados = new ArrayList<>();
        checkBoxes = new ArrayList<>();
        
        setTitle(GestorIdiomas.t("extras_titulo"));
        initModality(Modality.APPLICATION_MODAL);
        
        VBox contenedorPrincipal = new VBox(0);
        contenedorPrincipal.setStyle("-fx-background-color: #FFFFFF;");
        
        // Header moderno
        VBox header = new VBox(10);
        header.setPadding(new Insets(25, 30, 25, 30));
        header.setStyle("-fx-background-color: #CC0000; " +
                       "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0, 0, 3);");
        
        Label titulo = new Label(GestorIdiomas.t("extras_header"));
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        Label subtitulo = new Label(GestorIdiomas.t("extras_subtitulo"));
        subtitulo.setStyle("-fx-font-size: 13px; -fx-text-fill: rgba(255,255,255,0.9);");
        
        header.getChildren().addAll(titulo, subtitulo);
        contenedorPrincipal.getChildren().add(header);
        
        // Contenedor del cuerpo
        VBox cuerpo = new VBox(15);
        cuerpo.setPadding(new Insets(20, 30, 20, 30));
        
        // Área de scroll para los extras
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(400);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent; " +
                           "-fx-border-color: transparent;");
        
        VBox listaExtras = new VBox(12);
        listaExtras.setPadding(new Insets(5));
        
        // Agrupar extras por categoría
        Map<String, List<Extra>> extrasPorCategoria = new LinkedHashMap<>();
        List<Extra> extrasDisponibles = getExtrasDisponibles();
        for (Extra extra : extrasDisponibles) {
            extrasPorCategoria.computeIfAbsent(extra.getCategoria(), k -> new ArrayList<>()).add(extra);
        }
        
        // Crear UI por categoría
        for (Map.Entry<String, List<Extra>> entrada : extrasPorCategoria.entrySet()) {
            Label categoria = new Label("━━━ " + entrada.getKey().toUpperCase() + " ━━━");
            categoria.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #CC0000; " +
                              "-fx-padding: 10 0 5 0;");
            listaExtras.getChildren().add(categoria);
            
            for (Extra extra : entrada.getValue()) {
                HBox itemExtra = crearItemExtra(extra);
                listaExtras.getChildren().add(itemExtra);
            }
            Separator sep = new Separator();
            sep.setStyle("-fx-padding: 5 0;");
            listaExtras.getChildren().add(sep);
        }
        
        scrollPane.setContent(listaExtras);
        cuerpo.getChildren().add(scrollPane);
        
        // Panel de resumen
        HBox resumenPanel = new HBox(10);
        resumenPanel.setAlignment(Pos.CENTER);
        resumenPanel.setPadding(new Insets(15));
        resumenPanel.setStyle("-fx-background-color: #F5F5F5; -fx-background-radius: 8;");
        Label lblResumen = new Label(String.format(GestorIdiomas.t("extras_total"), 0, 0.0));
        lblResumen.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #666666;");
        resumenPanel.getChildren().add(lblResumen);
        cuerpo.getChildren().add(resumenPanel);
        
        // Actualizar resumen
        for (CheckBox cb : checkBoxes) {
            cb.selectedProperty().addListener((obs, oldVal, newVal) -> {
                int count = 0;
                double total = 0;
                for (CheckBox checkbox : checkBoxes) {
                    if (checkbox.isSelected()) {
                        count++;
                        total += ((Extra) checkbox.getUserData()).getPrecio();
                    }
                }
                lblResumen.setText(String.format(GestorIdiomas.t("extras_total"), count, total));
            });
        }
        
        // Botones modernos
        HBox panelBotones = new HBox(12);
        panelBotones.setAlignment(Pos.CENTER_RIGHT);
        panelBotones.setPadding(new Insets(0));
        Button btnCancelar = new Button(GestorIdiomas.t("cancelar"));
        btnCancelar.setStyle("-fx-background-color: transparent; -fx-text-fill: #666666; " +
                            "-fx-font-size: 14px; -fx-padding: 12 25; -fx-cursor: hand; " +
                            "-fx-border-color: #CCCCCC; -fx-border-width: 2; -fx-border-radius: 8; " +
                            "-fx-background-radius: 8;");
        btnCancelar.setOnMouseEntered(e -> btnCancelar.setStyle("-fx-background-color: #F5F5F5; -fx-text-fill: #333333; " +
                            "-fx-font-size: 14px; -fx-padding: 12 25; -fx-cursor: hand; " +
                            "-fx-border-color: #999999; -fx-border-width: 2; -fx-border-radius: 8; " +
                            "-fx-background-radius: 8;"));
        btnCancelar.setOnMouseExited(e -> btnCancelar.setStyle("-fx-background-color: transparent; -fx-text-fill: #666666; " +
                            "-fx-font-size: 14px; -fx-padding: 12 25; -fx-cursor: hand; " +
                            "-fx-border-color: #CCCCCC; -fx-border-width: 2; -fx-border-radius: 8; " +
                            "-fx-background-radius: 8;"));
        btnCancelar.setOnAction(e -> {
            extrasSeleccionados.clear();
            close();
        });
        
        Button btnAceptar = new Button(GestorIdiomas.t("extras_confirmar"));
        btnAceptar.setStyle("-fx-background-color: #CC0000; -fx-text-fill: white; " +
                           "-fx-font-size: 14px; -fx-padding: 12 30; -fx-cursor: hand; " +
                           "-fx-background-radius: 8; -fx-font-weight: bold; " +
                           "-fx-effect: dropshadow(gaussian, rgba(204,0,0,0.4), 8, 0, 0, 2);");
        btnAceptar.setOnMouseEntered(e -> btnAceptar.setStyle("-fx-background-color: #E60000; -fx-text-fill: white; " +
                           "-fx-font-size: 14px; -fx-padding: 12 30; -fx-cursor: hand; " +
                           "-fx-background-radius: 8; -fx-font-weight: bold; " +
                           "-fx-effect: dropshadow(gaussian, rgba(204,0,0,0.6), 10, 0, 0, 3);"));
        btnAceptar.setOnMouseExited(e -> btnAceptar.setStyle("-fx-background-color: #CC0000; -fx-text-fill: white; " +
                           "-fx-font-size: 14px; -fx-padding: 12 30; -fx-cursor: hand; " +
                           "-fx-background-radius: 8; -fx-font-weight: bold; " +
                           "-fx-effect: dropshadow(gaussian, rgba(204,0,0,0.4), 8, 0, 0, 2);"));
        btnAceptar.setOnAction(e -> {
            actualizarExtrasSeleccionados();
            close();
        });
        
        panelBotones.getChildren().addAll(btnCancelar, btnAceptar);
        cuerpo.getChildren().add(panelBotones);
        
        contenedorPrincipal.getChildren().add(cuerpo);
        contenedorPrincipal.getChildren().addAll(titulo, scrollPane, panelBotones);
        
        Scene scene = new Scene(contenedorPrincipal, 650, 650);
        setScene(scene);
    }
    
    private HBox crearItemExtra(Extra extra) {
        HBox item = new HBox(15);
        item.setAlignment(Pos.CENTER_LEFT);
        item.setPadding(new Insets(12, 15, 12, 15));
        item.setStyle("-fx-background-color: white; -fx-background-radius: 10; " +
                     "-fx-border-color: #E0E0E0; -fx-border-radius: 10; -fx-border-width: 1.5; " +
                     "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.05), 5, 0, 0, 2);");
        
        // Hover effect
        item.setOnMouseEntered(e -> item.setStyle("-fx-background-color: #FAFAFA; -fx-background-radius: 10; " +
                     "-fx-border-color: #CC0000; -fx-border-radius: 10; -fx-border-width: 1.5; " +
                     "-fx-effect: dropshadow(gaussian, rgba(204,0,0,0.15), 8, 0, 0, 3); " +
                     "-fx-cursor: hand;"));
        item.setOnMouseExited(e -> item.setStyle("-fx-background-color: white; -fx-background-radius: 10; " +
                     "-fx-border-color: #E0E0E0; -fx-border-radius: 10; -fx-border-width: 1.5; " +
                     "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.05), 5, 0, 0, 2);"));
        
        CheckBox checkBox = new CheckBox();
        checkBox.setUserData(extra);
        checkBox.setStyle("-fx-cursor: hand;");
        checkBoxes.add(checkBox);
        
        // Ícono de categoría
        Label icono = new Label(getIconoCategoria(extra.getCategoria()));
        icono.setStyle("-fx-font-size: 24px; -fx-padding: 5;");
        
        VBox infoBox = new VBox(4);
        Label nombre = new Label(extra.getNombre());
        nombre.setStyle("-fx-font-weight: bold; -fx-text-fill: #333333; -fx-font-size: 13px;");
        
        Label descripcion = new Label(extra.getDescripcion());
        descripcion.setStyle("-fx-font-size: 11px; -fx-text-fill: #666666;");
        descripcion.setWrapText(true);
        descripcion.setMaxWidth(300);
        
        infoBox.getChildren().addAll(nombre, descripcion);
        HBox.setHgrow(infoBox, Priority.ALWAYS);
        
        VBox precioBox = new VBox(2);
        precioBox.setAlignment(Pos.CENTER_RIGHT);
        Label precio = new Label(String.format("$%,.2f", extra.getPrecio()));
        precio.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #CC0000;");
        Label lblPrecio = new Label("MXN");
        lblPrecio.setStyle("-fx-font-size: 9px; -fx-text-fill: #999999;");
        precioBox.getChildren().addAll(precio, lblPrecio);
        
        item.getChildren().addAll(checkBox, icono, infoBox, precioBox);
        
        // Click en toda la tarjeta
        item.setOnMouseClicked(e -> {
            if (e.getTarget() != checkBox) {
                checkBox.setSelected(!checkBox.isSelected());
            }
        });
        
        return item;
    }
    
    private String getIconoCategoria(String categoria) {
        switch (categoria) {
            case "Confort": return "🛋️";
            case "Tecnología": return "📱";
            case "Seguridad": return "🛡️";
            case "Entretenimiento": return "🎵";
            case "Estética": return "✨";
            default: return "⭐";
        }
    }
    
    private void actualizarExtrasSeleccionados() {
        extrasSeleccionados.clear();
        for (CheckBox cb : checkBoxes) {
            if (cb.isSelected()) {
                extrasSeleccionados.add((Extra) cb.getUserData());
            }
        }
    }
    
    public List<Extra> getExtrasSeleccionados() {
        return new ArrayList<>(extrasSeleccionados);
    }
    
    public void setExtrasSeleccionados(List<Extra> extras) {
        for (CheckBox cb : checkBoxes) {
            Extra extraCB = (Extra) cb.getUserData();
            cb.setSelected(extras.stream().anyMatch(e -> e.getNombre().equals(extraCB.getNombre())));
        }
    }
}
