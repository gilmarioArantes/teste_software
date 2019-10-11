/**
 * https://www.devmedia.com.br/algoritmos-de-ordenacao-em-java/32693
 */
package br.com.gilmarioarantes.ordenacao.src;

import br.com.gilmarioarantes.ordenacao.util.CriaVetor;
import br.com.gilmarioarantes.ordenacao.util.ImprimeVetor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Log
public class BubbleSort {
    private static void bubbleSort(int[] vetor){

        boolean troca = true;
        int aux;
        int contadorIteracoes = 0;

        while(troca){
            troca = false;
            for(int i = 0; i < vetor.length - 1; i++){
                if(vetor[i] > vetor[i+1]){
                    contadorIteracoes++;
                    log.info("Iteração: " + contadorIteracoes);
                    aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    troca = true;
                    ImprimeVetor.imprimeVetor(vetor);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] vetor = CriaVetor.criaVetorSemRepeticao(10);

        log.info("Imprimindo o vetor antes da ordenação");

        ImprimeVetor.imprimeVetor(vetor);

        long tempoInicial = System.currentTimeMillis();

        bubbleSort(vetor);

        log.info("Imprimindo o vetor depois da ordenação");

        ImprimeVetor.imprimeVetor(vetor);

        long tempoFinal = System.currentTimeMillis();

        log.info("Executado em = " + (tempoFinal - tempoInicial) + " ms.");
    }
}
