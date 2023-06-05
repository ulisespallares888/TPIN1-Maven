package com.fut5app;

import com.fut5app.DatosIniciales.DatosIniciales;
import com.fut5app.Dominio.*;
import com.fut5app.Servicios.Entrada.Archivo.IServicioEntradaArchivo;
import com.fut5app.Servicios.Entrada.Archivo.impl.ServicioEntradaArchivo;
import com.fut5app.Servicios.Entrada.Scanner.impl.ServicioEntrada;
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

        IServicioEquipo servicioEquipo =   new ServicioEquipo();
        IServicioJugador servicioJugador= new ServicioJugador();
        IServicioSalida servicioSalida= new ServicioSalida();


        IMenu IServicioMenu = new ServicioMenu(servicioEquipo, servicioJugador, servicioSalida);
        IServicioMenu.mostrarMenu();

        ServicioEntrada.closeScanner();

    }
}
