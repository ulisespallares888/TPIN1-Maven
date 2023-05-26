package com.fut5app.Servicios.Entrenador.impl;

import com.fut5app.Dominio.Entrenador;
import com.fut5app.Servicios.Entrenador.IServicioEntrenador;

import java.util.Scanner;
import java.util.UUID;

public class ServicioEntrenador implements IServicioEntrenador {
    @Override
    public Entrenador crearEntrenador() {
        Scanner sc = new Scanner(System.in);
        Entrenador entrenador = new Entrenador();
        entrenador.setId(UUID.randomUUID());
        System.out.println("Ingrese el nombre del entrenador");
        entrenador.setNombre(sc.next());
        System.out.println("Ingrese el apellido del entrenador");
        entrenador.setApellido(sc.next());
        System.out.println("Ingrese la edad del entrenador");
        entrenador.setEdad(sc.nextInt());
        sc.close();

        return entrenador;
    }
}
