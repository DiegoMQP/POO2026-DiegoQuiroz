package edu.diego.quiroz.act2.ui;

import edu.diego.quiroz.act2.process.*;
import java.util.Scanner;

/**
 * Interfaz de línea de comandos para la calculadora aritmética.
 * Proporciona un menú interactivo para realizar operaciones matemáticas.
 * 
 * @author Diego Quiroz
 * @version 1.0
 */
public class CLI {
    
    /** Instancia de la calculadora utilizada por la interfaz */
    private static Calculadora calculadora;
    
    /**
     * Inicia la interfaz de línea de comandos de la calculadora.
     * Muestra el menú y procesa las operaciones seleccionadas por el usuario.
     */
    public static void iniciar() {
        calculadora = new Calculadora();
        
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuar = true;
            
            System.out.println("=================================================");
            System.out.println("    CALCULADORA ARITMETICA - ACTIVIDAD 2");
            System.out.println("=================================================");
            System.out.println();
            
            while (continuar) {
                mostrarMenu();
                
                int opcion = scanner.nextInt();
                
                if (opcion == 0) {
                    System.out.println("\nGracias por usar la calculadora!");
                    break;
                }
                
                if (opcion < 1 || opcion > 8) {
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    continue;
                }
                
                int num1, num2;
                
                if (opcion == 7) {
                    System.out.print("Ingrese el indice de la raiz: ");
                    num1 = scanner.nextInt();
                    System.out.print("Ingrese el numero: ");
                    num2 = scanner.nextInt();
                } else {
                    System.out.print("Ingrese el primer numero: ");
                    num1 = scanner.nextInt();
                    System.out.print("Ingrese el segundo numero: ");
                    num2 = scanner.nextInt();
                }
                
                try {
                    String claveOperacion = obtenerClaveOperacion(opcion);
                    int resultado = calculadora.calcular(claveOperacion, num1, num2);
                    String nombreOp = obtenerNombreOperacion(opcion, num1, num2);
                    System.out.println("\nResultado: " + nombreOp + " = " + resultado);
                } catch (Exception e) {
                    System.out.println("\nError: " + e.getMessage());
                }
            }
        }
    }
    
    private static void mostrarMenu() {
        System.out.println("\nSeleccione una operacion:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Modulo (residuo)");
        System.out.println("6. Potencia");
        System.out.println("7. Raiz");
        System.out.println("8. Logaritmo");
        System.out.println("0. Salir");
        System.out.print("\nOpcion: ");
    }
    
    private static String obtenerClaveOperacion(int opcion) {
        switch(opcion) {
            case 1: return "+";
            case 2: return "-";
            case 3: return "*";
            case 4: return "/";
            case 5: return "%";
            case 6: return "^";
            case 7: return "raiz";
            case 8: return "log";
            default: throw new IllegalArgumentException("Opcion no valida");
        }
    }
    
    private static String obtenerNombreOperacion(int opcion, int num1, int num2) {
        switch(opcion) {
            case 1:
                return num1 + " + " + num2;
            case 2:
                return num1 + " - " + num2;
            case 3:
                return num1 + " * " + num2;
            case 4:
                return num1 + " / " + num2;
            case 5:
                return num1 + " % " + num2;
            case 6:
                return num1 + " ^ " + num2;
            case 7:
                return "Raiz " + num1 + " de " + num2;
            case 8:
                return "log base " + num1 + " de " + num2;
            default:
                return "";
        }
    }
}
