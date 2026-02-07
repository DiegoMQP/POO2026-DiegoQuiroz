package edu.diego.quiroz.act2.process;

/**
 * Clase abstracta base para todas las operaciones matemáticas.
 * Define la interfaz común que deben implementar todas las operaciones.
 * 
 * @author Diego Quiroz
 * @version 1.0
 */
public abstract class Operacion {
    
    /**
     * Aplica la operación matemática a dos operandos.
     * 
     * @param a Primer operando
     * @param b Segundo operando
     * @return Resultado de la operación
     */
    public abstract int apply(int a, int b);
}
