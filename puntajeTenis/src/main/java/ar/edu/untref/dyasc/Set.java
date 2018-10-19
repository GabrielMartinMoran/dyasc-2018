package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

import Enums.Jugadores;
import Enums.ValorPuntajeGame;

public class Set {

    private List<Game> games;
    private int gamesJugador1;
    private int gamesJugador2;

    public Set() {
        this.games = new ArrayList<Game>();
        games.add(new Game());
    }

    public int getPuntaje(Jugadores jugador) {
        int gamesJugador = 0;
        if (jugador == Jugadores.JUGADOR_1) {
            gamesJugador = gamesJugador1;
        } else if (jugador == Jugadores.JUGADOR_2) {
            gamesJugador = gamesJugador2;
        }
        return gamesJugador;
    }

    public void agregarPunto(Jugadores jugador) {
        if (getGanador() != null) {
            throw new SetFinalizadoException();
        }
        Game ultimoGame = games.get(games.size() - 1);
        ultimoGame.agregarPunto(jugador);
        if (ultimoGame.finalizo()) {
            if (ultimoGame.getPuntaje(Jugadores.JUGADOR_1) == ValorPuntajeGame.GANO) {
                gamesJugador1++;
            } else {
                gamesJugador2++;
            }
            games.add(new Game());
        }
    }

    public Jugadores getGanador() {
        Jugadores ganador = null;
        if ((gamesJugador1 == 6 && gamesJugador2 < 5) || gamesJugador1 == 7) {
            ganador = Jugadores.JUGADOR_1;
        } else if ((gamesJugador2 == 6 && gamesJugador1 < 5)
                || gamesJugador2 == 7) {
            ganador = Jugadores.JUGADOR_2;
        }
        return ganador;
    }

    public boolean finalizo() {
        
        return (getGanador() != null);
    }

}
