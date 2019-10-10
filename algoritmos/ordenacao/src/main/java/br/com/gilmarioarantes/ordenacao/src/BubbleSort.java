/**
 * https://www.devmedia.com.br/algoritmos-de-ordenacao-em-java/32693
 */
package br.com.gilmarioarantes.ordenacao.src;

import br.com.gilmarioarantes.ordenacao.util.CriaVetor;
import br.com.gilmarioarantes.ordenacao.util.ImprimeVetor;

import java.io.IOException;

public class BubbleSort {
    private static void bubbleSort(int[] vetor){

        boolean troca = true;
        int aux;

        while(troca){
            troca = false;
            for(int i = 0; i < vetor.length - 1; i++){
                if(vetor[i] > vetor[i+1]){
                    aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    troca = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int[] vetor = CriaVetor.criaVetor(10);

        System.out.println("Imprimindo o vetor antes da ordenação");

        ImprimeVetor.imprimeVetor(vetor);

        long tempoInicial = System.currentTimeMillis();

        bubbleSort(vetor);

        System.out.println("Imprimindo o vetor depois da ordenação");

        ImprimeVetor.imprimeVetor(vetor);

        long tempoFinal = System.currentTimeMillis();

        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms.");
    }
}
