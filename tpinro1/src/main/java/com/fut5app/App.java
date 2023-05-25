package com.fut5app;

import com.fut5app.DatosIniciales.DatosIniciales;
import com.fut5app.Dominio.*;
import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Entrada.impl.ServicioEntradaArchivo;
import com.fut5app.Servicios.Equipo.impl.ServicioEquipo;
import com.fut5app.Servicios.Jugador.impl.ServicioJugador;
import com.fut5app.Servicios.Salida.impl.SercivioSalida;

import java.time.LocalDate;
import java.util.*;

public class App
{
    public static List<List<Jugador>> listaJugadores = DatosIniciales.devolverJugadores();
    public static List<Entrenador> listaEntrenadores = DatosIniciales.listaEntrenadores;
    public static List<Equipo> listaEquipos = DatosIniciales.listaEquipos;

    public static void main( String[] args )
    {
        ServicioEntrada.createScanner();

       // ServicioEquipo servicioEquipo = new ServicioEquipo();
        //System.out.println(servicioEquipo.crearEquipo());



        Entrenador entrenador = new Entrenador(UUID.randomUUID(),"asdasd","asdasd", 33);
        Equipo equipo = new Equipo(UUID.randomUUID(), "equipo", LocalDate.now(),entrenador);
        Jugador jugador = new Jugador(UUID.randomUUID(),"Ulises","pallares",1.66, Posiciones.ARQUERO, 22,10, true, 9,equipo);

        List<Jugador> listajug = new ArrayList<>();
        listajug.add(jugador);
       ServicioJugador servicioJugador = new ServicioJugador();

        equipo.setJugadores(jugador);
        listaEntrenadores.add(entrenador);
        listaEquipos.add(equipo);
        listaJugadores.add(listajug);

        //servicioJugador.mostrarJugador("Ulises");

        SercivioSalida sercivioSalida = new SercivioSalida();
        sercivioSalida.exportarEquipoCsv(listaEquipos.get(0));

        //sercivioSalida.exportarCsv(listaEquipos.get(0));

       // servicioEquipo.eliminarEquipo("Boca");

       // servicioEquipo.mostrarEquipoOrdenadoPorNombre("Boca");
        //servicioEquipo.mostrarEquipoOrdenadoPorPosicionYCamiseta("Boca");


        //listaEquipos.forEach(System.out::println);
        //listaEntrenadores.forEach(System.out::println);
        //listaJugadores.forEach(System.out::println);

        System.out.println("---------------------------------");

        //servicioEquipo.eliminarEquipo("equipo");
/*
        listaEquipos.forEach(System.out::println);
        listaEntrenadores.forEach(System.out::println);
        listaJugadores.forEach(lista -> {
            lista.forEach(elemento -> {
                // Hacer algo con cada elemento
                System.out.println(elemento);
            });
        });
*/
        ServicioEntradaArchivo servicioEntradaArchivo = new  ServicioEntradaArchivo();
        servicioEntradaArchivo.importarJugadores("Jugadores.csv",equipo).forEach(System.out::println);

       // SercivioSalida sercivioSalida = new SercivioSalida();
        //sercivioSalida.exportarEquipoTxt(listaEquipos.get(0));




        ServicioEntrada.closeScanner();

    }
}
