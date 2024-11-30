package com.inventario;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Fianzas {
    private double saldo;
    private double totalIngresos;
    private double totalRetiros;

    public Fianzas(String archivoSaldo, String archivoHistorialFianzas) {
        saldo = cargarSaldo("saldo.txt");
        totalIngresos = 0;
        totalRetiros = 0;
    }

    public void ingresarDinero(double cantidad, String motivo) {
        saldo += cantidad;
        totalIngresos += cantidad;
        registrarOperacion("Ingreso", cantidad, motivo, LocalDateTime.now());
        guardarSaldo("saldo.txt");
    }

    public void retirarDinero(double cantidad, String motivo) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            totalRetiros += cantidad;
            registrarOperacion("Retiro", cantidad, motivo, LocalDateTime.now());
            guardarSaldo("saldo.txt");
        } else {
            System.out.println("Fondos insuficientes para realizar el retiro.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public double getTotalRetiros() {
        return totalRetiros;
    }

    private double cargarSaldo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine();
            return Double.parseDouble(linea);
        } catch (IOException | NumberFormatException e) {
            return 0.0;
        }
    }

    private void guardarSaldo(String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(String.valueOf(saldo));
        } catch (IOException e) {
            System.out.println("No se pudo guardar el saldo.");
        }
    }

    private void registrarOperacion(String tipo, double cantidad, String motivo, LocalDateTime fecha) {
        String registro = tipo + ": $" + cantidad + " | Motivo: " + motivo + " | Fecha: " + fecha;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("historial_fianzas.txt", true))) {
            bw.write(registro);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("No se pudo registrar la operación.");
        }
    }

	public void mostrarHistorial() {
		
	}
}
