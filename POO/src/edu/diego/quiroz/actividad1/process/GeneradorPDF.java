package edu.diego.quiroz.actividad1.process;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GeneradorPDF {
    
    public static String generarTicketPDF(Cliente cliente, ArrayList<Vehiculo> vehiculos, 
                                         int numeroTicket, LocalDateTime fecha) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HHmmss");
        String nombreArchivo = "Ticket_" + numeroTicket + "_" + fecha.format(formatter) + ".txt";
        String rutaCompleta = System.getProperty("user.dir") + "\\" + nombreArchivo;
        
        try (FileOutputStream fos = new FileOutputStream(rutaCompleta)) {
            StringBuilder contenido = new StringBuilder();
            
            contenido.append("=================================================================\n");
            contenido.append("                         TECMINUEVOS                             \n");
            contenido.append("                       TICKET DE VENTA                           \n");
            contenido.append("=================================================================\n");
            
            DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            contenido.append("Ticket No: ").append(numeroTicket).append("\n");
            contenido.append("Fecha: ").append(fecha.format(displayFormatter)).append("\n");
            contenido.append("=================================================================\n");
            
            contenido.append("DATOS DEL CLIENTE\n");
            contenido.append("-----------------------------------------------------------------\n");
            contenido.append("Nombre:   ").append(cliente.getNombre()).append("\n");
            contenido.append("Telefono: ").append(cliente.getTelefono()).append("\n");
            contenido.append("Email:    ").append(cliente.getEmail()).append("\n");
            contenido.append("=================================================================\n");
            
            contenido.append("VEHICULOS COMPRADOS\n");
            contenido.append("=================================================================\n");
            
            double total = 0;
            int contador = 1;
            for (Vehiculo vehiculo : vehiculos) {
                contenido.append("\n").append(contador++).append(". ").append(vehiculo.getDescripcionBreve()).append("\n");
                contenido.append("   Marca:        ").append(vehiculo.getMarca()).append("\n");
                contenido.append("   Modelo:       ").append(vehiculo.getModelo()).append("\n");
                contenido.append("   Anio:         ").append(vehiculo.getAnio()).append("\n");
                contenido.append("   Color:        ").append(vehiculo.getColor()).append("\n");
                contenido.append("   Tipo:         ").append(vehiculo.getTipo()).append("\n");
                contenido.append("   Motor:        ").append(vehiculo.getMotor()).append("\n");
                contenido.append("   Transmision:  ").append(vehiculo.getTransmision()).append("\n");
                contenido.append("   Precio:       $").append(String.format("%,.2f", vehiculo.getPrecio())).append("\n");
                total += vehiculo.getPrecio();
            }
            
            contenido.append("\n=================================================================\n");
            contenido.append("TOTAL A PAGAR:                           $").append(String.format("%,.2f", total)).append("\n");
            contenido.append("=================================================================\n");
            contenido.append("\n");
            contenido.append("             Gracias por su compra en TECMINUEVOS!\n");
            contenido.append("                   Esperamos verle pronto\n");
            contenido.append("\n=================================================================\n");
            
            fos.write(contenido.toString().getBytes("UTF-8"));
            
            return rutaCompleta;
            
        } catch (Exception e) {
            System.err.println("Error al generar el ticket: " + e.getMessage());
            return null;
        }
    }
}
