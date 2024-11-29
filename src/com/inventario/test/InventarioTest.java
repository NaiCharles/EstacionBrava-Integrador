package com.inventario.test;

import com.inventario.Inventario;
import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {

    @Test
    public void testAgregarProducto() {
        Inventario inventario = new Inventario();
        inventario.agregarProducto("Producto A", 10);
        assertTrue(inventario.contieneProducto("Producto A"));
    }

    @Test
    public void testObtenerStock() {
        Inventario inventario = new Inventario();
        inventario.agregarProducto("Producto B", 20);
        assertEquals(20, inventario.obtenerStock("Producto B"));
    }

    @Test
    public void testProductoNoEncontrado() {
        Inventario inventario = new Inventario();
        assertFalse(inventario.contieneProducto("Producto X"));
    }
}
