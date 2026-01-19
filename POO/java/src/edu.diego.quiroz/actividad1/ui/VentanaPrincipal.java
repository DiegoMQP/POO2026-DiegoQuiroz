package edu.diego.quiroz.actividad1.ui;

import edu.diego.quiroz.actividad1.process.ControladorVentas;
import edu.diego.quiroz.actividad1.process.*;
import edu.diego.quiroz.actividad1.process.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.LocalDateTime;
import java.util.*;
import static edu.diego.quiroz.actividad1.process.GestorIdiomas.t;

public class VentanaPrincipal {
    private Stage stage;
    private ControladorVentas controladorVentas;
    private VBox panelCatalogo;
    private Label lblTotal;
    private ListView<String> listaCarrito;
    private Map<String, Vehiculo> mapaVehiculos;
    
    public VentanaPrincipal(Stage stage) {
        this.stage = stage;
        this.controladorVentas = new ControladorVentas();
        this.mapaVehiculos = new HashMap<>();
        
        stage.setTitle(t("titulo_app"));
        
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #FFFFFF;");
        
        // Header
        HBox header = crearHeader();
        root.setTop(header);
        
        // Centro con catálogo
        ScrollPane scrollCatalogo = new ScrollPane();
        scrollCatalogo.setFitToWidth(true);
        scrollCatalogo.setStyle("-fx-background: #FFFFFF; -fx-background-color: #FFFFFF;");
        
        panelCatalogo = new VBox(15);
        panelCatalogo.setPadding(new Insets(20));
        panelCatalogo.setStyle("-fx-background-color: #FFFFFF;");
        
        cargarVehiculos();
        scrollCatalogo.setContent(panelCatalogo);
        root.setCenter(scrollCatalogo);
        
        // Panel derecho con carrito
        VBox panelCarrito = crearPanelCarrito();
        root.setRight(panelCarrito);
        
        Scene scene = new Scene(root, 1200, 700);
        stage.setScene(scene);
    }
    
    private HBox crearHeader() {
        HBox header = new HBox();
        header.setPadding(new Insets(20, 40, 20, 40));
        header.setStyle("-fx-background-color: #CC0000;");
        header.setAlignment(Pos.CENTER_LEFT);
        
        Label titulo = new Label(t("titulo_header"));
        titulo.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        Label subtitulo = new Label(t("subtitulo_header"));
        subtitulo.setStyle("-fx-font-size: 14px; -fx-text-fill: white; -fx-opacity: 0.9;");
        
        VBox textos = new VBox(5);
        textos.getChildren().addAll(titulo, subtitulo);
        
        header.getChildren().add(textos);
        
        return header;
    }
    
    private void cargarVehiculos() {
        panelCatalogo.getChildren().clear();
        
        // Filtros
        HBox filtros = new HBox(15);
        filtros.setAlignment(Pos.CENTER_LEFT);
        
        Button btnTodos = new Button(t("todos"));
        Button btnNuevos = new Button(t("nuevos"));
        Button btnSeminuevos = new Button(t("seminuevos"));
        Button btnSedan = new Button(t("sedan"));
        Button btnSUV = new Button(t("suv"));
        
        String estiloBoton = "-fx-background-color: #E0E0E0; -fx-text-fill: #333333; " +
                           "-fx-padding: 8 20; -fx-cursor: hand; -fx-background-radius: 5;";
        
        btnTodos.setStyle(estiloBoton);
        btnNuevos.setStyle(estiloBoton);
        btnSeminuevos.setStyle(estiloBoton);
        btnSedan.setStyle(estiloBoton);
        btnSUV.setStyle(estiloBoton);
        
        btnTodos.setOnAction(e -> mostrarVehiculos(RepositorioVehiculos.obtenerTodos()));
        btnNuevos.setOnAction(e -> mostrarVehiculos(RepositorioVehiculos.obtenerNuevos()));
        btnSeminuevos.setOnAction(e -> mostrarVehiculos(RepositorioVehiculos.obtenerSeminuevos()));
        btnSedan.setOnAction(e -> mostrarVehiculos(RepositorioVehiculos.obtenerPorTipo("Sedan")));
        btnSUV.setOnAction(e -> mostrarVehiculos(RepositorioVehiculos.obtenerPorTipo("SUV")));
        
        filtros.getChildren().addAll(
            new Label(t("filtrar")),
            btnTodos, btnNuevos, btnSeminuevos, btnSedan, btnSUV
        );
        
        panelCatalogo.getChildren().add(filtros);
        
        // Mostrar todos los vehículos inicialmente
        mostrarVehiculos(RepositorioVehiculos.obtenerTodos());
    }
    
