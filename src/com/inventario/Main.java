package com.inventario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Ver Productos");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el nombre del producto: ");
                    String producto = scanner.nextLine();
                    inventario.agregarProducto(producto);
                    break;
                case 2:
                    System.out.print("Ingresa el nombre del producto a eliminar: ");
                    producto = scanner.nextLine();
                    inventario.eliminarProducto(producto);
                    break;
                case 3:
                    System.out.println("Productos en el inventario:");
                    for (String p : inventario.obtenerProductos()) {
                        System.out.println("- " + p);
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }
}
