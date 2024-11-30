package com.inventario;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BooleanSupplier;

public class Inventario {
    private Map<String, Producto> productos;
    private int productosAgregados;
    private int productosEliminados;

    public Inventario() {
        productos = cargarProductos("productos.txt");
        productosAgregados = 0;
        productosEliminados = 0;
    }

    public void agregarProducto(String nombre, int cantidad) {
        if (productos.containsKey(nombre)) {
            Producto producto = productos.get(nombre);
            producto.setCantidad(producto.getCantidad() + cantidad);
            producto.setFecha(LocalDateTime.now());
        } else {
            Producto nuevoProducto = new Producto(nombre, cantidad);
            nuevoProducto.setFecha(LocalDateTime.now());
            productos.put(nombre, nuevoProducto);
        }
        guardarProductos("productos.txt");
    }

    public void eliminarProducto(String nombre, int cantidad) {
        if (productos.containsKey(nombre)) {
            Producto producto = productos.get(nombre);
            int cantidadActual = producto.getCantidad();
            if (cantidadActual >= cantidad) {
                producto.setCantidad(cantidadActual - cantidad);
                productosEliminados += cantidad;
                if (producto.getCantidad() == 0) {
                    productos.remove(nombre);
                }
                guardarProductos("productos.txt");
            } else {
                System.out.println("No hay suficiente cantidad de ese producto para eliminar.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public int getProductosAgregados() {
        return productosAgregados;
    }

    public int getProductosEliminados() {
        return productosEliminados;
    }

    public int getStockTotal() {
        return productos.values().stream().mapToInt(Producto::getCantidad).sum();
    }

    public Collection<Producto> obtenerProductos() {
        System.out.println("Obteniendo productos...");
        for (Producto p : productos.values()) {
            System.out.println(p);
        }
        return productos.values();
    }

    private Map<String, Producto> cargarProductos(String archivo) {
        Map<String, Producto> productos = new HashMap<>();
        File archivoProductos = new File(archivo);

        if (!archivoProductos.exists()) {
            System.out.println("Archivo no encontrado, creando uno nuevo.");
            return productos;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(":");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    int cantidad = Integer.parseInt(partes[1]);
                    try {
                        LocalDateTime fecha = LocalDateTime.parse(partes[2], formatter);
                        Producto producto = new Producto(nombre, cantidad);
                        producto.setFecha(fecha);
                        productos.put(nombre, producto);
                    } catch (Exception e) {
                        System.out.println("Error al parsear la fecha para el producto: " + partes[0] + ", asignando fecha actual.");
                        Producto producto = new Producto(partes[0], cantidad);
                        producto.setFecha(LocalDateTime.now());
                        productos.put(nombre, producto);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de productos: " + e.getMessage());
        }

        return productos;
    }

    private void guardarProductos(String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Producto producto : productos.values()) {
                String fecha = (producto.getFecha() != null) ? producto.getFecha().toString() : "null";
                bw.write(producto.getNombre() + ":" + producto.getCantidad() + ":" + fecha);
                bw.newLine();
            }
            System.out.println("Productos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo de productos: " + e.getMessage());
        }
    }

	public BooleanSupplier contieneProducto(String string) {
		return null;
	}

	public Integer obtenerStock(String string) {
		return null;
	}
}

