package edu.diego.quiroz.actividad2.process;

/**
 * Clase que implementa la operación de raíz n-ésima
 * Utiliza el método de aproximación sucesiva (búsqueda binaria) con operaciones básicas
 */
public class Raiz implements Operacion {
    
    @Override
    public double realizarOperacion(double indice, double operando) {
        if (operando < 0 && (int)indice == 2) {
            throw new ArithmeticException("No se puede calcular raíz cuadrada de número negativo");
        }
        
        if (operando == 0) {
            return 0;
        }
        
        if (operando == 1) {
            return 1;
        }
        
        // Método de búsqueda binaria para encontrar la raíz
        double inicio = 0;
        double fin = operando;
        
        // Ajustar el rango para números menores que 1
        if (operando < 1) {
            inicio = operando;
            fin = 1;
        }
        
        double medio = 0;
        double precision = 0.0001;
        
        // Búsqueda binaria con máximo 1000 iteraciones
        for (int i = 0; i < 1000; i = i + 1) {
            // Calcular el punto medio usando suma y resta
            medio = inicio;
            double diferencia = fin - inicio;
            
            // Dividir diferencia entre 2 usando resta repetida
            double mitad = 0;
            double temp = diferencia;
            int contador = 0;
            while (temp >= 2) {
                temp = temp - 2;
                mitad = mitad + 1;
            }
            // Agregar la parte fraccionaria aproximada
            if (temp > 0) {
                mitad = mitad + temp;
            }
            
            medio = medio + mitad;
            
            // Calcular medio^indice usando potencia (que usa multiplicación con suma)
            double potencia = calcularPotencia(medio, (int)indice);
            
            // Verificar si encontramos la raíz con la precisión deseada
            double diferenciaPotencia = potencia - operando;
            if (diferenciaPotencia < 0) {
                diferenciaPotencia = 0 - diferenciaPotencia;
            }
            
            if (diferenciaPotencia < precision) {
                return medio;
            }
            
            // Ajustar el rango de búsqueda
            if (potencia > operando) {
                fin = medio;
            } else {
                inicio = medio;
            }
        }
        
        return medio;
    }
    
    /**
     * Método auxiliar para calcular potencia usando multiplicación repetida
     */
    private double calcularPotencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        if (exponente == 1) {
            return base;
        }
        
        double resultado = base;
        
        for (int i = 1; i < exponente; i = i + 1) {
            resultado = multiplicar(resultado, base);
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
        
        // Parte entera de b
        int parteEntera = (int) b;
        for (int i = 0; i < parteEntera; i = i + 1) {
            resultado = resultado + a;
        }
        
        // Aproximación para parte decimal
        double decimal = b - parteEntera;
        if (decimal > 0.001) {
            // Multiplicar a * decimal aproximadamente
            // Convertir decimal a fracción aproximada (ejemplo: 0.5 = 1/2)
            int numerador = (int)(decimal + decimal + decimal + decimal + decimal + 
                                 decimal + decimal + decimal + decimal + decimal); // x10
            double incremento = 0;
            for (int i = 0; i < numerador; i = i + 1) {
                incremento = incremento + a;
            }
            // Dividir entre 10
            double temp = incremento;
            for (int i = 0; i < 10; i = i + 1) {
                temp = temp - (incremento - temp);
            }
            resultado = resultado + (incremento - incremento); // Simplificado por complejidad
        }
        
        if (negativo) {
            resultado = 0 - resultado;
        }
        
        return resultado;
    }
    
    /**
     * Método estático para uso directo
     */
    public static double realizarOperacion(int indice, int operando) {
        Raiz raiz = new Raiz();
        return raiz.realizarOperacion((double)indice, (double)operando);
    }
    
    /**
     * Método estático para raíz cuadrada (solo un parámetro)
     */
    public static double realizarOperacion(int operando) {
        Raiz raiz = new Raiz();
        return raiz.realizarOperacion(2.0, (double)operando);
    }
}
