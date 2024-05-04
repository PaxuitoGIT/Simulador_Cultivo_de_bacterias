package CultivoBacterias.Lógica;

import java.util.Date;

public class PoblacionBacterias {
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int numBacterias;
    private int temperatura;
    private String luminosidad;
    private DosisAlimento dosisAlimento;

    public PoblacionBacterias(String nombre, Date fechaInicio, Date fechaFin, int numBacterias, int temperatura, String luminosidad, DosisAlimento dosisAlimento) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numBacterias = numBacterias;
        this.temperatura = temperatura;
        this.luminosidad = luminosidad;
        this.dosisAlimento = dosisAlimento;
    }
}
