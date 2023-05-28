package com.fut5app.Dominio;

import java.util.UUID;

public class Jugador extends Persona {
    private UUID id;
    private double altura;

    private Posiciones posicion;
    private int cantGoles;
    private int canttPartidos;
    private boolean capitan;
    private int nroCamiseta;
    private Equipo equipo;

    public Jugador(){}

    public Jugador(UUID id, String nombre, String apellido, double altura, Posiciones posicion, int cantGoles, int canttPartidos, boolean capitan, int nroCamiseta, Equipo equipo) {
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.id = id;
        this.altura = altura;
        this.posicion = posicion;
        this.cantGoles = cantGoles;
        this.canttPartidos = canttPartidos;
        this.capitan = capitan;
        this.nroCamiseta = nroCamiseta;
        this.equipo = equipo;
    }

    public Jugador(UUID id, String nombre, String apellido, double altura, Posiciones posicion, int cantGoles, int canttPartidos, boolean capitan, int nroCamiseta) {
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.id = id;
        this.altura = altura;
        this.posicion = posicion;
        this.cantGoles = cantGoles;
        this.canttPartidos = canttPartidos;
        this.capitan = capitan;
        this.nroCamiseta = nroCamiseta;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Posiciones getPosicion() {
        return posicion;
    }

    public void setPosicion(Posiciones posicion) {
        this.posicion = posicion;
    }

    public int getCantGoles() {
        return cantGoles;
    }

    public void setCantGoles(int cantGoles) {
        this.cantGoles = cantGoles;
    }

    public int getCanttPartidos() {
        return canttPartidos;
    }

    public void setCanttPartidos(int canttPartidos) {
        this.canttPartidos = canttPartidos;
    }

    public boolean isCapitan() {
        return capitan;
    }

    public void setCapitan(boolean capitan) {
        this.capitan = capitan;
    }

    public int getNroCamiseta() {
        return nroCamiseta;
    }

    public void setNroCamiseta(int nroCamiseta) {
        this.nroCamiseta = nroCamiseta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador{"  +
                "id=" + id +
                super.toString() +
                ", altura=" + altura +
                ", posicion=" + posicion.getPosicion() +
                ", cantGoles=" + cantGoles +
                ", canttPartidos=" + canttPartidos +
                ", capitan=" + capitan +
                ", nroCamiseta=" + nroCamiseta +
                ", equipo=" + equipo.getNombre() +
                "} " ;
    }
}
