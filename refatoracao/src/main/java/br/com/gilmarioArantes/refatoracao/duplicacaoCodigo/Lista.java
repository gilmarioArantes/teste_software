package br.com.gilmarioArantes.refatoracao.duplicacaoCodigo;

import java.util.ArrayList;

public class Lista {

    ArrayList lista = new ArrayList<>();

    public void adicionarItemInteiro(int t){
        lista.add(t);
    }

    public void adicionarItemString(String t){
        lista.add(t);
    }

    public int encontrarItemInteiro(int t){
        int indice = (int) lista.indexOf(t);
        int item = (int) lista.get(indice);
        return item;
    }

    public String encontrarItemString(String t){
        int indice = (int) Integer.parseInt(t);
        String item = (String) lista.get(indice);
        return item;
    }
}
