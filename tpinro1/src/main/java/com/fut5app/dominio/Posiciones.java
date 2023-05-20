package com.fut5app.dominio;

public enum Posiciones {
    DEFENSOR("Defensor"),
    ARQUERO("Arquero"),
    MEDIOCAMPISTA("Mediocampista"),
    DELANTERO("Delantero");

    private String posicion;

    Posiciones(String posision) {
        this.posicion = posision;
    }

    public String getPosicion() {
        return posicion;
    }
}
