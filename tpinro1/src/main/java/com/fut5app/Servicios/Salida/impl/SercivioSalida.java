package com.fut5app.Servicios.Salida.impl;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Dominio.Jugador;
import com.fut5app.Dominio.Posiciones;
import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Salida.IServicioSalida;
import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SercivioSalida implements IServicioSalida {

    @Override
    public void exportarAchivo(Equipo equipo){
        System.out.println("Ingrese una opcion");
        System.out.println("1 : Exportar archivo tipo txt");
        System.out.println("2 : Exportar archivo tipo csv");
        System.out.println("3 : Exportar archivo tipo txt y csv");

        switch (ServicioEntrada.getScanner().nextLine()){
            case "1":{
                exportarJugadoresTxt(equipo);
                break;
            }
            case "2":{
                exportarJugadoresCsv(equipo);
                break;
            }
            case "3":{
                exportarJugadoresTxt(equipo);
                exportarJugadoresCsv(equipo);
                break;
            }
        }

    }


    @Override
    public void exportarJugadoresTxt(Equipo equipo){

        String nombreArchivo = "Jugadores.txt";
        String ruta = "src\\main\\java\\com\\fut5app\\Resources\\ArchivoSalida\\" + nombreArchivo;
        ruta += " " + UUID.randomUUID();
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
            System.out.println("Archivo exportado exitosamente para visualizarlo debe detener el programa");
        }catch (IOException e){
            e.printStackTrace();
        }



    }




    @Override
    public void exportarJugadoresCsv(Equipo equipo){

        String nombreArchivo = "Jugadores.csv";
        String ruta = "src\\main\\java\\com\\fut5app\\Resources\\ArchivoSalida\\" + nombreArchivo;
        ruta += " " + UUID.randomUUID();
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
            System.out.println("Archivo exportado exitosamente para visualizarlo debe detener el programa");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
