package com.fut5app.Servicios.Menu.impl;

import com.fut5app.Servicios.Salida.IServicioSalida;
import com.fut5app.Servicios.Entrada.Scanner.impl.ServicioEntrada;
import com.fut5app.Servicios.Equipo.IServicioEquipo;
import com.fut5app.Servicios.Jugador.IServicioJugador;
import com.fut5app.Servicios.Menu.IMenu;


public class ServicioMenu implements IMenu {
    private  IServicioEquipo servicioEquipo;
    private  IServicioJugador servicioJugador;
    private  IServicioSalida servicioSalida;


    public ServicioMenu(IServicioEquipo servicioEquipo, IServicioJugador servicioJugador, IServicioSalida servicioSalida) {
        this.servicioEquipo = servicioEquipo;
        this.servicioJugador = servicioJugador;
        this.servicioSalida = servicioSalida;
    }

    @Override
    public void mostrarMenu(){
        String opcion = "";
        while (!opcion.equals("#")){
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("1 : Crear Equipos.");
            System.out.println("2 : Buscar jugador.");
            System.out.println("3 : Buscar equipo (Respuesta: equipo, entranador, capitan).");
            System.out.println("4 : Buscar equipo (Respuesta: equipo, entranador, jugadores).");
            System.out.println("5 : Buscar equipo (Respuesta: equipo, entranador, jugadores) ordeando por nombre de jugadores.");
            System.out.println("6 : Buscar equipo (Respuesta: equipo, entranador, jugadores) ordeando por numero de camiseta.");
            System.out.println("7 : Buscar equipo (Respuesta: equipo, entranador, jugadores) ordeando por numero de camiseta y posicion.");
            System.out.println("8 : Eliminar equipo.");
            System.out.println("9 : Eliminar un jugador de un equipo.");
            System.out.println("10 : Exportar equipo.");
            System.out.println("11 : Mostrar todos los equipos.");
            System.out.println("Ingrese # para salir ");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            opcion = ServicioEntrada.getScanner().nextLine();
            tomarOpcion(opcion);
        }
    }

    private void tomarOpcion(String opcion) {
        switch (opcion){
            case "1":{
                crearEquipos();
                break;
            }
            case "2":{
                buscarJugador();
                break;
            }
            case "3":{
                mostrarEquipoCapitan();
                break;
            }
            case "4":{
                mostrarEquipoJugadores();
                break;
            }
            case "5":{
                mostrarEquipoOrdenadoPorNombre();
                break;
            }
            case "6":{
                mostrarEquipoOrdenadoPorCamiseta();
                break;
            }
            case "7":{
                mostrarEquipoOrdenadoPorPosicionYCamiseta();
                break;
            }
            case "8":{
                eliminarEquipo();
                break;
            }
            case "9":{
                eliminarJugador();
                break;
            }
            case "10":{
                exportarJugadores();
                break;
            }
            case "11":{
                mostrarTodosLosEquipos();
                break;
            }
        }
    }

    private void crearEquipos(){
        String opcionCreacionEquipos = "";
        while(!opcionCreacionEquipos.equals("#")){
            this.servicioEquipo.crearEquipo();
            System.out.println("¿Desea seguir con la carga de equipos? ");
            System.out.println("1 : Si - 2 : No ");
            opcionCreacionEquipos = (ServicioEntrada.getScanner().nextLine().equals("1")) ? "" : "#";
        }
    }

    private void buscarJugador(){
        System.out.println("Ingrese nombre del jugador a buscar");
        this.servicioJugador.mostrarJugador(ServicioEntrada.getScanner().nextLine());
    }

    private void mostrarEquipoCapitan(){
        System.out.println("Ingrese nombre del equipo a buscar");
        this.servicioEquipo.mostrarEquipoCapitan(ServicioEntrada.getScanner().nextLine());
    }

    private void mostrarEquipoJugadores(){
        System.out.println("Ingrese nombre del equipo a buscar");
        this.servicioEquipo.mostrarEquipo(ServicioEntrada.getScanner().nextLine());
    }

    private void mostrarEquipoOrdenadoPorNombre(){
        System.out.println("Ingrese nombre del equipo a buscar");
        this.servicioEquipo.mostrarEquipoOrdenadoPorNombre(ServicioEntrada.getScanner().nextLine());
    }

    private void mostrarEquipoOrdenadoPorCamiseta(){
        System.out.println("Ingrese nombre del equipo a buscar");
        this.servicioEquipo.mostrarEquipoOrdenadoPorCamiseta(ServicioEntrada.getScanner().nextLine());
    }

    private void mostrarEquipoOrdenadoPorPosicionYCamiseta(){
        System.out.println("Ingrese nombre del equipo a buscar");
        this.servicioEquipo.mostrarEquipoOrdenadoPorPosicionYCamiseta(ServicioEntrada.getScanner().nextLine());
    }

    private void eliminarEquipo(){
        this.servicioEquipo.eliminarEquipo();
    }

    private void eliminarJugador(){
        this.servicioJugador.eliminarJugador();
    }

    private void exportarJugadores(){
        System.out.println("Ingrese nombre del equipo a exportar");
        this.servicioSalida.exportarAchivo(this.servicioEquipo.buscarEquipo(ServicioEntrada.getScanner().nextLine()));
    }

    private void mostrarTodosLosEquipos(){
        this.servicioEquipo.mostrarTodosLosEquipos();
    }

}
