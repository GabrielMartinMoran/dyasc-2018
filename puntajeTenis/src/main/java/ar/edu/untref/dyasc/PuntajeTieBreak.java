package ar.edu.untref.dyasc;

public class PuntajeTieBreak implements Puntaje<Integer> {

    protected int puntos = 0;

    @Override
    public Integer agregarPunto() {
        puntos++;
        return getPuntaje();
    }

    @Override
    public Integer quitarPunto() {
        throw new PuntajeException("No es posible quitar mas puntos que el minimo");
    }

    @Override
    public void setPuntaje(Integer valor) {
        if (valor < 0) {
            throw new SetPuntajeException("El elemento no pudo ser asignado ya que es menor a cero");
        }
        puntos = valor;

    }

    @Override
    public Integer getPuntaje() {
        return puntos;
    }

}
