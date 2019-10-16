package br.com.gilmarioArantes.refatoracao.tiposPrimitivos;

public class MassaRefatorada {

    private int gramas;

    public void setGramas(int gramas) {
        this.gramas = gramas;
    }

    public void setQuilos(double quilos) {
        this.gramas = (int) (1000 * quilos);
    }

    public int getGramas() {
        return gramas;
    }

    public double getQuilos() {
        return gramas * 1000;
    }
}
