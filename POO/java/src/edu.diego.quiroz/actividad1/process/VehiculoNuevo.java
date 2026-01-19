package edu.diego.quiroz.actividad1.process;

import java.util.ArrayList;
import java.util.List;

public class VehiculoNuevo extends Vehiculo {
    private List<Extra> extras;
    
    public VehiculoNuevo(String marca, String modelo, int año, String color, String motor,
                        String transmision, String combustible, int pasajeros, double precio,
                        String tipo, String urlImagen) {
        super(marca, modelo, año, color, motor, transmision, combustible, pasajeros, precio, tipo, urlImagen);
        this.extras = new ArrayList<>();
    }
    
    public void agregarExtra(Extra extra) {
        if (!extras.contains(extra)) {
            extras.add(extra);
        }
    }
    
    public void eliminarExtra(Extra extra) {
        extras.remove(extra);
    }
    
    public List<Extra> getExtras() {
        return new ArrayList<>(extras);
    }
    
    public void setExtras(List<Extra> extras) {
        this.extras = new ArrayList<>(extras);
    }
    
    @Override
    protected String obtenerDetallesEspecificos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehículo NUEVO - Garantía de fábrica");
        if (!extras.isEmpty()) {
            sb.append("\nExtras: ");
            for (Extra extra : extras) {
                sb.append(extra.getNombre()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }
    
    @Override
    public double calcularPrecioFinal() {
        double precioFinal = precio;
        for (Extra extra : extras) {
            precioFinal += extra.getPrecio();
        }
        return precioFinal;
    }
}
