package com.fut5app.Servicios.Jugador.impl;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Dominio.Jugador;
import com.fut5app.Dominio.Posiciones;
import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Jugador.IServicioJugador;
import com.fut5app.Servicios.Posicion.impl.ServicioPosicion;

import java.util.ArrayList;
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

        ServicioPosicion.mostrarPosiciones(ServicioPosicion.formacionEligida);

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
    public  List<Jugador>  buscarJugador(String nombreJugador) {
        List<Jugador> listJug = new ArrayList<>();
        for (List<Jugador> listaJuga: listaJugadores ) {
            for (Jugador jugador: listaJuga ) {
                if(jugador.getNombre().equals(nombreJugador) ) {
                    Jugador jugadorAux = new Jugador();
                    jugadorAux.setNombre(jugador.getNombre());
                    jugadorAux.setApellido(jugador.getApellido());
                    jugadorAux.setPosicion(jugador.getPosicion());
                    jugadorAux.setCapitan(jugador.isCapitan());
                    jugadorAux.setEquipo(jugador.getEquipo());
                    listJug.add(jugadorAux);
                }
            }
        }

        return listJug;
    }
    @Override
    public void mostrarJugador(String nombreJug){
       List<Jugador> listJug = buscarJugador(nombreJug);
        if(!listJug.isEmpty()){
            for (Jugador jugador: listJug ) {
                System.out.println("Nombre : " + jugador.getNombre());
                System.out.println("Apellido : " + jugador.getApellido());
                System.out.println("Posicion : " + jugador.getPosicion());
                if(jugador.isCapitan()){ System.out.println("Es capitan : Si"); }else {System.out.println("Es capitan : No"); }
                System.out.println("Equipo : " + jugador.getEquipo().getNombre());
                System.out.println("---------------");
            }
        } else {
            System.out.println("No exite el jugador !!!");
        }

    }

    @Override
    public Jugador eliminarJugador() {

        return null;
    }
}
