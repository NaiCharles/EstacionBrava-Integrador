package com.inventario.test;

import com.inventario.Inventario;
import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {

    @Test
    public void testAgregarProducto() {
        Inventario inventario = new Inventario();
        inventario.agregarProducto("Producto A", 10);
        assertTrue(inventario.obtenerProductos().length > 0);
    }

    @Test
    public void testEliminarProducto() {
        Inventario inventario = new Inventario();
        inventario.agregarProducto("Producto B", 20);
        inventario.eliminarProducto("Producto B", 10);
        assertEquals("Producto B - Cantidad: 10 - Ingresado en: ", inventario.obtenerProductos()[0].substring(0, 38));  // Verificamos la cantidad
    }

    @Test
    public void testProductoNoEncontrado() {
        Inventario inventario = new Inventario();
        assertEquals(0, inventario.obtenerProductos().length);
    }
}
