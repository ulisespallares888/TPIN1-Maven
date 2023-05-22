package com.fut5app.servicios.Entrenador.impl;

import com.fut5app.dominio.Entrenador;
import com.fut5app.servicios.Entrada.impl.ServicioEntrada;
import com.fut5app.servicios.Entrenador.IServicioEntrenador;

import java.util.UUID;

public class ServicioEntrenador implements IServicioEntrenador {
    @Override
    public Entrenador crearEntrenador() {
        Entrenador entrenador = new Entrenador();
        entrenador.setId(UUID.randomUUID());
        System.out.println("Ingrese el nombre del entrenador");
        entrenador.setNombre(ServicioEntrada.getScanner().next());
        System.out.println("Ingrese el apellido del entrenador");
        entrenador.setApellido(ServicioEntrada.getScanner().next());
        System.out.println("Ingrese la edad del entrenador");
        entrenador.setEdad(ServicioEntrada.getScanner().nextInt());
        return entrenador;
    }
}
