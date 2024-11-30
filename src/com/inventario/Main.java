package com.inventario;

import java.io.*;
import java.util.*;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String archivoUsuarios = "usuarios.txt";
        String archivoSaldo = "saldo.txt";
        String archivoHistorialFianzas = "historial_fianzas.txt";

        Map<String, String> usuarios = cargarUsuarios(archivoUsuarios);

        String usuarioCorrecto = "admin";
        String contrasenaCorrecta = "admin123";

        if (!usuarios.containsKey(usuarioCorrecto)) {
            usuarios.put(usuarioCorrecto, contrasenaCorrecta);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor ingresa el nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.println("Por favor ingresa la contraseña: ");
        String contrasena = scanner.nextLine();

        if (!usuarios.containsKey(usuario) || !usuarios.get(usuario).equals(contrasena)) {
            System.out.println("Acceso denegado. Usuario o contraseña incorrectos.");
            return;
        }

        System.out.println("¡Acceso concedido! Bienvenido al sistema de inventario.");

        Inventario inventario = new Inventario();
        Fianzas fianzas = new Fianzas(archivoSaldo, archivoHistorialFianzas);

        while (true) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Ver Productos");
            System.out.println("4. Agregar Usuario");
            System.out.println("5. Eliminar Usuario");
            System.out.println("6. Revisar Fianzas");
            System.out.println("7. Generar Reporte");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el nombre del producto: ");
                    String producto = scanner.nextLine();
                    System.out.print("Ingresa la cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    inventario.agregarProducto(producto, cantidad);
                    System.out.println("Producto agregado.");
                    break;
                case 2:
                    System.out.print("Ingresa el nombre del producto a eliminar: ");
                    producto = scanner.nextLine();
                    System.out.print("Ingresa la cantidad a eliminar: ");
                    cantidad = scanner.nextInt();
                    scanner.nextLine();
                    inventario.eliminarProducto(producto, cantidad);
                    System.out.println("Producto eliminado.");
                    break;
                case 3:
                    System.out.println("Productos en el inventario:");
                    for (Producto p : inventario.obtenerProductos()) {
                        System.out.println(p);
                    }
                    break;
                case 4:
                    System.out.print("Ingresa el nombre del nuevo usuario: ");
                    String nuevoUsuario = scanner.nextLine();
                    if (usuarios.containsKey(nuevoUsuario)) {
                        System.out.println("El usuario ya existe.");
                    } else {
                        System.out.print("Ingresa la contraseña para el nuevo usuario: ");
                        String nuevaContrasena = scanner.nextLine();
                        usuarios.put(nuevoUsuario, nuevaContrasena);
                        guardarUsuarios(usuarios, archivoUsuarios);
                        System.out.println("Usuario agregado.");
                    }
                    break;
                case 5:
                    System.out.print("Ingresa el nombre del usuario a eliminar: ");
                    String usuarioAEliminar = scanner.nextLine();
                    if (usuarios.containsKey(usuarioAEliminar)) {
                        usuarios.remove(usuarioAEliminar);
                        guardarUsuarios(usuarios, archivoUsuarios);
                        System.out.println("Usuario eliminado.");
                    } else {
                        System.out.println("El usuario no existe.");
                    }
                    break;
                case 6:
                    manejarFianzas(fianzas, scanner);
                    break;
                case 7:
                    generarReporte(inventario, fianzas);
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    guardarUsuarios(usuarios, archivoUsuarios);
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    public static Map<String, String> cargarUsuarios(String archivo) {
        Map<String, String> usuarios = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    usuarios.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de usuarios.");
        }
        return usuarios;
    }

    public static void guardarUsuarios(Map<String, String> usuarios, String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, String> entry : usuarios.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo de usuarios.");
        }
    }

    private static void manejarFianzas(Fianzas fianzas, Scanner scanner) {
        while (true) {
            System.out.println("\n=== Menú de Fianzas ===");
            System.out.println("1. Ingresar Dinero");
            System.out.println("2. Retirar Dinero");
            System.out.println("3. Ver Historial de Fianzas");
            System.out.println("4. Regresar al Menú Principal");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la cantidad a depositar: ");
                    double ingreso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingresa el motivo del depósito: ");
                    String motivoIngreso = scanner.nextLine();
                    fianzas.ingresarDinero(ingreso, motivoIngreso);
                    break;
                case 2:
                    System.out.print("Ingresa la cantidad a retirar: ");
                    double retiro = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingresa el motivo del retiro: ");
                    String motivoRetiro = scanner.nextLine();
                    fianzas.retirarDinero(retiro, motivoRetiro);
                    break;
                case 3:
                    fianzas.mostrarHistorial();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    public static void generarReporte(Inventario inventario, Fianzas fianzas) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("----- REPORTE DE FINANZAS E INVENTARIO -----\n\n");

        reporte.append("FINANZAS:\n");
        reporte.append("Saldo actual: $" + fianzas.getSaldo() + "\n");
        reporte.append("Total de ingresos: $" + fianzas.getTotalIngresos() + "\n");
        reporte.append("Total de retiros: $" + fianzas.getTotalRetiros() + "\n\n");

        reporte.append("INVENTARIO:\n");
        reporte.append("Productos agregados: " + inventario.getProductosAgregados() + "\n");
        reporte.append("Productos eliminados: " + inventario.getProductosEliminados() + "\n");
        reporte.append("Stock total: " + inventario.getStockTotal() + "\n\n");
        reporte.append("Lista de productos:\n");
        for (Producto producto : inventario.obtenerProductos()) {
            reporte.append("- " + producto.getNombre() + ": " + producto.getCantidad() + " unidades\n");
        }

        System.out.println(reporte);
    }
}
