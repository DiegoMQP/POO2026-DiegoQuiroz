package edu.diego.quiroz.actividad1.process;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TicketVenta {
    private Cliente cliente;
    private ArrayList<Vehiculo> vehiculosComprados;
    private LocalDateTime fechaTransaccion;
    private static int numeroTicket = 1000;
    private int idTicket;

    public TicketVenta(Cliente cliente, ArrayList<Vehiculo> vehiculosComprados) {
        this.cliente = cliente;
        this.vehiculosComprados = vehiculosComprados;
        this.fechaTransaccion = LocalDateTime.now();
        this.idTicket = ++numeroTicket;
    }

    public double calcularTotal() {
        double total = 0;
        for (Vehiculo vehiculo : vehiculosComprados) {
            total += vehiculo.getPrecio();
        }
        return total;
    }

    public void generarTicket() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = fechaTransaccion.format(formatter);

        System.out.println("\n");
        System.out.println("+=================================================================");
        System.out.println("|                         TECMINUEVOS                             |");
        System.out.println("|                       TICKET DE VENTA                           |");
        System.out.println("+=================================================================");
        System.out.println("| Ticket No: " + idTicket);
        System.out.println("| Fecha: " + fechaFormateada);
        System.out.println("+=================================================================");
        System.out.println("| Cliente: " + cliente.getNombre());
        System.out.println("| Telefono: " + cliente.getTelefono());
        System.out.println("| Email: " + cliente.getEmail());
        System.out.println("+=================================================================");
        System.out.println("|                      VEHICULOS COMPRADOS                        |");
        System.out.println("+=================================================================");

        int contador = 1;
        for (Vehiculo vehiculo : vehiculosComprados) {
            System.out.println("| " + contador++ + ". " + vehiculo.getDescripcionBreve());
            System.out.println("|    Color: " + vehiculo.getColor());
            System.out.println("|    Precio: $" + String.format("%,.2f", vehiculo.getPrecio()));
            System.out.println("|                                                                 |");
        }

        System.out.println("+=================================================================");
        System.out.println("| TOTAL A PAGAR:                              $" + String.format("%,.2f", calcularTotal()));
        System.out.println("+=================================================================");
        System.out.println("\n!Gracias por su compra!");
        
        String rutaPDF = GeneradorPDF.generarTicketPDF(cliente, vehiculosComprados, idTicket, fechaTransaccion);
        if (rutaPDF != null) {
            System.out.println("\n[OK] Ticket guardado en: " + rutaPDF);
        } else {
            System.out.println("\n[!] No se pudo guardar el ticket en archivo.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Vehiculo> getVehiculosComprados() {
        return vehiculosComprados;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public int getIdTicket() {
        return idTicket;
    }
}
