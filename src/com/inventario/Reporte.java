package com.inventario;

public class Reporte {

    public void generarReporte(String[] productos) {
        System.out.println("Reporte de Productos:");
        for (String producto : productos) {
            System.out.println("- " + producto);
        }
    }
}
