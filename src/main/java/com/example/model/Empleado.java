package com.example.model;

import java.util.Objects;

/**
 * Clase que representa un empleado con sus atributos básicos.
 * @author Diego Quiroz
 */
public class Empleado {
    private String nombre;
    private int edad;
    private double salario;
    private String departamento;

    public Empleado(String nombre, int edad, double salario, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getSalario() {
        return salario;
    }   
    public void setSalario(double salario) {
        this.salario = salario;
    }   
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return edad == empleado.edad &&
               Double.compare(empleado.salario, salario) == 0 &&
               Objects.equals(nombre, empleado.nombre) &&
               Objects.equals(departamento, empleado.departamento);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, salario, departamento);
    }

    @Override
    public String toString() {
        return "Empleado{" +
               "nombre='" + nombre + '\'' +
               ", edad=" + edad +
               ", salario=" + salario +
               ", departamento='" + departamento + '\'' +
               '}';
    }
    

}
