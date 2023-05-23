package com.fut5app;

import com.fut5app.DatosIniciales.DatosIniciales;
import com.fut5app.dominio.*;
import com.fut5app.servicios.*;
import com.fut5app.servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.servicios.Equipo.impl.ServicioEquipo;
import com.fut5app.servicios.Posicion.impl.ServicioPosicion;

import java.time.LocalDate;
import java.util.*;

public class App
{
    /*
    * Arreglar los de la carga de todas las listas
    */
    public static List<List<Jugador>> listaJugadores = DatosIniciales.devolverJugadores();
    public static List<Entrenador> listaEntrenadores = DatosIniciales.listaEntrenadores;
    public static List<Equipo> listaEquipos = DatosIniciales.listaEquipos;

    public static void main( String[] args )
    {

        ServicioEntrada.createScanner();

        ServicioEquipo servicioEquipo = new ServicioEquipo();
        servicioEquipo.crearEquipo();

       // System.out.println(ServicioPosicion.crearPosicion(1));

        listaEquipos.forEach(System.out::println);
        listaEntrenadores.forEach(System.out::println);
        listaJugadores.forEach(lista -> {
            lista.forEach(elemento -> {
                // Hacer algo con cada elemento
                System.out.println(elemento);
            });
        });


        ServicioEntrada.closeScanner();

    }
}
