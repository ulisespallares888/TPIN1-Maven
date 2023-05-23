package com.fut5app.servicios.Jugador.impl;

import com.fut5app.dominio.Equipo;
import com.fut5app.dominio.Jugador;
import com.fut5app.dominio.Posiciones;
import com.fut5app.servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.servicios.Jugador.IServicioJugador;
import com.fut5app.servicios.Posicion.impl.ServicioPosicion;

import java.util.List;
import java.util.UUID;

import static com.fut5app.App.listaJugadores;

public class ServicioJugador implements IServicioJugador {
    @Override
    public Jugador crearJugador(Equipo equipo) {
        Jugador jugador = new Jugador();
        jugador.setId(UUID.randomUUID());
        jugador.setEquipo(equipo);
        System.out.println("****** Cargar un jugador ****** ");
        System.out.println("Ingrese nombre del jugador");
        jugador.setNombre(ServicioEntrada.getScanner().nextLine());
        System.out.println("Ingrese apellido del jugador");
        jugador.setApellido(ServicioEntrada.getScanner().nextLine());
        System.out.println("Ingrese altura del jugador");
        jugador.setAltura(ServicioEntrada.getScanner().nextDouble());
        System.out.println("Ingrese posición del jugador");
        ServicioPosicion.mostrarPosiciones();
        jugador.setPosicion((Posiciones) ServicioPosicion.crearPosicion(ServicioEntrada.getScanner().nextInt()));
        System.out.println("Ingrese cantidad de goles del jugador");
        jugador.setCantGoles(ServicioEntrada.getScanner().nextInt());
        System.out.println("Ingrese cantidad de partidos del jugador");
        jugador.setCanttPartidos(ServicioEntrada.getScanner().nextInt());
        System.out.println("Ingrese el jugador es capitan. 1: Es capitan 2: No es capitan");
        jugador.setCapitan(opcionesCapitan(ServicioEntrada.getScanner().nextInt()));
        System.out.println("Ingrese numero de camiseta del jugador");
        jugador.setNroCamiseta(ServicioEntrada.getScanner().nextInt());
        ServicioEntrada.getScanner().nextLine();
        System.out.println("--------------------------------");

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
    public void buscarJugador(String nombreJugador, String nombreEquipo) {
        Jugador jugadorAux = new Jugador();
        for (List<Jugador> listaJuga: listaJugadores ) {
            for (Jugador jugador: listaJuga ) {
                if(jugador.getNombre().equals(nombreJugador) && nombreEquipo.equals(jugador.getEquipo().getNombre()))
                    jugadorAux.setNombre(jugador.getNombre());
                    jugadorAux.setApellido(jugador.getApellido());
                    jugadorAux.setPosicion(jugador.getPosicion());
                    jugadorAux.setCapitan(jugador.isCapitan());
                    jugadorAux.setEquipo(jugador.getEquipo());
            }
        }
        mostrarJugador(jugadorAux);
    }
    @Override
    public void mostrarJugador(Jugador jugadorAux){
        System.out.println("Nombre : " + jugadorAux.getNombre());
        System.out.println("Apellido : " + jugadorAux.getApellido());
        System.out.println("Posicion : " + jugadorAux.getPosicion());
        if(jugadorAux.isCapitan()){ System.out.println("Es capitan : Si"); }else {System.out.println("Es capitan : No"); }
        System.out.println("Equipo : " + jugadorAux.getEquipo().getNombre());
    }

    @Override
    public Jugador eliminarJugador() {

        return null;
    }
}
