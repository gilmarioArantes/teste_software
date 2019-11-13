package br.com.gilmar;

import org.junit.Test;

import static org.junit.Assert.*;

public class AvaliacaoTest {
	
	private double nota1;
	private double nota2;
	private int faltas;
	private int cargaHoraria;
	private String resultadoEsperado;
	private Avaliacao avaliacao = new Avaliacao();
/*	
	@Test
	public void testaValoresInvalidos1(){
		nota1 = -1;
		nota2 = 0;
		faltas = 17;
		cargaHoraria = 64;
		resultadoEsperado = "Valores Inválidos.";
		assertEquals(resultadoEsperado,avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
	}
	
	@Test
	public void testaReprovacaoPorFalta(){
		nota1 = 7;
		nota2 = 8;
		faltas = 17;
		cargaHoraria = 64;
		resultadoEsperado = "Reprovado por Falta.";
		assertEquals(resultadoEsperado,avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
	}
	
	@Test
	public void testaReprovacaoPorMedia(){
		nota1 = 1;
		nota2 = 4;
		faltas = 5;
		cargaHoraria = 64;
		resultadoEsperado = "Reprovado por Média.";
		assertEquals(resultadoEsperado,avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
	}
	
	@Test
	public void testaProvaExtraLimiteSuperior(){
		nota1 = 5.99;
		nota2 = 6;
		faltas = 5;
		cargaHoraria = 64;
		resultadoEsperado = "Prova Extra.";
		assertEquals(resultadoEsperado,avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
	}
	
	@Test
	public void testaProvaExtraLimiteInferior(){
		nota1 = 3.01;
		nota2 = 3.01;
		faltas = 5;
		cargaHoraria = 64;
		resultadoEsperado = "Prova Extra.";
		assertEquals(resultadoEsperado,avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
	}
	
	@Test
	public void testaAprovacao(){
		nota1 = 6.00;
		nota2 = 6.00;
		faltas = 5;
		cargaHoraria = 64;
		resultadoEsperado = "Aprovado.";
		assertEquals(resultadoEsperado,avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
	}
*/	
	@Test(expected = ValoresInvalidosException.class)
	public void testaValorMaiorQue10() throws ValoresInvalidosException{
		nota1 = 16.00;
		nota2 = 6.00;
		faltas = 5;
		cargaHoraria = 64;
		//resultadoEsperado = "Valores Inválidos.";
		assertEquals(resultadoEsperado,avaliacao.avalia(nota1, nota2, faltas, cargaHoraria));
	}
	
	@Test(expected = ArithmeticException.class)
	public void testaDivisaoPorZero() throws ArithmeticException{
		int n1 = 2;
		int n2 = 0;
		double result = n1 /n2;
	}
	
}
