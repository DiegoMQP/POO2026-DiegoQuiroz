package edu.diego.quiroz.actividad1.process;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int año;
    protected String color;
    protected String motor;
    protected String transmision;
    protected String combustible;
    protected int pasajeros;
    protected double precio;
    protected String tipo;
    protected String urlImagen;
    
    public Vehiculo(String marca, String modelo, int año, String color, String motor,
                   String transmision, String combustible, int pasajeros, double precio,
                   String tipo, String urlImagen) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.motor = motor;
        this.transmision = transmision;
        this.combustible = combustible;
        this.pasajeros = pasajeros;
        this.precio = precio;
        this.tipo = tipo;
        this.urlImagen = urlImagen;
    }
    
    // Template Method Pattern
    public final String obtenerDescripcionCompleta() {
        StringBuilder desc = new StringBuilder();
        desc.append(obtenerDescripcionBasica());
        desc.append("\n").append(obtenerDetallesTecnicos());
        desc.append("\n").append(obtenerDetallesEspecificos());
        return desc.toString();
    }
    
    private String obtenerDescripcionBasica() {
        return String.format("%s %s %d - %s", marca, modelo, año, color);
    }
    
    private String obtenerDetallesTecnicos() {
        return String.format("Motor: %s | Transmisión: %s | Combustible: %s | Pasajeros: %d",
                           motor, transmision, combustible, pasajeros);
    }
    
    protected abstract String obtenerDetallesEspecificos();
    
    public abstract double calcularPrecioFinal();
    
    // Getters
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAño() { return año; }
    public String getColor() { return color; }
    public String getMotor() { return motor; }
    public String getTransmision() { return transmision; }
    public String getCombustible() { return combustible; }
    public int getPasajeros() { return pasajeros; }
    public double getPrecio() { return precio; }
    public String getTipo() { return tipo; }
    public String getUrlImagen() { return urlImagen; }
    
    // Setters
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAño(int año) { this.año = año; }
    public void setColor(String color) { this.color = color; }
    public void setMotor(String motor) { this.motor = motor; }
    public void setTransmision(String transmision) { this.transmision = transmision; }
    public void setCombustible(String combustible) { this.combustible = combustible; }
    public void setPasajeros(int pasajeros) { this.pasajeros = pasajeros; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setUrlImagen(String urlImagen) { this.urlImagen = urlImagen; }
}
