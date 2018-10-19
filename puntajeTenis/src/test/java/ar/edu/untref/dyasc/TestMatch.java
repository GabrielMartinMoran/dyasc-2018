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
    
    @Test
    public void jugador1GanaUnSet() {
        Match match = new Match();

        this.agregarPuntos(match, Jugadores.JUGADOR_1, 6*4);
        int puntajeJ1 = match.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = match.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(1, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }
    
    @Test
    public void jugador1Gana3Sets() {
        Match match = new Match();

        this.agregarPuntos(match, Jugadores.JUGADOR_1, 3*6*4);
        int puntajeJ1 = match.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = match.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(3, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }
    
    @Test
    public void jugador1Gana2Sets() {
        Match match = new Match();

        this.agregarPuntos(match, Jugadores.JUGADOR_1, 2*6*4);
        int puntajeJ1 = match.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = match.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(2, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }
    
    @Test
    public void jugador1GanaElMatch() {
        Match match = new Match();

        this.agregarPuntos(match, Jugadores.JUGADOR_1, 3*6*4);
        int puntajeJ1 = match.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = match.getPuntaje(Jugadores.JUGADOR_2);
        Jugadores ganador = match.getGanador();

        Assert.assertEquals(3, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
        Assert.assertEquals(Jugadores.JUGADOR_1, ganador);
    }
    
    @Test
    public void jugador2GanaElMatch() {
        Match match = new Match();

        this.agregarPuntos(match, Jugadores.JUGADOR_2, 3*6*4);
        int puntajeJ1 = match.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = match.getPuntaje(Jugadores.JUGADOR_2);
        Jugadores ganador = match.getGanador();

        Assert.assertEquals(3, puntajeJ2);
        Assert.assertEquals(0, puntajeJ1);
        Assert.assertEquals(Jugadores.JUGADOR_2, ganador);
    }
    
    private void agregarPuntos(Match match, Jugadores jugador, int puntos) {
        for (int i = 0; i < puntos; i++) {
            try {
                match.agregarPunto(jugador);
            } catch (MatchFinalizadoException e) {
                e.printStackTrace();
            }
        }
    }
}

