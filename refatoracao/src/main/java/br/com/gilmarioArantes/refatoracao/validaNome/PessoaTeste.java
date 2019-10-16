package br.com.gilmarioArantes.refatoracao.validaNome;

public class PessoaTeste {
    public static void main(String[] args){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Joao Guimaraes Rosa");
        boolean nomeValido = false;
        int tamanhoNome = pessoa.getNome().length();
        for(int i = 0; i < tamanhoNome;i++){
            String nomePessoa = pessoa.getNome().trim();
            System.out.println(nomePessoa);
            boolean eCaracter = Character.isAlphabetic(nomePessoa.charAt(i));
            boolean eNumero = Character.isDigit(nomePessoa.codePointAt(i));

            if(eCaracter || eNumero ){
                nomeValido = true;
            }else{
                nomeValido = false;
                break;
            }
        }

        System.out.println(nomeValido);
    }
}
