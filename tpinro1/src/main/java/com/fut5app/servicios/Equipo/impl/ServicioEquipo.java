package com.fut5app.servicios.Equipo.impl;

import com.fut5app.dominio.Equipo;
import com.fut5app.servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.servicios.Entrenador.impl.ServicioEntrenador;
import com.fut5app.servicios.Equipo.IServicioEquipo;
import com.fut5app.servicios.Jugador.impl.ServicioJugador;
import com.fut5app.dominio.Jugador;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.fut5app.App.*;

public class ServicioEquipo implements IServicioEquipo {
    @Override
    public Equipo crearEquipo() {
        Equipo equipoNuevo = new Equipo();
        equipoNuevo.setId(UUID.randomUUID());
        System.out.println("Ingrese nombre del equipo");
        equipoNuevo.setNombre(ServicioEntrada.getScanner().nextLine());
        System.out.println("Ingrese fecha de creacion del equipo. Formato(DD-MM-AAAA)");
        String fecha = ServicioEntrada.getScanner().nextLine();
        //#################################falta feecha de creacion###############################
        equipoNuevo.setFechaDeCreacion(LocalDate.now());

        cargarJugadores(equipoNuevo);
        cargarEntrenador(equipoNuevo);
        setearTodasLasListas(equipoNuevo);
       return equipoNuevo;
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
}
