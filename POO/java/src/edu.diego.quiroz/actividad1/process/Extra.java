package edu.diego.quiroz.actividad1.process;

public class Extra {
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String categoria;
    
    public Extra(String id, String nombre, String descripcion, double precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    public Extra(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public String getCategoria() { return categoria; }
    
    // Setters
    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    
    @Override
    public String toString() {
        return nombre + " - $" + String.format("%.2f", precio);
    }
}
