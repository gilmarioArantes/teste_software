package br.com.gilmarioArantes.refatoracao.duplicacaoCodigo;

import lombok.Data;

@Data
public class RobotRefactored {

    private Posicao posicao;

    public Posicao mover(String direcao){
        setPosicao(new Posicao(direcao));
        return getPosicao();
    }
}
