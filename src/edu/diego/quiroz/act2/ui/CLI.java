package edu.diego.quiroz.act2.ui;

import edu.diego.quiroz.act2.process.*;
import java.util.Scanner;

/**
 * Interfaz de línea de comandos para la calculadora aritmética
 */
public class CLI {
    
    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        System.out.println("=================================================");
        System.out.println("    CALCULADORA ARITMETICA - ACTIVIDAD 2");
        System.out.println("=================================================");
        System.out.println();
        
        while (continuar) {
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
            
            int opcion = scanner.nextInt();
            
            if (opcion == 0) {
                continuar = false;
                System.out.println("\nGracias por usar la calculadora!");
                break;
            }
            
            if (opcion < 1 || opcion > 8) {
                System.out.println("Opcion invalida. Intente nuevamente.");
                continue;
            }
            
            int num1, num2 = 0;
            
            if (opcion == 7) {
                // Raíz cuadrada solo necesita un número
                System.out.print("Ingrese el numero: ");
                num1 = scanner.nextInt();
            } else {
                System.out.print("Ingrese el primer numero: ");
                num1 = scanner.nextInt();
                System.out.print("Ingrese el segundo numero: ");
                num2 = scanner.nextInt();
            }
            
            double resultado = 0;
            String operacionNombre = "";
            
            try {
                switch (opcion) {
                    case 1:
                        resultado = Suma.realizarOperacion(num1, num2);
                        operacionNombre = num1 + " + " + num2;
                        break;
                    case 2:
                        resultado = Resta.realizarOperacion(num1, num2);
                        operacionNombre = num1 + " - " + num2;
                        break;
                    case 3:
                        resultado = Multiplicacion.realizarOperacion(num1, num2);
                        operacionNombre = num1 + " * " + num2;
                        break;
                    case 4:
                        resultado = Division.realizarOperacion(num1, num2);
                        operacionNombre = num1 + " / " + num2;
                        break;
                    case 5:
                        resultado = Modulo.realizarOperacion(num1, num2);
                        operacionNombre = num1 + " % " + num2;
                        break;
                    case 6:
                        resultado = Potencia.realizarOperacion(num1, num2);
                        operacionNombre = num1 + " ^ " + num2;
                        break;
                    case 7:
                        resultado = Raiz.realizarOperacion(num1);
                        operacionNombre = "Raiz cuadrada de " + num1;
                        break;
                    case 8:
                        resultado = Logaritmo.realizarOperacion(num1, num2);
                        operacionNombre = "log base " + num1 + " de " + num2;
                        break;
                }
                
                System.out.println("\nResultado: " + operacionNombre + " = " + resultado);
                
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}
