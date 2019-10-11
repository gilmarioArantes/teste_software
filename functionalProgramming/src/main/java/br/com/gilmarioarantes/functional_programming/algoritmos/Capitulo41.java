package br.com.gilmarioarantes.functional_programming.algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo41 {
    public static void main(String ... args){
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini",120);
        Usuario user3 = new Usuario("Guilherme Silveira",190);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        Consumer<Usuario> mostraMensagem = u -> System.out.println("Antes de imprimir os nomes");

        Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());

        usuarios.forEach(mostraMensagem.andThen(imprimeNome));

        //remove usuário com pontuação maior que 160
        usuarios.removeIf(u -> u.getPontos() > 160);

        System.out.println("Impressão após remoção:");

        usuarios.forEach(imprimeNome);

    }
}
