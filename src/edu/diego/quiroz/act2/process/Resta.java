package edu.diego.quiroz.act2.process;

/**
 * Clase que implementa la operación de resta
 */
public class Resta implements Operacion {
    
    @Override
    public double realizarOperacion(double operando1, double operando2) {
        return operando1 - operando2;
    }
    
    /**
     * Método estático para uso directo
     */
    public static int realizarOperacion(int operando1, int operando2) {
        return operando1 - operando2;
    }
}