    private void mostrarVehiculos(List<Vehiculo> vehiculos) {
        // Remover todo excepto los filtros
        if (panelCatalogo.getChildren().size() > 1) {
            panelCatalogo.getChildren().remove(1, panelCatalogo.getChildren().size());
        }
        
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(20, 0, 0, 0));
        
        int columna = 0;
        int fila = 0;
        
        for (Vehiculo v : vehiculos) {
            VBox tarjeta = crearTarjetaVehiculo(v);
            grid.add(tarjeta, columna, fila);
            
            columna++;
            if (columna >= 3) {
                columna = 0;
                fila++;
            }
        }
        
        panelCatalogo.getChildren().add(grid);
    }
    
    private VBox crearTarjetaVehiculo(Vehiculo v) {
        VBox tarjeta = new VBox(10);
        tarjeta.setPrefWidth(280);
        tarjeta.setStyle("-fx-background-color: #FAFAFA; -fx-border-color: #E0E0E0; " +
                        "-fx-border-radius: 10; -fx-background-radius: 10; -fx-padding: 15;");
        
        // Imagen
        ImageView imageView = new ImageView();
        imageView.setFitWidth(250);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);
        
        try {
            Image imagen = new Image(v.getUrlImagen(), true);
            imageView.setImage(imagen);
        } catch (Exception e) {
            Label errorImg = new Label(t("sin_imagen"));
            errorImg.setPrefSize(250, 150);
            errorImg.setAlignment(Pos.CENTER);
            errorImg.setStyle("-fx-background-color: #E0E0E0;");
        }
        
        // Información
        Label lblMarca = new Label(v.getMarca() + " " + v.getModelo());
        lblMarca.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #333333;");
        
        Label lblAño = new Label(t("año") + ": " + v.getAño() + " | " + v.getColor());
        lblAño.setStyle("-fx-font-size: 12px; -fx-text-fill: #666666;");
        
        Label lblTipo = new Label(v.getTipo());
        if (v instanceof VehiculoNuevo) {
            lblTipo = new Label(v.getTipo() + " - " + t("nuevo"));
            lblTipo.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; " +
                           "-fx-padding: 3 8; -fx-background-radius: 3; -fx-font-size: 11px;");
        } else {
            lblTipo = new Label(v.getTipo() + " - " + t("seminuevo"));
            lblTipo.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white; " +
                           "-fx-padding: 3 8; -fx-background-radius: 3; -fx-font-size: 11px;");
        }
        
        Label lblPrecio = new Label(String.format("$%.2f", v.calcularPrecioFinal()));
        lblPrecio.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #CC0000;");
        
        Button btnAgregar = new Button(t("agregar_carrito"));
        btnAgregar.setStyle("-fx-background-color: #CC0000; -fx-text-fill: white; " +
                          "-fx-padding: 10 20; -fx-cursor: hand; -fx-background-radius: 5; " +
                          "-fx-font-weight: bold;");
        btnAgregar.setMaxWidth(Double.MAX_VALUE);
        
        btnAgregar.setOnAction(e -> {
            if (v instanceof VehiculoNuevo) {
                mostrarDialogoExtras((VehiculoNuevo) v);
            } else {
                agregarAlCarrito(v);
            }
        });
        
        tarjeta.getChildren().addAll(imageView, lblMarca, lblAño, lblTipo, lblPrecio, btnAgregar);
        
        return tarjeta;
    }
    
    private void mostrarDialogoExtras(VehiculoNuevo vehiculo) {
        DialogoExtras dialogo = new DialogoExtras();
        dialogo.setExtrasSeleccionados(vehiculo.getExtras());
        dialogo.showAndWait();
        
        List<Extra> extrasSeleccionados = dialogo.getExtrasSeleccionados();
        vehiculo.setExtras(extrasSeleccionados);
        
        agregarAlCarrito(vehiculo);
    }
    
    private void agregarAlCarrito(Vehiculo v) {
        controladorVentas.agregarAlCarrito(v);
        actualizarCarrito();
        
        // Alerta moderna con estilo
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(t("vehiculo_agregado_titulo"));
        alert.setHeaderText(null);
        alert.setContentText(v.getMarca() + " " + v.getModelo() + " " + t("vehiculo_agregado_msg"));
        
        // Personalizar el diálogo
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #CC0000; " +
                           "-fx-border-width: 3; -fx-font-size: 13px;");
        dialogPane.lookup(".content.label").setStyle("-fx-font-size: 14px; -fx-text-fill: #333333; " +
                                                     "-fx-padding: 20;");
        
        // Botón personalizado
        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        okButton.setStyle("-fx-background-color: #CC0000; -fx-text-fill: white; " +
                         "-fx-font-weight: bold; -fx-padding: 10 30; -fx-background-radius: 5; " +
                         "-fx-cursor: hand;");
        
        alert.showAndWait();
    }
    
    private VBox crearPanelCarrito() {
        VBox panel = new VBox(15);
        panel.setPrefWidth(320);
        panel.setPadding(new Insets(20));
        panel.setStyle("-fx-background-color: #F5F5F5; -fx-border-color: #E0E0E0; " +
                      "-fx-border-width: 0 0 0 2;");
        
        Label titulo = new Label(t("carrito_titulo"));
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333;");
        
        listaCarrito = new ListView<>();
        listaCarrito.setPrefHeight(300);
        listaCarrito.setStyle("-fx-background-color: white;");
        
        lblTotal = new Label(t("total") + ": $0.00");
        lblTotal.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #CC0000;");
        
        Button btnVaciar = new Button(t("vaciar_carrito"));
        btnVaciar.setStyle("-fx-background-color: #E0E0E0; -fx-text-fill: #333333; " +
                          "-fx-padding: 10 20; -fx-cursor: hand; -fx-background-radius: 5;");
        btnVaciar.setMaxWidth(Double.MAX_VALUE);
        btnVaciar.setOnAction(e -> vaciarCarrito());
        
        Button btnComprar = new Button(t("generar_ticket"));
        btnComprar.setStyle("-fx-background-color: #CC0000; -fx-text-fill: white; " +
                           "-fx-padding: 15 30; -fx-cursor: hand; -fx-background-radius: 5; " +
                           "-fx-font-size: 16px; -fx-font-weight: bold;");
        btnComprar.setMaxWidth(Double.MAX_VALUE);
        btnComprar.setOnAction(e -> generarTicket());
        
        panel.getChildren().addAll(titulo, listaCarrito, lblTotal, btnVaciar, btnComprar);
        
        return panel;
    }
    
    private void actualizarCarrito() {
        listaCarrito.getItems().clear();
        mapaVehiculos.clear();
        
        for (Vehiculo v : controladorVentas.getCarrito()) {
            String descripcion = String.format("%s %s - $%.2f", 
                v.getMarca(), v.getModelo(), v.calcularPrecioFinal());
            listaCarrito.getItems().add(descripcion);
            mapaVehiculos.put(descripcion, v);
        }
        
        lblTotal.setText(String.format(t("total") + ": $%.2f", controladorVentas.getTotal()));
    }
    
    private void vaciarCarrito() {
        controladorVentas.vaciarCarrito();
        actualizarCarrito();
    }
    
    private void generarTicket() {
        if (controladorVentas.estaVacio()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(t("carrito_vacio_titulo"));
            alert.setHeaderText(null);
            alert.setContentText(t("carrito_vacio_msg"));
            
            // Personalizar diálogo de advertencia
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #FF9800; " +
                               "-fx-border-width: 3; -fx-font-size: 13px;");
            dialogPane.lookup(".content.label").setStyle("-fx-font-size: 14px; -fx-text-fill: #333333; " +
                                                         "-fx-padding: 20;");
            
            Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
            okButton.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white; " +
                             "-fx-font-weight: bold; -fx-padding: 10 30; -fx-background-radius: 5; " +
                             "-fx-cursor: hand;");
            
            alert.showAndWait();
            return;
        }
        
        // Diálogo personalizado para nombre del cliente
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle(t("info_cliente_titulo"));
        dialog.setHeaderText(t("info_cliente_header"));
        dialog.setContentText(t("nombre_completo"));
        
        // Personalizar el diálogo de input
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #CC0000; " +
                           "-fx-border-width: 3; -fx-font-size: 13px;");
        dialogPane.lookup(".content.label").setStyle("-fx-font-size: 14px; -fx-text-fill: #333333; " +
                                                     "-fx-font-weight: bold;");
        dialogPane.lookup(".text-field").setStyle("-fx-font-size: 13px; -fx-padding: 10; " +
                                                  "-fx-border-color: #E0E0E0; -fx-border-radius: 5; " +
                                                  "-fx-background-radius: 5;");
        
        // Botones personalizados
        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        okButton.setText(t("generar_ticket_btn"));
        okButton.setStyle("-fx-background-color: #CC0000; -fx-text-fill: white; " +
                         "-fx-font-weight: bold; -fx-padding: 10 25; -fx-background-radius: 5; " +
                         "-fx-cursor: hand;");
        
        Button cancelButton = (Button) dialogPane.lookupButton(ButtonType.CANCEL);
        cancelButton.setText(t("cancelar"));
        cancelButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #666666; " +
                             "-fx-border-color: #CCCCCC; -fx-border-width: 2; " +
                             "-fx-padding: 10 25; -fx-background-radius: 5; -fx-border-radius: 5; " +
                             "-fx-cursor: hand;");
        
        Optional<String> resultado = dialog.showAndWait();
        if (resultado.isPresent() && !resultado.get().trim().isEmpty()) {
            String cliente = resultado.get();
            String ticketId = "TKT-" + System.currentTimeMillis();
            
            Ticket ticket = new Ticket(
                ticketId,
                LocalDateTime.now(),
                controladorVentas.getCarrito(),
                controladorVentas.getSubtotal(),
                controladorVentas.getIva(),
                controladorVentas.getTotal(),
                cliente
            );
            
            String nombreArchivo = ticketId + ".pdf";
            GeneradorPDF.generarTicket(ticket, nombreArchivo);
            
            // Alerta de éxito personalizada
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(t("venta_exitosa_titulo"));
            alert.setHeaderText(t("ticket_generado"));
            alert.setContentText(String.format("%s: %s\n%s: %s\n%s: $%,.2f\n\n%s:\n%s",
                                               t("cliente"), cliente, t("ticket"), ticketId, 
                                               t("total"), ticket.getTotal(), 
                                               t("archivo_guardado"), nombreArchivo));
            
            DialogPane successPane = alert.getDialogPane();
            successPane.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #4CAF50; " +
                                "-fx-border-width: 3; -fx-font-size: 13px;");
            successPane.lookup(".content.label").setStyle("-fx-font-size: 13px; -fx-text-fill: #333333; " +
                                                         "-fx-padding: 20;");
            
            Button successOk = (Button) successPane.lookupButton(ButtonType.OK);
            successOk.setText(t("aceptar"));
            successOk.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; " +
                              "-fx-font-weight: bold; -fx-padding: 10 30; -fx-background-radius: 5; " +
                              "-fx-cursor: hand;");
            
            alert.showAndWait();
            
            vaciarCarrito();
        }
    }
    
    public void mostrar() {
        stage.show();
    }
}
