package br.com.gilmarioArantes.refatoracao.promocaoMetodo;

import lombok.Data;

@Data
public class ContaCorrente {
    private double saldo;

    public double obtemSaldo(){
        System.out.println("O valor do saldo atual é:");
        return saldo;
    }
}
