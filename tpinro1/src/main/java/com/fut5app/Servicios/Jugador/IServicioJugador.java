package com.fut5app.Servicios.Jugador;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Dominio.Jugador;


public interface IServicioJugador {
    Jugador crearJugador(Equipo equipo);

    void eliminarJugador();
    void mostrarJugador(String nombreJug);
}
