package edu.diego.quiroz.actividad1.process;

import java.time.LocalDateTime;
import java.util.List;

public class Ticket {
    private String id;
    private LocalDateTime fecha;
    private List<Vehiculo> vehiculos;
    private double subtotal;
    private double iva;
    private double total;
    private String cliente;
    
    public Ticket(String id, LocalDateTime fecha, List<Vehiculo> vehiculos, 
                 double subtotal, double iva, double total, String cliente) {
        this.id = id;
        this.fecha = fecha;
        this.vehiculos = vehiculos;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.cliente = cliente;
    }
    
    // Getters
    public String getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public List<Vehiculo> getVehiculos() { return vehiculos; }
    public double getSubtotal() { return subtotal; }
    public double getIva() { return iva; }
    public double getTotal() { return total; }
    public String getCliente() { return cliente; }
    
    // Setters
    public void setId(String id) { this.id = id; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public void setVehiculos(List<Vehiculo> vehiculos) { this.vehiculos = vehiculos; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public void setIva(double iva) { this.iva = iva; }
    public void setTotal(double total) { this.total = total; }
    public void setCliente(String cliente) { this.cliente = cliente; }
}
