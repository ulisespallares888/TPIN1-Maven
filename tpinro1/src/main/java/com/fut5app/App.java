package com.fut5app;

import com.fut5app.DatosIniciales.DatosIniciales;
import com.fut5app.dominio.*;
import com.fut5app.servicios.*;
import com.fut5app.servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.servicios.Equipo.impl.ServicioEquipo;

import java.time.LocalDate;
import java.util.*;

public class App
{
    public static List<List<Jugador>> listaJugadores = DatosIniciales.listaJugadores;
    public static List<Entrenador> listaEntrenadores = DatosIniciales.listaEntrenadores;
    public static List<Equipo> listaEquipos = DatosIniciales.listaEquipos;

    public static void main( String[] args )
    {
        ServicioEntrada.createScanner();

        ServicioEquipo servicioEquipo = new ServicioEquipo();
        System.out.println(servicioEquipo.crearEquipo().toString());



        ServicioEntrada.closeScanner();

    }
}
