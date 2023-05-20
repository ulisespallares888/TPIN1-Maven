package com.fut5app.dominio;

import java.util.*;

public class Equipo {
    private UUID id;
    private String nombre;
    private Date fechaDeCreacion;
    private List jugadores = new ArrayList<>();
    private Entrenador entrenador;

    public Equipo() {}

    public Equipo(UUID id, String nombre, Date fechaDeCreacion, List<Jugador> jugadores, Entrenador entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.fechaDeCreacion = fechaDeCreacion;
        this.jugadores.add(jugadores);
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

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador jugador) {
            this.jugadores.add(jugador);
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
                ", nombre='" + nombre + '\'' +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", entrenador=" + entrenador +", jugadores=";
                for (Object jugador: jugadores) {
                    salida += jugador.toString();
                }
        return salida;
    }
}
