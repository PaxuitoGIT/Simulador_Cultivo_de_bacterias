package CultivoBacterias.Lógica;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Experimento implements Serializable {
    private List<PoblacionBacterias> poblaciones;

    public Experimento() {
        this.poblaciones = new ArrayList<>();
    }

    public void agregarPoblacion(PoblacionBacterias poblacion) {
        poblaciones.add(poblacion);
    }

    public void eliminarPoblacion(PoblacionBacterias poblacion) {
        poblaciones.remove(poblacion);
    }

    public List<PoblacionBacterias> getPoblaciones() {
        return poblaciones;
    }
}
