package com.fut5app.Dominio;

import java.time.LocalDate;
import java.util.*;

public class Equipo {
    private UUID id;
    private String nombre;
    private LocalDate fechaDeCreacion;
    private List jugadores = new ArrayList<>();
    private Entrenador entrenador;

    public Equipo() {}

    public Equipo(String nombre) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.fechaDeCreacion = LocalDate.now();
    }
    public Equipo(UUID id, String nombre, LocalDate fechaDeCreacion, List<Jugador> jugadores, Entrenador entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.fechaDeCreacion = fechaDeCreacion;
        this.jugadores.add(jugadores);
        this.entrenador = entrenador;
    }
    public Equipo(UUID id, String nombre, LocalDate fechaDeCreacion,  Entrenador entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.fechaDeCreacion = fechaDeCreacion;
        this.entrenador = entrenador;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador jugador) {
            this.jugadores.add(jugador);
    }
    public void setJugadores(List<Jugador> jugador) {
        this.jugadores.addAll(jugador);
    }
    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        String salida = "Equipo{" +
                "id=" + id +
                ", nombre='" + this.nombre + '\'' +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", entrenador=" + entrenador +", jugadores=" + jugadores;
        return salida;
    }
}
