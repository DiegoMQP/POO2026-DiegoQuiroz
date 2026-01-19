package edu.diego.quiroz.actividad1.process;

import edu.diego.quiroz.actividad1.process.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorVentas {
    private List<Vehiculo> carrito;
    private double subtotal;
    private double iva;
    private double total;
    private static final double IVA_PORCENTAJE = 0.16;
    
    public ControladorVentas() {
        this.carrito = new ArrayList<>();
        recalcularTotales();
    }
    
    public void agregarAlCarrito(Vehiculo vehiculo) {
        carrito.add(vehiculo);
        recalcularTotales();
    }
    
    public void eliminarDelCarrito(Vehiculo vehiculo) {
        carrito.remove(vehiculo);
        recalcularTotales();
    }
    
    public void vaciarCarrito() {
        carrito.clear();
        recalcularTotales();
    }
    
    private void recalcularTotales() {
        subtotal = 0;
        for (Vehiculo v : carrito) {
            subtotal += v.calcularPrecioFinal();
        }
        iva = subtotal * IVA_PORCENTAJE;
        total = subtotal + iva;
    }
    
    public List<Vehiculo> getCarrito() {
        return new ArrayList<>(carrito);
    }
    
    public double getSubtotal() {
        return subtotal;
    }
    
    public double getIva() {
        return iva;
    }
    
    public double getTotal() {
        return total;
    }
    
    public int getCantidadItems() {
        return carrito.size();
    }
    
    public boolean estaVacio() {
        return carrito.isEmpty();
    }
}
