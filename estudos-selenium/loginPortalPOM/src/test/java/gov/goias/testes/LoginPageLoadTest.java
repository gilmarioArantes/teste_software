package gov.goias.testes;

import gov.goias.pages.PaginaLoginPortal;
import gov.goias.util.InstanciaDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginPageLoadTest {

    /**
     * Driver do selenium responsável por encontrar os elementos da página em teste.
     */
    WebDriver driver;

    /**
     * Classe responsável pela configuração do driver.
     */
    InstanciaDriver id;

    /**
     * Página de Login a ser testada.
     */
    PaginaLoginPortal paginaLoginPortal;

    /**
     * Configurações iniciais antes do teste.
     */
    @Before
    public void setUp(){
        id = new InstanciaDriver();
        /**
         * configura as propriedades do driver.
         */
        driver = id.getDriver();
        if(driver != null){
            driver.get("https://testeap.intra.goias.gov.br/pas-acesso-app/");
        }else{
            System.out.println("The driver is null");
        }
    }

    @Test
    public void validaCarregamentoPagina(){
        /**
         * cria uma instância da página de login.
         */
        paginaLoginPortal = new PaginaLoginPortal(driver);

        String cadastro = paginaLoginPortal.getCadastro();

        assertTrue(cadastro.toLowerCase().contains("cadastro"));

    }

    @After
    public void encerraDriver(){
        if(driver != null){
            driver.quit();
        }
    }

}
