package edu.diego.quiroz.actividad1.process;

public class VehiculoSeminuevo extends Vehiculo {
    private int kilometraje;
    
    public VehiculoSeminuevo(String marca, String modelo, int año, String color, String motor,
                            String transmision, String combustible, int pasajeros, double precio,
                            String tipo, String urlImagen, int kilometraje) {
        super(marca, modelo, año, color, motor, transmision, combustible, pasajeros, precio, tipo, urlImagen);
        this.kilometraje = kilometraje;
    }
    
    public int getKilometraje() {
        return kilometraje;
    }
    
    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
    
    @Override
    protected String obtenerDetallesEspecificos() {
        String condicion;
        if (kilometraje < 30000) {
            condicion = "Excelente estado";
        } else if (kilometraje < 80000) {
            condicion = "Buen estado";
        } else {
            condicion = "Estado aceptable";
        }
        return String.format("Vehículo SEMINUEVO - %s\nKilometraje: %,d km", condicion, kilometraje);
    }
    
    @Override
    public double calcularPrecioFinal() {
        double factor = 1.0;
        if (kilometraje < 30000) {
            factor = 0.95;
        } else if (kilometraje < 80000) {
            factor = 0.85;
        } else {
            factor = 0.75;
        }
        return precio * factor;
    }
}
