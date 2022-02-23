package br.com.gilmarioarantes.ordenacao.src;

import br.com.gilmarioarantes.ordenacao.util.CriaVetor;
import br.com.gilmarioarantes.ordenacao.util.ImprimeVetor;

public class SelectionSort {

    public static void selectionSort(int[] array){

        for(int fixo = 0; fixo < array.length - 1; fixo++){
            int menor = fixo;

            for(int i = menor + 1; i < array.length; i++){
                if(array[i] < array[menor]){
                    menor = i;
                }
            }
            if(menor != fixo){
                int t = array[fixo];
                array[fixo] = array[menor];
                array[menor] = t;
            }
        }
    }

    public static void main(String[] args) throws Exception{

        int[] vetor = CriaVetor.criaVetor(10);

        System.out.println("Imprimindo o vetor antes da ordenação.");

        ImprimeVetor.imprimeVetor(vetor);

        long tempoInicial = System.currentTimeMillis();

        selectionSort(vetor);

        System.out.println("Imprimindo o vetor depois da ordenação.");

        ImprimeVetor.imprimeVetor(vetor);

        long tempoFinal = System.currentTimeMillis();

        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms.");
    }
}
