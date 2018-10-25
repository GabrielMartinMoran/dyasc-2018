package ar.edu.untref.dyasc;

public class PuntajeTieBreak implements Puntaje<Integer> {

    protected int puntos = 0;

    @Override
    public Integer agregarPunto() {
        this.puntos++;
        return getPuntaje();
    }

    @Override
    public Integer quitarPunto() {
        throw new PuntajeException("No es posible quitar puntos");
    }

    @Override
    public void setPuntaje(Integer valor) {
        if (valor < 0) {
            throw new SetPuntajeException("El elemento no pudo ser asignado ya que es menor a cero");
        }
        this.puntos = valor;

    }

    @Override
    public Integer getPuntaje() {
        return this.puntos;
    }

}
