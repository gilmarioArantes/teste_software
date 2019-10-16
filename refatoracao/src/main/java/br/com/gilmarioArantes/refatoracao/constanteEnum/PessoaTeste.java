package br.com.gilmarioArantes.refatoracao.constanteEnum;

public class PessoaTeste {
    public static void main(String[] args){
        Pessoa pessoa = new Pessoa();
        pessoa.setGenero(Sexo.MASCULINO);
        System.out.println(pessoa.getGenero().toString());
    }
}
