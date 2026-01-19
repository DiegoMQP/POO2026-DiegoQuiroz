package edu.diego.quiroz.actividad1.process;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import edu.diego.quiroz.actividad1.process.*;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GeneradorPDF {
    
    private static final BaseColor ROJO_MAZDA = new BaseColor(204, 0, 0);
    private static final BaseColor GRIS_OSCURO = new BaseColor(51, 51, 51);
    private static final BaseColor GRIS_CLARO = new BaseColor(245, 245, 245);
    private static final BaseColor AZUL_INFO = new BaseColor(33, 150, 243);
    
    public static void generarTicket(Ticket ticket, String nombreArchivo) {
        try {
            Document documento = new Document(PageSize.LETTER, 40, 40, 50, 50);
            PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));
            
            documento.open();
            
            // ============= ENCABEZADO PREMIUM =============
            agregarEncabezado(documento);
            
            // ============= INFORMACIÓN DEL TICKET =============
            agregarInfoTicket(documento, ticket);
            
            // ============= DETALLE DE VEHÍCULOS =============
            for (int i = 0; i < ticket.getVehiculos().size(); i++) {
                Vehiculo v = ticket.getVehiculos().get(i);
                agregarDetalleVehiculo(documento, v, i + 1);
                documento.add(new Paragraph(" "));
            }
            
            // ============= RESUMEN FINANCIERO =============
            agregarResumenFinanciero(documento, ticket);
            
            // ============= INFORMACIÓN ADICIONAL =============
            agregarInfoAdicional(documento);
            
            // ============= PIE DE PÁGINA =============
            agregarPiePagina(documento);
            
            documento.close();
            System.out.println("✓ PDF generado correctamente: " + nombreArchivo);
            
        } catch (Exception e) {
            System.err.println("✗ Error al generar PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void agregarEncabezado(Document doc) throws DocumentException {
        // Fondo rojo del header
        PdfPTable headerBg = new PdfPTable(1);
        headerBg.setWidthPercentage(100);
        PdfPCell bgCell = new PdfPCell();
        bgCell.setBackgroundColor(ROJO_MAZDA);
        bgCell.setBorder(Rectangle.NO_BORDER);
        bgCell.setPadding(20);
        
        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 28, BaseColor.WHITE);
        Paragraph titulo = new Paragraph(GestorIdiomas.t("pdf_titulo"), fuenteTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        
        Font fuenteSubtitulo = FontFactory.getFont(FontFactory.HELVETICA, 11, BaseColor.WHITE);
        Paragraph subtitulo = new Paragraph(GestorIdiomas.t("pdf_subtitulo"), fuenteSubtitulo);
        subtitulo.setAlignment(Element.ALIGN_CENTER);
        subtitulo.setSpacingBefore(5);
        
        bgCell.addElement(titulo);
        bgCell.addElement(subtitulo);
        headerBg.addCell(bgCell);
        
        doc.add(headerBg);
        doc.add(new Paragraph(" "));
    }
    
    private static void agregarInfoTicket(Document doc, Ticket ticket) throws DocumentException {
        PdfPTable tabla = new PdfPTable(2);
        tabla.setWidthPercentage(100);
        tabla.setWidths(new float[]{1, 1});
        
        Font fuenteLabel = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, GRIS_OSCURO);
        Font fuenteValor = FontFactory.getFont(FontFactory.HELVETICA, 10, GRIS_OSCURO);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        // Ticket No
        PdfPCell cellTicket = new PdfPCell();
        cellTicket.setBorder(Rectangle.BOTTOM);
        cellTicket.setBorderColor(BaseColor.LIGHT_GRAY);
        cellTicket.setPadding(8);
        cellTicket.addElement(new Phrase(GestorIdiomas.t("pdf_ticket_no"), fuenteLabel));
        cellTicket.addElement(new Phrase(ticket.getId(), fuenteValor));
        tabla.addCell(cellTicket);
        
        // Fecha
        PdfPCell cellFecha = new PdfPCell();
        cellFecha.setBorder(Rectangle.BOTTOM);
        cellFecha.setBorderColor(BaseColor.LIGHT_GRAY);
        cellFecha.setPadding(8);
        cellFecha.addElement(new Phrase(GestorIdiomas.t("pdf_fecha"), fuenteLabel));
        cellFecha.addElement(new Phrase(ticket.getFecha().format(formatter), fuenteValor));
        tabla.addCell(cellFecha);
        
        // Cliente
        PdfPCell cellCliente = new PdfPCell();
        cellCliente.setBorder(Rectangle.BOTTOM);
        cellCliente.setBorderColor(BaseColor.LIGHT_GRAY);
        cellCliente.setPadding(8);
        cellCliente.addElement(new Phrase(GestorIdiomas.t("pdf_cliente"), fuenteLabel));
        cellCliente.addElement(new Phrase(ticket.getCliente(), fuenteValor));
        tabla.addCell(cellCliente);
        
        // Vendedor
        PdfPCell cellVendedor = new PdfPCell();
        cellVendedor.setBorder(Rectangle.BOTTOM);
        cellVendedor.setBorderColor(BaseColor.LIGHT_GRAY);
        cellVendedor.setPadding(8);
        cellVendedor.addElement(new Phrase(GestorIdiomas.t("pdf_vendedor"), fuenteLabel));
        cellVendedor.addElement(new Phrase(GestorIdiomas.t("pdf_vendedor_nombre"), fuenteValor));
        tabla.addCell(cellVendedor);
        
        doc.add(tabla);
        doc.add(new Paragraph(" "));
        doc.add(new Paragraph(" "));
    }
    
    private static void agregarDetalleVehiculo(Document doc, Vehiculo v, int numero) throws DocumentException {
        // Título del vehículo
        Font fuenteTituloVehiculo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, ROJO_MAZDA);
        Paragraph tituloVeh = new Paragraph(String.format(GestorIdiomas.t("pdf_vehiculo"), numero), fuenteTituloVehiculo);
        doc.add(tituloVeh);
        doc.add(new Paragraph(" ", FontFactory.getFont(FontFactory.HELVETICA, 5)));
        
        // Card del vehículo
        PdfPTable cardVehiculo = new PdfPTable(1);
        cardVehiculo.setWidthPercentage(100);
        PdfPCell card = new PdfPCell();
        card.setBackgroundColor(GRIS_CLARO);
        card.setPadding(15);
        card.setBorder(Rectangle.BOX);
        card.setBorderColor(BaseColor.LIGHT_GRAY);
        card.setBorderWidth(1.5f);
        
        Font fuenteNombreVeh = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, GRIS_OSCURO);
        Font fuenteEspec = FontFactory.getFont(FontFactory.HELVETICA, 10, GRIS_OSCURO);
        Font fuentePrecio = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, ROJO_MAZDA);
        
        // Nombre del vehículo
        Paragraph nombreVeh = new Paragraph(v.getMarca() + " " + v.getModelo() + " " + v.getAño(), fuenteNombreVeh);
        nombreVeh.setSpacingAfter(10);
        card.addElement(nombreVeh);
        
        // Especificaciones
        PdfPTable especTable = new PdfPTable(2);
        especTable.setWidthPercentage(100);
        especTable.setWidths(new float[]{1, 1});
        
        agregarEspecificacion(especTable, GestorIdiomas.t("pdf_tipo"), v.getTipo(), fuenteEspec);
        agregarEspecificacion(especTable, GestorIdiomas.t("pdf_color"), v.getColor(), fuenteEspec);
        agregarEspecificacion(especTable, GestorIdiomas.t("pdf_motor"), v.getMotor(), fuenteEspec);
        agregarEspecificacion(especTable, GestorIdiomas.t("pdf_transmision"), v.getTransmision(), fuenteEspec);
        agregarEspecificacion(especTable, GestorIdiomas.t("pdf_combustible"), v.getCombustible(), fuenteEspec);
        agregarEspecificacion(especTable, GestorIdiomas.t("pdf_pasajeros"), String.valueOf(v.getPasajeros()), fuenteEspec);
        
        // Info específica según tipo de vehículo
        if (v instanceof VehiculoSeminuevo) {
            VehiculoSeminuevo seminuevo = (VehiculoSeminuevo) v;
            agregarEspecificacion(especTable, GestorIdiomas.t("pdf_kilometraje"), String.format("%,d km", seminuevo.getKilometraje()), fuenteEspec);
            agregarEspecificacion(especTable, GestorIdiomas.t("pdf_condicion"), GestorIdiomas.t("pdf_seminuevo"), fuenteEspec);
        } else if (v instanceof VehiculoNuevo) {
            agregarEspecificacion(especTable, GestorIdiomas.t("pdf_garantia"), GestorIdiomas.t("pdf_garantia_fabrica"), fuenteEspec);
            agregarEspecificacion(especTable, GestorIdiomas.t("pdf_condicion"), GestorIdiomas.t("pdf_nuevo"), fuenteEspec);
        }
        
        card.addElement(especTable);
        
        // EXTRAS (solo para vehículos nuevos)
        if (v instanceof VehiculoNuevo) {
            VehiculoNuevo nuevo = (VehiculoNuevo) v;
            List<Extra> extras = nuevo.getExtras();
            
            if (extras != null && !extras.isEmpty()) {
                Paragraph tituloExtras = new Paragraph(GestorIdiomas.t("pdf_extras"), 
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, ROJO_MAZDA));
                tituloExtras.setSpacingBefore(10);
                card.addElement(tituloExtras);
                
                for (Extra extra : extras) {
                    Font fuenteExtra = FontFactory.getFont(FontFactory.HELVETICA, 9, GRIS_OSCURO);
                    Paragraph pExtra = new Paragraph(
                        String.format("  ✓ %s - $%.2f MXN", extra.getNombre(), extra.getPrecio()),
                        fuenteExtra
                    );
                    pExtra.setSpacingBefore(3);
                    card.addElement(pExtra);
                }
            }
        }
        
        // Precio
        Paragraph precio = new Paragraph(
            String.format(GestorIdiomas.t("pdf_precio_final"), v.calcularPrecioFinal()),
            fuentePrecio
        );
        precio.setSpacingBefore(10);
        card.addElement(precio);
        
        cardVehiculo.addCell(card);
        doc.add(cardVehiculo);
    }
    
    private static void agregarEspecificacion(PdfPTable tabla, String label, String valor, Font fuente) {
        Font fuenteBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, GRIS_OSCURO);
        
        PdfPCell cellLabel = new PdfPCell(new Phrase(label, fuenteBold));
        cellLabel.setBorder(Rectangle.NO_BORDER);
        cellLabel.setPadding(4);
        
        PdfPCell cellValor = new PdfPCell(new Phrase(valor, fuente));
        cellValor.setBorder(Rectangle.NO_BORDER);
        cellValor.setPadding(4);
        
        tabla.addCell(cellLabel);
        tabla.addCell(cellValor);
    }
    
    private static void agregarResumenFinanciero(Document doc, Ticket ticket) throws DocumentException {
        doc.add(new Paragraph(" "));
        
        Font fuenteTituloResumen = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, ROJO_MAZDA);
        Paragraph tituloResumen = new Paragraph(GestorIdiomas.t("pdf_resumen"), fuenteTituloResumen);
        doc.add(tituloResumen);
        doc.add(new Paragraph(" ", FontFactory.getFont(FontFactory.HELVETICA, 5)));
        
        PdfPTable tabla = new PdfPTable(2);
        tabla.setWidthPercentage(100);
        tabla.setWidths(new float[]{3, 1});
        
        Font fuenteConcepto = FontFactory.getFont(FontFactory.HELVETICA, 12, GRIS_OSCURO);
        Font fuenteMonto = FontFactory.getFont(FontFactory.HELVETICA, 12, GRIS_OSCURO);
        Font fuenteTotal = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.WHITE);
        
        // Subtotal
        agregarFilaResumen(tabla, GestorIdiomas.t("pdf_subtotal"), String.format("$%.2f", ticket.getSubtotal()), 
                          fuenteConcepto, fuenteMonto, BaseColor.WHITE);
        
        // IVA
        agregarFilaResumen(tabla, GestorIdiomas.t("pdf_iva"), String.format("$%.2f", ticket.getIva()), 
                          fuenteConcepto, fuenteMonto, BaseColor.WHITE);
        
        // Total (con fondo rojo)
        agregarFilaResumen(tabla, GestorIdiomas.t("pdf_total_pagar"), String.format("$%.2f MXN", ticket.getTotal()), 
                          fuenteTotal, fuenteTotal, ROJO_MAZDA);
        
        doc.add(tabla);
    }
    
    private static void agregarFilaResumen(PdfPTable tabla, String concepto, String monto, 
                                           Font fuenteConcepto, Font fuenteMonto, BaseColor bgColor) {
        PdfPCell cellConcepto = new PdfPCell(new Phrase(concepto, fuenteConcepto));
        cellConcepto.setBackgroundColor(bgColor);
        cellConcepto.setBorder(Rectangle.BOX);
        cellConcepto.setBorderColor(BaseColor.LIGHT_GRAY);
        cellConcepto.setPadding(10);
        
        PdfPCell cellMonto = new PdfPCell(new Phrase(monto, fuenteMonto));
        cellMonto.setBackgroundColor(bgColor);
        cellMonto.setBorder(Rectangle.BOX);
        cellMonto.setBorderColor(BaseColor.LIGHT_GRAY);
        cellMonto.setPadding(10);
        cellMonto.setHorizontalAlignment(Element.ALIGN_RIGHT);
        
        tabla.addCell(cellConcepto);
        tabla.addCell(cellMonto);
    }
    
    private static void agregarInfoAdicional(Document doc) throws DocumentException {
        doc.add(new Paragraph(" "));
        
        PdfPTable infoBox = new PdfPTable(1);
        infoBox.setWidthPercentage(100);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(new BaseColor(230, 245, 255));
        cell.setBorder(Rectangle.BOX);
        cell.setBorderColor(AZUL_INFO);
        cell.setBorderWidth(2);
        cell.setPadding(15);
        
        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, AZUL_INFO);
        Font fuenteTexto = FontFactory.getFont(FontFactory.HELVETICA, 9, GRIS_OSCURO);
        
        Paragraph titulo = new Paragraph(GestorIdiomas.t("pdf_info_titulo"), fuenteTitulo);
        titulo.setSpacingAfter(8);
        cell.addElement(titulo);
        
        cell.addElement(new Phrase(GestorIdiomas.t("pdf_info_garantia"), fuenteTexto));
        cell.addElement(new Phrase(GestorIdiomas.t("pdf_info_precios"), fuenteTexto));
        cell.addElement(new Phrase(GestorIdiomas.t("pdf_info_pago"), fuenteTexto));
        cell.addElement(new Phrase(GestorIdiomas.t("pdf_info_entrega"), fuenteTexto));
        cell.addElement(new Phrase(GestorIdiomas.t("pdf_info_consulte"), fuenteTexto));
        
        infoBox.addCell(cell);
        doc.add(infoBox);
    }
    
    private static void agregarPiePagina(Document doc) throws DocumentException {
        doc.add(new Paragraph(" "));
        
        Font fuentePie = FontFactory.getFont(FontFactory.HELVETICA, 9, BaseColor.GRAY);
        Font fuentePieBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9, GRIS_OSCURO);
        
        Paragraph linea = new Paragraph("═══════════════════════════════════════════════════════", fuentePie);
        linea.setAlignment(Element.ALIGN_CENTER);
        doc.add(linea);
        
        Paragraph contacto = new Paragraph(GestorIdiomas.t("pdf_titulo"), fuentePieBold);
        contacto.setAlignment(Element.ALIGN_CENTER);
        contacto.setSpacingBefore(5);
        doc.add(contacto);
        
        Paragraph info = new Paragraph(GestorIdiomas.t("pdf_contacto"), fuentePie);
        info.setAlignment(Element.ALIGN_CENTER);
        doc.add(info);
        
        Paragraph web = new Paragraph(GestorIdiomas.t("pdf_web"), fuentePie);
        web.setAlignment(Element.ALIGN_CENTER);
        doc.add(web);
        
        Paragraph gracias = new Paragraph(GestorIdiomas.t("pdf_gracias"), fuentePieBold);
        gracias.setAlignment(Element.ALIGN_CENTER);
        doc.add(gracias);
    }
}
