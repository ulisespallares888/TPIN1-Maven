package com.fut5app.Servicios.Entrada;

import java.util.Scanner;

public interface IServicioEntrada {
    static void createScanner(){};
    static Scanner getScanner(){
        return null;
    };

    static Scanner setScannerDeArchivo(String rutaArchivo){
        return null;
    }

    static void closeScanner(){};


}