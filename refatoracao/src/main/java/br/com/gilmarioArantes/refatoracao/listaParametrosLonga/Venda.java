package br.com.gilmarioArantes.refatoracao.listaParametrosLonga;

public class Venda {
    private int quantidade;
    private int precoItem;

    public double getPreco() {
        int precoBase = quantidade * precoItem;
        int nivelDesconto;
        if (quantidade > 100) nivelDesconto = 2;
        else nivelDesconto = 1;
        double precoFinal = precoDesconto(precoBase, nivelDesconto);
        return precoFinal;
    }
    private double precoDesconto(int precoBase, int nivelDesconto) {
        if (nivelDesconto == 2) return precoBase * 0.1;
        else return precoBase * 0.05;
    }
}
