package pages.dominio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.genericas.SuperPagina;

public class PaginaDominio extends SuperPagina {

    @FindBy(how = How.ID, using = "Email")
    private WebElement campoEmail;

    public PaginaDominio(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean RN03(String funcionalidade){
        return pi.validaUsuarioSemPerfilAcessoFuncionalidade(funcionalidade);
    }

    public Boolean RN03A(String menu, String subMenu, String funcionalidade) throws InterruptedException{
        pi.clicaMenu(menu);
        pi.clicaMenu(subMenu);
        return pi.validaUsuarioSemPerfilAcessoFuncionalidade(funcionalidade);
    }

    protected void setEmail(String email){
        //wait.until(ExpectedConditions.visibilityOf(campoEmail));
        campoEmail.clear();
        campoEmail.sendKeys(email);
    }
}
