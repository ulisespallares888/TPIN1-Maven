package com.fut5app.servicios.Posicion.impl;

import com.fut5app.dominio.Posiciones;
import com.fut5app.servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.servicios.Posicion.IServicioPosicion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ServicioPosicion implements IServicioPosicion {
    public static List< Posiciones> listaFormacion211 = new ArrayList<>();
    public static List< Posiciones>  listaFormacion121 =  new ArrayList<>();
    public static List< Posiciones>  listaFormacion22 =  new ArrayList<>();
    public static List<List<Posiciones>> listaDeFormaciones = new ArrayList<>();
    public static List< Posiciones>  formacionEligida =  new ArrayList<>();
    public static boolean posicionCreada = false;

    public void cargarFormaciones(){
        listaDeFormaciones.add(listaFormacion211);
        listaDeFormaciones.add(listaFormacion121);
        listaDeFormaciones.add(listaFormacion22);
    }

    public static List<Posiciones>  cargarFormacion211(){
        listaFormacion211.add(Posiciones.DEFENSOR);
        listaFormacion211.add(Posiciones.DEFENSOR);
        listaFormacion211.add(Posiciones.ARQUERO);
        listaFormacion211.add(Posiciones.MEDIOCAMPISTA);
        listaFormacion211.add(Posiciones.DELANTERO);
        return listaFormacion211;
    }
    public static List<Posiciones> cargarFormacion121(){
        listaFormacion121.add( Posiciones.DEFENSOR);
        listaFormacion121.add( Posiciones.ARQUERO);
        listaFormacion121.add( Posiciones.MEDIOCAMPISTA);
        listaFormacion121.add( Posiciones.MEDIOCAMPISTA);
        listaFormacion121.add( Posiciones.DELANTERO);
        return listaFormacion121;
    }
    public static List<Posiciones>  cargarFormacion22(){
        listaFormacion22.add( Posiciones.ARQUERO);
        listaFormacion22.add( Posiciones.MEDIOCAMPISTA);
        listaFormacion22.add( Posiciones.MEDIOCAMPISTA);
        listaFormacion22.add( Posiciones.DELANTERO);
        listaFormacion22.add( Posiciones.DELANTERO);
        return listaFormacion22;
    }


    public static List<Posiciones> cargarPosiciones(int formacion){
        if(!posicionCreada) {
            if (formacion == 1) {
                return cargarFormacion211();
            } else if (formacion == 2) {
                return cargarFormacion121();
            }else if (formacion == 3){
                return cargarFormacion22();
            }
        }
        return null;
    }
    public static void  mostrarFormaciones(){
        System.out.println("***** Formaciones disponibles *****");
        System.out.println("1 : 2-1-1");
        System.out.println("2 : 1-2-1");
        System.out.println("3 : 2-2");
    }

    public static void elegirFomacion(int opcion){
        formacionEligida = cargarPosiciones(opcion);
        mostrarPosiciones(formacionEligida);
    }


    public static void mostrarPosiciones(List<Posiciones> listaPosiciones){
        System.out.println("**** Posiciones ****");
        for (int i = 0 ;i < listaPosiciones.size(); i++){
            System.out.println( i+1 + " : " + listaPosiciones.get(i));
        }
    }

    public static Posiciones crearPosicion(int posicion) {
        posicionCreada = true;
        Posiciones posicionNueva = formacionEligida.get(posicion-1);
        formacionEligida.remove(posicionNueva);
        return posicionNueva;
    }


}
