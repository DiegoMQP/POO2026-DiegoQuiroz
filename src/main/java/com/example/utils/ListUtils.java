package com.example.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidades para operaciones con listas de números.
 * @author Diego Quiroz
 */
public class ListUtils {

    /**
     * Mueve todos los ceros al final de la lista manteniendo el orden de los demás elementos.
     * @param numeros lista de números enteros
     * @return lista con los ceros movidos al final
     */
    public static List<Integer> moverCerosAlFinal(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> resultado = new ArrayList<>();
        int contadorCeros = 0;

        // Añadir todos los números que no sean cero
        for (Integer numero : numeros) {
            if (numero == 0) {
                contadorCeros++;
            } else {
                resultado.add(numero);
            }
        }

        // Añadir todos los ceros al final
        for (int i = 0; i < contadorCeros; i++) {
            resultado.add(0);
        }

        return resultado;
    }

    /**
     * Cuenta la cantidad de números pares en una lista.
     * @param numeros lista de números enteros
     * @return cantidad de números pares
     */
    public static int contarPares(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            return 0;
        }

        int contador = 0;
        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                contador++;
            }
        }

        return contador;
    }
}
