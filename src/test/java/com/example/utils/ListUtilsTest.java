package com.example.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Diego Quiroz
 */
class ListUtilsTest {

    // ========================================================================
    // TESTS: Mover ceros al final de la lista
    // ========================================================================

    @Test
    void testMoverCerosAlFinal() {
        List<Integer> input = Arrays.asList(0, 5, 0, 3, 7, 0, 2, 9, 0, 1, 4, 0, 8, 6, 0, 2, 5, 0, 3, 0);
        List<Integer> expected = Arrays.asList(5, 3, 7, 2, 9, 1, 4, 8, 6, 2, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> result = ListUtils.moverCerosAlFinal(input);
        assertEquals(expected, result);
    }

    @Test
    void testMoverCerosAlFinalSinCeros() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = ListUtils.moverCerosAlFinal(input);
        assertEquals(expected, result);
    }

    @Test
    void testMoverCerosAlFinalTodosCeros() {
        List<Integer> input = Arrays.asList(0, 0, 0);
        List<Integer> expected = Arrays.asList(0, 0, 0);
        List<Integer> result = ListUtils.moverCerosAlFinal(input);
        assertEquals(expected, result);
    }

    // ========================================================================
    // TESTS: Contar números pares en la lista
    // ========================================================================

    @Test
    void testContarPares() {
        List<Integer> input = Arrays.asList(9, 2, 7, 4, 1, 8, 3, 6, 5);
        int result = ListUtils.contarPares(input);
        assertEquals(4, result);
    }

    @Test
    void testContarParesSinPares() {
        List<Integer> input = Arrays.asList(1, 3, 5, 7);
        int result = ListUtils.contarPares(input);
        assertEquals(0, result);
    }

    @Test
    void testContarParesTodoPares() {
        List<Integer> input = Arrays.asList(2, 4, 6, 8);
        int result = ListUtils.contarPares(input);
        assertEquals(4, result);
    }
}
