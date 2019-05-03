package alfa.br.com.gilmario;

import static org.junit.Assert.assertEquals;

import alfa.br.com.gilmario.modelo.Avaliacao;
import org.junit.Test;

/**
 * Created by gilmario on 26/02/17.
 */
public class AvaliacaoTest {
    private double nota1;
    private double nota2;
    private int faltas;
    private int cargaHoraria;
    private String resultadoEsperado;
    private final Avaliacao avaliacao = new Avaliacao();

    @Test
    public void testaValoresInvalidos1(){
        nota1 = -1;
        nota2 = 0;
        faltas = 17;
        cargaHoraria = 64;
        resultadoEsperado = "Valores Inválidos.";
        try {
            assertEquals(resultadoEsperado, avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testaValoresInvalidos2(){
        nota1 = 0;
        nota2 = -1;
        faltas = 17;
        cargaHoraria = 64;
        resultadoEsperado = "Valores Inválidos.";
        try {
            assertEquals(resultadoEsperado, avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testaValoresInvalidos3(){
        nota1 = 0;
        nota2 = 0;
        faltas = -1;
        cargaHoraria = 64;
        resultadoEsperado = "Valores Inválidos.";
        try {
            assertEquals(resultadoEsperado, avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testaValoresInvalidos4(){
        nota1 = 0;
        nota2 = 0;
        faltas = 16;
        cargaHoraria = -64;
        resultadoEsperado = "Valores Inválidos.";
        try {
            assertEquals(resultadoEsperado, avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testaReprovacaoPorFalta(){
        nota1 = 0;
        nota2 = 0;
        faltas = 17;
        cargaHoraria = 64;
        resultadoEsperado = "Reprovado por Falta.";
        try {
            assertEquals(resultadoEsperado, avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testaReprovacaoPorMedia(){
        nota1 = 0;
        nota2 = 0;
        faltas = 16;
        cargaHoraria = 64;
        resultadoEsperado = "Reprovado por Média.";
        try {
            assertEquals(resultadoEsperado, avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testaProvaExtra1(){
        nota1 = 3;
        nota2 = 3;
        faltas = 16;
        cargaHoraria = 64;
        resultadoEsperado = "Prova Extra.";
        try {
            assertEquals(resultadoEsperado, avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testaProvaExtra2(){
        nota1 = 5.99;
        nota2 = 6;
        faltas = 16;
        cargaHoraria = 64;
        resultadoEsperado = "Prova Extra.";
        try {
            assertEquals(resultadoEsperado, avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testaAprovacao(){
        nota1 = 6.00;
        nota2 = 6;
        faltas = 16;
        cargaHoraria = 64;
        resultadoEsperado = "Aprovado.";
        try {
            assertEquals(resultadoEsperado, avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
