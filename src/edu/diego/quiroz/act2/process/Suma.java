package edu.diego.quiroz.act2.process;

/**
 * Clase que implementa la operación de suma.
 * <p>
 * Esta es la operación más básica que utiliza directamente el operador primitivo de suma (+).
 * Sirve como base para otras operaciones más complejas como la multiplicación.
 * </p>
 *
 * @author Diego Quiroz
 * @version 1.0
 * @since 2026-02-06
 */
public class Suma extends Operacion {
    
    /**
     * Realiza la suma de dos números enteros.
     *
     * @param a el primer sumando
     * @param b el segundo sumando
     * @return la suma de a + b
     */
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}
