package com.fut5app.servicios.Jugador.impl;

import com.fut5app.dominio.Jugador;
import com.fut5app.servicios.Jugador.IServicioJugador;

public class ServicioJugador implements IServicioJugador {
    @Override
    public Jugador crearJugador() {
        Jugador jugador = new Jugador();

        return jugador;
    }

    @Override
    public Jugador buscarJugador() {
        return null;
    }

    @Override
    public Jugador eliminarJugador() {
        return null;
    }
}
