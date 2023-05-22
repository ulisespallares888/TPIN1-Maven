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

    public static void cargarEquipos(){
        cargarEntrenadores();
        listaEquipos.add(new Equipo(UUID.randomUUID(), "Boca", LocalDate.now(), listaJugadores.get(0), listaEntrenadores.get(0)));
        listaEquipos.add(new Equipo(UUID.randomUUID(), "River", LocalDate.now(), listaJugadores.get(1), listaEntrenadores.get(1)));
    }
    public static void cargarEntrenadores(){
        listaEntrenadores.add(new Entrenador(UUID.randomUUID(),"Juan","Soto", 33));
        listaEntrenadores.add(new Entrenador(UUID.randomUUID(),"Jose","Morales", 44));
    }
    public static void cargarJugadores(){
        cargarEquipos();
        List<Jugador> listaJugadoresE1 = new ArrayList<>();
        List<Jugador> listaJugadoresE2 = new ArrayList<>();

        listaJugadoresE1.add(new Jugador(UUID.randomUUID(),"Pablo","Alonso",1.66, Posiciones.ARQUERO, 22,10, true, 9,listaEquipos.get(0)));
        listaJugadoresE2.add(new Jugador(UUID.randomUUID(),"Martin","Palermo",1.66, Posiciones.ARQUERO, 22,10, true, 9,listaEquipos.get(1)));


        listaJugadores.add(listaJugadoresE1);
        listaJugadores.add(listaJugadoresE2);
    }

    public static void agregarEquipo(Equipo equipo){
        listaEquipos.add(equipo);
        listaJugadores.add(equipo.getJugadores());
        listaEntrenadores.add(equipo.getEntrenador());
    }

}
