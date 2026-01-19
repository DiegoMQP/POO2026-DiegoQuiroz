package com.vehiculos;

import com.vehiculos.modelos.Cliente;
import com.vehiculos.modelos.Vehiculo;
import com.vehiculos.servicios.TicketVenta;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaVentaVehiculos {
    private static ArrayList<Vehiculo> inventario;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        inicializarInventario();
        
        mostrarBienvenida();
        ejecutarSistema();
        
        scanner.close();
    }

    private static void inicializarInventario() {
        inventario = new ArrayList<>();
        
        inventario.add(new Vehiculo("Toyota", "Camry", 2024, "Blanco Perla", 
            28500.00, "Sedán", "2.5L 4 cilindros", "Automática"));
        
        inventario.add(new Vehiculo("Honda", "CR-V", 2024, "Negro", 
            32000.00, "SUV", "1.5L Turbo", "Automática CVT"));
        
        inventario.add(new Vehiculo("Ford", "Mustang", 2024, "Rojo Racing", 
            45000.00, "Deportivo", "5.0L V8", "Manual 6 velocidades"));
        
        inventario.add(new Vehiculo("Chevrolet", "Silverado", 2024, "Gris Grafito", 
            38500.00, "Pick-up", "5.3L V8", "Automática"));
        
        inventario.add(new Vehiculo("Tesla", "Model 3", 2024, "Azul Medianoche", 
            42000.00, "Sedán Eléctrico", "Motor Eléctrico Dual", "Automática"));
        
        inventario.add(new Vehiculo("BMW", "X5", 2024, "Blanco Alpino", 
            65000.00, "SUV Premium", "3.0L 6 cilindros Turbo", "Automática 8 vel"));
        
        inventario.add(new Vehiculo("Mazda", "CX-5", 2024, "Rojo Soul", 
            29500.00, "SUV", "2.5L 4 cilindros", "Automática"));
        
        inventario.add(new Vehiculo("Nissan", "Altima", 2024, "Plateado", 
            26000.00, "Sedán", "2.0L 4 cilindros Turbo", "Automática CVT"));
        
        inventario.add(new Vehiculo("Audi", "A4", 2024, "Negro Brillante", 
            48000.00, "Sedán Premium", "2.0L 4 cilindros Turbo", "Automática 7 vel"));
        
        inventario.add(new Vehiculo("Jeep", "Grand Cherokee", 2024, "Verde Oliva", 
            52000.00, "SUV", "3.6L V6", "Automática 8 vel"));
        
        inventario.add(new Vehiculo("Volkswagen", "Jetta", 2024, "Blanco Puro", 
            24500.00, "Sedán", "1.4L 4 cilindros Turbo", "Automática"));
        
        inventario.add(new Vehiculo("Hyundai", "Tucson", 2024, "Azul Océano", 
            30000.00, "SUV", "2.5L 4 cilindros", "Automática 8 vel"));
    }

    private static void mostrarBienvenida() {
        System.out.println("\n+=================================================================+");
        System.out.println("|                                                                 |");
        System.out.println("|                   BIENVENIDO A TECMINUEVOS                      |");
        System.out.println("|                                                                 |");
        System.out.println("|             Su destino para vehiculos de calidad                |");
        System.out.println("|                                                                 |");
        System.out.println("+=================================================================+\n");
    }

    private static void ejecutarSistema() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n+====================================+");
            System.out.println("|         MENU PRINCIPAL             |");
            System.out.println("+====================================+");
            System.out.println("| 1. Ver vehiculos en exhibicion     |");
            System.out.println("| 2. Realizar compra                 |");
            System.out.println("| 3. Salir                           |");
            System.out.println("+====================================+");
            System.out.print("Seleccione una opcion: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    mostrarInventario();
                    break;
                case 2:
                    realizarCompra();
                    break;
                case 3:
                    continuar = false;
                    mostrarDespedida();
                    break;
                default:
                    System.out.println("[X] Opcion invalida. Intente nuevamente.");
            }
        }
    }

    private static void mostrarInventario() {
        int paginaActual = 0;
        int vehiculosPorPagina = 5;
        boolean continuar = true;

        while (continuar) {
            int inicio = paginaActual * vehiculosPorPagina;
            int fin = Math.min(inicio + vehiculosPorPagina, inventario.size());

            System.out.println("\n+=================================================================+");
            System.out.println("|              VEHICULOS DISPONIBLES EN EXHIBICION                |");
            System.out.println("+=================================================================+\n");

            for (int i = inicio; i < fin; i++) {
                System.out.println("===================================================================");
                System.out.println("OPCION " + (i - inicio + 1) + " - VEHICULO #" + (i + 1));
                inventario.get(i).mostrarCaracteristicas();
                System.out.println();
            }

            System.out.println("+====================================+");
            System.out.println("|         OPCIONES DE NAVEGACION     |");
            System.out.println("+====================================+");
            
            for (int i = 1; i <= Math.min(vehiculosPorPagina, fin - inicio); i++) {
                System.out.println(String.format("| %d. Ver detalles del vehiculo %d    |", i, i));
            }
            
            System.out.println("+------------------------------------+");
            
            if (fin < inventario.size()) {
                System.out.println("| 6. Siguiente pagina                |");
            }
            if (paginaActual > 0) {
                System.out.println("| 7. Pagina anterior                 |");
            }
            System.out.println("| 0. Volver al menu principal        |");
            System.out.println("+====================================+");
            
            System.out.println(String.format("\nPagina %d de %d | Mostrando vehiculos %d-%d de %d", 
                paginaActual + 1, 
                (inventario.size() + vehiculosPorPagina - 1) / vehiculosPorPagina,
                inicio + 1, fin, inventario.size()));
            
            System.out.print("Seleccione una opción: ");
            int opcion = leerOpcion();

            if (opcion == 0) {
                continuar = false;
            } else if (opcion >= 1 && opcion <= 5 && opcion <= (fin - inicio)) {
                // Mostrar detalles del vehículo seleccionado
                int indiceVehiculo = inicio + opcion - 1;
                System.out.println("\n+=================================================================+");
                System.out.println("|                  DETALLES COMPLETOS DEL VEHICULO                |");
                System.out.println("+=================================================================+\n");
                inventario.get(indiceVehiculo).mostrarCaracteristicas();
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            } else if (opcion == 6 && fin < inventario.size()) {
                paginaActual++;
            } else if (opcion == 7 && paginaActual > 0) {
                paginaActual--;
            } else {
                System.out.println("[X] Opcion invalida.");
            }
        }
    }

    private static void realizarCompra() {
        ArrayList<Vehiculo> carrito = new ArrayList<>();
        
        System.out.println("\n+=================================================================+");
        System.out.println("|                     PROCESO DE COMPRA                           |");
        System.out.println("+=================================================================+\n");

        System.out.println("Vehiculos disponibles:\n");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println(String.format("%d. %s", (i + 1), inventario.get(i).toString()));
        }

        boolean agregarMas = true;
        while (agregarMas && !inventario.isEmpty()) {
            System.out.print("\nIngrese el numero del vehiculo a comprar (0 para terminar): ");
            int seleccion = leerOpcion();

            if (seleccion == 0) {
                agregarMas = false;
            } else if (seleccion > 0 && seleccion <= inventario.size()) {
                Vehiculo vehiculoSeleccionado = inventario.get(seleccion - 1);
                carrito.add(vehiculoSeleccionado);
                System.out.println("[OK] Agregado: " + vehiculoSeleccionado.getDescripcionBreve());
                
                System.out.print("Desea agregar otro vehiculo? (S/N): ");
                scanner.nextLine(); // Limpiar buffer
                String respuesta = scanner.nextLine().trim().toLowerCase();
                agregarMas = respuesta.equals("s") || respuesta.equals("si");
            } else {
                System.out.println("[X] Seleccion invalida.");
            }
        }

        if (carrito.isEmpty()) {
            System.out.println("\n[!] No se seleccionaron vehiculos. Volviendo al menu principal...");
            return;
        }

        Cliente cliente = capturarDatosCliente();

        TicketVenta ticket = new TicketVenta(cliente, carrito);
        ticket.generarTicket();

        for (Vehiculo v : carrito) {
            inventario.remove(v);
        }
    }

    private static Cliente capturarDatosCliente() {
        scanner.nextLine();
        
        System.out.println("\n+=================================================================+");
        System.out.println("|                    DATOS DEL CLIENTE                            |");
        System.out.println("+=================================================================+\n");

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new Cliente(nombre, telefono, email);
    }

    private static int leerOpcion() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void mostrarDespedida() {
        System.out.println("\n+=================================================================+");
        System.out.println("|                                                                 |");
        System.out.println("|            Gracias por visitar TECMINUEVOS!                     |");
        System.out.println("|              Esperamos verle pronto                             |");
        System.out.println("|                                                                 |");
        System.out.println("+=================================================================+\n");
    }
}
