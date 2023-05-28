package com.fut5app.Servicios.Entrada.impl;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Dominio.Jugador;
import com.fut5app.Dominio.Posiciones;
import com.fut5app.Servicios.Entrada.IServicioEntrada;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class ServicioEntradaArchivo implements IServicioEntrada {


    public List<Jugador> importarJugadores(String archivoRuta, Equipo equipo){
        List<Jugador> listJug = new ArrayList<>();
        List<String> listasplited = new ArrayList<>();

        try{
            List<String> lineas = FileUtils.readLines(new File(archivoRuta), StandardCharsets.UTF_8);

            for (String linea: lineas) {
                Jugador jugador = new Jugador();
                String[] datosArray = linea.split(",");

                for (String dato : datosArray) {
                    listasplited.add(dato);
                }

                jugador.setId(UUID.randomUUID());
                jugador.setNombre(listasplited.get(0));
                jugador.setApellido(listasplited.get(1));
                jugador.setAltura(Double.parseDouble(listasplited.get(2)));
                jugador.setPosicion(Posiciones.valueOf(listasplited.get(3)));
                jugador.setCantGoles(Integer.parseInt(listasplited.get(4)));
                jugador.setNroCamiseta(Integer.parseInt(listasplited.get(5)));
                jugador.setCapitan(Boolean.parseBoolean(listasplited.get(6)));
                jugador.setNroCamiseta(Integer.parseInt(listasplited.get(7)));
                jugador.setEquipo(equipo);
                listJug.add(jugador);

                listasplited.clear();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);

        }catch (NullPointerException n){
            System.out.println(n.getMessage());
            throw new RuntimeException(n);
        }

        return listJug;

    }

}

