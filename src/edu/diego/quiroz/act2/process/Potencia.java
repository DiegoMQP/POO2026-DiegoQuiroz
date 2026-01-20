package edu.diego.quiroz.actividad2.process;

/**
 * Clase que implementa la operación de potencia
 * Utiliza multiplicación repetida (que a su vez usa suma repetida)
 */
public class Potencia implements Operacion {
    
    @Override
    public double realizarOperacion(double base, double exponente) {
        // Casos especiales
        if (exponente == 0) {
            return 1;
        }
        
        if (base == 0) {
            return 0;
        }
        
        // Manejo de exponentes negativos
        boolean exponenteNegativo = false;
        if (exponente < 0) {
            exponenteNegativo = true;
            exponente = 0 - exponente;
        }
        
        // Potencia mediante multiplicación repetida
        double resultado = 1;
        int exp = (int) exponente;
        
        for (int i = 0; i < exp; i = i + 1) {
            // Multiplicar resultado por base usando suma repetida
            resultado = multiplicar(resultado, base);
        }
        
        // Si el exponente era negativo, calculamos 1/resultado
        if (exponenteNegativo) {
            // 1/resultado usando división (que usa resta repetida)
            resultado = dividir(1, resultado);
        }
        
        return resultado;
    }
    
    /**
     * Método auxiliar para multiplicar usando suma repetida
     */
    private double multiplicar(double a, double b) {
        if (a == 0 || b == 0) {
            return 0;
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
        
        double resultado = 0;
        int veces = (int) b;
        
        for (int i = 0; i < veces; i = i + 1) {
            resultado = resultado + a;
        }
        
        if (negativo) {
            resultado = 0 - resultado;
        }
        
        return resultado;
    }
    
    /**
     * Método auxiliar para dividir usando resta repetida
     */
    private double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero");
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
        
        double cociente = 0;
        double dividendo = a;
        
        while (dividendo >= b) {
            dividendo = dividendo - b;
            cociente = cociente + 1;
        }
        
        if (negativo) {
            cociente = 0 - cociente;
        }
        
        return cociente;
    }
    
    /**
     * Método estático para uso directo
     */
    public static double realizarOperacion(int base, int exponente) {
        Potencia potencia = new Potencia();
        return potencia.realizarOperacion((double)base, (double)exponente);
    }
}
