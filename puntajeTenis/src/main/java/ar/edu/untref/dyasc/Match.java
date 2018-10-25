package ar.edu.untref.dyasc;

import java.util.ArrayList;

import Enums.Jugadores;

public class Match {

    private ArrayList<Set> sets;
    private int setsJugador1 = 0;
    private int setsJugador2 = 0;

    public Match() {
        this.sets = new ArrayList<Set>();
        this.sets.add(new Set());
    }

    public int getPuntaje(Jugadores jugador) {
        return jugador == Jugadores.JUGADOR_1 ? this.setsJugador1 : this.setsJugador2;
    }

    public Set ultimoSet() {
        return this.sets.get(this.sets.size() - 1);
    }

    public void agregarPunto(Jugadores jugador) throws MatchFinalizadoException {
        if (getGanador() != null) {
            throw new MatchFinalizadoException();
        }
        ultimoSet().agregarPunto(jugador);
        if (ultimoSet().finalizo()) {
            if (ultimoSet().getGanador() == Jugadores.JUGADOR_1) {
                this.setsJugador1++;
            } else {
                this.setsJugador2++;
            }
            this.sets.add(new Set());
        }
    }

    public Jugadores getGanador() {
        Jugadores ganador = null;
        if (this.setsJugador1 == 3) {
            ganador = Jugadores.JUGADOR_1;
        } else if (this.setsJugador2 == 3) {
            ganador = Jugadores.JUGADOR_2;
        }
        return ganador;
    }

}
