package com.fut5app;

import com.fut5app.DatosIniciales.DatosIniciales;
import com.fut5app.Dominio.*;
import com.fut5app.Servicios.Entrada.IServicioEntradaArchivo;
import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Entrada.impl.ServicioEntradaArchivo;
import com.fut5app.Servicios.Equipo.IServicioEquipo;
import com.fut5app.Servicios.Equipo.impl.ServicioEquipo;
import com.fut5app.Servicios.Jugador.IServicioJugador;
import com.fut5app.Servicios.Jugador.impl.ServicioJugador;
import com.fut5app.Servicios.Menu.IMenu;
import com.fut5app.Servicios.Menu.impl.ServicioMenu;
import com.fut5app.Servicios.Salida.IServicioSalida;
import com.fut5app.Servicios.Salida.impl.ServicioSalida;

import java.util.List;

public class App
{
    public static List<Equipo> listaEquipos = DatosIniciales.devolverEquipos();

    public static void main( String[] args )
    {
        ServicioEntrada.createScanner();

        IServicioEquipo servicioEquipo = new ServicioEquipo();
        IServicioEntradaArchivo servicioEntradaArchivo = new ServicioEntradaArchivo();
        IServicioJugador servicioJugador = new ServicioJugador();
        IServicioSalida sercivioSalida = new ServicioSalida();

        IMenu IServicioMenu = new ServicioMenu((ServicioEquipo) servicioEquipo,
                                                (ServicioEntradaArchivo) servicioEntradaArchivo,
                                                (ServicioJugador) servicioJugador,
                                                (ServicioSalida) sercivioSalida);
        IServicioMenu.mostrarMenu();

        ServicioEntrada.closeScanner();

    }
}
