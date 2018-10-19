package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import Enums.Jugadores;

public class TestMatch {
    @Test
    public void crearUnMatchYVerificarPuntajeInicialJugadores() {
        Match match = new Match();

        int puntajeJ1 = match.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = match.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(0, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }
}
