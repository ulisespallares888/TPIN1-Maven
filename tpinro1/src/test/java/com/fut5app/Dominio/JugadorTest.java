package com.fut5app.Dominio;

import junit.framework.TestCase;

public class JugadorTest extends TestCase {
    Jugador jugador = new Jugador();
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testSetAltura() {
        jugador.setAltura(1);
        assertEquals(1.0,jugador.getAltura());
    }

}