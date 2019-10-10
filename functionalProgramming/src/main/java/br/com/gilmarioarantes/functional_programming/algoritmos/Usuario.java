package br.com.gilmarioarantes.functional_programming.algoritmos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
class Usuario {
    private String nome;
    private int pontos;
    private boolean moderador;

    public Usuario(String nome, int pontos){
        this.nome = nome;
        this.pontos = pontos;
        this.moderador = false;
    }

    public void tornaModerador(){
        this.moderador = true;
    }
}
