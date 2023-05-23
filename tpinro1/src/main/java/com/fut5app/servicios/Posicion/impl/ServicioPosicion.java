package com.fut5app.servicios.Posicion.impl;

import com.fut5app.dominio.Posiciones;
import com.fut5app.servicios.Posicion.IServicioPosicion;

import java.util.HashMap;
import java.util.Map;


public class ServicioPosicion implements IServicioPosicion {

    public static Map<Integer , Posiciones> mapPosicionesDisponibles = new HashMap<>();
    public static boolean posicionCreada = false;
    public static void cargarPosiciones(){
        if(posicionCreada==false) {
            mapPosicionesDisponibles.put(1, Posiciones.DEFENSOR);
            mapPosicionesDisponibles.put(2, Posiciones.ARQUERO);
            mapPosicionesDisponibles.put(3, Posiciones.MEDIOCAMPISTA);
            mapPosicionesDisponibles.put(4, Posiciones.DELANTERO);
        }
    }

    public static void mostrarPosiciones(){
        cargarPosiciones();

        for (Map.Entry<Integer,Posiciones> posicion: mapPosicionesDisponibles.entrySet()) {
            System.out.println(posicion.getKey() + " : " + posicion.getValue());
        }

    }

    public static Posiciones crearPosicion(int posicion) {
        posicionCreada = true;
        Posiciones posicionNueva = null;
        switch (posicion){
            case 1:{
                posicionNueva = Posiciones.DEFENSOR;
                mapPosicionesDisponibles.remove(1,Posiciones.DEFENSOR);
                break;
            }
            case 2:{
                posicionNueva = Posiciones.ARQUERO;
                mapPosicionesDisponibles.remove(2,Posiciones.ARQUERO);
                break;
            }
            case 3:{
                posicionNueva = Posiciones.MEDIOCAMPISTA;
                mapPosicionesDisponibles.remove(3,Posiciones.MEDIOCAMPISTA);
                break;
            }
            case 4:{
                posicionNueva = Posiciones.DELANTERO;
                mapPosicionesDisponibles.remove(4,Posiciones.DELANTERO);
                break;
            }
        }
        return posicionNueva;
    }
}
