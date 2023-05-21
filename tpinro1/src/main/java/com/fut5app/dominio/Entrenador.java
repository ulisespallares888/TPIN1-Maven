package com.fut5app.dominio;

import java.util.UUID;

public class Entrenador extends Persona implements IEntrenar{
    private UUID id;
    private int edad;

    public Entrenador() { }
    public Entrenador(UUID id, String nombre, String apellido, int edad) {
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.id = id;
        this.edad = edad;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + id +
                super.toString() +
                ", edad=" + edad +"} ";
    }

    @Override
    public String entrenar() {
        return "Enrtenar equipo";
    }
}
