package gov.goias.testes;

import gov.goias.paginas.PaginaLogin;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TesteCarregamentoPaginaLogin extends AbstractTest{

    /**
     * Página de Login a ser testada.
     */
    PaginaLogin paginaLogin;


    @Test
    public void validaCarregamentoPagina(){
        /**
         * cria uma instância da página de login.
         */
        paginaLogin = new PaginaLogin(getDriver(), getUrlPortal());

        String cadastro = paginaLogin.getCadastro();

        assertTrue(cadastro.toLowerCase().contains("cadastro"));

    }

}
