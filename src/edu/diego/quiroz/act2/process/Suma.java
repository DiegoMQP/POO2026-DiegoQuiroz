package edu.diego.quiroz.actividad2.process;

/**
 * Clase que implementa la operación de suma
 */
public class Suma implements Operacion {
    
    @Override
    public double realizarOperacion(double operando1, double operando2) {
        return operando1 + operando2;
    }
    
    /**
     * Método estático para uso directo
     */
    public static double realizarOperacion(int operando1, int operando2) {
        return operando1 + operando2;
    }
}
