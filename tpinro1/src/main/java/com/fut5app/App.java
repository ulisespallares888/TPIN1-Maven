package com.fut5app;

import com.fut5app.dominio.*;
import com.fut5app.servicios.*;
import com.fut5app.servicios.Entrada.impl.ServicioEntrada;

import java.time.LocalDate;
import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        ServicioEntrada.createScanner();

        Equipo equipo = new Equipo(UUID.randomUUID(), "boca");
        Entrenador entrenador = new Entrenador(UUID.randomUUID(),"nombre","apellido",33);
        Jugador jugador = new Jugador(UUID.randomUUID(),"nombre","apellido", 1.55, Posiciones.ARQUERO,33,4,true,4,equipo);

        equipo.setJugadores(jugador);
        equipo.setEntrenador(entrenador);
        System.out.println(equipo.getNombre());
        System.out.println(equipo.getJugadores().size());
        System.out.println(entrenador.entrenar());
        System.out.println(jugador.getPosicion().entrenar());

        ServicioEntrada.closeScanner();

    }
}
