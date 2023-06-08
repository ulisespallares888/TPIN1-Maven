package com.fut5app.Servicios.Jugador.impl;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Dominio.Jugador;
import com.fut5app.Servicios.Entrada.Scanner.impl.ServicioEntrada;
import com.fut5app.Servicios.Equipo.impl.ServicioEquipo;
import com.fut5app.Servicios.Jugador.IServicioJugador;
import com.fut5app.Servicios.Posicion.impl.ServicioPosicion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.fut5app.App.listaEquipos;

public class ServicioJugador implements IServicioJugador {

    public ServicioJugador() {
    }

    @Override
    public Jugador crearJugador(Equipo equipo) {
        Jugador jugadorNuevo = new Jugador();
        jugadorNuevo.setId(UUID.randomUUID());
        jugadorNuevo.setEquipo(equipo);

        System.out.println("****** Cargar un jugador ****** ");
        cargarNombre(jugadorNuevo);
        cargarApellido(jugadorNuevo);
        cargarAltura(jugadorNuevo);
        cargarPosicion(jugadorNuevo);
        cargarCantGoles(jugadorNuevo);
        cargarCantPartidos(jugadorNuevo);
        controlCapitan(equipo,jugadorNuevo);
        controlCamisetas(equipo,jugadorNuevo);
        System.out.println("--------------------------------");
        return jugadorNuevo;
    }


    private void cargarNombre(Jugador jugadorNuevo){
        System.out.println("Ingrese nombre del jugador");
        jugadorNuevo.setNombre(ServicioEntrada.getScanner().nextLine());
    }
    private void cargarApellido(Jugador jugadorNuevo){
        System.out.println("Ingrese apellido del jugador");
        jugadorNuevo.setApellido(ServicioEntrada.getScanner().nextLine());
    }

    private void cargarAltura(Jugador jugadorNuevo){
        System.out.println("Ingrese altura del jugador");
        jugadorNuevo.setAltura(Double.parseDouble(ServicioEntrada.getScanner().nextLine()));
    }

    private void cargarPosicion(Jugador jugadorNuevo){
        System.out.println("Ingrese posición del jugador");
        ServicioPosicion.mostrarPosiciones(ServicioPosicion.formacionEligida);
        jugadorNuevo.setPosicion(ServicioPosicion.crearPosicion(Integer.parseInt(ServicioEntrada.getScanner().nextLine())));
    }

    private void cargarCantGoles(Jugador jugadorNuevo){
        System.out.println("Ingrese cantidad de goles del jugador");
        jugadorNuevo.setCantGoles(Integer.parseInt(ServicioEntrada.getScanner().nextLine()));
    }

    private void cargarCantPartidos(Jugador jugadorNuevo){
        System.out.println("Ingrese cantidad de partidos del jugador");
        jugadorNuevo.setCanttPartidos(Integer.parseInt(ServicioEntrada.getScanner().nextLine()));
    }


    private void controlCamisetas(Equipo equipo, Jugador jugadorNuevo){
        System.out.println("Ingrese numero de camiseta del jugador");
        int numeroCamiseta = Integer.parseInt(ServicioEntrada.getScanner().nextLine());

        boolean mismaCamiseta = false;
        boolean seguir = true;
        while (seguir){
            for (Jugador jugador: equipo.getJugadores()){
                if (numeroCamiseta == jugador.getNroCamiseta()){
                    mismaCamiseta = true;
                }
            }
            if (mismaCamiseta){
                System.out.println("El numero de camiseta ingreado ya esta ocupado elija otro.");
                numeroCamiseta = Integer.parseInt(ServicioEntrada.getScanner().nextLine());
                mismaCamiseta = false;
            }else {
                jugadorNuevo.setNroCamiseta(numeroCamiseta);
                seguir = false;
            }
        }
    }

    private void controlCapitan(Equipo equipo, Jugador jugador){

        boolean isCapitan = false;

        for (Jugador jugador1: equipo.getJugadores()){
            if (jugador1.isCapitan()){
                isCapitan = true;
            }
        }
        if (!isCapitan){
            System.out.println("Ingrese el jugador es capitan. 1: Es capitan 2: No es capitan");
            String opcion= ServicioEntrada.getScanner().nextLine();
            if (opcion.equals("1")){
                jugador.setCapitan(true);
            } else if (opcion.equals("2")) {
                jugador.setCapitan(false);
            }
        }

    }

    private List<Jugador>  buscarJugador(String nombreJugador) {
        List<Jugador> listJug = new ArrayList<>();
        for (Equipo equipos: listaEquipos ) {
            for (Jugador jugador: equipos.getJugadores() ) {
                if(jugador.getNombre().toLowerCase().equals(nombreJugador.toLowerCase()) ) {
                    listJug.add(jugador);
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
                if(jugador.isCapitan()){ System.out.println("Es capitan : Si");
                } else {System.out.println("Es capitan : No");}
                System.out.println("Equipo : " + jugador.getEquipo().getNombre());
                System.out.println("---------------");
            }
        } else {
            System.out.println("No exite el jugador !!!");
        }

    }

    @Override
    public void eliminarJugador() {
        System.out.println("Ingrese nombre del jugador.");
        String jugador = ServicioEntrada.getScanner().nextLine();
        System.out.println("Ingrese nombre del equipo.");
        String equipo = ServicioEntrada.getScanner().nextLine();

        ServicioEquipo servicioEquipo = new ServicioEquipo();
        Equipo equipoBuscado = servicioEquipo.buscarEquipo(equipo);
        List<Jugador> jugadorBuscado = new ArrayList<>();

        if(buscarJugador(jugador).size() > 0) {
            jugadorBuscado.add(buscarJugador(jugador).get(0));

            if (equipoBuscado != null) {
                if (jugadorBuscado.get(0).getEquipo() == equipoBuscado) {
                    equipoBuscado.getJugadores().remove(jugadorBuscado.get(0));
                    equipoBuscado.getJugadores().remove(jugadorBuscado.get(0));

                    System.out.println("El jugador fue eliminado con exito.");
                } else {
                    System.out.println("El jugador " + jugador + " no juega en " + equipo);
                }
            } else {
                System.out.println("No existe el equipo " + equipo);
            }
        } else{
                System.out.println("No existe el jugador " + jugador);
            }
        }
}
