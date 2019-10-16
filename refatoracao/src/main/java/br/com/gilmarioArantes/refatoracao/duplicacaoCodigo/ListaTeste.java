package br.com.gilmarioArantes.refatoracao.duplicacaoCodigo;

public class ListaTeste {
    public static void main(String[] args){

        ListaRefatorada lr = new ListaRefatorada();

        lr.adicionarItem("Teste");
        lr.adicionarItem(2);

        System.out.println(lr.encontrarItem("Teste"));
        System.out.println(lr.encontrarItem(2));

    }
}
