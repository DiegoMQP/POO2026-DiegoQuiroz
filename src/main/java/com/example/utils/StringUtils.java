package com.example.utils;

/**
 * Clase de utilidades para operaciones con cadenas de texto.
 * @author Diego Quiroz
 */
public class StringUtils {

    /**
     * Determina si una cadena es un palíndromo (se lee igual de izquierda a derecha y viceversa).
     * @param texto cadena a evaluar
     * @return true si es palíndromo, false en caso contrario
     */
    public static boolean esPalindromo(String texto) {
        if (texto == null) {
            return false;
        }

        // Eliminar espacios y convertir a minúsculas para la comparación
        String textoLimpio = texto.toLowerCase().replaceAll("\\s+", "");

        int inicio = 0;
        int fin = textoLimpio.length() - 1;

        while (inicio < fin) {
            if (textoLimpio.charAt(inicio) != textoLimpio.charAt(fin)) {
                return false;
            }
            inicio++;
            fin--;
        }

        return true;
    }

    /**
     * Cuenta el número de vocales en una cadena.
     * @param texto cadena a evaluar
     * @return número de vocales (a, e, i, o, u)
     */
    public static int contarVocales(String texto) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }

        int contador = 0;
        String textoMinusculas = texto.toLowerCase();

        for (char c : textoMinusculas.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Invierte una cadena sin usar el método reverse.
     * @param texto cadena a invertir
     * @return cadena invertida, cadena vacía si el texto es null o vacío
     * @throws IllegalArgumentException si texto es null
     */
    public static String invertirCadena(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("El texto no puede ser null");
        }
        if (texto.isEmpty()) {
            return texto;
        }

        StringBuilder resultado = new StringBuilder();
        for (int i = texto.length() - 1; i >= 0; i--) {
            resultado.append(texto.charAt(i));
        }

        return resultado.toString();
    }

    /**
     * Encuentra la primera posición de un carácter en una cadena.
     * @param texto cadena donde buscar
     * @param caracter carácter a buscar
     * @return índice de la primera ocurrencia del carácter, -1 si no se encuentra
     */
    public static int encontrarPrimeraOcurrencia(String texto, char caracter) {
        if (texto == null || texto.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == caracter) {
                return i;
            }
        }

        return -1;
    }
}
