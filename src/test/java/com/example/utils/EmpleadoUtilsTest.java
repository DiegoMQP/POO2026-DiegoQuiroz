package com.example.utils;

import com.example.model.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Diego Quiroz
 */
class EmpleadoUtilsTest {

    private List<Empleado> empleados;

    @BeforeEach
    void setUp() {
        empleados = Arrays.asList(
                new Empleado("Sofia", 28, 30000, "Sistemas"),
                new Empleado("Ricardo", 32, 35000, "Ventas"),
                new Empleado("Valeria", 24, 22000, "Sistemas"),
                new Empleado("Beatriz", 28, 28000, "Recursos Humanos"),
                new Empleado("Alejandro", 35, 40000, "Sistemas"),
                new Empleado("Daniela", 22, 20000, "Ventas"),
                new Empleado("Fernando", 28, 26000, "Finanzas")
        );
    }

    // ========================================================================
    // TESTS: Empleado con mayor salario
    // ========================================================================

    @Test
    void testEmpleadoConMayorSalario() {
        Empleado result = EmpleadoUtils.empleadoConMayorSalario(empleados);
        assertNotNull(result);
        assertEquals("Alejandro", result.getNombre());
        assertEquals(40000, result.getSalario());
    }

    // ========================================================================
    // TESTS: Edad más común
    // ========================================================================

    @Test
    void testEdadMasComun() {
        int result = EmpleadoUtils.edadMasComun(empleados);
        assertEquals(28, result); // Hay 3 empleados con 28 años
    }

    @Test
    void testEdadMasComunListaVacia() {
        int result = EmpleadoUtils.edadMasComun(List.of());
        assertEquals(-1, result);
    }

    // ========================================================================
    // TESTS: Promedio de edad
    // ========================================================================

    @Test
    void testPromedioEdad() {
        double result = EmpleadoUtils.promedioEdad(empleados);
        assertEquals(28.14, result, 0.01);
    }

    @Test
    void testPromedioEdadListaVacia() {
        double result = EmpleadoUtils.promedioEdad(List.of());
        assertEquals(0.0, result);
    }

    // ========================================================================
    // TESTS: Promedio de salario
    // ========================================================================

    @Test
    void testPromedioSalario() {
        double result = EmpleadoUtils.promedioSalario(empleados);
        assertEquals(28714.29, result, 0.01);
    }

    @Test
    void testPromedioSalarioListaVacia() {
        double result = EmpleadoUtils.promedioSalario(List.of());
        assertEquals(0.0, result);
    }

    // ========================================================================
    // TESTS: Promedio de edad con salario mayor a 25K
    // ========================================================================

    @Test
    void testPromedioEdadConSalarioMayorA25K() {
        double result = EmpleadoUtils.promedioEdadConSalarioMayorA25K(empleados);
        // Empleados con salario > 25000: Sofia(28), Ricardo(32), Beatriz(28), Alejandro(35), Fernando(28)
        // Promedio: (28+32+28+35+28)/5 = 30.2
        assertEquals(30.2, result, 0.01);
    }

    @Test
    void testPromedioEdadConSalarioMayorA25KSinEmpleados() {
        List<Empleado> empleadosBajosSalarios = Arrays.asList(
                new Empleado("Test1", 25, 20000, "Test"),
                new Empleado("Test2", 26, 24000, "Test")
        );
        double result = EmpleadoUtils.promedioEdadConSalarioMayorA25K(empleadosBajosSalarios);
        assertEquals(0.0, result);
    }

    // ========================================================================
    // TESTS: Filtrar empleados menores de 25 años
    // ========================================================================

    @Test
    void testFiltrarMenoresDe25() {
        List<Empleado> result = EmpleadoUtils.filtrarMenoresDe25(empleados);
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(e -> e.getEdad() < 25));
    }

    @Test
    void testFiltrarMenoresDe25SinMenores() {
        List<Empleado> empleadosMayores = Arrays.asList(
                new Empleado("Test1", 25, 30000, "Test"),
                new Empleado("Test2", 30, 35000, "Test")
        );
        List<Empleado> result = EmpleadoUtils.filtrarMenoresDe25(empleadosMayores);
        assertEquals(0, result.size());
    }

    // ========================================================================
    // TESTS: Contar empleados del departamento de Sistemas
    // ========================================================================

    @Test
    void testContarEmpleadosDeSistemas() {
        int result = EmpleadoUtils.contarEmpleadosDeSistemas(empleados);
        assertEquals(3, result);
    }

    @Test
    void testContarEmpleadosDeSistemasSinEmpleados() {
        List<Empleado> empleadosSinSistemas = Arrays.asList(
                new Empleado("Test1", 25, 30000, "Ventas"),
                new Empleado("Test2", 30, 35000, "Ventas")
        );
        int result = EmpleadoUtils.contarEmpleadosDeSistemas(empleadosSinSistemas);
        assertEquals(0, result);
    }

    // ========================================================================
    // TESTS: Empleado con mayor salario y mayor de 30 años
    // ========================================================================

    @Test
    void testEmpleadoConMayorSalarioMayorDe30() {
        Empleado result = EmpleadoUtils.empleadoConMayorSalarioMayorDe30(empleados);
        assertNotNull(result);
        assertEquals("Alejandro", result.getNombre());
        assertEquals(35, result.getEdad());
        assertEquals(40000, result.getSalario());
    }

    @Test
    void testEmpleadoConMayorSalarioMayorDe30SinEmpleados() {
        List<Empleado> empleadosJovenes = Arrays.asList(
                new Empleado("Test1", 25, 30000, "Test"),
                new Empleado("Test2", 28, 35000, "Test")
        );
        Empleado result = EmpleadoUtils.empleadoConMayorSalarioMayorDe30(empleadosJovenes);
        assertNull(result);
    }

    // ========================================================================
    // TESTS: Empleado con menor salario y edad menos común
    // ========================================================================

    @Test
    void testEmpleadoConMenorSalarioYEdadMenosComun() {
        // Edades: 28(3), 32(1), 24(1), 35(1), 22(1)
        // Edad menos común: 32, 24, 35, 22 (frecuencia 1)
        // Entre ellos, el de menor salario: Daniela (22 años, 20000)
        Empleado result = EmpleadoUtils.empleadoConMenorSalarioYEdadMenosComun(empleados);
        assertNotNull(result);
        assertEquals("Daniela", result.getNombre());
        assertEquals(20000, result.getSalario());
    }

    @Test
    void testEmpleadoConMenorSalarioYEdadMenosComunListaVacia() {
        Empleado result = EmpleadoUtils.empleadoConMenorSalarioYEdadMenosComun(List.of());
        assertNull(result);
    }
}
