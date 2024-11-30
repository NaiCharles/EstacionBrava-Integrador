package com.inventario;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<String, Producto> productos;

    // Constructor
    public Inventario() {
        productos = new HashMap<>();
    }

    // Agregar un producto
    public void agregarProducto(String nombre, int cantidad) {
        if (productos.containsKey(nombre)) {
            // Si el producto ya existe, sumamos la cantidad
            Producto p = productos.get(nombre);
            p.setCantidad(p.getCantidad() + cantidad);
        } else {
            // Si no existe, lo agregamos como nuevo
            productos.put(nombre, new Producto(nombre, cantidad));
        }
    }

    // Eliminar producto (reducir cantidad)
    public void eliminarProducto(String nombre, int cantidad) {
        if (productos.containsKey(nombre)) {
            Producto p = productos.get(nombre);
            int cantidadActual = p.getCantidad();
            if (cantidadActual > cantidad) {
                p.setCantidad(cantidadActual - cantidad);
            } else {
                productos.remove(nombre);  // Eliminar el producto si la cantidad es igual o menor a la que se quiere eliminar
            }
        }
    }

    // Obtener todos los productos en inventario
    public String[] obtenerProductos() {
        String[] productosListados = new String[productos.size()];
        int i = 0;
        for (Producto producto : productos.values()) {
            productosListados[i] = producto.toString();
            i++;
        }
        return productosListados;
    }
}
