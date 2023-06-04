package com.fut5app.Servicios.Menu.impl;

import com.fut5app.Servicios.Entrada.Archivo.IServicioEntradaArchivo;
import com.fut5app.Servicios.Salida.IServicioSalida;
import com.fut5app.Servicios.Entrada.Scanner.impl.ServicioEntrada;
import com.fut5app.Servicios.Entrada.Archivo.impl.ServicioEntradaArchivo;
import com.fut5app.Servicios.Equipo.IServicioEquipo;
import com.fut5app.Servicios.Equipo.impl.ServicioEquipo;
import com.fut5app.Servicios.Jugador.IServicioJugador;
import com.fut5app.Servicios.Jugador.impl.ServicioJugador;
import com.fut5app.Servicios.Menu.IMenu;
import com.fut5app.Servicios.Salida.impl.ServicioSalida;



public class ServicioMenu implements IMenu {
    private IServicioEquipo servicioEquipo = new ServicioEquipo();
    private IServicioEntradaArchivo servicioEntradaArchivo = new ServicioEntradaArchivo();
    private IServicioJugador servicioJugador = new ServicioJugador();
    private IServicioSalida sercivioSalida = new ServicioSalida();

    public ServicioMenu() {
    }


    public ServicioMenu(IServicioEquipo servicioEquipo, IServicioEntradaArchivo servicioEntradaArchivo, IServicioJugador servicioJugador, IServicioSalida sercivioSalida) {
        this.servicioEquipo = servicioEquipo;
        this.servicioEntradaArchivo = servicioEntradaArchivo;
        this.servicioJugador = servicioJugador;
        this.sercivioSalida = sercivioSalida;
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
                String opcionCreacionEquipos = "";
                while(!opcionCreacionEquipos.equals("#")){
                    this.servicioEquipo.crearEquipo();
                    System.out.println("¿Desea seguir con la carga de equipos? ");
                    System.out.println("1 : Si - 2 : No ");
                    opcionCreacionEquipos = (ServicioEntrada.getScanner().nextLine().equals("1")) ? "" : "#";
                }
                break;
            }
            case "2":{
                System.out.println("Ingrese nombre del jugador a buscar");
                this.servicioJugador.mostrarJugador(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "3":{

                System.out.println("Ingrese nombre del equipo a buscar");
                this.servicioEquipo.mostrarEquipoCapitan(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "4":{
                System.out.println("Ingrese nombre del equipo a buscar");
                this.servicioEquipo.mostrarEquipo(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "5":{
                System.out.println("Ingrese nombre del equipo a buscar");
                this.servicioEquipo.mostrarEquipoOrdenadoPorNombre(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "6":{
                System.out.println("Ingrese nombre del equipo a buscar");
                this.servicioEquipo.mostrarEquipoOrdenadoPorCamiseta(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "7":{
                System.out.println("Ingrese nombre del equipo a buscar");
                this.servicioEquipo.mostrarEquipoOrdenadoPorPosicionYCamiseta(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "8":{
                System.out.println("Ingrese nombre del equipo a eliminar");
                this.servicioEquipo.eliminarEquipo(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "9":{
                this.servicioJugador.eliminarJugador();
                break;
            }
            case "10":{
                System.out.println("Ingrese nombre del equipo a exportar");
                this.sercivioSalida.exportarAchivo(this.servicioEquipo.buscarEquipo(ServicioEntrada.getScanner().nextLine()));
                break;
            }
            case "11":{
                this.servicioEquipo.mostrarTodosLosEquipos();
                break;
            }
        }
    }
}
