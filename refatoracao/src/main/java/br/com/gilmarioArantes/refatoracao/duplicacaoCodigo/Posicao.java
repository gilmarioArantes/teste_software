package br.com.gilmarioArantes.refatoracao.duplicacaoCodigo;

import lombok.Data;

@Data
public class Posicao {

    private String nome;

    public Posicao(String nome){
        this.nome = nome;
    }
}
