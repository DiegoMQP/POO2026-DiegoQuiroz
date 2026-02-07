package edu.diego.quiroz.act2.process;

/**
 * Clase que implementa la operación de división entera mediante resta repetida.
 * <p>
 * No utiliza el operador de división nativo (/), en su lugar implementa
 * la división restando repetidamente el divisor del dividendo hasta que
 * el residuo sea menor que el divisor. Maneja correctamente números negativos
 * y valida la división por cero.
 * </p>
 *
 * @author Diego Quiroz
 * @version 1.0
 * @since 2026-02-06
 */
public class Division extends Operacion {
    
    /**
     * Divide dos números enteros usando resta repetida.
     * <p>
     * Implementación que resta el divisor del dividendo repetidamente,
     * contando cuántas veces se puede realizar la operación antes de que
     * el residuo sea menor que el divisor.
     * </p>
     *
     * @param a el dividendo
     * @param b el divisor
     * @return el cociente entero de a / b
     * @throws ArithmeticException si b es igual a cero
     */
    @Override
    public int apply(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        
        boolean negativo = false;
        if (a < 0) {
            a = 0 - a;
            negativo = !negativo;
        }
        if (b < 0) {
            b = 0 - b;
            negativo = !negativo;
        }
        
        int cociente = 0;
        int dividendo = a;
        
        while (dividendo >= b) {
            dividendo = dividendo - b;
            cociente = cociente + 1;
        }
        
        if (negativo) {
            cociente = 0 - cociente;
        }
        
        return cociente;
    }
}
