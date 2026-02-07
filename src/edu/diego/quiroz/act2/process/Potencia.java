package edu.diego.quiroz.act2.process;

/**
 * Clase que implementa la operación de potencia mediante multiplicación repetida.
 * <p>
 * No utiliza Math.pow(), en su lugar implementa la potenciación multiplicando
 * repetidamente la base consigo misma tantas veces como indique el exponente.
 * Utiliza la clase Multiplicacion para realizar los cálculos, lo que demuestra
 * composición entre operaciones. Maneja exponentes negativos mediante división.
 * </p>
 *
 * @author Diego Quiroz
 * @version 1.0
 * @since 2026-02-06
 */
public class Potencia extends Operacion {
    
    /**
     * Calcula la potencia de un número mediante multiplicación repetida.
     * <p>
     * Implementación que multiplica la base consigo misma 'exponente' veces.
     * Utiliza instancias de Multiplicacion y Division para los cálculos.
     * Maneja casos especiales como base 0, exponente 0, y exponentes negativos.
     * </p>
     *
     * @param base la base de la potencia
     * @param exponente el exponente al que se elevará la base
     * @return el resultado de base ^ exponente
     */
    @Override
    public int apply(int base, int exponente) {
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
        int resultado = 1;
        
        for (int i = 0; i < exponente; i = i + 1) {
            // Multiplicar resultado por base usando la operación de multiplicación
            resultado = new Multiplicacion().apply(resultado, base);
        }
        
        // Si el exponente era negativo, calculamos 1/resultado
        if (exponenteNegativo) {
            // 1/resultado usando división (que usa resta repetida)
            resultado = new Division().apply(1, resultado);
        }

        return resultado;
    }
}
