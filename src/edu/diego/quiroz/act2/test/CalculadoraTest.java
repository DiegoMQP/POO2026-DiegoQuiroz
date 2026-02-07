package edu.diego.quiroz.act2.test;

import edu.diego.quiroz.act2.process.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la Calculadora.
 * Contiene tests para todas las operaciones matemáticas implementadas.
 * 
 * @author Diego Quiroz
 * @version 1.0
 */
@DisplayName("Tests de Calculadora")
public class CalculadoraTest {
    
    /** Instancia de calculadora utilizada en los tests */
    private Calculadora calculadora;
    
    /**
     * Configuración inicial antes de cada test.
     * Inicializa una nueva instancia de LA calculadora.
     */
    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }
    
    @Test
    @DisplayName("Test de suma positivos")
    public void testSumaPositivos() {
        assertEquals(8, calculadora.calcular("+", 5, 3));
        assertEquals(10, calculadora.calcular("+", 7, 3));
    }
    
    @Test
    @DisplayName("Test de suma con negativos")
    public void testSumaNegativos() {
        assertEquals(2, calculadora.calcular("+", 5, -3));
        assertEquals(-2, calculadora.calcular("+", -5, 3));
        assertEquals(-8, calculadora.calcular("+", -5, -3));
    }
    
    @Test
    @DisplayName("Test de suma con cero")
    public void testSumaCero() {
        assertEquals(5, calculadora.calcular("+", 5, 0));
        assertEquals(5, calculadora.calcular("+", 0, 5));
    }
    
    @Test
    @DisplayName("Test de resta positivos")
    public void testRestaPositivos() {
        assertEquals(2, calculadora.calcular("-", 5, 3));
        assertEquals(4, calculadora.calcular("-", 7, 3));
    }
    
    @Test
    @DisplayName("Test de resta con negativos")
    public void testRestaNegativos() {
        assertEquals(8, calculadora.calcular("-", 5, -3));
        assertEquals(-8, calculadora.calcular("-", -5, 3));
        assertEquals(-2, calculadora.calcular("-", -5, -3));
    }
    
    @Test
    @DisplayName("Test de multiplicacion positivos")
    public void testMultiplicacionPositivos() {
        assertEquals(15, calculadora.calcular("*", 5, 3));
        assertEquals(24, calculadora.calcular("*", 6, 4));
    }
    
    @Test
    @DisplayName("Test de multiplicacion con cero")
    public void testMultiplicacionCero() {
        assertEquals(0, calculadora.calcular("*", 5, 0));
        assertEquals(0, calculadora.calcular("*", 0, 5));
    }
    
    @Test
    @DisplayName("Test de multiplicacion con negativos")
    public void testMultiplicacionNegativos() {
        assertEquals(-15, calculadora.calcular("*", 5, -3));
        assertEquals(-15, calculadora.calcular("*", -5, 3));
        assertEquals(15, calculadora.calcular("*", -5, -3));
    }
    
    @Test
    @DisplayName("Test de division entera")
    public void testDivision() {
        assertEquals(5, calculadora.calcular("/", 15, 3));
        assertEquals(3, calculadora.calcular("/", 17, 5));
    }
    
    @Test
    @DisplayName("Test de division con negativos")
    public void testDivisionNegativos() {
        assertEquals(-5, calculadora.calcular("/", 15, -3));
        assertEquals(-5, calculadora.calcular("/", -15, 3));
        assertEquals(5, calculadora.calcular("/", -15, -3));
    }
    
    @Test
    @DisplayName("Test de division por cero lanza excepcion")
    public void testDivisionPorCero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.calcular("/", 10, 0);
        });
    }
    
    @Test
    @DisplayName("Test de modulo")
    public void testModulo() {
        assertEquals(2, calculadora.calcular("%", 17, 5));
        assertEquals(0, calculadora.calcular("%", 20, 4));
        assertEquals(3, calculadora.calcular("%", 23, 5));
    }
    
    @Test
    @DisplayName("Test de modulo con negativos")
    public void testModuloNegativos() {
        assertEquals(-2, calculadora.calcular("%", -17, 5));
        assertEquals(2, calculadora.calcular("%", 17, -5));
    }
    
    @Test
    @DisplayName("Test de modulo por cero lanza excepcion")
    public void testModuloPorCero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.calcular("%", 10, 0);
        });
    }
    
    @Test
    @DisplayName("Test de potencia")
    public void testPotencia() {
        assertEquals(8, calculadora.calcular("^", 2, 3));
        assertEquals(25, calculadora.calcular("^", 5, 2));
        assertEquals(1, calculadora.calcular("^", 5, 0));
        assertEquals(0, calculadora.calcular("^", 0, 5));
    }
    
    @Test
    @DisplayName("Test de raiz cuadrada")
    public void testRaizCuadrada() {
        assertEquals(4, calculadora.calcular("raiz", 2, 16));
        assertEquals(5, calculadora.calcular("raiz", 2, 25));
        assertEquals(3, calculadora.calcular("raiz", 2, 9));
    }
    
    @Test
    @DisplayName("Test de raiz cubica")
    public void testRaizCubica() {
        assertEquals(3, calculadora.calcular("raiz", 3, 27));
        assertEquals(2, calculadora.calcular("raiz", 3, 8));
    }
    
    @Test
    @DisplayName("Test de raiz cuadrada con numero negativo lanza excepcion")
    public void testRaizNegativa() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.calcular("raiz", 2, -4);
        });
    }
    
    @Test
    @DisplayName("Test de logaritmo")
    public void testLogaritmo() {
        assertEquals(3, calculadora.calcular("log", 2, 8));
        assertEquals(4, calculadora.calcular("log", 2, 16));
        assertEquals(2, calculadora.calcular("log", 10, 100));
    }
    
    @Test
    @DisplayName("Test de logaritmo con base invalida lanza excepcion")
    public void testLogaritmoBaseInvalida() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.calcular("log", 1, 10);
        });
    }
    
    @Test
    @DisplayName("Test de operacion no soportada lanza excepcion")
    public void testOperacionNoSoportada() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcular("&", 5, 3);
        });
    }
    
    @Test
    @DisplayName("Test de registro de nueva operacion")
    public void testRegistrarOperacion() {
        Operacion nuevaOp = new Suma();
        calculadora.registrarOperacion("sumar", nuevaOp);
        assertTrue(calculadora.tieneOperacion("sumar"));
        assertEquals(8, calculadora.calcular("sumar", 5, 3));
    }
    
    @Test
    @DisplayName("Test de verificar operacion existente")
    public void testTieneOperacion() {
        assertTrue(calculadora.tieneOperacion("+"));
        assertTrue(calculadora.tieneOperacion("-"));
        assertTrue(calculadora.tieneOperacion("*"));
        assertFalse(calculadora.tieneOperacion("invalida"));
    }
}
