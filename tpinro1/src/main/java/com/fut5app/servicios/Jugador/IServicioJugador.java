package com.fut5app.servicios.Jugador;

import com.fut5app.dominio.Equipo;
import com.fut5app.dominio.Jugador;

public interface IServicioJugador {
    Jugador crearJugador(Equipo equipo);
    void buscarJugador(String nombreJugador, String nombreEquipo);
    Jugador eliminarJugador();
    void mostrarJugador(Jugador jugadorAux);
}
