package com.inventario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Ver Productos");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            
            // Manejo de excepciones en caso de que se ingrese un dato incorrecto
            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de línea pendiente
            } catch (Exception e) {
                System.out.println("Por favor ingresa una opción válida.");
                scanner.nextLine();  // Consumir el salto de línea en caso de error
                continue; 
                }

  switch (opcion) {
                case 1:
                    // Agregar producto
                    System.out.print("Ingresa el nombre del producto: ");
                    String producto = scanner.nextLine();
                    System.out.print("Ingresa la cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea pendiente
                    inventario.agregarProducto(producto, cantidad);
         System.out.println("Producto agregado.");
                    break;
                case 2:
                    // Eliminar producto
                    System.out.print("Ingresa el nombre del producto a eliminar: ");
                    producto = scanner.nextLine();
                    System.out.print("Ingresa la cantidad a eliminar: ");
                    cantidad = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea pendiente
                    inventario.eliminarProducto(producto, cantidad);
                    System.out.println("Producto eliminado.");
                    break;
                case 3:
                    // Ver productos
                    System.out.println("Productos en el inventario:");
                    for (String p : inventario.obtenerProductos()) {
                        System.out.println(p);
                    }
                    break;
                case 4:
                    // Salir
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }
}
