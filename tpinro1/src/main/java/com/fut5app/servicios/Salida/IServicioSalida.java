package com.fut5app.servicios.Salida;

import com.fut5app.dominio.Equipo;

public interface IServicioSalida {
    void exportarTxt(Equipo equipo);
    void exportarCsv(Equipo equipo);
}
