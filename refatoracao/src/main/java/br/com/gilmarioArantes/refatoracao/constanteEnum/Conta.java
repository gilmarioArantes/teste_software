package br.com.gilmarioArantes.refatoracao.constanteEnum;

public class Conta {
    private static final int CONTA_CORRENTE = 1;
    private static final int CONTA_CORRETORA = 2;

    public void visualizarExtrato(int tipoConta) {
        switch (tipoConta) {
            case CONTA_CORRENTE:
                System.out.println("Saída do Saldo Conta Corrente:");
                break;
            case CONTA_CORRETORA:
                System.out.println("Saída do Saldo Conta Corretora:");
                break;
        }
    }
}
