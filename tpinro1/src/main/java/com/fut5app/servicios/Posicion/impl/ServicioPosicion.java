package com.fut5app.servicios.Posicion.impl;

import com.fut5app.dominio.Posiciones;
import com.fut5app.servicios.Posicion.IServicioPosicion;


public class ServicioPosicion implements IServicioPosicion {
    
    public static void mostrarPosiciones(){
        System.out.println("1:Defensor");
        System.out.println("2:Arquero");
        System.out.println("3:Madio campista");
        System.out.println("4:Delantero");
    }

    public static Posiciones crearPosicion(int posicion) {
        Posiciones posicionNueva = null;
        switch (posicion){
            case 1:{
               posicionNueva = Posiciones.DEFENSOR;
              break;
            }
            case 2:{
                 posicionNueva = Posiciones.ARQUERO;
                break;
            }
            case 3:{
                 posicionNueva = Posiciones.MEDIOCAMPISTA;
                break;
            }
            case 4:{
                 posicionNueva = Posiciones.DELANTERO;
                break;
            }
        }
        return posicionNueva;
    }
}
