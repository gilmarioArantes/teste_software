package br.com.gilmarioarantes.refatoracao.codigoduplicado;

import lombok.Data;

@Data
public class Posicao {

    private String nome;

    public Posicao(String nome){
        this.nome = nome;
    }
}
