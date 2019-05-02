package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.genericas.PaginaLoginPortal;
import utils.InstanciaDriver;

public class LoginPortalTest extends InstanciaDriver {

    @Test
    public void logarPortalTest(){
        PaginaLoginPortal plp = new PaginaLoginPortal(driver);
        String urlPortal = "http://sggteste.intra.goias.gov.br/";
        String userName = "gilmararantes";
        String password = "gfa2706";
        boolean result = plp.loginPortal(urlPortal, userName, password);
        Assert.assertTrue(result);
    }

}
