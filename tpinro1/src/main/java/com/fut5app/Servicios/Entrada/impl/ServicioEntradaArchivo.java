package com.fut5app.Servicios.Entrada.impl;

import com.fut5app.Dominio.Equipo;
import com.fut5app.Dominio.Jugador;
import com.fut5app.Dominio.Posiciones;
import com.fut5app.Servicios.Entrada.IServicioEntrada;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ServicioEntradaArchivo implements IServicioEntrada {


    public List<Jugador> importarJugadores(String archivo, Equipo equipo) {

        String ruta = "src\\main\\java\\com\\fut5app\\Resources\\ArchivoEntrada\\" + archivo;

        ServicioEntrada.setScannerDeArchivo(ruta);

        List<Jugador> listaJug = new ArrayList<>();
        List<String> listasplited = new ArrayList<>();

        while (ServicioEntrada.getScanner().hasNextLine()) {

            Jugador jugador = new Jugador();
            String linea = ServicioEntrada.getScanner().nextLine();
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
            listaJug.add(jugador);

            listasplited.clear();
        }

        ServicioEntrada.closeScanner();
        return listaJug;
        }


    }

