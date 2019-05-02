package pages.dominio;

import org.openqa.selenium.WebDriver;

public class PaginaDominioConsulta extends PaginaDominio {

    public PaginaDominioConsulta(WebDriver driver){
        super(driver);
    }

    /*
    public Boolean ConsultaUmDominio(String menu, String subMenu, String nomeDominio){
        pi.clicaMenu(menu);
        pi.clicaMenu(subMenu);
        pc.consultaIndividualParaTeste(subMenu, nomeDominio, nomeDominio);
            return pc.validaGridComUmElemento(nomeDominio);
    }

    public Boolean ConsultaTodosDominios(String menu, String subMenu, String nomeDominio) {
        pi.clicaMenu(menu);
        pi.clicaMenu(subMenu);
        pc.consultaLista(subMenu, nomeDominio);
        return pc.validaGridComVariosElementos(nomeDominio);
    }
    */
}
