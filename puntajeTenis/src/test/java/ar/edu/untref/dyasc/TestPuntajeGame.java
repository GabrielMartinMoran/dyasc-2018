package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import Enums.ValorPuntajeGame;

public class TestPuntajeGame {

    @Test
    public void creamosUnPuntajeGameCorroboramosElValorPorDefecto() {
        PuntajeGame puntaje = new PuntajeGame();

        ValorPuntajeGame valorPuntaje = puntaje.getPuntaje();

        Assert.assertEquals(ValorPuntajeGame._0, valorPuntaje);
    }

    @Test
    public void creamosUnPuntajeGameYAgregamosUnPunto() {
        PuntajeGame puntaje = new PuntajeGame();

        ValorPuntajeGame valorPuntaje = puntaje.agregarPunto();

        Assert.assertEquals(ValorPuntajeGame._15, valorPuntaje);
    }

    @Test(expected = PuntajeException.class)
    public void creamosUnPuntajeGameYAgregamosUnoMasAlMaximoDePuntos() {
        PuntajeGame puntaje = new PuntajeGame();

        puntaje.agregarPunto(); // 15
        puntaje.agregarPunto(); // 30
        puntaje.agregarPunto(); // 40
        puntaje.agregarPunto(); // ADV
        puntaje.agregarPunto(); // GANO
        puntaje.agregarPunto(); // EXEPTION

    }

    @Test(expected = PuntajeException.class)
    public void creamosUnPuntajeGameYTratamosDeQuitarUnPunto() {
        PuntajeGame puntaje = new PuntajeGame();

        puntaje.quitarPunto();
    }

    @Test
    public void creamosUnPuntajeGameAgregamosDosPuntosYQuitamosUno() {
        PuntajeGame puntaje = new PuntajeGame();

        puntaje.agregarPunto();
        puntaje.agregarPunto();
        ValorPuntajeGame valorPuntaje = puntaje.quitarPunto();

        Assert.assertEquals(ValorPuntajeGame._15, valorPuntaje);
    }

    @Test
    public void asignamosValorValidoAUnPuntajeGameYCorroboramosQueHayaSidoAsignado() {
        PuntajeGame puntaje = new PuntajeGame();

        puntaje.setPuntaje(ValorPuntajeGame._40);
        ValorPuntajeGame valorPuntaje = puntaje.getPuntaje();

        Assert.assertEquals(ValorPuntajeGame._40, valorPuntaje);
    }

}
