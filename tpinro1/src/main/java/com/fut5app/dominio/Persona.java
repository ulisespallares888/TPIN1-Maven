package com.fut5app.dominio;

public abstract class Persona {
    private String nombre;
    private  String apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return  " nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'';
    }
}
