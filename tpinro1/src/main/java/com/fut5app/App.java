package com.fut5app;

import com.fut5app.DatosIniciales.DatosIniciales;
import com.fut5app.Dominio.*;
import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Menu.ServicioMenu;

import java.time.LocalDate;
import java.util.*;

public class App
{
    public static List<Equipo> listaEquipos = DatosIniciales.devolverEquipos();

    public static void main( String[] args )
    {
        ServicioEntrada.createScanner();

        ServicioMenu.mostrarMenu();

        ServicioEntrada.closeScanner();

    }
}
