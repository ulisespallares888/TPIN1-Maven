package com.fut5app.Servicios.Entrenador.impl;

import com.fut5app.Dominio.Entrenador;
import com.fut5app.Servicios.Entrada.Scanner.impl.ServicioEntrada;
import com.fut5app.Servicios.Entrenador.IServicioEntrenador;

import java.util.UUID;

public class ServicioEntrenador implements IServicioEntrenador {
    @Override
    public Entrenador crearEntrenador() {
        System.out.println("****** Carga de entrenador ****** ");
        Entrenador entrenador = new Entrenador();
        entrenador.setId(UUID.randomUUID());
        System.out.println("Ingrese el nombre del entrenador");
        entrenador.setNombre(ServicioEntrada.getScanner().next());
        System.out.println("Ingrese el apellido del entrenador");
        entrenador.setApellido(ServicioEntrada.getScanner().next());
        System.out.println("Ingrese la edad del entrenador");
        entrenador.setEdad(ServicioEntrada.getScanner().nextInt());
        ServicioEntrada.getScanner().nextLine();
        return entrenador;
    }
}
