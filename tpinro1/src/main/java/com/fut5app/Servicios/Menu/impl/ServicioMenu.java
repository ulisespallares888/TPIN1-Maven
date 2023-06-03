package com.fut5app.Servicios.Menu.impl;

import com.fut5app.Servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.Servicios.Equipo.impl.ServicioEquipo;
import com.fut5app.Servicios.Jugador.impl.ServicioJugador;
import com.fut5app.Servicios.Menu.IMenu;
import com.fut5app.Servicios.Salida.impl.SercivioSalida;


public class ServicioMenu implements IMenu {
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
            System.out.println("Ingrese # para salir ");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            opcion = ServicioEntrada.getScanner().nextLine();
            tomarOpcion(opcion);
        }

    }

    private void tomarOpcion(String opcion) {
        switch (opcion){
            case "1":{
                ServicioEquipo servicioEquipo = new ServicioEquipo();
                String opcionCreacionEquipos = "";
                while(!opcionCreacionEquipos.equals("#")){
                    servicioEquipo.crearEquipo();
                    System.out.println("¿Desea seguir con la carga de equipos? ");
                    System.out.println("1 : Si - 2 : No ");
                    opcionCreacionEquipos = (ServicioEntrada.getScanner().nextLine().equals("1")) ? "" : "#";
                }
                break;
            }
            case "2":{
                ServicioJugador servicioJugador = new ServicioJugador();
                System.out.println("Ingrese nombre del jugador a buscar");
                servicioJugador.mostrarJugador(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "3":{
                ServicioEquipo servicioEquipo = new ServicioEquipo();
                System.out.println("Ingrese nombre del equipo a buscar");
                servicioEquipo.mostrarEquipoCapitan(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "4":{
                ServicioEquipo servicioEquipo = new ServicioEquipo();
                System.out.println("Ingrese nombre del equipo a buscar");
                servicioEquipo.mostrarEquipo(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "5":{
                ServicioEquipo servicioEquipo = new ServicioEquipo();
                System.out.println("Ingrese nombre del equipo a buscar");
                servicioEquipo.mostrarEquipoOrdenadoPorNombre(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "6":{
                ServicioEquipo servicioEquipo = new ServicioEquipo();
                System.out.println("Ingrese nombre del equipo a buscar");
                servicioEquipo.mostrarEquipoOrdenadoPorCamiseta(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "7":{
                ServicioEquipo servicioEquipo = new ServicioEquipo();
                System.out.println("Ingrese nombre del equipo a buscar");
                servicioEquipo.mostrarEquipoOrdenadoPorPosicionYCamiseta(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "8":{
                ServicioEquipo servicioEquipo = new ServicioEquipo();
                System.out.println("Ingrese nombre del equipo a buscar");
                servicioEquipo.eliminarEquipo(ServicioEntrada.getScanner().nextLine());
                break;
            }
            case "9":{
                ServicioJugador servicioJugador = new ServicioJugador();
                servicioJugador.eliminarJugador();
                break;
            }
            case "10":{
                SercivioSalida sercivioSalida = new SercivioSalida();
                ServicioEquipo servicioEquipo = new ServicioEquipo();
                System.out.println("Ingrese nombre del equipo a exportar");
                sercivioSalida.exportarAchivo(servicioEquipo.buscarEquipo(ServicioEntrada.getScanner().nextLine()));
                break;
            }
        }
    }
}
