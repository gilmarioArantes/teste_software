package pages.genericas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Mensagem;

public class PaginaInclusao extends PaginaInicial {

    @FindBy(how = How.XPATH, using = ".//*[@id='formularioPadrao'/div[3/div/div[1/button")
    private WebElement caixaSelecaoDominio;

    @FindBy(how = How.XPATH, using = ".//*[@id='divIndicador'/div/div/div[1/button")
    private WebElement caixaSelecaoIndicador;

    @FindBy(how = How.XPATH, using = ".//*[@id='divComboPrograma'/div/div/div[1/button")
    private WebElement caixaSelecaoPrograma;

    public PaginaInclusao(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selecionaDominio(String dominio) {
        wait.until(ExpectedConditions.visibilityOf(caixaSelecaoDominio));
        caixaSelecaoDominio.click();
        WebElement valorDominio;
        try{
            valorDominio = driver.findElement(By.linkText(dominio));
            valorDominio.click();
        } catch (Exception e){
            log.error(Mensagem.getMensagemElementoNaoEncontrado(dominio), e);
        }
    }

    public Boolean validaCaixaDominioDesabilitada() {
        if (caixaSelecaoDominio.isSelected()) {
            result = true;
        }
        return result;
    }


    public void selecionaIndicador(String nomeIndicador) {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(nomeIndicador)));
            WebElement indicador = driver.findElement(By.linkText(nomeIndicador));
            indicador.click();
        }catch (Exception e){
            log.error(Mensagem.getMensagemElementoNaoEncontrado(nomeIndicador), e);
        }
    }

    public void adicionarIndicador(String nomeIndicador, String data, String valor) {
        wait.until(ExpectedConditions.visibilityOf(caixaSelecaoIndicador));
        caixaSelecaoIndicador.click();
        selecionaIndicador(nomeIndicador);
        informarDataMeta(data);
        informarValorMeta(valor);
        clicaBotaoAdicionar();
    }

    public void selecionaPrograma(String nomePrograma) {
        try{
            wait.until(ExpectedConditions.visibilityOf(caixaSelecaoPrograma));
            abrirCaixaSelecaoPrograma();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(nomePrograma)));
            WebElement Programa = driver.findElement(By.linkText(nomePrograma));
            Programa.click();
        }catch (Exception e){
            log.error(Mensagem.getMensagemElementoNaoEncontrado(nomePrograma), e);
        }
    }

    public void abrirCaixaSelecaoPrograma(){
        wait.until(ExpectedConditions.visibilityOf(caixaSelecaoPrograma));
        caixaSelecaoPrograma.click();
    }
}
