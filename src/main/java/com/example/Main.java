package com.example;

import com.example.model.Empleado;
import com.example.utils.EmpleadoUtils;
import com.example.utils.ListUtils;
import com.example.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author Diego Quiroz
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE LOS 15 MÉTODOS ===");
        System.out.println("\n" + "=".repeat(70) + "\n");

        // ========== MÉTODO 1: Mover ceros al final ==========
        List<Integer> numeros = Arrays.asList(0, 5, 0, 3, 7, 0, 2, 9, 0, 1, 4, 0, 8, 6, 0, 2, 5, 0, 3, 0);
        System.out.println("1. Mover ceros al final:");
        System.out.println("   Input:  " + numeros);
        System.out.println("   Output: " + ListUtils.moverCerosAlFinal(numeros));
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 2: Contar números pares ==========
        List<Integer> numeros2 = Arrays.asList(9, 2, 7, 4, 1, 8, 3, 6, 5);
        System.out.println("2. Contar números pares:");
        System.out.println("   Input:  " + numeros2);
        System.out.println("   Output: " + ListUtils.contarPares(numeros2) + " pares");
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 3: Verificar palíndromo ==========
        String texto1 = "reconocer";
        String texto2 = "buenos dias";
        System.out.println("3. Verificar palíndromo:");
        System.out.println("   Input:  '" + texto1 + "'");
        System.out.println("   Output: " + StringUtils.esPalindromo(texto1));
        System.out.println("   Input:  '" + texto2 + "'");
        System.out.println("   Output: " + StringUtils.esPalindromo(texto2));
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 4: Contar vocales ==========
        String texto3 = "programacion";
        System.out.println("4. Contar vocales:");
        System.out.println("   Input:  '" + texto3 + "'");
        System.out.println("   Output: " + StringUtils.contarVocales(texto3) + " vocales");
        System.out.println("\n" + "-".repeat(70) + "\n");

        // Datos de empleados para los ejemplos
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Sofia", 23, 22000, "Sistemas"),
                new Empleado("Ricardo", 33, 38000, "Ventas"),
                new Empleado("Valeria", 24, 24000, "Sistemas"),
                new Empleado("Beatriz", 28, 28000, "Recursos Humanos"),
                new Empleado("Alejandro", 36, 42000, "Sistemas"),
                new Empleado("Daniela", 22, 20000, "Ventas"),
                new Empleado("Fernando", 28, 26000, "Finanzas")
        );

        // ========== MÉTODO 5: Empleado con mayor salario ==========
        Empleado maxSalario = EmpleadoUtils.empleadoConMayorSalario(empleados);
        System.out.println("5. Empleado con mayor salario:");
        System.out.println("   Output: " + maxSalario.getNombre() + " - $" + maxSalario.getSalario());
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 6: Edad más común ==========
        int edadComun = EmpleadoUtils.edadMasComun(empleados);
        System.out.println("6. Edad más común:");
        System.out.println("   Output: " + edadComun + " años");
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 7: Promedio de edad ==========
        double promedioEdad = EmpleadoUtils.promedioEdad(empleados);
        System.out.println("7. Promedio de edad:");
        System.out.println("   Output: " + String.format("%.2f", promedioEdad) + " años");
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 8: Promedio de salario ==========
        double promedioSalario = EmpleadoUtils.promedioSalario(empleados);
        System.out.println("8. Promedio de salario:");
        System.out.println("   Output: $" + String.format("%.2f", promedioSalario));
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 9: Promedio de edad con salario > 25K ==========
        double promedioEdadSalarioAlto = EmpleadoUtils.promedioEdadConSalarioMayorA25K(empleados);
        System.out.println("9. Promedio de edad de empleados con salario > $25,000:");
        System.out.println("   Output: " + String.format("%.2f", promedioEdadSalarioAlto) + " años");
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 10: Filtrar menores de 25 años ==========
        List<Empleado> menoresDe25 = EmpleadoUtils.filtrarMenoresDe25(empleados);
        System.out.println("10. Empleados menores de 25 años:");
        System.out.print("    Output: ");
        for (int i = 0; i < menoresDe25.size(); i++) {
            System.out.print(menoresDe25.get(i).getNombre());
            if (i < menoresDe25.size() - 1) System.out.print(", ");
        }
        System.out.println(" (" + menoresDe25.size() + " empleados)");
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 11: Contar empleados de Sistemas ==========
        int totalSistemas = EmpleadoUtils.contarEmpleadosDeSistemas(empleados);
        System.out.println("11. Empleados del departamento de Sistemas:");
        System.out.println("    Output: " + totalSistemas + " empleados");
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 12: Invertir cadena ==========
        String textoInvertir = "codigo";
        System.out.println("12. Invertir cadena:");
        System.out.println("    Input:  '" + textoInvertir + "'");
        System.out.println("    Output: '" + StringUtils.invertirCadena(textoInvertir) + "'");
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 13: Primera ocurrencia de un carácter ==========
        String textoBuscar = "programacion";
        char caracterBuscar = 'a';
        System.out.println("13. Primera ocurrencia de un carácter:");
        System.out.println("    Input:  texto='" + textoBuscar + "', caracter='" + caracterBuscar + "'");
        System.out.println("    Output: posición " + StringUtils.encontrarPrimeraOcurrencia(textoBuscar, caracterBuscar));
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 14: Mayor salario con más de 30 años ==========
        Empleado mayorSalarioMayor30 = EmpleadoUtils.empleadoConMayorSalarioMayorDe30(empleados);
        System.out.println("14. Empleado con mayor salario que tenga más de 30 años:");
        if (mayorSalarioMayor30 != null) {
            System.out.println("    Output: " + mayorSalarioMayor30.getNombre() + 
                             " (" + mayorSalarioMayor30.getEdad() + " años) - $" + 
                             mayorSalarioMayor30.getSalario());
        }
        System.out.println("\n" + "-".repeat(70) + "\n");

        // ========== MÉTODO 15: Menor salario con edad menos común ==========
        Empleado menorSalarioEdadMenosComun = EmpleadoUtils.empleadoConMenorSalarioYEdadMenosComun(empleados);
        System.out.println("15. Empleado con menor salario y edad menos común:");
        if (menorSalarioEdadMenosComun != null) {
            System.out.println("    Output: " + menorSalarioEdadMenosComun.getNombre() + 
                             " (" + menorSalarioEdadMenosComun.getEdad() + " años) - $" + 
                             menorSalarioEdadMenosComun.getSalario());
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.println("Actividad 3 finalizada.");
        System.out.println("=".repeat(70));
    }
}
