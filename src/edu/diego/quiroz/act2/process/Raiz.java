package edu.diego.quiroz.act2.process;

/**
 * Clase que implementa la operación de raíz n-ésima.
 * Extiende de Potencia y utiliza búsqueda incremental para encontrar la raíz.
 * 
 * @author Diego Quiroz
 * @version 1.0
 */
public class Raiz extends Potencia {
    
    /**
     * Calcula la raíz n-ésima de un número.
     * 
     * @param indice El índice de la raíz (2 para raíz cuadrada, 3 para cúbica, etc.)
     * @param valor El número del cual se calcula la raíz
     * @return La raíz entera del número
     * @throws ArithmeticException si el índice es 0 o si se intenta calcular
     *         raíz cuadrada de un número negativo
     */
    @Override
    public int apply(int indice, int valor) {
        if (indice == 0) {
            throw new ArithmeticException("El indice no puede ser 0");
        }
        if (valor < 0 && indice == 2) {
            throw new ArithmeticException("No se puede calcular raiz cuadrada de numero negativo");
        }
        
        if (valor == 0) return 0;
        if (valor == 1) return 1;
        
        int inicio = 1;
        
        while (super.apply(inicio, indice) <= valor) {
            inicio++;
        }
        
        return inicio - 1;
    }
}
