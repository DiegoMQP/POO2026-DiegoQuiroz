package com.example.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Diego Quiroz
 */
class StringUtilsTest {

    // ========================================================================
    // TESTS: Verificar si es palíndromo
    // ========================================================================

    @Test
    void testEsPalindromoFalso() {
        assertFalse(StringUtils.esPalindromo("buenos dias"));
    }

    @Test
    void testEsPalindromoVerdadero() {
        assertTrue(StringUtils.esPalindromo("reconocer"));
    }

    @Test
    void testEsPalindromoConEspacios() {
        assertTrue(StringUtils.esPalindromo("anita lava la tina"));
    }

    @Test
    void testEsPalindromoMayusculasMinusculas() {
        assertTrue(StringUtils.esPalindromo("Anita lava la tina"));
    }

    // ========================================================================
    // TESTS: Contar vocales en una cadena
    // ========================================================================

    @Test
    void testContarVocales() {
        assertEquals(5, StringUtils.contarVocales("programacion"));
    }

    @Test
    void testContarVocalesCadenaVacia() {
        assertEquals(0, StringUtils.contarVocales(""));
    }

    @Test
    void testContarVocalesSinVocales() {
        assertEquals(0, StringUtils.contarVocales("xyz"));
    }

    // ========================================================================
    // TESTS: Invertir cadena (sin usar reverse)
    // ========================================================================

    @Test
    void testInvertirCadena() {
        assertEquals("ogidoc", StringUtils.invertirCadena("codigo"));
    }

    @Test
    void testInvertirCadenaCadenaVacia() {
        assertEquals("", StringUtils.invertirCadena(""));
    }

    @Test
    void testInvertirCadenaUnCaracter() {
        assertEquals("a", StringUtils.invertirCadena("a"));
    }

    // ========================================================================
    // TESTS: Encontrar primera ocurrencia de un carácter (sin usar indexOf)
    // ========================================================================

    @Test
    void testEncontrarPrimeraOcurrenciaExiste() {
        assertEquals(2, StringUtils.encontrarPrimeraOcurrencia("codigo", 'd'));
    }

    @Test
    void testEncontrarPrimeraOcurrenciaNoExiste() {
        assertEquals(-1, StringUtils.encontrarPrimeraOcurrencia("codigo", 'x'));
    }

    @Test
    void testEncontrarPrimeraOcurrenciaPrimerCaracter() {
        assertEquals(0, StringUtils.encontrarPrimeraOcurrencia("codigo", 'c'));
    }

    @Test
    void testEncontrarPrimeraOcurrenciaUltimoCaracter() {
        assertEquals(1, StringUtils.encontrarPrimeraOcurrencia("codigo", 'o'));
    }
}
