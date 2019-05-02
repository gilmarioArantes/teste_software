package gov.goias.testes;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import gov.goias.paginas.PaginaLogin;
import gov.goias.paginas.PaginaPortal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TesteLogin extends AbstractTest{

    /**
     * Página de Login a ser testada.
     */
    PaginaLogin paginaLogin;
    PaginaPortal paginaPortal;


    //@Before
    //@cucumber.api.java.Before
    @Dado("que o usuario acesse a página de login do portal")
    public void setUp(){
//        super.setUp();
        paginaLogin = new PaginaLogin(getDriver(), getUrlPortal());
    }

    //@Test
    @Quando("ele informar seu nome de usuario e senha")
    public void logar(){
        /**
         * Loga no portal
         */
        try{
            paginaPortal = paginaLogin.logar("gilmararantes", "gfa2706");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Teste do lgin
     */
    //@Test
    @Entao("a página de sistemas do portal é apresentada.")
    public void loginTeste(){
        /**
         * Página de sistemas do usuário, para onde é direcionado se o login for bem sucedido.
         */
        //PaginaPortal paginaPortal;
        /**
         * Navega para a página de sistemas do portal
         */
        //paginaPortal = new PaginaPortal(getDriver());

        /**
         * Valida o elemento da página, que tem o nome: sistemas
         */
        assertTrue(paginaPortal.getElementoPagina().toLowerCase().contains("sistemas"));
        //assertTrue(true);

    }

    public void tearDown(){
        super.tearDown();
    }

}
