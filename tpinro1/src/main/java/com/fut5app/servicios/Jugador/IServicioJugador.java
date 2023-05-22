package com.fut5app.servicios.Jugador;

import com.fut5app.dominio.Equipo;
import com.fut5app.dominio.Jugador;

public interface IServicioJugador {
    Jugador crearJugador(Equipo equipo);
    Jugador buscarJugador();
    Jugador eliminarJugador();
}
