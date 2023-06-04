package com.fut5app.Servicios.Equipo.impl;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Servicios.Entrada.IServicioEntradaArchivo;
import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Entrada.impl.ServicioEntradaArchivo;
import com.fut5app.Servicios.Entrenador.IServicioEntrenador;
import com.fut5app.Servicios.Entrenador.impl.ServicioEntrenador;
import com.fut5app.Servicios.Equipo.IServicioEquipo;
import com.fut5app.Servicios.Jugador.IServicioJugador;
import com.fut5app.Servicios.Jugador.impl.ServicioJugador;
import com.fut5app.Dominio.Jugador;
import com.fut5app.Servicios.Posicion.impl.ServicioPosicion;
import com.fut5app.Servicios.Salida.IServicioSalida;
import com.fut5app.Servicios.Salida.impl.ServicioSalida;


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

        controlDeNombre(equipoNuevo);

        System.out.println("Ingrese fecha de creacion del equipo. Formato(DD-MM-AAAA)");
        equipoNuevo.setFechaDeCreacion(foramtearFecha(ServicioEntrada.getScanner().nextLine()));

        establecerTipoDeCarga(equipoNuevo);

        cargarEntrenador(equipoNuevo);

        setearListaEquipos(equipoNuevo);

        mostrarEquipo(equipoNuevo.getNombre());
    }
    @Override
    public void mostrarTodosLosEquipos(){
        if(!listaEquipos.isEmpty()){
            for (int i = 0; i<listaEquipos.size(); i++){
                System.out.println(i+1 +" : " + listaEquipos.get(i).getNombre());
            }
        } else {
            System.out.println("No hay equipos cargados");
        }



    }

    private void controlDeNombre(Equipo equipoNuevo){
        System.out.println("Ingrese nombre del equipo");
        String nombre = ServicioEntrada.getScanner().nextLine();
        if(buscarEquipo(nombre).getNombre() != null){
            boolean seguir = true;
            while (seguir){
                System.out.println("Ya existe un equipo con ese nombre, ingrese otro.");
                nombre = ServicioEntrada.getScanner().nextLine();
                if (buscarEquipo(nombre).getNombre() == null) {
                    seguir = false;
                    equipoNuevo.setNombre(nombre);
                }
            }
        }else{
            equipoNuevo.setNombre(nombre);
        }

    }

    private void establecerTipoDeCarga(Equipo equipoNuevo){
        System.out.println("Tipo de carga");
        System.out.println("1 : Maualmente ");
        System.out.println("2 : Por importacion");
        String opcion = ServicioEntrada.getScanner().nextLine();
        if( opcion.equals("1")){
            cargaManual(equipoNuevo);
        } else{
            cargaPorImportacion(equipoNuevo);
          }
    }

    private void cargaManual(Equipo equipoNuevo){
        ServicioPosicion.mostrarFormaciones();
        ServicioPosicion.elegirFomacion(ServicioEntrada.getScanner().nextInt());
        System.out.println("****** Carga de jugadores ****** ");
        ServicioEntrada.getScanner().nextLine();
        cargarJugadores(equipoNuevo);
    }

    private void cargaPorImportacion(Equipo equipoNuevo){
        System.out.println("[Atencion] : El formato del archvo debe ser nombre, apellido, altura, posicion," +
                " cantidad de goles, cantidad de partidos, si es capitan(true/false) y numero de camiseta ");
        System.out.println("Ingrese la ruta del archivo");
        IServicioEntradaArchivo servicioEntradaArchivo = new ServicioEntradaArchivo();
        equipoNuevo.setJugadores(servicioEntradaArchivo.importarJugadores(ServicioEntrada.getScanner().nextLine(),equipoNuevo));
    }

    private LocalDate foramtearFecha(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaFormateada = LocalDate.parse(fecha, formatter);
        return fechaFormateada;
    }

    private void setearListaEquipos(Equipo equipoNuevo){
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

    @Override
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
        IServicioJugador servicioJugador = new ServicioJugador();
        for (int i=0; i<5; i++){
           equipo.setJugadores(servicioJugador.crearJugador(equipo));
        }
    }

    @Override
    public void cargarEntrenador(Equipo equipo) {
        IServicioEntrenador servicioEntrenador = new ServicioEntrenador();
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

    private  void mostrarEquipoOrdenado(Equipo equipo, List<Jugador> listaOrdenada){
        System.out.println("Equipo : " + equipo.getNombre());
        System.out.println("Entrenador : " + equipo.getEntrenador().getNombre());
        System.out.println("Jugadores: ");
        for (Jugador jugador: listaOrdenada ) {
            System.out.println(jugador.getNroCamiseta()+ " - " + jugador.getNombre() +  " - " + jugador.getPosicion().getPosicion());
        }
        opcionDeExportar(equipo,listaOrdenada);
    }

    private void opcionDeExportar(Equipo equipo, List<Jugador> listaOrdenada) {
        System.out.println("¿Desea exportar jugadores? 1 : Si - 2 : No");
        if (ServicioEntrada.getScanner().nextLine().equals("1")) {
            IServicioSalida servicioSalida = new ServicioSalida();
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
