package br.com.gilmarioArantes.refatoracao.tiposPrimitivos;

public class Massa {
    private int tipo; //0: grama, 1: quilograma
    private int massa;

    public Massa(int tipo, int massa) {
        this.tipo = tipo;
        this.massa = massa;
    }

    public int getTipo() {
        return tipo;
    }
    public double getMassa() {
        return massa;
    }
}
