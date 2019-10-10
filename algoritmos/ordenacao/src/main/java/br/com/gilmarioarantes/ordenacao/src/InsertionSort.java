package br.com.gilmarioarantes.ordenacao.src;

import br.com.gilmarioarantes.ordenacao.util.CriaVetor;
import br.com.gilmarioarantes.ordenacao.util.ImprimeVetor;

import java.io.IOException;

public class InsertionSort {

    public static void insertionSort(int[] vetor){
        int j;
        int key;
        int i;

        for(j = 1; j < vetor.length; j++){
            key = vetor[j];
            for(i = j - 1; (i >= 0) && (vetor[i] > key); i--){
                vetor[i+1] = vetor[i];
            }
            vetor[i+1] = key;
        }
    }

    public static void main(String[] args) throws IOException {

        int[] vetor = CriaVetor.criaVetor(10);

        System.out.println("Imprimindo o vetor antes da ordenação.");

        ImprimeVetor.imprimeVetor(vetor);

        long tempoInicial = System.currentTimeMillis();

        insertionSort(vetor);

        System.out.println("Imprimindo o vetor depois da ordenação.");

        ImprimeVetor.imprimeVetor(vetor);

        long tempoFinal = System.currentTimeMillis();

        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
    }
}
