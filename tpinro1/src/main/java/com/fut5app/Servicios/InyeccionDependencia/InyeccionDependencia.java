package com.fut5app.Servicios.InyeccionDependencia;

import com.fut5app.Servicios.Entrada.Archivo.IServicioEntradaArchivo;
import com.fut5app.Servicios.Entrada.Archivo.impl.ServicioEntradaArchivo;
import com.fut5app.Servicios.Equipo.IServicioEquipo;
import com.fut5app.Servicios.Equipo.impl.ServicioEquipo;
import com.fut5app.Servicios.Jugador.IServicioJugador;
import com.fut5app.Servicios.Jugador.impl.ServicioJugador;
import com.fut5app.Servicios.Salida.IServicioSalida;
import com.fut5app.Servicios.Salida.impl.ServicioSalida;

public class InyeccionDependencia {
   public static IServicioEquipo servicioEquipo;
    public static IServicioEntradaArchivo servicioEntradaArchivo;
    public static IServicioJugador servicioJugador;
    public static  IServicioSalida sercivioSalida;
    public static void inyectarDependencias(){
      servicioEquipo = new ServicioEquipo();
      servicioEntradaArchivo = new ServicioEntradaArchivo();
      servicioJugador = new ServicioJugador();
      sercivioSalida = new ServicioSalida();
    }
}
