package dad.AdivinApp;

import java.util.Random;

public class Numero {
    private int numero;
    private int numeroAleatorio;
    public Numero() {
        this.numero = numero;
        this.numeroAleatorio = numeroAleatorio;
    }

    public void setNumeroAleatorio(int numeroAleatorio) {
        this.numeroAleatorio = numeroAleatorio;
    }

    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Genera un número entre 1 y 100
    }
}
