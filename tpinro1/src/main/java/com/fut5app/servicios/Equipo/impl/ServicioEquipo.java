package com.fut5app.servicios.Equipo.impl;

import com.fut5app.DatosIniciales.DatosIniciales;
import com.fut5app.dominio.Entrenador;
import com.fut5app.dominio.Equipo;
import com.fut5app.dominio.Jugador;
import com.fut5app.servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.servicios.Entrenador.impl.ServicioEntrenador;
import com.fut5app.servicios.Equipo.IServicioEquipo;
import com.fut5app.servicios.Jugador.impl.ServicioJugador;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class ServicioEquipo implements IServicioEquipo {
    @Override
    public Equipo crearEquipo() {
       Equipo equipoNuevo = new Equipo();
       equipoNuevo.setId(UUID.randomUUID());
       equipoNuevo.setFechaDeCreacion(LocalDate.now());
        System.out.println("Ingrese nombre del equipo");
       // falta feecha de creacion
       equipoNuevo.setNombre(ServicioEntrada.getScanner().nextLine());
       cargarJugadores(equipoNuevo);
       cargarEntrenador(equipoNuevo);


        DatosIniciales.agregarEquipo(equipoNuevo);

       return equipoNuevo;
    }

    @Override
    public Equipo buscarEquipo(String nombre) {
        return null;
    }

    @Override
    public void cargarJugadores(Equipo equipo){
        ServicioJugador servicioJugador = new ServicioJugador();
        for (int i=0; i<1; i++){
           equipo.setJugadores(servicioJugador.crearJugador(equipo));
        }
    }

    @Override
    public Equipo eliminarEquipo(String nombre) {
        return null;
    }

    @Override
    public void cargarEntrenador(Equipo equipo) {
        ServicioEntrenador servicioEntrenador = new ServicioEntrenador();
        equipo.setEntrenador(servicioEntrenador.crearEntrenador());

    }
}
