package com.vehiculos.modelos;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private String color;
    private double precio;
    private String tipo;
    private String motor;
    private String transmision;

    public Vehiculo(String marca, String modelo, int anio, String color, 
                    double precio, String tipo, String motor, String transmision) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.precio = precio;
        this.tipo = tipo;
        this.motor = motor;
        this.transmision = transmision;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMotor() {
        return motor;
    }

    public String getTransmision() {
        return transmision;
    }

    public void mostrarCaracteristicas() {
        System.out.println("+=========================================================+");
        System.out.println("| CARACTERISTICAS DEL VEHICULO                            |");
        System.out.println("+=========================================================+");
        System.out.println("| Marca:         " + marca);
        System.out.println("| Modelo:        " + modelo);
        System.out.println("| Anio:          " + anio);
        System.out.println("| Color:         " + color);
        System.out.println("| Tipo:          " + tipo);
        System.out.println("| Motor:         " + motor);
        System.out.println("| Transmision:   " + transmision);
        System.out.println("| Precio:        $" + String.format("%,.2f", precio));
        System.out.println("+=========================================================+");
    }

    public String getDescripcionBreve() {
        return marca + " " + modelo + " " + anio;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d) - $%,.2f", marca, modelo, anio, precio);
    }
}
