package gov.goias.testes;

import gov.goias.pages.PaginaLoginPortal;
import gov.goias.pages.PaginaSistemasPortal;
import gov.goias.util.InstanciaDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class LoginPageTest {

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
     * Página de sistemas do usuário, para onde é direcionado se o login for bem sucedido.
     */
    PaginaSistemasPortal paginaSistemasPortal;

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

    /**
     * Teste do lgin
     */
    @Test
    public void loginTeste(){

        /**
         * cria uma instância da página de login.
         */
        paginaLoginPortal = new PaginaLoginPortal(driver);

        /**
         * Loga no portal
         */
        paginaLoginPortal.logar("gilmararantes", "gfa2706");

        /**
         * Navega para a página de sistemas do portal
         */
        paginaSistemasPortal = new PaginaSistemasPortal(driver);

        /**
         * Valida o título da página
         */
        assertTrue(paginaSistemasPortal.getElementoPagina().toLowerCase().contains("sistemas"));
    }

    @After
    public void encerraDriver(){
        if(driver != null){
            driver.quit();
        }
    }

}
