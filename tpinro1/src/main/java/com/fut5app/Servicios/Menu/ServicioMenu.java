package com.fut5app.Servicios.Menu;

import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Equipo.impl.ServicioEquipo;
import com.fut5app.Servicios.Jugador.impl.ServicioJugador;
import com.fut5app.Servicios.Salida.impl.SercivioSalida;

import java.util.Scanner;

public class ServicioMenu {
    public static void mostrarMenu(){

        String opcion = "";
        while (!opcion.equals("#")){

            System.out.println("1 : Crear Equipo");
            System.out.println("2 : Buscar jugador");
            System.out.println("3 : Buscar equipo");
            System.out.println("4 : Eliminar equipo");
            System.out.println("5 : Exportar equipo");
            System.out.println("Ingrese # para salir ");

            tomarOpcion(ServicioEntrada.getScanner().nextLine());
        }

    }

    private static void tomarOpcion(String opcion) {
        switch (opcion){
            case "1":{
                ServicioEquipo servicioEquipo = new ServicioEquipo();
                System.out.println(servicioEquipo.crearEquipo());
                break;
            }
            case "2":{
                ServicioJugador servicioJugador = new ServicioJugador();
                System.out.println(servicioJugador.buscarJugador("Ulises"));
                break;
            }

        }
    }
}
