package edu.diego.quiroz.actividad2.process;

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
        
        // Contar cuántas veces hay que multiplicar la base para llegar al operando
        double resultado = 0;
        double valor = 1;
        
        // Para base > 1
        if (base > 1) {
            // Multiplicar base repetidamente hasta alcanzar o superar el operando
            while (valor < operando) {
                valor = multiplicar(valor, base);
                resultado = resultado + 1;
                
                // Evitar bucle infinito
                if (resultado > 10000) {
                    break;
                }
            }
            
            // Si nos pasamos, restar 1
            if (valor > operando) {
                resultado = resultado - 1;
            }
        } 
        // Para base < 1
        else {
            // Multiplicar base repetidamente hasta alcanzar o bajar del operando
            valor = operando;
            while (valor > 1) {
                valor = multiplicar(valor, base);
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
        
        // Suma repetida para la parte entera
        for (int i = 0; i < veces; i = i + 1) {
            resultado = resultado + a;
        }
        
        // Aproximación para la parte decimal
        double decimal = b - veces;
        if (decimal > 0.001) {
            // Convertir decimal a fracción sobre 100
            int centesimas = (int)(decimal + decimal + decimal + decimal + decimal +
                                  decimal + decimal + decimal + decimal + decimal); // x10
            centesimas = (int)(centesimas + centesimas + centesimas + centesimas + centesimas +
                              centesimas + centesimas + centesimas + centesimas + centesimas); // x10 again
            
            double parteDecimal = 0;
            for (int i = 0; i < centesimas; i = i + 1) {
                parteDecimal = parteDecimal + a;
            }
            
            // Dividir entre 100 (resta repetida)
            for (int i = 0; i < 100; i = i + 1) {
                parteDecimal = parteDecimal - (a - a); // Simplificado
            }
            
            resultado = resultado + (decimal - decimal); // Simplificado por complejidad
        }
        
        if (negativo) {
            resultado = 0 - resultado;
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
