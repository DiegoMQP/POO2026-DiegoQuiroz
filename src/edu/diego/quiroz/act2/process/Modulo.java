package edu.diego.quiroz.actividad2.process;

/**
 * Clase que implementa la operación de módulo (residuo)
 * Utiliza resta repetida para calcular el resultado
 */
public class Modulo implements Operacion {
    
    @Override
    public double realizarOperacion(double operando1, double operando2) {
        if (operando2 == 0) {
            throw new ArithmeticException("Módulo por cero no permitido");
        }
        
        // Convertir a positivos para el cálculo
        boolean operando1Negativo = operando1 < 0;
        if (operando1Negativo) {
            operando1 = 0 - operando1;
        }
        
        double divisor = operando2;
        if (divisor < 0) {
            divisor = 0 - divisor;
        }
        
        // Restar el divisor repetidamente hasta que el residuo sea menor que el divisor
        double residuo = operando1;
        while (residuo >= divisor) {
            residuo = residuo - divisor;
        }
        
        // Si el operando1 era negativo, el residuo también lo es
        if (operando1Negativo) {
            residuo = 0 - residuo;
        }
        
        return residuo;
    }
    
    /**
     * Método estático para uso directo con enteros
     */
    public static int realizarOperacion(int operando1, int operando2) {
        if (operando2 == 0) {
            throw new ArithmeticException("Módulo por cero no permitido");
        }
        
        boolean operando1Negativo = operando1 < 0;
        if (operando1Negativo) {
            operando1 = 0 - operando1;
        }
        
        int divisor = operando2;
        if (divisor < 0) {
            divisor = 0 - divisor;
        }
        
        int residuo = operando1;
        while (residuo >= divisor) {
            residuo = residuo - divisor;
        }
        
        if (operando1Negativo) {
            residuo = 0 - residuo;
        }
        
        return residuo;
    }
}
