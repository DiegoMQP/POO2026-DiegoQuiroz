package edu.diego.quiroz.act2.process;

/**
 * Clase que implementa la operación de módulo (residuo) mediante resta repetida.
 * <p>
 * No utiliza el operador de módulo nativo (%), en su lugar implementa
 * el cálculo del residuo restando repetidamente el divisor del dividendo
 * hasta que el residuo sea menor que el divisor. Maneja correctamente
 * números negativos y valida el módulo por cero.
 * </p>
 *
 * @author Diego Quiroz
 * @version 1.0
 * @since 2026-02-06
 */
public class Modulo extends Operacion {
    
    /**
     * Calcula el residuo (módulo) de la división de dos números enteros.
     * <p>
     * Implementación que resta el divisor del dividendo repetidamente
     * hasta que el residuo sea menor que el divisor, devolviendo ese
     * valor residual.
     * </p>
     *
     * @param a el dividendo
     * @param b el divisor
     * @return el residuo de a % b
     * @throws ArithmeticException si b es igual a cero
     */
    @Override
    public int apply(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Módulo por cero no permitido");
        }
        
        // Convertir a positivos para el cálculo
        boolean aNegativo = a < 0;
        if (aNegativo) {
            a = 0 - a;
        }
        
        int divisor = b;
        if (divisor < 0) {
            divisor = 0 - divisor;
        }
        
        // Restar el divisor repetidamente hasta que el residuo sea menor que el divisor
        int residuo = a;
        while (residuo >= divisor) {
            residuo = residuo - divisor;
        }
        
        // Si el operando1 era negativo, el residuo también lo es
        if (aNegativo) {
            residuo = 0 - residuo;
        }
        
        return residuo;
    }
}
