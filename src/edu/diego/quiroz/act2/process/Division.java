package edu.diego.quiroz.act2.process;

/**
 * Clase que implementa la operación de división
 * Utiliza resta repetida para calcular el resultado
 */
public class Division implements Operacion {
    
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
        double epsilon = 0.0000001; // Tolerancia para comparaciones de punto flotante
        
        // Parte entera: contar cuántas veces cabe el divisor en el dividendo
        while (dividendo >= operando2 - epsilon) {
            dividendo = dividendo - operando2;
            cociente = cociente + 1;
        }
        
        // Parte decimal: aproximación con precisión de 6 decimales
        if (dividendo > epsilon) {
            // Escalar el resto multiplicando por 10 (usando suma repetida)
            double divisorEscalado = operando2;
            for (int escala = 0; escala < 6; escala = escala + 1) {
                double dividendoEscalado = dividendo;
                
                // Multiplicar por 10 usando suma
                double temp = dividendoEscalado;
                for (int i = 0; i < 9; i = i + 1) {
                    dividendoEscalado = dividendoEscalado + temp;
                }
                
                double digitoDecimal = 0;
                while (dividendoEscalado >= divisorEscalado - epsilon) {
                    dividendoEscalado = dividendoEscalado - divisorEscalado;
                    digitoDecimal = digitoDecimal + 1;
                }
                
                // Dividir digitoDecimal entre 10^(escala+1) y sumar al cociente
                double divisor = 10;
                for (int i = 0; i < escala; i = i + 1) {
                    double temp2 = divisor;
                    for (int j = 0; j < 9; j = j + 1) {
                        divisor = divisor + temp2;
                    }
                }
                
                // Sumar la contribución decimal (dividir digitoDecimal entre 10^(escala+1))
                double contribucion = digitoDecimal;
                while (contribucion >= divisor && contribucion > epsilon) {
                    contribucion = contribucion - divisor;
                }
                cociente = cociente + contribucion;
                
                dividendo = dividendoEscalado;
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
