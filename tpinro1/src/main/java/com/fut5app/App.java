package com.fut5app;

import com.fut5app.DatosIniciales.DatosIniciales;
import com.fut5app.Dominio.*;
import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Entrada.impl.ServicioEntradaArchivo;
import com.fut5app.Servicios.Equipo.impl.ServicioEquipo;
import com.fut5app.Servicios.Jugador.impl.ServicioJugador;
import com.fut5app.Servicios.Menu.ServicioMenu;
import com.fut5app.Servicios.Salida.impl.SercivioSalida;

import java.time.LocalDate;
import java.util.*;

public class App
{
    public static List<Entrenador> listaEntrenadores = DatosIniciales.listaEntrenadores;
    public static List<Equipo> listaEquipos = DatosIniciales.listaEquipos;

    public static void main( String[] args )
    {
        ServicioEntrada.createScanner();



        Entrenador entrenador = new Entrenador(UUID.randomUUID(),"asdasd","asdasd", 33);
        Equipo equipo = new Equipo(UUID.randomUUID(), "equipo", LocalDate.now(),entrenador);
        Jugador jugador = new Jugador(UUID.randomUUID(),"Ulises","pallares",1.66, Posiciones.ARQUERO, 22,10, true, 9,equipo);

        List<Jugador> listajug = new ArrayList<>();
        listajug.add(jugador);

        equipo.setJugadores(jugador);
        listaEntrenadores.add(entrenador);
        listaEquipos.add(equipo);



        ServicioMenu.mostrarMenu();

        ServicioEntrada.closeScanner();

    }
}
