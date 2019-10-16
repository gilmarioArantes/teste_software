package br.com.gilmarioarantes.refatoracao.codigoduplicado;

import lombok.Data;
import lombok.extern.flogger.Flogger;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
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
