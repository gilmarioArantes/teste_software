package br.com.gilmarioarantes.ordenacao.util;

public class CriaVetor {

    public static int[] criaVetor(int quantidadeElementos){

        int[] vetor = new int[quantidadeElementos];

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = (int) (Math.random()*quantidadeElementos);
        }
        return vetor;
    }
}
