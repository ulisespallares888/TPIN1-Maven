package com.fut5app.DatosIniciales;

import com.fut5app.Dominio.Entrenador;
import com.fut5app.Dominio.Equipo;
import com.fut5app.Dominio.Jugador;
import com.fut5app.Dominio.Posiciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatosIniciales {
    public static List<List<Jugador>> listaJugadores = new ArrayList<>();
    public static List<Entrenador> listaEntrenadores = new ArrayList<>();
    public static List<Equipo> listaEquipos = new  ArrayList<>();

    public static  List<Equipo> devolverEquipos(){
        cargarEquipo();
        return listaEquipos;
    }

    private static  void cargarEquipo(){
        cargarEntrenadores();
        listaEquipos.add(new Equipo(UUID.randomUUID(), "Boca", LocalDate.now(),listaEntrenadores.get(0)));
        listaEquipos.add(new Equipo(UUID.randomUUID(), "River", LocalDate.now(), listaEntrenadores.get(1)));
        cargarJugadores();
    }


    private static void cargarEntrenadores(){
        listaEntrenadores.add(new Entrenador(UUID.randomUUID(),"Juan","Soto", 33));
        listaEntrenadores.add(new Entrenador(UUID.randomUUID(),"Jose","Morales", 44));
    }


    private static void cargarJugadores(){
        cargarEntrenadores();
        List<Jugador> listaJugadoresE1 = new ArrayList<>();
        List<Jugador> listaJugadoresE2 = new ArrayList<>();

        listaJugadoresE1.add(new Jugador(UUID.randomUUID(),"Pablo","Alonso",1.66, Posiciones.ARQUERO, 22,10, false, 1,listaEquipos.get(0)));
        listaJugadoresE1.add(new Jugador(UUID.randomUUID(),"Martin","Palermo",1.66, Posiciones.DEFENSOR, 22,10, false, 12,listaEquipos.get(0)));
        listaJugadoresE1.add(new Jugador(UUID.randomUUID(), "Andrés", "López", 1.82, Posiciones.DEFENSOR, 23, 8, false, 14, listaEquipos.get(0)));
        listaJugadoresE1.add(new Jugador(UUID.randomUUID(), "Diego", "Martínez", 1.79, Posiciones.MEDIOCAMPISTA, 26, 9, true, 7, listaEquipos.get(0)));
        listaJugadoresE1.add(new Jugador(UUID.randomUUID(), "Elias", "Martínez", 1.79, Posiciones.DELANTERO, 26, 9, false, 10, listaEquipos.get(0)));

        listaJugadoresE2.add(new Jugador(UUID.randomUUID(), "Alejandro", "Gómez", 1.75, Posiciones.ARQUERO, 24, 6, true, 1, listaEquipos.get(1)));
        listaJugadoresE2.add(new Jugador(UUID.randomUUID(), "Lucas", "Fernández", 1.82, Posiciones.DEFENSOR, 25, 5, false, 14, listaEquipos.get(1)));
        listaJugadoresE2.add(new Jugador(UUID.randomUUID(), "Sergio", "Vargas", 1.79, Posiciones.MEDIOCAMPISTA, 27, 10, false, 8, listaEquipos.get(1)));
        listaJugadoresE2.add(new Jugador(UUID.randomUUID(), "Ulises", "López", 1.76, Posiciones.MEDIOCAMPISTA, 22, 7, false, 9, listaEquipos.get(1)));
        listaJugadoresE2.add(new Jugador(UUID.randomUUID(), "Ulises", "Pallarés", 1.76, Posiciones.DELANTERO, 22, 7, false, 10, listaEquipos.get(1)));

        setearEquiposConJugadores(listaJugadoresE1,listaJugadoresE2);
        cargarListaJugadores(listaJugadoresE1, listaJugadoresE2);

    }

    private static void setearEquiposConJugadores(List<Jugador> listaJugadoresE1,List<Jugador> listaJugadoresE2){

        listaEquipos.get(0).setJugadores(listaJugadoresE1);
        listaEquipos.get(1).setJugadores(listaJugadoresE2);
    }

    private static void cargarListaJugadores(List<Jugador> listaJugadoresE1,List<Jugador> listaJugadoresE2){
        listaJugadores.add(listaJugadoresE1);
        listaJugadores.add(listaJugadoresE2);
    }



}
