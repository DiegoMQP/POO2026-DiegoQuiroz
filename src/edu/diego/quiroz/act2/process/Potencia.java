package edu.diego.quiroz.act2.process;

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
            resultado = new Multiplicacion().realizarOperacion(resultado, base);
        }
        
        // Si el exponente era negativo, calculamos 1/resultado
        if (exponenteNegativo) {
            // 1/resultado usando división (que usa resta repetida)
            resultado = new Division().realizarOperacion(1, resultado);
        }

        return resultado;
    }
    
    /**
     * Método estático para uso directo
     */
    public static double realizarOperacion(int base, int exponente) {
        Potencia potencia = new Potencia();
        return potencia.realizarOperacion((double)base, (double)exponente);
    }
}
