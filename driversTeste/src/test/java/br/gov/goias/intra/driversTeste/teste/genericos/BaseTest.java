package br.gov.goias.intra.driversTeste.teste.genericos;

import br.gov.goias.intra.driversTeste.excecoes.BrowserException;
import br.gov.goias.intra.driversTeste.pages.infra.PageGenerator;
import br.gov.goias.intra.driversTeste.util.PropertiesReader;
import br.gov.goias.intra.driversTeste.util.SeleniumWebDriver;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

/**
 * Classe definida para ser uma base para as demais classes de teste.
 */
@Log4j
public class BaseTest {

    protected static Logger log = Logger.getLogger(BaseTest.class);

    protected static WebDriver driver;

    protected WebDriverWait wait;

    protected PageGenerator page;

    /**
     * Método definido para ser executado antes de todos os métodos, de
     * todas as classes de teste, cujo objetivo é sempre renovar a instância
     * de page, para a classe que responda aos métodos utilizados no teste.
     */
    @BeforeMethod
    public void methodLevelSetup(){
        //Instancia o objeto page
        page = new PageGenerator(driver);
    }

    /**
     * Método definido para executar as configurações necessárias antes
     * da execução dos testes.
     */
    @BeforeSuite
    public void setup(){
        String browser = null;
        try{
            browser = PropertiesReader.getBrowser();
            driver = new SeleniumWebDriver().getDriver(browser);
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver,15);
            driver.get("http://sggteste.intra.goias.gov.br/");
        }catch (BrowserException be){
            log.error("Erro ao obter a informação sobre o browse",be);
        }catch (IOException io){
            log.error("Erro ao obter a informação sobre o webdriver",io);
        }
    }

    /**
     * Método definido para fechar o driver selenium após a execução dos
     * testes.
     */
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}
