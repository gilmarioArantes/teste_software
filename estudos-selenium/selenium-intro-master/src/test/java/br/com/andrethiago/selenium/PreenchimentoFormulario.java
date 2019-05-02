package br.com.andrethiago.selenium;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class PreenchimentoFormulario {
	
	@Test
	public void preencheFormularioCorreiosBuscaLogradouroPorBairro() {

        System.setProperty("webdriver.chrome.driver", "/home/gilmario/workspaces/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		// Visita a página do Correios
		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/buscaLogBairro.cfm");
		
		// Escolhe o valor de UF
		Select selectUF = new Select(driver.findElement(By.name("UF")));
		selectUF.selectByVisibleText("RJ");
		// Preenche a Localidade com o valor "Rio de Janeiro"
		WebElement inputLocalidade = driver.findElement(By.name("Localidade"));
		inputLocalidade.sendKeys("Rio de Janeiro");
		// Preenche o campo Bairro com o valor "Copacabana"
		WebElement inputBairro = driver.findElement(By.name("Bairro"));
		inputBairro.sendKeys("Copacabana");
		
		// clica no botão Buscar
		WebElement buttonBuscar = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonBuscar.click();
		
		// verifica se há resultados
		String codigoPagina = driver.getPageSource();
		assertThat(codigoPagina, Matchers.containsString("DADOS ENCONTRADOS COM SUCESSO."));
		assertNotNull(driver.findElement(By.cssSelector("table.tmptabela")));
		try {
            Thread.sleep(10000);
            driver.quit();
        }catch(InterruptedException ie){
		    ie.printStackTrace();
        }
	}
}
