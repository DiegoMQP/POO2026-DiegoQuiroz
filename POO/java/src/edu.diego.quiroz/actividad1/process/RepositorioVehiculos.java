package edu.diego.quiroz.actividad1.process;

import edu.diego.quiroz.actividad1.process.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioVehiculos {
    private static List<Vehiculo> vehiculos;
    
    static {
        vehiculos = new ArrayList<>();
        inicializarVehiculos();
    }
    
    private static void inicializarVehiculos() {
        vehiculos.add(new VehiculoNuevo("Mazda", "Mazda 3", 2024, "Rojo Soul",
            "2.5L Turbo", "Automática", "Gasolina", 5, 32000.0, "Sedan",
            "https://images.unsplash.com/photo-1617654112368-307921291f42?w=600"));
        
        vehiculos.add(new VehiculoNuevo("Mazda", "CX-5", 2024, "Azul Profundo",
            "2.5L Turbo", "Automática", "Gasolina", 5, 35000.0, "SUV",
            "https://images.unsplash.com/photo-1617654112368-307921291f42?w=600"));
        
        vehiculos.add(new VehiculoNuevo("Toyota", "Corolla", 2024, "Plata Metalizado",
            "1.8L Hybrid", "CVT", "Híbrido", 5, 28000.0, "Sedan",
            "https://images.unsplash.com/photo-1621007947382-bb3c3994e3fb?w=600"));
        
        vehiculos.add(new VehiculoNuevo("Honda", "Civic", 2024, "Negro Cristal",
            "1.5L Turbo", "Automática", "Gasolina", 5, 30000.0, "Sedan",
            "https://images.unsplash.com/photo-1590362891991-f776e747a588?w=600"));
        
        vehiculos.add(new VehiculoNuevo("Nissan", "Versa", 2024, "Blanco Perla",
            "1.6L", "Automática", "Gasolina", 5, 22000.0, "Sedan",
            "https://images.unsplash.com/photo-1605559424843-9e4c228bf1c2?w=600"));
        
        vehiculos.add(new VehiculoNuevo("Hyundai", "Tucson", 2024, "Gris Titanio",
            "2.0L Turbo", "Automática", "Gasolina", 5, 33000.0, "SUV",
            "https://images.unsplash.com/photo-1619767886558-efdc259cde1a?w=600"));
        
        vehiculos.add(new VehiculoSeminuevo("Mazda", "Mazda 3", 2022, "Gris Meteoro",
            "2.0L", "Automática", "Gasolina", 5, 25000.0, "Sedan",
            "https://images.unsplash.com/photo-1617654112368-307921291f42?w=600", 15000));
        
        vehiculos.add(new VehiculoSeminuevo("Toyota", "RAV4", 2021, "Azul Marino",
            "2.5L Hybrid", "CVT", "Híbrido", 5, 30000.0, "SUV",
            "https://images.unsplash.com/photo-1581788929645-a4f2c2b2d9c6?w=600", 28000));
        
        vehiculos.add(new VehiculoSeminuevo("Honda", "CR-V", 2020, "Blanco Diamante",
            "1.5L Turbo", "Automática", "Gasolina", 5, 27000.0, "SUV",
            "https://images.unsplash.com/photo-1606664515524-ed2f786a0bd6?w=600", 45000));
        
        vehiculos.add(new VehiculoSeminuevo("Nissan", "Sentra", 2021, "Negro",
            "1.8L", "Automática", "Gasolina", 5, 18000.0, "Sedan",
            "https://images.unsplash.com/photo-1605559424843-9e4c228bf1c2?w=600", 35000));
        
        vehiculos.add(new VehiculoSeminuevo("Chevrolet", "Cavalier", 2020, "Rojo",
            "1.5L", "Automática", "Gasolina", 5, 16000.0, "Sedan",
            "https://images.unsplash.com/photo-1583267746897-c5f90d3b8c40?w=600", 55000));
        
        vehiculos.add(new VehiculoSeminuevo("Ford", "Escape", 2021, "Azul Oxford",
            "2.0L Turbo", "Automática", "Gasolina", 5, 26000.0, "SUV",
            "https://images.unsplash.com/photo-1609521263047-f8f79df08845?w=600", 32000));
    }
    
    public static List<Vehiculo> obtenerTodos() {
        return new ArrayList<>(vehiculos);
    }
    
    public static List<Vehiculo> obtenerPorTipo(String tipo) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            if (v.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(v);
            }
        }
        return resultado;
    }
    
    public static List<Vehiculo> obtenerNuevos() {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            if (v instanceof VehiculoNuevo) {
                resultado.add(v);
            }
        }
        return resultado;
    }
    
    public static List<Vehiculo> obtenerSeminuevos() {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            if (v instanceof VehiculoSeminuevo) {
                resultado.add(v);
            }
        }
        return resultado;
    }
}
