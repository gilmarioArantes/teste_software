package br.com.gilmarioarantes.functional_programming.algoritmos;

import java.util.Arrays;
import java.util.List;

public class Capitulo2 {
    public static void main(String ... args){
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini",120);
        Usuario user3 = new Usuario("Guilherme Silveira",190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        //Imprimir os nomes dos usuário com uma iteração na maneira antiga
        for(Usuario u : usuarios){
            System.out.println(u.getNome());
        }

        //Imprimir os nomes dos usuário com uma iteração Lambda.
        usuarios.forEach(u -> System.out.println(u.getNome()));

        //Tornar todos os usuários moderadores
        usuarios.forEach(u -> u.tornaModerador());
    }
}
