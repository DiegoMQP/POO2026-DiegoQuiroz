package edu.diego.quiroz.act2.process;

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
        
        // Multiplicación por suma repetida (solo parte entera)
        int veces = (int) operando2;
        
        // Suma repetida
        for (int i = 0; i < veces; i = i + 1) {
            resultado = resultado + operando1;
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
        Multiplicacion multiplicacion = new Multiplicacion();
        return multiplicacion.realizarOperacion((double)operando1, (double)operando2);
    }
}
