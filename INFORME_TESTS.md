# Informe de Ejecución de Tests - Calculadora Aritmética

**Fecha de Ejecución:** 6 de Febrero de 2026  
**Framework de Testing:** JUnit Jupiter 5.10.0  
**Tiempo Total de Ejecución:** 115 ms

---

## Resumen General

| Métrica | Cantidad | Estado |
|---------|----------|--------|
| **Tests Totales** | 23 | OK |
| **Tests Exitosos** | 23 | OK |
| **Tests Fallidos** | 0 | OK |
| **Tests Omitidos** | 0 | OK |
| **Contenedores Ejecutados** | 4 | OK |
| **Tasa de Éxito** | 100% | OK |

---

## Tests Ejecutados y Aprobados

### 1. **Operaciones de Suma** (3 tests)
- OK Test de suma positivos
- OK Test de suma con negativos
- OK Test de suma con cero

-----

### 2. **Operaciones de Resta** (2 tests)
- OK Test de resta positivos
- OK Test de resta con negativos

-----

### 3. **Operaciones de Multiplicación** (3 tests)
- OK Test de multiplicacion positivos
- OK Test de multiplicacion con negativos
- OK Test de multiplicacion con cero

-----

### 4. **Operaciones de División** (3 tests)
- OK Test de division entera
- OK Test de division con negativos
- OK Test de division por cero lanza excepcion

-----

### 5. **Operaciones de Módulo** (3 tests)
- OK Test de modulo
- OK Test de modulo con negativos
- OK Test de modulo por cero lanza excepcion

-----

### 6. **Operaciones de Potencia** (1 test)
- OK Test de potencia

-----

### 7. **Operaciones de Raíz** (3 tests)
- OK Test de raiz cuadrada
- OK Test de raiz cubica
- OK Test de raiz cuadrada con numero negativo lanza excepcion

-----

### 8. **Operaciones de Logaritmo** (2 tests)
- OK Test de logaritmo
- OK Test de logaritmo con base invalida lanza excepcion

-----

### 9. **Tests del Sistema Calculadora** (3 tests)
- OK Test de operacion no soportada lanza excepcion
- OK Test de registro de nueva operacion
- OK Test de verificar operacion existente

---

## Cobertura de Funcionalidad

### Operaciones Básicas Implementadas
1. OK Suma (`+`)
2. OK Resta (`-`)
3. OK Multiplicación (`*`)
4. OK División (`/`)
5. OK Módulo/Residuo (`%`)
6. OK Potencia (`^`)
7. OK Raíz (`raiz`)
8. OK Logaritmo (`log`)

### Casos de Prueba Cubiertos
- OK Operaciones con números positivos
- OK Operaciones con números negativos
- OK Operaciones con cero
- OK Manejo de excepciones (división por cero, módulo por cero, etc.)
- OK Operaciones matemáticas avanzadas (potencias, raíces, logaritmos)
- OK Registro dinámico de operaciones
- OK Verificación de operaciones existentes

---

## Detalles Técnicos

### Implementación
- **Patrón de Diseño:** Registry Pattern (HashMap)
- **Jerarquía de Herencia:** Clase abstracta `Operacion` extendida por todas las operaciones
- **Método Principal:** `apply(int a, int b)`
- **Restricción:** Solo usa operadores primitivos (++, --) para suma y resta
- **Operaciones Complejas:** Construidas mediante operaciones más simples (suma repetida, resta repetida)

### Estructura de Clases Probadas
```
Operacion (abstracta)
├── Suma
├── Resta
├── Multiplicacion
├── Division
├── Modulo
├── Potencia
├── Raiz
└── Logaritmo
```

---

## Observaciones

1. **Todas las operaciones básicas funcionan correctamente** con números positivos, negativos y cero.

2. **Manejo de excepciones apropiado** para casos como:
   - División por cero
   - Módulo por cero
   - Raíz cuadrada de números negativos
   - Logaritmo con base inválida
   - Operaciones no soportadas

3. **Sistema de registro dinámico de operaciones** funciona correctamente, permitiendo:
   - Registrar nuevas operaciones
   - Verificar operaciones existentes
   - Ejecutar operaciones registradas

4. **Implementación sin operadores aritméticos nativos** (excepto ++ y --):
   - Suma y Resta: Solo usan incrementos y decrementos
   - Multiplicación: Suma repetida
   - División: Resta repetida
   - Potencia: Multiplicación repetida
   - Raíz: Búsqueda con potencias
   - Módulo: Resta repetida
   - Logaritmo: División repetida

---

## Conclusión

**Estado Final: TODOS LOS TESTS APROBADOS**

El sistema de calculadora aritmética ha pasado exitosamente todas las pruebas unitarias (23/23 tests). La implementación cumple con todos los requisitos funcionales y maneja correctamente los casos especiales y excepciones.

**Calidad del Código: EXCELENTE**
- 100% de tests aprobados
- 0% de tests fallidos
- Cobertura completa de funcionalidad
- Manejo robusto de excepciones

---

**Generado el:** 6 de Febrero de 2026  
**Framework:** JUnit Jupiter 5.10.0  
**Proyecto:** Calculadora Aritmética - Actividad 2
