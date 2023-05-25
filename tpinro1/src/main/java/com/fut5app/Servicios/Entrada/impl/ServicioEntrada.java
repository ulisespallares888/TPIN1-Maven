package com.fut5app.Servicios.Entrada.impl;

import com.fut5app.Servicios.Entrada.IServicioEntrada;

import java.io.File;
import java.io.FileNotFoundException;
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

    public static Scanner setScannerDeArchivo(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            scanner = new Scanner(archivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scanner;
    }

    public static void closeScanner(){
        if(scanner != null){
            scanner.close();
        }
    }


}
