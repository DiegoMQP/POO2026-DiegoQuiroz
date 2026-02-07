package edu.diego.quiroz.act2.process;

/**
 * Clase que implementa la operación de resta.
 * <p>
 * Esta es una operación básica que utiliza directamente el operador primitivo de resta (-).
 * Sirve como base para operaciones más complejas como la división y el módulo.
 * </p>
 *
 * @author Diego Quiroz
 * @version 1.0
 * @since 2026-02-06
 */
public class Resta extends Operacion {
    
    /**
     * Realiza la resta de dos números enteros.
     *
     * @param a el minuendo
     * @param b el sustraendo
     * @return la diferencia a - b
     */
    @Override
    public int apply(int a, int b) {
        return a - b;
    }
}
