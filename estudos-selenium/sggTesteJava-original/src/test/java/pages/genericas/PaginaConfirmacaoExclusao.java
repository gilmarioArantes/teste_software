package pages.genericas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaginaConfirmacaoExclusao extends PaginaInicial{

    //@FindBy(how = How.XPATH, using = "(//a[contains(text(),'excluir')])[2]")
    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div[4]/div/div[1]/div[2]/div/div[4]/a[2]")
    //@FindBy(how = How.CSS, using = "div.widget.containerConteudo")
    private WebElement botaoConfirmacaoExclusao;

    public PaginaConfirmacaoExclusao(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void confirmaExclusao() throws InterruptedException{
        Thread.sleep(1000);
        botaoConfirmacaoExclusao.click();
    }
/*
    public Boolean validaMensagemErro(String mensagemErro) {
        if (getElementoErro().contains(mensagemErro)) {
            result = true;
        }else{
            log.error(Mensagem.getMensagemElementoNaoEncontrado("Mensagem de erro"));
            return result;
        }
        return result;
    }

    private String getElementoErro() {
        String mensagemErro = null;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notifyjs-segplan-base.notifyjs-segplan-error")));
            WebElement elementoErro = driver.findElement(By.cssSelector(".notifyjs-segplan-base.notifyjs-segplan-error"));
            mensagemErro = elementoErro.getText();
        } catch (Exception e){
            log.error(Mensagem.getMensagemElementoNaoEncontrado(mensagemErro));
        }
        return mensagemErro;
    }
*/
}
