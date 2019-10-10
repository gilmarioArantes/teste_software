package br.com.gilmarioarantes.ordenacao.src;

import br.com.gilmarioarantes.ordenacao.util.CriaVetor;
import br.com.gilmarioarantes.ordenacao.util.ImprimeVetor;

import java.io.IOException;

public class QuickSort {

    private static void quickSort(int[] vetor, int inicio, int fim){
        if(inicio < fim){
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int separar(int[] vetor, int inicio, int fim){

        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;

        while (i <= f){
            if(vetor[i] <= pivo)
                i++;
            else if(pivo < vetor[f])
                f--;
            else{
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    public static void main(String[] args) throws IOException {

        int[] vetor = CriaVetor.criaVetor(10);

        System.out.println("Imprimindo o vetor antes da ordenação.");

        ImprimeVetor.imprimeVetor(vetor);

        long tempoInicial = System.currentTimeMillis();

        quickSort(vetor,0, vetor.length-1);

        System.out.println("Imprimindo o vetor depois da ordenação.");

        ImprimeVetor.imprimeVetor(vetor);

        long tempoFinal = System.currentTimeMillis();

        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms.");
    }
}
