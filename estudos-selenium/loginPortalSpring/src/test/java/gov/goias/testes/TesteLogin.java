package gov.goias.testes;

import cucumber.api.java.pt.Dado;
import gov.goias.paginas.PaginaLogin;
import gov.goias.paginas.PaginaPortal;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TesteLogin extends AbstractTest{

    /**
     * Página de Login a ser testada.
     */
    PaginaLogin paginaLogin;

    /**
     * Página de sistemas do usuário, para onde é direcionado se o login for bem sucedido.
     */
    PaginaPortal paginaPortal;

    @Test
    public void loginTeste(){

        paginaLogin = new PaginaLogin(getDriver(), getUrlPortal());

        /**
         * Navega para a página de sistemas do portal
         */
        paginaPortal = new PaginaPortal(getDriver());

        /**
         * Loga no portal
         */
        paginaLogin.logar("gilmararantes", "gfa2706");
        /**
         * Valida que a página de sistemas do portal foi acessada corretamente.
         */
        assertTrue(paginaPortal.getElementoPagina().toLowerCase().contains("sistemas"));

    }

}
