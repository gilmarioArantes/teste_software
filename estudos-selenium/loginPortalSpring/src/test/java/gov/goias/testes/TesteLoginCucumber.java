package gov.goias.testes;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import gov.goias.paginas.PaginaLogin;
import gov.goias.paginas.PaginaPortal;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TesteLoginCucumber extends AbstractTest{

    /**
     * Página de Login a ser testada.
     */
    PaginaLogin paginaLogin;

    /**
     * Página de sistemas do usuário, para onde é direcionado se o login for bem sucedido.
     */
    PaginaPortal paginaPortal;


    @Dado("que o usuario necessite logar no portal")
    public void setUp(){
        paginaLogin = new PaginaLogin(getDriver(), getUrlPortal());
    }

    @Quando("quando ele informar seu nome de usuario e senha")
    public void logar(){
        /**
         * Loga no portal
         */
        paginaLogin.logar("gilmararantes", "gfa2706");
    }

    /**
     * Teste do lgin
     */
    @Entao("o sistema carrega a página de sistemas do portal")
    public void loginTeste(){
        /**
         * Navega para a página de sistemas do portal
         */
        paginaPortal = new PaginaPortal(getDriver());

        /**
         * Valida o título da página
         */
        assertTrue(paginaPortal.getElementoPagina().toLowerCase().contains("sistemas"));

    }

}
