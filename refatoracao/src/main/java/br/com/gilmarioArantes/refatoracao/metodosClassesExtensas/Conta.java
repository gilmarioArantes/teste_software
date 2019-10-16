package br.com.gilmarioArantes.refatoracao.metodosClassesExtensas;

import lombok.Data;

@Data
public class Conta {

    private static int receitaVendas;
    private static int receitaAlugueis;
    private static int receitaComissoes;

    public static int getReceitaVendas(){
        return receitaVendas;
    }

    public static int getReceitaAlugueis(){
        return receitaAlugueis;
    }

    public static int getReceitaComissoes(){
        return receitaComissoes;
    }
}
