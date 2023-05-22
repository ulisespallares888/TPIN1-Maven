package com.fut5app.servicios.Jugador.impl;

import com.fut5app.dominio.Equipo;
import com.fut5app.dominio.Jugador;
import com.fut5app.servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.servicios.Equipo.impl.ServicioEquipo;
import com.fut5app.servicios.Jugador.IServicioJugador;
import com.fut5app.servicios.Posicion.IServicioPosicion;
import com.fut5app.servicios.Posicion.impl.ServicioPosicion;

import java.util.UUID;

public class ServicioJugador implements IServicioJugador {
    @Override
    public Jugador crearJugador(Equipo equipo) {
        Jugador jugador = new Jugador();
        jugador.setId(UUID.randomUUID());
        jugador.setEquipo(equipo);
        System.out.println("Ingrese nombre del jugador");
        jugador.setNombre(ServicioEntrada.getScanner().nextLine());
        System.out.println("Ingrese apellido del jugador");
        jugador.setApellido(ServicioEntrada.getScanner().nextLine());
        System.out.println("Ingrese altura del jugador");
        jugador.setAltura(ServicioEntrada.getScanner().nextDouble());
        System.out.println("Ingrese posición del jugador");
        ServicioPosicion.mostrarPosiciones();
        jugador.setPosicion(ServicioPosicion.crearPosicion(ServicioEntrada.getScanner().nextInt()));
        System.out.println("Ingrese cantidad de goles del jugador");
        jugador.setCantGoles(ServicioEntrada.getScanner().nextInt());
        System.out.println("Ingrese cantidad de partidos del jugador");
        jugador.setCanttPartidos(ServicioEntrada.getScanner().nextInt());
        System.out.println("Ingrese el jugador es capitan. 1: Es capitan 2: No es capitan");
        jugador.setCapitan(opcionesCapitan(ServicioEntrada.getScanner().nextInt()));
        System.out.println("Ingrese numero de camista del jugador");
        jugador.setNroCamiseta(ServicioEntrada.getScanner().nextInt());

        return jugador;
    }

    public boolean opcionesCapitan(int opcion){
        if (opcion==1){
            return true;
        } else if (opcion==2) {
            return  false;
        }
        return false;
    }


    @Override
    public Jugador buscarJugador() {
        return null;
    }

    @Override
    public Jugador eliminarJugador() {
        return null;
    }
}
