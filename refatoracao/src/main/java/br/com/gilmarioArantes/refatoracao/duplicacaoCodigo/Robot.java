package br.com.gilmarioArantes.refatoracao.duplicacaoCodigo;

import lombok.Data;

@Data
public class Robot {

    private Posicao posicao;

    public Posicao moverFrente(){
        setPosicao(new Posicao("Frente"));
        return getPosicao();
    }

    public Posicao moverTras(){
        setPosicao(new Posicao("Trás"));
        return getPosicao();
    }

    public Posicao moverDireita(){
        setPosicao(new Posicao("Direita"));
        return getPosicao();
    }

    public Posicao moverEsquerda(){
        setPosicao(new Posicao("Esquerda"));
        return getPosicao();
    }

}
