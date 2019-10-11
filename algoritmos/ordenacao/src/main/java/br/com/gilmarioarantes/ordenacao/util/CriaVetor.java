package br.com.gilmarioarantes.ordenacao.util;

import java.util.*;

public class CriaVetor {

    //cria um vetor com uma quantidade de elementos, sorteados de forma aleatória.
    public static int[] criaVetor(int quantidadeElementos){

        int[] vetor = new int[quantidadeElementos];

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = (int) (Math.random()*quantidadeElementos);
        }
        return vetor;
    }

    //cria um vetor com uma quantidade de elementos, sorteados de forma aleatória, sem permitir a repetição dos elementos.
    public static int[] criaVetorSemRepeticao(int quantidadeElementos){
        List<Integer> numeros = new ArrayList<>();
        int i = 0;
        while (i < quantidadeElementos){
            int num = (int) (Math.random()*quantidadeElementos);
            if(!numeros.contains(num)){
                numeros.add(num);
                i++;
            }
        }

        int[] vetor = new int[quantidadeElementos];
        for(int j = 0; j < vetor.length; j++){
            vetor[j] = (int) numeros.get(j);
        }

        return vetor;
    }

    public static void main(String[] args){
        int[] vetor = criaVetorSemRepeticao(10);
        ImprimeVetor.imprimeVetor(vetor);
    }


}
