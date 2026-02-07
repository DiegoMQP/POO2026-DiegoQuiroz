package edu.diego.quiroz.act2.process;

/**
 * Clase que implementa la operación de logaritmo mediante división repetida.
 * <p>
 * No utiliza Math.log(), en su lugar implementa el cálculo del logaritmo
 * dividiendo repetidamente el operando por la base hasta llegar a un valor
 * menor que la base. El número de divisiones realizadas es el resultado.
 * Utiliza la clase Division para realizar los cálculos.
 * </p>
 *
 * @author Diego Quiroz
 * @version 1.0
 * @since 2026-02-06
 */
public class Logaritmo extends Operacion {
    
    /**
     * Calcula el logaritmo entero de un número en una base dada.
     * <p>
     * Implementación que cuenta cuántas veces se puede dividir el operando
     * por la base hasta que el resultado sea menor que la base. Utiliza
     * instancias de Division para realizar los cálculos.
     * </p>
     *
     * @param base la base del logaritmo (debe ser mayor que 0 y diferente de 1)
     * @param operando el número del cual se calculará el logaritmo (debe ser mayor que 0)
     * @return el logaritmo entero de operando en base 'base'
     * @throws ArithmeticException si la base es menor o igual a 0, igual a 1, o si el operando es menor o igual a 0
     */
    @Override
    public int apply(int base, int operando) {
        if (base <= 0 || base == 1) {
            throw new ArithmeticException("La base debe ser mayor que 0 y diferente de 1");
        }
        
        if (operando <= 0) {
            throw new ArithmeticException("El operando debe ser mayor que 0");
        }
        
        // Caso especial: si operando = 1, log = 0
        if (operando == 1) {
            return 0;
        }
        
        // Contar cuántas veces hay que dividir el operando por la base para llegar a 1
        int resultado = 0;
        int valor = operando;
        
        // Para base > 1: dividir hasta llegar a valor < base
        if (base > 1) {
            while (valor >= base) {
                valor = new Division().apply(valor, base);
                resultado = resultado + 1;
                
                // Evitar bucle infinito
                if (resultado > 10000) {
                    break;
                }
            }
        }
        
        return resultado;
    }
}
