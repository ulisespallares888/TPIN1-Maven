package com.fut5app.Servicios.Equipo;

import com.fut5app.Dominio.Equipo;

public interface IServicioEquipo {
    Equipo crearEquipo();

    Equipo buscarEquipo(String nombre);
    void eliminarEquipo(String nombre);
    void cargarEntrenador(Equipo equipo);

    void cargarJugadores(Equipo equipo);

    void mostrarEquipoCapitan(String equipo);

    void mostrarEquipoOrdenadoPorNombre(String equipoNombre);

    void mostrarEquipoOrdenadoPorCamiseta(String equipoNombre);
    void mostrarEquipoOrdenadoPorPosicionYCamiseta(String equipoNombre);
}
