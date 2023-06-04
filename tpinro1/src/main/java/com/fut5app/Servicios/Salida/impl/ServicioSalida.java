package com.fut5app.Servicios.Salida.impl;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Dominio.Jugador;
import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Salida.IServicioSalida;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class ServicioSalida implements IServicioSalida {

    @Override
    public void exportarAchivo(Equipo equipo){
        System.out.println("Ingrese una opcion");
        System.out.println("1 : Exportar archivo tipo txt");
        System.out.println("2 : Exportar archivo tipo csv");
        System.out.println("3 : Exportar archivo tipo txt y csv");

        switch (ServicioEntrada.getScanner().nextLine()){
            case "1":{
                exportarJugadores(equipo,"txt");
                break;
            }
            case "2":{
                exportarJugadores(equipo,"csv");
                break;
            }
            case "3":{
                exportarJugadores(equipo,"txt");
                exportarJugadores(equipo,"csv");
                break;
            }
        }

    }



    private void exportarJugadores(Equipo equipo, String modo){
        String nombreArchivo = "";
        if (modo.equals("txt")) {
             nombreArchivo = equipo.getNombre() + ".txt";
        } else if (modo.equals("csv")) {
             nombreArchivo = equipo.getNombre() + ".csv";
        }

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
            System.out.println("Archivo " + modo + " exportado exitosamente.");
            System.out.println("[Nota] : Para visualizarlo debe detener el programa");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
