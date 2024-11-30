package com.inventario;

import java.time.LocalDateTime;

public class Producto {
    private String nombre;
    private int cantidad;
    private LocalDateTime fecha;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fecha = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return nombre + ":" + cantidad + ":" + (fecha != null ? fecha.toString() : "null");
    }
}
