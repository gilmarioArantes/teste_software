package br.com.gilmarioarantes.refatoracao.codigoduplicado;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class RobotRefactored {

    private Posicao posicao;

    public Posicao mover(String direcao){
        setPosicao(new Posicao(direcao));
        return getPosicao();
    }
}
