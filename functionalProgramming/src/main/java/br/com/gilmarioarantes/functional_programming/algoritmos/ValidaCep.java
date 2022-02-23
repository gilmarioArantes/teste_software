package br.com.gilmarioarantes.functional_programming.algoritmos;

import br.com.gilmarioarantes.functional_programming.interfaces.Validador;

public class ValidaCep {
    public static void main(String ... args){
        Validador<String> validadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");
        System.out.println(validadorCEP.valida("74393-580"));
    }
}
