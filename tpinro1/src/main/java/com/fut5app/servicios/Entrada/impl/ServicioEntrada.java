package com.fut5app.servicios.Entrada.impl;

import com.fut5app.servicios.Entrada.IServicioEntrada;

import java.util.Scanner;

public class ServicioEntrada implements IServicioEntrada{
    public static Scanner scanner;

    public static void createScanner(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
    }

    public static Scanner getScanner(){
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static void closeScanner(){
        if(scanner != null){
            scanner.close();
        }
    }
}
