package edu.diego.quiroz.act2.process;

/**
 * Interfaz que define el contrato para las operaciones aritméticas
 */
public interface Operacion {
    /**
     * Realiza la operación aritmética con dos operandos
     * @param operando1 Primer operando
     * @param operando2 Segundo operando
     * @return Resultado de la operación
     */
    double realizarOperacion(double operando1, double operando2);
}
