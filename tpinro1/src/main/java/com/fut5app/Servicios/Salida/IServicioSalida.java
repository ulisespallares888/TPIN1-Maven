package com.fut5app.Servicios.Salida;

import com.fut5app.Dominio.Equipo;

public interface IServicioSalida {
    void exportarJugadoresTxt(Equipo equipo);
    void exportarJugadoresCsv(Equipo equipo);
    void exportarAchivo(Equipo equipo);
}
