package com.fut5app.Servicios.Equipo.impl;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Entrada.impl.ServicioEntradaArchivo;
import com.fut5app.Servicios.Entrenador.impl.ServicioEntrenador;
import com.fut5app.Servicios.Equipo.IServicioEquipo;
import com.fut5app.Servicios.Jugador.impl.ServicioJugador;
import com.fut5app.Dominio.Jugador;
import com.fut5app.Servicios.Posicion.impl.ServicioPosicion;
import com.fut5app.Servicios.Salida.impl.SercivioSalida;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;


import static com.fut5app.App.listaEquipos;
public class ServicioEquipo implements IServicioEquipo {
    @Override
    public void crearEquipo() {
        System.out.println("****** Carga de equipo ****** ");
        Equipo equipoNuevo = new Equipo();
        equipoNuevo.setId(UUID.randomUUID());
        System.out.println("Ingrese nombre del equipo");
        equipoNuevo.setNombre(ServicioEntrada.getScanner().nextLine());
        System.out.println("Ingrese fecha de creacion del equipo. Formato(DD-MM-AAAA)");
        equipoNuevo.setFechaDeCreacion(foramtearFecha(ServicioEntrada.getScanner().nextLine()));

        establecerTipoDeCarga(equipoNuevo);

        System.out.println("****** Carga de entrenador ****** ");
        cargarEntrenador(equipoNuevo);
        setearTodasLasListas(equipoNuevo);
        mostrarEquipo(equipoNuevo.getNombre());
    }


    public void establecerTipoDeCarga(Equipo equipoNuevo){
        System.out.println("Tipo de carga");
        System.out.println("1 : Maualmente ");
        System.out.println("2 : Por importacion");
        String opcion = ServicioEntrada.getScanner().nextLine();
        if( opcion.equals("1")){
            ServicioPosicion.mostrarFormaciones();
            ServicioPosicion.elegirFomacion(ServicioEntrada.getScanner().nextInt());
            System.out.println("****** Carga de jugadores ****** ");
            ServicioEntrada.getScanner().nextLine();
            cargarJugadores(equipoNuevo);
        } else{
            System.out.println("[Atencion] : El formato del archvo debe ser nombre, apellido, altura, posicion," +
                    " cantidad de goles, cantidad de partidos, si es capitan(true/false) y numero de camiseta ");
            System.out.println("Ingrese la ruta del archivo");
            ServicioEntradaArchivo servicioEntradaArchivo = new ServicioEntradaArchivo();
            equipoNuevo.setJugadores(servicioEntradaArchivo.importarJugadores(ServicioEntrada.getScanner().nextLine(),equipoNuevo));

        }
    }

    public LocalDate foramtearFecha(String fecha){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaFormateada = LocalDate.parse(fecha, formatter);

        return fechaFormateada;
    }

    public void setearTodasLasListas(Equipo equipoNuevo){
        listaEquipos.add(equipoNuevo);

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
            System.out.println("Jugadoes: ");
            for (Jugador jugador: equipo.getJugadores() ) {
                System.out.println(jugador.getNroCamiseta()+ " - " + jugador.getNombre() +  " - " + jugador.getPosicion().getPosicion());
            }
        } else {
            System.out.println("No existe el equipo");
        }
        System.out.println(" ");
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
        boolean equipoEiminado = listaEquipos.remove(buscarEquipo(nombre));

        if(equipoEiminado){
            System.out.println("Equipo eliminado exitosamente");
        } else {
            System.out.println("No se encontro el equipo ");
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
           mostrarEquipoOrdenado(equipo,listaOrdenada);
        } else {
            System.out.println("No existe el equipo");
        }
    }

    public  void mostrarEquipoOrdenado(Equipo equipo, List<Jugador> listaOrdenada){
        System.out.println("Equipo : " + equipo.getNombre());
        System.out.println("Entrenador : " + equipo.getEntrenador().getNombre());
        System.out.println("Jugadores: ");
        for (Jugador jugador: listaOrdenada ) {
            System.out.println(jugador.getNroCamiseta()+ " - " + jugador.getNombre() +  " - " + jugador.getPosicion().getPosicion());
        }
        System.out.println("¿Desea exportar jugadores? 1 : Si - 2 : No" );
        if(ServicioEntrada.getScanner().nextLine().equals("1")){
            SercivioSalida servicioSalida = new SercivioSalida();
            equipo.getJugadores().clear();
            equipo.setJugadores(listaOrdenada);
            servicioSalida.exportarAchivo(equipo);

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
            mostrarEquipoOrdenado(equipo,listaOrdenada);
        } else {
            System.out.println("No existe el equipo");
        }
    }

    @Override
    public void mostrarEquipoOrdenadoPorPosicionYCamiseta(String equipoNombre){
        Equipo equipo =  buscarEquipo(equipoNombre);

        if(equipo.getNombre() != null){
            List<Jugador> listaOrdenada = new ArrayList<>(equipo.getJugadores());
           listaOrdenada.sort(Comparator.comparing(Jugador::getPosicion).thenComparing(Jugador::getNroCamiseta));
            mostrarEquipoOrdenado(equipo,listaOrdenada);
        } else {
            System.out.println("No existe el equipo");
        }
    }



}
