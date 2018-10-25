package ar.edu.untref.dyasc;

import Enums.Jugadores;
import Enums.ValorPuntajeGame;

public class Game {

    private PuntajeGame puntajeJugador1;
    private PuntajeGame puntajeJugador2;

    public Game() {
        puntajeJugador1 = new PuntajeGame();
        puntajeJugador2 = new PuntajeGame();
    }

    public ValorPuntajeGame getPuntaje(Jugadores jugador) {
        switch (jugador) {
        case JUGADOR_1:
            return puntajeJugador1.getPuntaje();
        case JUGADOR_2:
            return puntajeJugador2.getPuntaje();
        default:
            return ValorPuntajeGame._0;
        }
    }

    public void agregarPunto(Jugadores jugador) {
        if (finalizo()) {
            throw new GameFinalizadoException();
        }
        switch (jugador) {
        case JUGADOR_1:
            if (puntajeJugador2.getPuntaje() == ValorPuntajeGame.VENTAJA) {
                puntajeJugador2.quitarPunto();
                return;
            }
            calcularProximoPuntaje(puntajeJugador1, puntajeJugador2);
            break;
        case JUGADOR_2:
            if (puntajeJugador1.getPuntaje() == ValorPuntajeGame.VENTAJA) {
                puntajeJugador1.quitarPunto();
                return;
            }
            calcularProximoPuntaje(puntajeJugador2, puntajeJugador1);
            break;
        }
    }

    public void calcularProximoPuntaje(PuntajeGame sumador, PuntajeGame otro) {
        if (sumador.getPuntaje() == ValorPuntajeGame._40) {
            if (otro.getPuntaje() == ValorPuntajeGame._40) {
                sumador.setPuntaje(ValorPuntajeGame.VENTAJA);
                return;
            } else {
                sumador.setPuntaje(ValorPuntajeGame.GANO);
                return;
            }
        }
        sumador.agregarPunto();
    }

    public boolean finalizo() {
        return puntajeJugador1.getPuntaje() == ValorPuntajeGame.GANO || puntajeJugador2.getPuntaje() == ValorPuntajeGame.GANO;
    }
}
