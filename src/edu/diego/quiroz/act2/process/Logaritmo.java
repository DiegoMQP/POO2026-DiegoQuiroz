package edu.diego.quiroz.act2.process;

/**
 * Clase que implementa la operación de logaritmo
 * Utiliza multiplicación repetida para contar cuántas veces hay que multiplicar la base
 */
public class Logaritmo implements Operacion {
    
    @Override
    public double realizarOperacion(double base, double operando) {
        if (base <= 0 || base == 1) {
            throw new ArithmeticException("La base debe ser mayor que 0 y diferente de 1");
        }
        
        if (operando <= 0) {
            throw new ArithmeticException("El operando debe ser mayor que 0");
        }
        
        // Caso especial: si operando = 1, log = 0
        if (operando == 1) {
            return 0;
        }
        
        // Contar cuántas veces hay que dividir el operando por la base para llegar a 1
        double resultado = 0;
        double valor = operando;
        double epsilon = 0.0000001;
        
        // Para base > 1: dividir hasta llegar a 1
        if (base > 1) {
            while (valor > 1 + epsilon) {
                valor = new Division().realizarOperacion(valor, base);
                resultado = resultado + 1;
                
                // Evitar bucle infinito
                if (resultado > 10000) {
                    break;
                }
            }
        } 
        // Para base < 1: multiplicar (o dividir por 1/base) hasta llegar a 1
        else {
            while (valor < 1 - epsilon) {
                valor = new Division().realizarOperacion(valor, base);
                resultado = resultado + 1;
                
                if (resultado > 10000) {
                    break;
                }
            }
            resultado = 0 - resultado; // Resultado negativo para base < 1
        }
        
        return resultado;
    }
    
    /**
     * Método estático para uso directo
     */
    public static double realizarOperacion(int base, int operando) {
        Logaritmo logaritmo = new Logaritmo();
        return logaritmo.realizarOperacion((double)base, (double)operando);
    }
}
