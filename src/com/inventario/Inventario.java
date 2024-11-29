package com.inventario;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<String, Integer> productos;

    public Inventario() {
        productos = new HashMap<>();
    }

    public void agregarProducto(String nombre, int cantidad) {
        productos.put(nombre, cantidad);
    }

    public boolean contieneProducto(String nombre) {
        return productos.containsKey(nombre);
    }

    public int obtenerStock(String nombre) {
        return productos.getOrDefault(nombre, 0);
    }

	public void agregarProducto(String producto) {
		// TODO Auto-generated method stub
		
	}

	public void eliminarProducto(String producto) {
		// TODO Auto-generated method stub
		
	}

	public String[] obtenerProductos() {
		// TODO Auto-generated method stub
		return null;
	}
}
