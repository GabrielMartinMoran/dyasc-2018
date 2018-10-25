package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import Enums.Jugadores;

public class TestPuntajeTieBreak {

    @Test
    public void creamosUnPuntajeTieBreakYcorroboramosSuValorDeInicio() {
        PuntajeTieBreak puntaje = new PuntajeTieBreak();

        int valorPuntaje = puntaje.getPuntaje();

        Assert.assertEquals(0, valorPuntaje);
    }

    @Test
    public void creamosUnPuntajeTieBreakYAgregamosUnPunto() {
        PuntajeTieBreak puntaje = new PuntajeTieBreak();

        int valorPuntaje = puntaje.agregarPunto();

        Assert.assertEquals(1, valorPuntaje);
    }

    @Test(expected = PuntajeException.class)
    public void creamosUnPuntajeTieBreakYTratamosDeQuitarUnPunto() {
        PuntajeTieBreak puntaje = new PuntajeTieBreak();

        puntaje.quitarPunto();
    }


    @Test(expected = SetPuntajeException.class)
    public void creamosUnPuntajeTieBreakYTratamosDeAsgnarUnPuntajeNegativo() {
        PuntajeTieBreak puntaje = new PuntajeTieBreak();

        puntaje.setPuntaje(-1);
    }

    @Test
    public void creamosUnPuntajeTieBreakAsignamosUnPuntajeYCorroboramosElValor() {
        PuntajeTieBreak puntaje = new PuntajeTieBreak();
        agregarPuntos(puntaje,5);

        int valorPuntaje = puntaje.getPuntaje();

        Assert.assertEquals(5, valorPuntaje);
    }
    
    private void agregarPuntos(PuntajeTieBreak puntaje, int puntos) {
        for (int i = 0; i < puntos; i++) {
            puntaje.agregarPunto();
        }
    }

}