package com.inventario;

import java.time.LocalDateTime;

public class Producto {
    private String nombre;
    private int cantidad;
    private LocalDateTime fechaDeIngreso;

    // Constructor
    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaDeIngreso = LocalDateTime.now(); // Fecha y hora actual
    }

    // Getters y Setters
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

    public LocalDateTime getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    @Override
    public String toString() {
        return nombre + " - Cantidad: " + cantidad + " - Ingresado en: " + fechaDeIngreso;
    }
}
