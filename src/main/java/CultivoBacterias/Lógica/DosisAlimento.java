package CultivoBacterias.Lógica;

public class DosisAlimento {
    private int comidaInicial;
    private int diaConsumir;
    private int comidaFinal;

    public DosisAlimento(int comidaInicial, int diaIncremento, int comidaFinal) {
        this.comidaInicial = comidaInicial;
        this.diaConsumir = diaIncremento;
        this.comidaFinal = comidaFinal;
    }

    public int calcularCantidadComida(int dia, Experimento experimentoActual) {
        // Si el día es menor o igual al día de incremento, la cantidad de comida es la comida inicial
        if (dia <= diaConsumir) {
            return comidaInicial + dia;
        }
        // Si el día es mayor al día de incremento, pero menor o igual al día 30, se calcula la cantidad de comida
        else if (dia <= 30) {
            // Se calcula la cantidad de comida que se debe incrementar por día
            double incrementoDiario = (double) (comidaFinal - comidaInicial) / (30 - diaConsumir);
            // Se calcula la cantidad de comida para este día
            int cantidadComida = (int) Math.round(comidaInicial + incrementoDiario * (dia - diaConsumir));
            // Se asegura de que la cantidad de comida no sea mayor que 300 ni menor que 0
            cantidadComida = Math.max(Math.min(cantidadComida, 300), 0);
            // Se resta la cantidad de comida del número de bacterias
            int comidaConsumida = cantidadComida * experimentoActual.getPoblaciones().get(0).getNumBacterias(); // Suponiendo que solo hay una población
            experimentoActual.getPoblaciones().get(0).setNumBacterias(experimentoActual.getPoblaciones().get(0).getNumBacterias() - comidaConsumida);
            return cantidadComida;
        }
        // Si el día es mayor que 30, la cantidad de comida es la comida final
        else {
            return comidaFinal;
        }
    }
}