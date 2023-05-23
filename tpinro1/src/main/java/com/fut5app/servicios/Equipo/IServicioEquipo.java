package com.fut5app.servicios.Equipo;

import com.fut5app.dominio.Equipo;

public interface IServicioEquipo {
    Equipo crearEquipo();

    Equipo buscarEquipo(String nombre);
    void eliminarEquipo(String nombre);
    void cargarEntrenador(Equipo equipo);

    void cargarJugadores(Equipo equipo);

    void mostrarEquipoCapitan(String equipo);
}
