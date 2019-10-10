package br.com.gilmarioarantes.ordenacao.util;

public class ImprimeVetor {

    public static void imprimeVetor(int[] vetor){
        for(int i = 0; i < vetor.length; i++){
            if(i == 0){
                System.out.print("[" + vetor[i] + ",");
            }else if(i == vetor.length - 1){
                System.out.println(vetor[i] + "]");
            }else{
                System.out.print(vetor[i] + ",");
            }
        }
    }
}
