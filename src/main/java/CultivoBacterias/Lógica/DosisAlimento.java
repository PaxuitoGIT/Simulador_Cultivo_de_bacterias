package CultivoBacterias.Lógica;

public class DosisAlimento {
    private int comidaInicial;
    private int diaIncremento;
    private int comidaIncremento;
    private int comidaFinal;

    public DosisAlimento(int comidaInicial, int diaIncremento, int comidaIncremento, int comidaFinal) {
        this.comidaInicial = comidaInicial;
        this.diaIncremento = diaIncremento;
        this.comidaIncremento = comidaIncremento;
        this.comidaFinal = comidaFinal;
    }

    public int calcularCantidadComida(int dia) {
        // Si el día es menor o igual al día de incremento, la cantidad de comida es la comida inicial
        if (dia <= diaIncremento) {
            return comidaInicial;
        }
        // Si el día es mayor al día de incremento, pero menor o igual al día 30, se calcula la cantidad de comida
        else if (dia <= 30) {
            // Se calcula la cantidad de comida que se debe incrementar por día
            double incrementoDiario = (double) (comidaFinal - comidaInicial) / (30 - diaIncremento);
            // Se calcula la cantidad de comida para este día
            int cantidadComida = (int) Math.round(comidaIncremento + incrementoDiario * (dia - diaIncremento));
            // Se asegura de que la cantidad de comida no sea mayor que 300
            return Math.min(cantidadComida, 300);
        }
        // Si el día es mayor que 30, la cantidad de comida es la comida final
        else {
            return comidaFinal;
        }
    }
}
