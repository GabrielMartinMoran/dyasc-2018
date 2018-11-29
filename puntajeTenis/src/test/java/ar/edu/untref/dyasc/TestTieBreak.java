package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import Enums.Jugadores;
import Enums.ValorPuntajeGame;

public class TestTieBreak {
    @Test
    public void crearUnTieBreakYVerificarPuntajeInicialJugadores() {
        TieBreak tieBreak = new TieBreak();

        ValorPuntajeGame puntajeJ1 = tieBreak.getPuntaje(Jugadores.JUGADOR_1);
        ValorPuntajeGame puntajeJ2 = tieBreak.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ1);
        Assert.assertEquals(ValorPuntajeGame._0, puntajeJ2);
    }

    @Test
    public void terminarTieBreakYVerificarQueSeTermino() {
        TieBreak tieBreak = new TieBreak();

        agregarPuntos(tieBreak, Jugadores.JUGADOR_1, 7);

        Assert.assertTrue(tieBreak.finalizo());
    }

    @Test
    public void noTerminarTieBreakYVerificarQueNoSeTermino() {
        TieBreak tieBreak = new TieBreak();

        agregarPuntos(tieBreak, Jugadores.JUGADOR_1, 2);

        Assert.assertFalse(tieBreak.finalizo());
    }

    @Test(expected = GameFinalizadoException.class)
    public void agregarPuntoConTieBreakFinalizado() {
        TieBreak tieBreak = new TieBreak();

        agregarPuntos(tieBreak, Jugadores.JUGADOR_1, 8);
    }

    private void agregarPuntos(TieBreak tieBreak, Jugadores jugador, int puntos) {
        for (int i = 0; i < puntos; i++) {
            tieBreak.agregarPunto(jugador);
        }
    }
}
