package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import Enums.Jugadores;
import Enums.ValorPuntajeGame;

public class TestGame {
    @Test
    public void crearUnGameYVerificarPuntajeInicialJugadores() {
        Game game = new Game();

        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ1);
        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ2);
    }

    @Test
    public void sumar1PuntosAlJugador1() {
        Game game = new Game();

        game.agregarPunto(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._15, puntajeJ1);
        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ2);
    }

    @Test
    public void sumar1PuntosAlJugador2() {
        Game game = new Game();

        game.agregarPunto(Jugadores.JUGADOR_2);
        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ1);
        Assert.assertEquals(ValorPuntajeGame._15, puntajeJ2);
    }

    @Test
    public void sumar2PuntosAlJugador1() {
        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_1, 2);
        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._30, puntajeJ1);
        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ2);
    }

    @Test
    public void sumar2PuntosAlJugador2() {
        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_2, 2);
        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._30, puntajeJ2);
        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ1);
    }

    @Test
    public void sumar3PuntosAlJugador1() {
        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_1, 3);

        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._40, puntajeJ1);
        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ2);
    }

    @Test
    public void sumar3PuntosAlJugador2() {
        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_2, 3);

        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._40, puntajeJ2);
        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ1);
    }

    @Test
    public void sumar4PuntosAlJugador1ParaQueGane() {
        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_1, 4);

        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame.GANO, puntajeJ1);
        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ2);
    }

    @Test
    public void sumar4PuntosAlJugador2ParaQueGane() {
        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_2, 4);

        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame.GANO, puntajeJ2);
        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ1);
    }

    @Test
    public void enDeuce() {

        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_1, 3);
        agregarPuntos(game, Jugadores.JUGADOR_2, 3);

        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._40, puntajeJ2);
        Assert.assertEquals(ValorPuntajeGame._40, puntajeJ1);
    }

    @Test
    public void jugador2enVentaja() {

        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_1, 3);
        agregarPuntos(game, Jugadores.JUGADOR_2, 4);

        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._40, puntajeJ1);
        Assert.assertEquals(ValorPuntajeGame.VENTAJA, puntajeJ2);
    }

    @Test
    public void jugador2GanaEnVentaja() {

        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_1, 3);
        agregarPuntos(game, Jugadores.JUGADOR_2, 5);

        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._40, puntajeJ1);
        Assert.assertEquals(ValorPuntajeGame.GANO, puntajeJ2);
    }

    @Test
    public void jugador1HaceUnPuntoConJugador2EnVentaja() {

        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_1, 3);
        agregarPuntos(game, Jugadores.JUGADOR_2, 4);
        game.agregarPunto(Jugadores.JUGADOR_1);

        ValorPuntajeGame puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._40, puntajeJ1);
        Assert.assertEquals(ValorPuntajeGame._40, puntajeJ2);
    }

    @Test
    public void terminarGameYVerificarQueSeTermino() {
        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_1, 4);

        Assert.assertTrue(game.finalizo());
    }

    @Test
    public void noTerminarGameYVerificarQueNoSeTermino() {
        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_1, 3);

        Assert.assertFalse(game.finalizo());
    }

    @Test(expected = GameFinalizadoException.class)
    public void agregarPuntoConGameFinalizado() {
        Game game = new Game();

        agregarPuntos(game, Jugadores.JUGADOR_1, 5);
    }

    private void agregarPuntos(Game game, Jugadores jugador, int puntos) {
        for (int i = 0; i < puntos; i++) {
            game.agregarPunto(jugador);
        }
    }
}
