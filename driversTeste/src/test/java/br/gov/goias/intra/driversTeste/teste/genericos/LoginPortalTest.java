package br.gov.goias.intra.driversTeste.teste.genericos;

import br.gov.goias.intra.driversTeste.pages.genericas.PaginaLoginPortal;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Classe definida para se encapsular os métodos necessários para o teste
 * da operação de logar no portal de sistemas.
 */
public class LoginPortalTest extends BaseTest {

    /**
     * Método definido para se testar o login no portal de sistemas.
     */
    @Test
    public void logarPortalTest(){

        //acessar a página para logar no portal
        page.getInstance(PaginaLoginPortal.class).goToPortalPage();

        //Informar o usuário e senha
        page.getInstance(PaginaLoginPortal.class).loginPortal("gilmararantes","gfa2706");

        //Validar se o login foi bem sucedido
        Assert.assertTrue(page.getInstance(PaginaLoginPortal.class).capturaElementoPaginaInicial());
    }

}
