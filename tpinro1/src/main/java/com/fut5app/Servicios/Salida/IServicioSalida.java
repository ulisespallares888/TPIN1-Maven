package com.fut5app.Servicios.Salida;

import com.fut5app.Dominio.Equipo;

public interface IServicioSalida {
    void exportarEquipoTxt(Equipo equipo);
    void exportarEquipoCsv(Equipo equipo);
}
