package br.com.gilmarioArantes.refatoracao.listaParametrosLonga;

public class VendaRefatorada {
    private int quantidade;
    private int precoItem;

    public double getPreco() {
        return precoDesconto();
    }

    private double precoDesconto() {
        if (getNivelDesconto() == 2) return getPrecoBase() * 0.1;
        else return getPrecoBase() * 0.05;
    }

    private double getPrecoBase() {
        return quantidade * precoItem;
    }

    private int getNivelDesconto() {
        if (quantidade > 100) return 2;
        else return 1;
    }
}
