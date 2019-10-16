package br.com.gilmarioArantes.refatoracao.maIndentacao;

public class ClasseMalIndentada {
    public void metodo(int a, int b) {
        if (a==0){ System.out.println("a=0"); }else{ System.out.println("a<>0"); }
        if (a>0){ System.out.println("a=0"); }else if (b==0){ System.out.println("b=0"); }
        else { System.out.println("(a e b)<>0"); }
    }
}
