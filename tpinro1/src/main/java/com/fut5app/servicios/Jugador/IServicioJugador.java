package com.fut5app.servicios.Jugador;

import com.fut5app.dominio.Equipo;
import com.fut5app.dominio.Jugador;

import java.util.List;

public interface IServicioJugador {
    Jugador crearJugador(Equipo equipo);
    List<Jugador> buscarJugador(String nombreJugador);
    Jugador eliminarJugador();
    void mostrarJugador(String nombreJug);
}
