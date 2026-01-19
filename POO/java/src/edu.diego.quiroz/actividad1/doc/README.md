# Documentación - Sistema de Venta de Vehículos TecmiNuevos

## Información del Proyecto

- **Proyecto:** Actividad 1 - POO 2026
- **Autor:** Diego Quiroz
- **Versión:** 1.0.0
- **Tecnologías:** Java 11, JavaFX 17, iText 5, SQLite

## Descripción

Sistema de gestión y venta de vehículos desarrollado con JavaFX. Permite visualizar catálogos de vehículos nuevos y seminuevos, gestionar ventas, seleccionar extras y generar tickets en PDF.

## Estructura del Proyecto

### Paquete: actividad1.process

Contiene la lógica de negocio y procesamiento del sistema.

- **App** - Clase principal de la aplicación. Punto de entrada JavaFX.
- **BaseDatos** - Gestiona la conexión y operaciones con la base de datos SQLite.
- **ControladorVentas** - Controla el proceso de ventas y gestión del carrito de compras.
- **Extra** - Representa un extra o accesorio adicional para vehículos.
- **GeneradorPDF** - Genera tickets de venta en formato PDF.
- **GestorIdiomas** - Gestiona la internacionalización del sistema (ES/EN).
- **RepositorioVehiculos** - Repositorio de vehículos disponibles en el sistema.
- **Ticket** - Representa un ticket de venta con todos sus detalles.
- **Vehiculo** - Clase abstracta que representa un vehículo genérico.
- **VehiculoNuevo** - Representa un vehículo nuevo con garantía.
- **VehiculoSeminuevo** - Representa un vehículo seminuevo con historial.

### Paquete: actividad1.ui

Contiene las interfaces gráficas del usuario.

- **VentanaPrincipal** - Ventana principal del sistema con catálogo y carrito.
- **DialogoExtras** - Diálogo para seleccionar extras y accesorios.
- **DialogoSeleccionIdioma** - Diálogo inicial para seleccionar el idioma de la aplicación.

## Características Principales

- ✅ Catálogo visual de vehículos nuevos y seminuevos
- ✅ Sistema de carrito de compras
- ✅ Selección de extras y accesorios
- ✅ Generación de tickets en PDF
- ✅ Soporte multiidioma (Español e Inglés)
- ✅ Persistencia de datos con SQLite

## Cómo Usar la Documentación

1. Abre `index.html` en tu navegador para ver el índice completo
2. Navega a través de las clases para ver detalles específicos
3. Cada clase tiene su página con métodos y atributos documentados

## Construcción del Proyecto

```bash
# Instalar dependencias
mvn clean install

# Ejecutar la aplicación
mvn javafx:run
```

## Generación de PDFs

El sistema utiliza iText 5.5.13 para generar tickets de venta profesionales con:
- Logotipo de la empresa
- Detalles del cliente
- Información completa de vehículos
- Resumen financiero con IVA
- Términos y condiciones

## Base de Datos

SQLite integrado para persistencia de:
- Catálogo de vehículos
- Historial de ventas
- Información de clientes
- Configuración del sistema
