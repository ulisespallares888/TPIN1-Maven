package com.fut5app.servicios.Salida;

import com.fut5app.dominio.Equipo;

public interface IServicioSalida {
    void exportarEquipoTxt(Equipo equipo);
    void exportarEquipoCsv(Equipo equipo);
}
