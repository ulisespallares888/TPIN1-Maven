package com.fut5app.Servicios.Equipo.impl;


import com.fut5app.Dominio.Equipo;
import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Entrada.impl.ServicioEntradaArchivo;
import com.fut5app.Servicios.Entrenador.impl.ServicioEntrenador;
import com.fut5app.Servicios.Equipo.IServicioEquipo;
import com.fut5app.Servicios.Jugador.impl.ServicioJugador;
import com.fut5app.Dominio.Jugador;
import com.fut5app.Servicios.Posicion.impl.ServicioPosicion;


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

        System.out.println("Tipo de carga");
        System.out.println("1 : Maual 2: Por importacion");
        String opcion = ServicioEntrada.getScanner().nextLine();

        if( opcion.equals("1")){
            ServicioPosicion.mostrarFormaciones();
            ServicioPosicion.elegirFomacion(ServicioEntrada.getScanner().nextInt());
            System.out.println("****** Carga de jugadores ****** ");
            ServicioEntrada.getScanner().nextLine();
            cargarJugadores(equipoNuevo);
        } else{
            System.out.println("El formato del archvo debe ser nombre, apellido, ");
            ServicioEntradaArchivo servicioEntradaArchivo = new ServicioEntradaArchivo();
            equipoNuevo.setJugadores(servicioEntradaArchivo.importarJugadores(ServicioEntrada.getScanner().nextLine(),equipoNuevo));
            equipoNuevo.getJugadores().forEach(System.out::println);
            ServicioEntrada.createScanner();
        }


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
        for (int i=0; i<5; i++){
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
        listaJugadores.remove(buscarEquipo(nombre).getJugadores());
        listaEntrenadores.remove(buscarEquipo(nombre).getEntrenador());
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
