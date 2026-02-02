package com.example.utils;

import com.example.model.Empleado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Clase de utilidades para operaciones con empleados.
 * @author Diego Quiroz
 */
public class EmpleadoUtils {

    /**
     * Encuentra el empleado con el mayor salario.
     * @param empleados lista de empleados
     * @return empleado con mayor salario, null si la lista está vacía
     */
    public static Empleado empleadoConMayorSalario(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return null;
        }

        Empleado maxSalario = empleados.get(0);
        for (Empleado empleado : empleados) {
            if (empleado.getSalario() > maxSalario.getSalario()) {
                maxSalario = empleado;
            }
        }

        return maxSalario;
    }

    /**
     * Encuentra la edad más común entre los empleados.
     * @param empleados lista de empleados
     * @return edad más común, -1 si la lista está vacía
     */
    public static int edadMasComun(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return -1;
        }

        Map<Integer, Integer> frecuenciaEdades = new HashMap<>();

        // Contar frecuencia de cada edad
        for (Empleado empleado : empleados) {
            int edad = empleado.getEdad();
            frecuenciaEdades.put(edad, frecuenciaEdades.getOrDefault(edad, 0) + 1);
        }

        // Encontrar la edad con mayor frecuencia
        int edadMasFrecuente = -1;
        int maxFrecuencia = 0;

        for (Map.Entry<Integer, Integer> entry : frecuenciaEdades.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                edadMasFrecuente = entry.getKey();
            }
        }

        return edadMasFrecuente;
    }

    /**
     * Calcula el promedio de edad de los empleados.
     * @param empleados lista de empleados
     * @return promedio de edad, 0.0 si la lista está vacía
     */
    public static double promedioEdad(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return 0.0;
        }

        int sumaEdades = 0;
        for (Empleado empleado : empleados) {
            sumaEdades += empleado.getEdad();
        }

        return (double) sumaEdades / empleados.size();
    }

    /**
     * Calcula el promedio de salario de los empleados.
     * @param empleados lista de empleados
     * @return promedio de salario, 0.0 si la lista está vacía
     */
    public static double promedioSalario(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return 0.0;
        }

        double sumaSalarios = 0.0;
        for (Empleado empleado : empleados) {
            sumaSalarios += empleado.getSalario();
        }

        return sumaSalarios / empleados.size();
    }

    /**
     * Calcula el promedio de edad de los empleados que ganan más de 25,000.
     * @param empleados lista de empleados
     * @return promedio de edad de empleados con salario > 25000, 0.0 si no hay empleados que cumplan la condición
     */
    public static double promedioEdadConSalarioMayorA25K(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return 0.0;
        }

        int sumaEdades = 0;
        int contador = 0;

        for (Empleado empleado : empleados) {
            if (empleado.getSalario() > 25000) {
                sumaEdades += empleado.getEdad();
                contador++;
            }
        }

        return contador > 0 ? (double) sumaEdades / contador : 0.0;
    }

    /**
     * Filtra empleados menores de 25 años.
     * @param empleados lista de empleados (elementos null son ignorados)
     * @return lista mutable de empleados menores de 25 años
     */
    public static List<Empleado> filtrarMenoresDe25(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return new ArrayList<>();
        }

        return empleados.stream()
                .filter(empleado -> empleado != null && empleado.getEdad() < 25)
                .collect(Collectors.toList());
    }

    /**
     * Cuenta cuántos empleados pertenecen al departamento de Sistemas.
     * @param empleados lista de empleados (elementos null son ignorados)
     * @return cantidad de empleados de Sistemas
     */
    public static int contarEmpleadosDeSistemas(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return 0;
        }

        return (int) empleados.stream()
                .filter(emp -> emp != null && emp.getDepartamento() != null)
                .filter(emp -> "Sistemas".equalsIgnoreCase(emp.getDepartamento()))
                .count();
    }

    /**
     * Encuentra el empleado con mayor salario que tenga más de 30 años.
     * @param empleados lista de empleados (no debe contener elementos null)
     * @return empleado con mayor salario y más de 30 años, null si no hay empleados que cumplan la condición
     */
    public static Empleado empleadoConMayorSalarioMayorDe30(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return null;
        }

        return empleados.stream()
                .filter(emp -> emp != null && emp.getEdad() > 30)
                .max((e1, e2) -> Double.compare(e1.getSalario(), e2.getSalario()))
                .orElse(null);
    }

    /**
     * Encuentra el empleado con menor salario cuya edad sea la menos común.
     * @param empleados lista de empleados
     * @return empleado con menor salario y edad menos común, null si la lista está vacía
     */
    public static Empleado empleadoConMenorSalarioYEdadMenosComun(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return null;
        }

        // Calcular frecuencia de edades
        Map<Integer, Integer> frecuenciaEdades = new HashMap<>();
        for (Empleado empleado : empleados) {
            int edad = empleado.getEdad();
            frecuenciaEdades.put(edad, frecuenciaEdades.getOrDefault(edad, 0) + 1);
        }

        // Encontrar la frecuencia mínima
        int minFrecuencia = Integer.MAX_VALUE;
        for (int frecuencia : frecuenciaEdades.values()) {
            if (frecuencia < minFrecuencia) {
                minFrecuencia = frecuencia;
            }
        }

        // Filtrar empleados con edad menos común
        final int frecuenciaMinimaFinal = minFrecuencia;
        List<Empleado> empleadosConEdadMenosComun = empleados.stream()
                .filter(e -> frecuenciaEdades.get(e.getEdad()) == frecuenciaMinimaFinal)
                .collect(Collectors.toList());

        // Entre esos, encontrar el de menor salario
        if (empleadosConEdadMenosComun.isEmpty()) {
            return null;
        }

        Empleado resultado = empleadosConEdadMenosComun.get(0);
        for (Empleado empleado : empleadosConEdadMenosComun) {
            if (empleado.getSalario() < resultado.getSalario()) {
                resultado = empleado;
            }
        }

        return resultado;
    }
}
