package br.com.gilmarioarantes.functional_programming.algoritmos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo4 {
    public static void main(String ... args){
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini",120);
        Usuario user3 = new Usuario("Guilherme Silveira",190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Consumer<Usuario> mostraMensagem = u -> System.out.println("Antes de imprimir os nomes");

        Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());

        usuarios.forEach(mostraMensagem.andThen(imprimeNome));

    }
}
