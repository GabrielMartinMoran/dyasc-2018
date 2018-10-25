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

    @Test
    public void jugador2GanaElSet() {
        Set set = new Set();

        this.agregarPuntos(set, Jugadores.JUGADOR_2, 24);
        int puntajeJ1 = set.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = set.getPuntaje(Jugadores.JUGADOR_2);
        Jugadores ganador = set.getGanador();

        Assert.assertEquals(0, puntajeJ1);
        Assert.assertEquals(6, puntajeJ2);
        Assert.assertEquals(Jugadores.JUGADOR_2, ganador);
    }

    @Test
    public void jugador1GanaElSetPorDiferenciaDeDos() {
        Set set = new Set();

        this.agregarPuntos(set, Jugadores.JUGADOR_2, 16);
        this.agregarPuntos(set, Jugadores.JUGADOR_1, 24);
        int puntajeJ1 = set.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = set.getPuntaje(Jugadores.JUGADOR_2);
        Jugadores ganador = set.getGanador();

        Assert.assertEquals(6, puntajeJ1);
        Assert.assertEquals(4, puntajeJ2);
        Assert.assertEquals(Jugadores.JUGADOR_1, ganador);
    }

    @Test
    public void jugador1NoGanaElSetPorNoTenerDiferenciaDeDos() {
        Set set = new Set();

        this.agregarPuntos(set, Jugadores.JUGADOR_2, 20);
        this.agregarPuntos(set, Jugadores.JUGADOR_1, 24);
        int puntajeJ1 = set.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = set.getPuntaje(Jugadores.JUGADOR_2);
        Jugadores ganador = set.getGanador();

        Assert.assertEquals(6, puntajeJ1);
        Assert.assertEquals(5, puntajeJ2);
        Assert.assertNull(ganador);
    }

    

    @Test
    public void jugador2GanaEnTieBreak() {
        Set set = new Set();

        this.agregarPuntos(set, Jugadores.JUGADOR_1, 20);
        this.agregarPuntos(set, Jugadores.JUGADOR_2, 24);
        this.agregarPuntos(set, Jugadores.JUGADOR_1, 4);
        this.agregarPuntos(set, Jugadores.JUGADOR_2, 7);

        Jugadores ganador = set.getGanador();

        Assert.assertEquals(Jugadores.JUGADOR_2, ganador);
    }

    @Test(expected = SetFinalizadoException.class)
    public void agregarPuntoConSetFinalizado() {
        Set set = new Set();

        this.agregarPuntos(set, Jugadores.JUGADOR_1, 25);
    }

    private void agregarPuntos(Set set, Jugadores jugador, int puntos) {
        for (int i = 0; i < puntos; i++) {
            set.agregarPunto(jugador);
        }
    }
}
