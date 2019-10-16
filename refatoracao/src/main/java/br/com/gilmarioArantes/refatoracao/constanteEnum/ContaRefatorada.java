package br.com.gilmarioArantes.refatoracao.constanteEnum;

public class ContaRefatorada {

    public void visualizarExtrado(TipoConta tipoConta) {
        switch (tipoConta) {
            case CORRENTE:
                System.out.println("Saída do Saldo Conta Corrente:");
                break;
            case CORRETORA:
                System.out.println("Saída do Saldo Conta Corretora:");
                break;
            default:
                break;
        }
    }

}
