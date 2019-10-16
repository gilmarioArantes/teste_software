package br.com.gilmarioArantes.refatoracao.duplicacaoCodigo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ListaRefatorada <T>{

    ArrayList lista = new ArrayList<>();

    public void adicionarItem(T t){

        lista.add(t);
    }

    public T encontrarItem(T t){
        int indice = (int) lista.indexOf(t);
        T item = (T) lista.get(indice);
        return item;
    }
}
