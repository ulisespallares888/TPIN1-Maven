package com.fut5app.servicios.Entrada.impl;

import com.fut5app.servicios.Entrada.IServicioEntrada;

import java.util.Scanner;

public class ServicioEntradaArchivo implements IServicioEntrada {
    public static void createScanner() {
        System.out.println("Creando escaner para archivo");
    }

    public Scanner getScanner() {
        return null;
    }

    public void closeScanner() {
        System.out.println("Cerrando escaner para archivo");

    }
}
