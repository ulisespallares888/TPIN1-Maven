package com.fut5app.dominio;

public enum Posiciones implements IEntrenar {
    DEFENSOR ("Defensor") {
        @Override
        public String entrenar() {
            return "Defender area";
        }
    },
    ARQUERO("Arquero") {
        @Override
        public String entrenar() {
            return "Atajar goles";
        }
    },
    MEDIOCAMPISTA("Mediocampista") {
        @Override
        public String entrenar() {
            return "Pasar la pelota";
        }
    },
    DELANTERO("Delantero") {
        @Override
        public String entrenar() {
            return "Hacer goles";
        }
    };

    private String posicion;

    Posiciones(String posicion) {
        this.posicion = posicion;
    }

    public String getPosicion() {
        return posicion;
    }
}