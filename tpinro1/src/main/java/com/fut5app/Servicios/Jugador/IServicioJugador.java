package com.fut5app.Servicios.Jugador;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Dominio.Jugador;

import java.util.List;

public interface IServicioJugador {
    Jugador crearJugador(Equipo equipo);
    List<Jugador> buscarJugador(String nombreJugador);
    void eliminarJugador();
    void mostrarJugador(String nombreJug);
}
