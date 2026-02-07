package edu.diego.quiroz.act2;

import edu.diego.quiroz.act2.ui.CLI;

/**
 * Clase principal de la calculadora aritmética.
 * <p>
 * Esta clase contiene el punto de entrada de la aplicación. Inicia la interfaz
 * de línea de comandos (CLI) que permite al usuario interactuar con la calculadora.
 * </p>
 *
 * @author Diego Quiroz
 * @version 1.0
 * @since 2026-02-06
 */
public class Main {
    
    /**
     * Punto de entrada principal de la aplicación.
     * <p>
     * Inicia la interfaz de línea de comandos de la calculadora aritmética.
     * </p>
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        CLI.iniciar();
    }
}
