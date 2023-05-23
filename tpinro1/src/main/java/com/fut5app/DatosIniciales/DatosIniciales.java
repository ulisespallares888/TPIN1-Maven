package com.fut5app.DatosIniciales;

import com.fut5app.dominio.Entrenador;
import com.fut5app.dominio.Equipo;
import com.fut5app.dominio.Jugador;
import com.fut5app.dominio.Posiciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.UUID;

public class DatosIniciales {
    public static List<List<Jugador>> listaJugadores = new ArrayList<>();
    public static List<Entrenador> listaEntrenadores = new ArrayList<>();
    public static List<Equipo> listaEquipos = new  ArrayList<>();

    public static  List<Equipo> devolverEquipos(){
        //devolverEntrenadores();
        cargarEquipo();
        return listaEquipos;
    }

    public static  void cargarEquipo(){
        listaEquipos.add(new Equipo(UUID.randomUUID(), "Boca", LocalDate.now(),listaEntrenadores.get(0)));
        listaEquipos.add(new Equipo(UUID.randomUUID(), "River", LocalDate.now(), listaEntrenadores.get(1)));
    }


    public static void cargarEntrenadores(){
        listaEntrenadores.add(new Entrenador(UUID.randomUUID(),"Juan","Soto", 33));
        listaEntrenadores.add(new Entrenador(UUID.randomUUID(),"Jose","Morales", 44));
    }

    public static  List<List<Jugador>> devolverJugadores(){
        cargarJugadores();
        return listaJugadores;
    }

    public static void cargarJugadores(){
        cargarEntrenadores();
        cargarEquipo();
        List<Jugador> listaJugadoresE1 = new ArrayList<>();
        List<Jugador> listaJugadoresE2 = new ArrayList<>();

        listaJugadoresE1.add(new Jugador(UUID.randomUUID(),"Pablo","Alonso",1.66, Posiciones.ARQUERO, 22,10, true, 9,listaEquipos.get(0)));
        listaJugadoresE2.add(new Jugador(UUID.randomUUID(),"Martin","Palermo",1.66, Posiciones.DEFENSOR, 22,10, true, 9,listaEquipos.get(1)));

        setearEquiposConJugadores(listaJugadoresE1,listaJugadoresE2);
        cargarListaJugadores(listaJugadoresE1, listaJugadoresE2);

    }

    public static void setearEquiposConJugadores(List<Jugador> listaJugadoresE1,List<Jugador> listaJugadoresE2){
        listaEquipos.get(0).setJugadores(listaJugadoresE1);
        listaEquipos.get(1).setJugadores(listaJugadoresE2);
    }

    public static void cargarListaJugadores(List<Jugador> listaJugadoresE1,List<Jugador> listaJugadoresE2){
        listaJugadores.add(listaJugadoresE1);
        listaJugadores.add(listaJugadoresE2);
    }



}
