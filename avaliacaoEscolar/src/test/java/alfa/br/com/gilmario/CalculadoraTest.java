package alfa.br.com.gilmario;

import org.junit.Test;

import alfa.br.com.gilmario.modelo.Calculadora;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

public class CalculadoraTest {
	
	int a;
	int b;
	int resultado;
	Calculadora calculadora = new Calculadora();
	
	
	@Test
	public void testaSoma(){
		a = 2;
		b = 3;
		resultado = a + b;
		Assert.assertEquals(resultado, calculadora.soma(a,b));
	}
	
	@Test
	public void testaSubtracao(){
		a = 15;
		b = 10;
		resultado = a - b;
		Assert.assertEquals(resultado, calculadora.subtracao(a,b));
	}
	
	@Test
	public void testaMultiplicacao(){
		a = 5;
		b = 5;
		resultado = a * b;
		Assert.assertEquals(resultado, calculadora.multiplicacao(a,b));
	}
	
	@Test
	public void testaDivisao(){
		a = 15; //numerador
		b = 5;  //denominador
		resultado = a / b;
		
		Assert.assertEquals(resultado, calculadora.divisao(a,b));
	}
	
	@Test(expected = ArithmeticException.class)
	public void testaDivisaoPorZeroCapturaExcecao() throws ArithmeticException{
		a = 15; //numerador
		b = 0;  //denominador
		Assert.assertEquals(resultado, calculadora.divisao(a,b));
	}
	@Test
	public void testaDivisaoPorZero() {
		a = 15; //numerador
		b = 0;  //denominador
		try {
			Assert.assertEquals(resultado, calculadora.divisao(a,b));
		} catch (Exception e) {
			assertTrue(e instanceof ArithmeticException);
		}
	}
}
