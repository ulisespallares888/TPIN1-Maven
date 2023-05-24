package com.fut5app.servicios.Salida.impl;

import com.fut5app.dominio.Equipo;
import com.fut5app.dominio.Jugador;
import com.fut5app.servicios.Salida.IServicioSalida;

import java.io.FileWriter;
import java.io.IOException;

public class SercivioSalida implements IServicioSalida {
    @Override
    public void exportarTxt(Equipo equipo) {
        String nombreArchivo = "Jugadores.txt";
        String ruta = "src\\main\\java\\com\\fut5app\\servicios\\Salida\\Archivos\\" + nombreArchivo;

        try {
            FileWriter archivo = new FileWriter(ruta);
            archivo.write("Equipo: " + equipo.getNombre()+ "\n");
            archivo.write("Jugadores: " + "\n");
            for(Jugador jugador: equipo.getJugadores()) {
                archivo.write("*" + jugador.getNombre()+" " + jugador.getApellido()+ "\n");
            }
            archivo.close();

            System.out.println("\nEl archivo .txt se ha exportado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void exportarCsv(Equipo equipo) {
        String nombreArchivo = "Jugadores.csv";
        String ruta = "src\\main\\java\\com\\fut5app\\servicios\\Salida\\Archivos\\" + nombreArchivo;
        try {
            FileWriter archivo = new FileWriter(ruta);
            archivo.write("Equipo: " + equipo.getNombre()+ "\n");
            archivo.write("Jugadores: " + "\n");
            for(Jugador jugador: equipo.getJugadores()) {
                archivo.write("*" + jugador.getNombre()+" " + jugador.getApellido()+ "\n");
            }
            archivo.close();

            System.out.println("El archivo .csv se ha exportado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
