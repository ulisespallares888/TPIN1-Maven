package com.fut5app.Servicios.Salida.impl;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Dominio.Jugador;
import com.fut5app.Dominio.Posiciones;
import com.fut5app.Servicios.Salida.IServicioSalida;
import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SercivioSalida implements IServicioSalida {
    @Override
    public void exportarEquipoTxt(Equipo equipo) {
        String nombreArchivo = "Jugadores.txt";
        String ruta = "src\\main\\java\\com\\fut5app\\Resources\\ArchivoSalida\\" + nombreArchivo;

        try {
            FileWriter archivo = new FileWriter(ruta);

            for(Jugador jugador: equipo.getJugadores()) {
                archivo.write(
                        jugador.getNombre() + "," +
                        jugador.getApellido() + "," +
                        jugador.getAltura() + "," +
                        jugador.getPosicion()+ "," +
                        jugador.getCantGoles()  + "," +
                        jugador.getCanttPartidos() + "," +
                        jugador.isCapitan()  + "," +
                        jugador.getNroCamiseta());
                archivo.write("\n");
            }
            archivo.close();

            System.out.println("\nEl archivo .txt se ha exportado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void exportarEquipoCsv(Equipo equipo) {
        String nombreArchivo = "Jugadores.csv";
        String ruta = "src\\main\\java\\com\\fut5app\\Resources\\ArchivoSalida\\" + nombreArchivo;
        try {
            FileWriter archivo = new FileWriter(ruta);
            for(Jugador jugador: equipo.getJugadores()) {
                archivo.write(
                        jugador.getNombre() + "," +
                                jugador.getApellido() + "," +
                                jugador.getAltura() + "," +
                                jugador.getPosicion()+ "," +
                                jugador.getCantGoles()  + "," +
                                jugador.getCanttPartidos() + "," +
                                jugador.isCapitan()  + "," +
                                jugador.getNroCamiseta());
                archivo.write("\n");
            }
            archivo.close();

            System.out.println("El archivo .csv se ha exportado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportarJugadoresTxt(Equipo equipo){

        String nombreArchivo = "Jugadores.txt";
        String ruta = "src\\main\\java\\com\\fut5app\\Resources\\ArchivoSalida\\" + nombreArchivo;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))){

            for (Jugador jugador: equipo.getJugadores()) {

                String linea = jugador.getNombre() + "," +
                        jugador.getApellido() + "," +
                        jugador.getAltura() + "," +
                        jugador.getPosicion()+ "," +
                        jugador.getCantGoles()  + "," +
                        jugador.getCanttPartidos() + "," +
                        jugador.isCapitan()  + "," +
                        jugador.getNroCamiseta();

                writer.write(linea);
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
