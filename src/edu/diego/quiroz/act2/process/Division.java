package edu.diego.quiroz.actividad2.process;

/**
 * Clase que implementa la operación de división
 * Utiliza resta repetida para calcular el resultado
 */
public class Division implements edu.diego.quiroz.actividad2.process.Operacion {
    
    @Override
    public double realizarOperacion(double operando1, double operando2) {
        if (operando2 == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        
        // Determinar si el resultado será negativo
        boolean negativo = false;
        if (operando1 < 0) {
            operando1 = 0 - operando1;
            negativo = !negativo;
        }
        if (operando2 < 0) {
            operando2 = 0 - operando2;
            negativo = !negativo;
        }
        
        // División por resta repetida
        double cociente = 0;
        double dividendo = operando1;
        
        // Contar cuántas veces cabe el divisor en el dividendo
        while (dividendo >= operando2 || (dividendo > operando2 - 0.0001 && dividendo < operando2 + 0.0001)) {
            dividendo = dividendo - operando2;
            cociente = cociente + 1;
            
            if (dividendo < operando2) {
                break;
            }
        }
        
        // Aplicar signo si es necesario
        if (negativo) {
            cociente = 0 - cociente;
        }
        
        return cociente;
    }
    
    /**
     * Método estático para uso directo con enteros
     */
    public static int realizarOperacion(int operando1, int operando2) {
        if (operando2 == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        
        boolean negativo = false;
        if (operando1 < 0) {
            operando1 = 0 - operando1;
            negativo = !negativo;
        }
        if (operando2 < 0) {
            operando2 = 0 - operando2;
            negativo = !negativo;
        }
        
        int cociente = 0;
        int dividendo = operando1;
        
        while (dividendo >= operando2) {
            dividendo = dividendo - operando2;
            cociente = cociente + 1;
        }
        
        if (negativo) {
            cociente = 0 - cociente;
        }
        
        return cociente;
    }
}
