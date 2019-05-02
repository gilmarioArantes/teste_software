package pages.genericas;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SuperPagina {
    protected WebDriver driver;
    protected PaginaInclusao pi;
    protected PaginaConsulta pc;
    protected PaginaAlteracaoExclusao pae;
    protected WebDriverWait wait;

    protected static Logger log = Logger.getLogger(SuperPagina.class);

    public SuperPagina(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver,30);
        pi = new PaginaInclusao(driver);
        pc = new PaginaConsulta(driver);
        pae = new PaginaAlteracaoExclusao(driver);
    }

}
