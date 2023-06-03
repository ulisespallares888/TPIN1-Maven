package com.fut5app;

import com.fut5app.DatosIniciales.DatosIniciales;
import com.fut5app.Dominio.*;
import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Menu.IMenu;
import com.fut5app.Servicios.Menu.impl.ServicioMenu;

import java.util.List;

public class App
{
    public static List<Equipo> listaEquipos = DatosIniciales.devolverEquipos();

    public static void main( String[] args )
    {
        ServicioEntrada.createScanner();

        IMenu IServicioMenu = new ServicioMenu();
        IServicioMenu.mostrarMenu();

        ServicioEntrada.closeScanner();

    }
}
