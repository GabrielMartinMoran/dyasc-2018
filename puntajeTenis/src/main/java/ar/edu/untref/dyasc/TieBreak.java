package ar.edu.untref.dyasc;

import Enums.Jugadores;
import Enums.ValorPuntajeGame;
import java.lang.Math;

public class TieBreak extends Game {
    private PuntajeTieBreak puntajeJugador1;
    private PuntajeTieBreak puntajeJugador2;

    public TieBreak() {
        puntajeJugador1 = new PuntajeTieBreak();
        puntajeJugador2 = new PuntajeTieBreak();
    }

    @Override
    public ValorPuntajeGame getPuntaje(Jugadores jugador) {
        return ValorPuntajeGame._0;
    }
    
    @Override
    public void agregarPunto(Jugadores jugador) {
        if (finalizo()) {
            throw new GameFinalizadoException();
        }
        switch (jugador) {
        case JUGADOR_1:
            puntajeJugador1.agregarPunto();
            break;
        case JUGADOR_2:
            puntajeJugador2.agregarPunto();
            break;
        }
    }
    
    @Override
    public boolean finalizo() {
        return (Math.abs(puntajeJugador1.getPuntaje() - puntajeJugador2.getPuntaje()) >= 2) && (puntajeJugador1.getPuntaje() >= 7 || puntajeJugador2.getPuntaje() >= 7);
    }
}
