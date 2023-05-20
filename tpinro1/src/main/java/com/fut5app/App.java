package com.fut5app;

import com.fut5app.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class App
{
    public static void main( String[] args )
    {

        Equipo equipo = new Equipo();
        Entrenador entrenador = new Entrenador(UUID.randomUUID(),"nombre","apellido",33);
        Jugador jugador = new Jugador(UUID.randomUUID(),"nombre","apellido", 1.55, Posiciones.ARQUERO,33,4,true,4,equipo);

        equipo.setJugadores(jugador);
        equipo.setJugadores(jugador);
        equipo.setNombre("equipo name");
        System.out.println(equipo);
        System.out.println(entrenador);
        System.out.println(jugador);
    }
}
