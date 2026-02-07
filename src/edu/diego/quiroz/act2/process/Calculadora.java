package edu.diego.quiroz.act2.process;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculadora que utiliza el patrón Registry para gestionar operaciones matemáticas.
 * Permite registrar y ejecutar operaciones dinámicamente usando un HashMap.
 * 
 * @author Diego Quiroz
 * @version 1.0
 */
public class Calculadora {
    /** Mapa que almacena las operaciones registradas */
    private final Map<String, Operacion> operaciones;
    
    /**
     * Constructor que inicializa la calculadora y registra operaciones por defecto.
     */
    public Calculadora() {
        operaciones = new HashMap<>();
        registrarOperacionesPorDefecto();
    }
    
    private void registrarOperacionesPorDefecto() {
        registrarOperacion("+", new Suma());
        registrarOperacion("-", new Resta());
        registrarOperacion("*", new Multiplicacion());
        registrarOperacion("/", new Division());
        registrarOperacion("%", new Modulo());
        registrarOperacion("^", new Potencia());
        registrarOperacion("raiz", new Raiz());
        registrarOperacion("log", new Logaritmo());
    }
    
    /**
     * Registra una nueva operación en la calculadora.
     * 
     * @param clave Identificador de la operación (ej: "+", "-", "*")
     * @param operacion Instancia de la operación a registrar
     */
    public void registrarOperacion(String clave, Operacion operacion) {
        operaciones.put(clave, operacion);
    }
    
    /**
     * Calcula el resultado de una operación con dos operandos.
     * 
     * @param tipoOperacion Clave de la operación a ejecutar
     * @param a Primer operando
     * @param b Segundo operando
     * @return Resultado de la operación
     * @throws IllegalArgumentException si la operación no está registrada
     */
    public int calcular(String tipoOperacion, int a, int b) {
        Operacion operacion = operaciones.get(tipoOperacion);
        if (operacion == null) {
            throw new IllegalArgumentException("Operacion no soportada: " + tipoOperacion);
        }
        return operacion.apply(a, b);
    }
    
    /**
     * Obtiene una operación registrada por su clave.
     * 
     * @param clave Identificador de la operación
     * @return La operación registrada o null si no existe
     */
    public Operacion obtenerOperacion(String clave) {
        return operaciones.get(clave);
    }
    
    /**
     * Verifica si una operación está registrada.
     * 
     * @param clave Identificador de la operación
     * @return true si la operación existe, false en caso contrario
     */
    public boolean tieneOperacion(String clave) {
        return operaciones.containsKey(clave);
    }
}
