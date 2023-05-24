package com.fut5app;

import com.fut5app.DatosIniciales.DatosIniciales;
import com.fut5app.dominio.*;
import com.fut5app.servicios.*;
import com.fut5app.servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.servicios.Equipo.impl.ServicioEquipo;
import com.fut5app.servicios.Jugador.impl.ServicioJugador;
import com.fut5app.servicios.Posicion.impl.ServicioPosicion;
import com.fut5app.servicios.Salida.impl.SercivioSalida;

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

        ServicioEquipo servicioEquipo = new ServicioEquipo();
        //System.out.println(servicioEquipo.crearEquipo());



        Entrenador entrenador = new Entrenador(UUID.randomUUID(),"asdasd","asdasd", 33);
        Equipo equipo = new Equipo(UUID.randomUUID(), "equipo1", LocalDate.now(),entrenador);
        Jugador jugador = new Jugador(UUID.randomUUID(),"Ulises","pallares",1.66, Posiciones.ARQUERO, 22,10, true, 9,equipo);

       ServicioJugador servicioJugador = new ServicioJugador();

        equipo.setJugadores(jugador);
        listaEntrenadores.add(entrenador);
        listaEquipos.add(equipo);
        listaJugadores.get(0).add(jugador);

        //servicioJugador.mostrarJugador("Ulises");

        //SercivioSalida sercivioSalida = new SercivioSalida();
        //sercivioSalida.exportarTxt(listaEquipos.get(0));
        //sercivioSalida.exportarCsv(listaEquipos.get(0));

       // servicioEquipo.eliminarEquipo("Boca");

       // servicioEquipo.mostrarEquipoOrdenadoPorNombre("Boca");
        servicioEquipo.mostrarEquipoOrdenadoPorPosicionYCamiseta("Boca");
        /*

        listaEntrenadores.forEach(System.out::println);
        listaJugadores.forEach(lista -> {
            lista.forEach(elemento -> {
                // Hacer algo con cada elemento
                System.out.println(elemento);
            });
        });
        */




        ServicioEntrada.closeScanner();

    }
}
