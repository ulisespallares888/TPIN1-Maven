package com.fut5app.servicios.Equipo.impl;


import com.fut5app.dominio.Equipo;
import com.fut5app.servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.servicios.Entrenador.impl.ServicioEntrenador;
import com.fut5app.servicios.Equipo.IServicioEquipo;
import com.fut5app.servicios.Jugador.impl.ServicioJugador;
import com.fut5app.dominio.Jugador;
import com.fut5app.servicios.Salida.impl.SercivioSalida;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

import static com.fut5app.App.*;

public class ServicioEquipo implements IServicioEquipo {
    @Override
    public Equipo crearEquipo() {
        System.out.println("****** Carga de equipo ****** ");
        Equipo equipoNuevo = new Equipo();
        equipoNuevo.setId(UUID.randomUUID());
        System.out.println("Ingrese nombre del equipo");
        equipoNuevo.setNombre(ServicioEntrada.getScanner().nextLine());
        System.out.println("Ingrese fecha de creacion del equipo. Formato(DD-MM-AAAA)");
        equipoNuevo.setFechaDeCreacion(foramtearFecha(ServicioEntrada.getScanner().nextLine()));
        System.out.println("****** Carga de jugadores ****** ");
        cargarJugadores(equipoNuevo);
        System.out.println("****** Carga de entrenador ****** ");
        cargarEntrenador(equipoNuevo);
        setearTodasLasListas(equipoNuevo);
       return equipoNuevo;
    }

    public LocalDate foramtearFecha(String fecha){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaFormateada = LocalDate.parse(fecha, formatter);

        return fechaFormateada;
    }

    public void setearTodasLasListas(Equipo equipoNuevo){
        listaEquipos.add(equipoNuevo);
        listaJugadores.add(equipoNuevo.getJugadores());
        listaEntrenadores.add(equipoNuevo.getEntrenador());
    }


    @Override
    public Equipo buscarEquipo(String nombre) {
        Equipo equipoEncontrado = new Equipo();
        for (Equipo equipo: listaEquipos ) {
            if(equipo.getNombre().equals(nombre)){
                equipoEncontrado = equipo;
             }
        }
        return equipoEncontrado;
    }

    public void mostrarEquipoCapitan(String equipoNombre){
        Equipo equipo = new Equipo();
        equipo = buscarEquipo(equipoNombre);
        if(equipo.getNombre() != null){
            String capitan ="";
            for (int i=0; i < equipo.getJugadores().size();i++) {
                if(equipo.getJugadores().get(i).isCapitan()){
                    capitan = equipo.getJugadores().get(i).getNombre();
                }
            }
            System.out.println("Equipo : " + equipo.getNombre());
            System.out.println("Entrenador : " + equipo.getEntrenador().getNombre());
            System.out.println("Capitan : " + capitan);
        } else {
            System.out.println("No existe el equipo");
        }
    }


    public void mostrarEquipo(String equipoNombre){
        Equipo equipo = new Equipo();
        equipo = buscarEquipo(equipoNombre);
        if(equipo.getNombre() != null){
            System.out.println("Equipo : " + equipo.getNombre());
            System.out.println("Entrenador : " + equipo.getEntrenador().getNombre());
            System.out.print("Jugadoes: ");
            for (Jugador jugador: equipo.getJugadores() ) {
                System.out.print(jugador.getNombre()+ " ");
            }
        } else {
            System.out.println("No existe el equipo");
        }
    }

    @Override
    public void cargarJugadores(Equipo equipo){
        ServicioJugador servicioJugador = new ServicioJugador();
        for (int i=0; i<2; i++){
           equipo.setJugadores(servicioJugador.crearJugador(equipo));
        }
    }

    @Override
    public void cargarEntrenador(Equipo equipo) {
        ServicioEntrenador servicioEntrenador = new ServicioEntrenador();
        equipo.setEntrenador(servicioEntrenador.crearEntrenador());

    }
    @Override
    public void eliminarEquipo(String nombre) {
      boolean equipoEiminado = listaEquipos.remove(buscarEquipo(nombre));
      if(equipoEiminado){
          System.out.println("Equipo eliminado");
      } else {
          System.out.println("No se encontro el equipo");
      }
    }
    @Override
    public void mostrarEquipoOrdenadoPorNombre(String equipoNombre){
        Equipo equipo = buscarEquipo(equipoNombre);
        if(equipo.getNombre() != null){
            List<Jugador> listaOrdenada = (equipo.getJugadores()
                    .stream()
                    .sorted((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()))
                    .collect(Collectors.toList()));
            System.out.println("Equipo : " + equipo.getNombre());
            System.out.println("Entrenador : " + equipo.getEntrenador().getNombre());
            System.out.print("Jugadores: ");
            for (Jugador jugador: listaOrdenada ) {
                System.out.print(jugador.getNombre()+ " ");
            }
        } else {
            System.out.println("No existe el equipo");
        }
    }

    @Override
    public void mostrarEquipoOrdenadoPorCamiseta(String equipoNombre){
        Equipo equipo = buscarEquipo(equipoNombre);
        if(equipo.getNombre() != null){
            List<Jugador> listaOrdenada = (equipo.getJugadores()
                    .stream()
                    .sorted((p1, p2) -> Integer.compare(p1.getNroCamiseta(),p2.getNroCamiseta()))
                    .collect(Collectors.toList()));
            System.out.println("Equipo : " + equipo.getNombre());
            System.out.println("Entrenador : " + equipo.getEntrenador().getNombre());
            System.out.print("Jugadores: ");
            for (Jugador jugador:listaOrdenada ) {
                System.out.print(jugador.getNombre()+ " ");
            }
        } else {
            System.out.println("No existe el equipo");
        }
    }

    @Override
    public void mostrarEquipoOrdenadoPorPosicionYCamiseta(String equipoNombre){
        Equipo equipo =  buscarEquipo(equipoNombre);

        if(equipo.getNombre() != null){
            List<Jugador> listaOrdenada = equipo.getJugadores();
            listaOrdenada.sort(Comparator.comparing(Jugador::getPosicion).thenComparing(Jugador::getNroCamiseta));
            System.out.println("Equipo : " + equipo.getNombre());
            System.out.println("Entrenador : " + equipo.getEntrenador().getNombre());
            System.out.print("Jugadores: ");
            for (Jugador jugador: listaOrdenada ) {
                System.out.print(jugador.getNombre()+ " ");
            }
        } else {
            System.out.println("No existe el equipo");
        }
    }



}
