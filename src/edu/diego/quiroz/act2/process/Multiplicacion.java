package edu.diego.quiroz.act2.process;

/**
 * Clase que implementa la operación de multiplicación mediante suma repetida.
 * <p>
 * No utiliza el operador de multiplicación nativo (*), en su lugar implementa
 * la multiplicación sumando repetidamente el primer operando tantas veces como
 * indique el segundo operando. Maneja correctamente números negativos.
 * </p>
 *
 * @author Diego Quiroz
 * @version 1.0
 * @since 2026-02-06
 */
public class Multiplicacion extends Operacion {
    
    /**
     * Multiplica dos números enteros usando suma repetida.
     * <p>
     * Implementación que suma el valor 'a' un total de 'b' veces.
     * Maneja casos especiales como multiplicación por cero y números negativos.
     * </p>
     *
     * @param a el multiplicando
     * @param b el multiplicador (número de veces que se suma 'a')
     * @return el producto de a * b
     */
    @Override
    public int apply(int a, int b) {
        // Manejo de casos especiales
        if (a == 0 || b == 0) {
            return 0;
        }
        
        // Determinar si el resultado será negativo
        boolean negativo = false;
        if (a < 0) {
            a = 0 - a; // Convertir a positivo usando resta
            negativo = !negativo;
        }
        if (b < 0) {
            b = 0 - b; // Convertir a positivo usando resta
            negativo = !negativo;
        }
        
        int resultado = 0;
        
        // Multiplicación por suma repetida
        for (int i = 0; i < b; i = i + 1) {
            resultado = resultado + a;
        }
        
        // Aplicar signo si es necesario
        if (negativo) {
            resultado = 0 - resultado;
        }
        
        return resultado;
    }
}
