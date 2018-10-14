
package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import Enums.Jugadores;

public class TestSet {

    @Test
    public void crearUnSetYVerificarPuntajeInicialJugadores() {
        Set set = new Set();

        int puntajeJ1 = set.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = set.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(0, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }

    @Test
    public void sumar1PuntosAlJugador1() {
        Set set = new Set();

        this.agregarPuntos(set, Jugadores.JUGADOR_1, 1);
        int puntajeJ1 = set.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = set.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(0, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }

    @Test
    public void jugador1GanaUnGame() {
        Set set = new Set();

        this.agregarPuntos(set, Jugadores.JUGADOR_1, 4);
        int puntajeJ1 = set.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = set.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(1, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }

    @Test
    public void jugador1Gana3Games() {
        Set set = new Set();

        this.agregarPuntos(set, Jugadores.JUGADOR_1, 12);
        int puntajeJ1 = set.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = set.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(3, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }

    @Test
    public void jugador1GanaElSet() {
        Set set = new Set();

        this.agregarPuntos(set, Jugadores.JUGADOR_1, 24);
        int puntajeJ1 = set.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = set.getPuntaje(Jugadores.JUGADOR_2);
        Jugadores ganador = set.getGanador();

        Assert.assertEquals(6, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
        Assert.assertEquals(Jugadores.JUGADOR_1, ganador);
    }

    private void agregarPuntos(Set set, Jugadores jugador, int puntos) {
        for (int i = 0; i < puntos; i++) {
            set.agregarPunto(jugador);
        }
    }
}
