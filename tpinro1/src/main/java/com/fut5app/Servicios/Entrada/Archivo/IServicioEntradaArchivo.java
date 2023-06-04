package com.fut5app.Servicios.Entrada.Archivo;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Dominio.Jugador;

import java.util.List;

public interface IServicioEntradaArchivo {
    List<Jugador> importarJugadores(String archivoRuta, Equipo equipo);
}
