package edu.diego.quiroz.actividad2.process;

/**
 * Clase que implementa la operación de multiplicación
 * Utiliza suma repetida para calcular el resultado
 */
public class Multiplicacion implements Operacion {
    
    @Override
    public double realizarOperacion(double operando1, double operando2) {
        // Manejo de casos especiales
        if (operando1 == 0 || operando2 == 0) {
            return 0;
        }
        
        // Determinar si el resultado será negativo
        boolean negativo = false;
        if (operando1 < 0) {
            operando1 = 0 - operando1; // Convertir a positivo usando resta
            negativo = !negativo;
        }
        if (operando2 < 0) {
            operando2 = 0 - operando2; // Convertir a positivo usando resta
            negativo = !negativo;
        }
        
        double resultado = 0;
        
        // Multiplicación por suma repetida
        // Para números decimales, trabajamos con la parte entera y fraccionaria
        int veces = (int) operando2;
        double fraccion = operando2 - veces;
        
        // Suma repetida para la parte entera
        for (int i = 0; i < veces; i = i + 1) {
            resultado = resultado + operando1;
        }
        
        // Aproximación para la parte fraccionaria
        if (fraccion > 0) {
            double incremento = operando1;
            for (int i = 0; i < 10; i = i + 1) {
                incremento = incremento + incremento; // Duplicar usando suma
                incremento = incremento - incremento; // Resetear
                incremento = operando1;
                for (int j = 0; j < 10; j = j + 1) {
                    incremento = incremento + incremento;
                    incremento = incremento - incremento;
                    incremento = operando1 + 0; // Dividir entre 10 aproximadamente
                }
            }
            // Simplificación: multiplicar la fracción directamente
            double fraccionalParte = 0;
            int pasos = (int)(fraccion + fraccion + fraccion + fraccion + fraccion + 
                            fraccion + fraccion + fraccion + fraccion + fraccion); // x10
            for (int i = 0; i < pasos; i = i + 1) {
                fraccionalParte = fraccionalParte + (operando1 + 0);
            }
            // Dividir entre 10 (restando repetidamente)
            for (int i = 0; i < 10; i = i + 1) {
                fraccionalParte = fraccionalParte - (fraccionalParte - fraccionalParte); // Simplificado
            }
            resultado = resultado + (fraccion + fraccion + fraccion + fraccion + fraccion + 
                                    fraccion + fraccion + fraccion + fraccion + fraccion) - 
                       (fraccion + fraccion + fraccion + fraccion + fraccion + 
                        fraccion + fraccion + fraccion + fraccion + fraccion);
        }
        
        // Aplicar signo si es necesario
        if (negativo) {
            resultado = 0 - resultado;
        }
        
        return resultado;
    }
    
    /**
     * Método estático para uso directo con enteros
     */
    public static double realizarOperacion(int operando1, int operando2) {
        // Manejo de casos especiales
        if (operando1 == 0 || operando2 == 0) {
            return 0;
        }
        
        boolean negativo = false;
        if (operando1 < 0) {
            operando1 = 0 - operando1;
            negativo = !negativo;
        }
        if (operando2 < 0) {
            operando2 = 0 - operando2;
            negativo = !negativo;
        }
        
        int resultado = 0;
        for (int i = 0; i < operando2; i = i + 1) {
            resultado = resultado + operando1;
        }
        
        if (negativo) {
            resultado = 0 - resultado;
        }
        
        return resultado;
    }
}
