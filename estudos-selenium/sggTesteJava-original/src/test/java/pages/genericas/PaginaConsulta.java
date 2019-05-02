package pages.genericas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Mensagem;

public class PaginaConsulta extends PaginaInicial{

    @FindBy(how = How.CSS, using = "button.btn.btn-success")
    private WebElement botaoFiltrar;

    @FindBy(how = How.CSS, using = "button.btn.btn-default")
    private WebElement botaoLimpar;

    //@FindBy(how = How.LINK_TEXT, using = "Novo Item")
    //@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div[4]/div/div[1]/div/a")
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Novo Item')]")
    private WebElement botaoNovoItem;

    //@FindBy(how = How.XPATH, using = ".//*[@id='row0gridListagem'/div[2]/div")
    @FindBy(how = How.XPATH, using = "//div[@id='row0gridListagem']/div[2]/div")
    //@FindBy(how = How.XPATH, using = "//form[@id='formularioPadrao']/div[4]/label")
    //@FindBy(how = How.LINK_TEXT, using = "DOMINIO PARA TESTE AUTOMATIZADO")
    private WebElement primeiroElementoGrid;

    @FindBy(how = How.XPATH, using = ".//*[@id='row1gridListagem'/div[2]/div")
    private WebElement segundoElementoGrid;

    @FindBy(how = How.XPATH, using = ".//*[@id='containerfiltro'/div[1]/div/div/button")
    private WebElement caixaSelecaoDominio;

    @FindBy(how = How.XPATH, using = ".//*[@id='content'/h2/small")
    private WebElement identificadorPaginaConsulta;

    @FindBy(how = How.XPATH, using = ".//*[@id='divComboPrograma'/div/div/div/button")
    private WebElement caixaSelecaoPrograma;

    @FindBy(how = How.XPATH, using = ".//*[@id='divComboProjeto'/div/div/div/button")
    private WebElement caixaSelecaoProjeto;


    public PaginaConsulta(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void consultaIndividualParaAlteracaoExclusao(String subMenu, String nomeDominio, String valorCampoPesquisa) throws InterruptedException{
        if (dependeDominio(subMenu))
        {
            selecionaDominio(nomeDominio);
        }
        setNome(valorCampoPesquisa);
        filtrar();
        selecionaElementoGrid();
    }

    public void clicaBotaoNovoItem() throws InterruptedException{
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Novo Item")));
        //WebElement botaoNovoItem = driver.findElement(By.linkText("Novo Item"));
        botaoNovoItem.click();
    }

    public void selecionaElementoGrid() throws InterruptedException{
        Thread.sleep(1000);
        primeiroElementoGrid.click();
    }

    public void filtrar() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoFiltrar));
        botaoFiltrar.click();
    }

    public void limpar() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoLimpar));
        botaoLimpar.click();
    }

    public Boolean validaGridComUmElemento(String nomeObjeto) {
        wait.until(ExpectedConditions.visibilityOf(primeiroElementoGrid));
        if (primeiroElementoGrid.getText().contains(nomeObjeto))
        {
            result = true;
        }else{
            log.error("Primeiro elemento da grid não contém o nome informado.");
        }
        return result;
    }

    public void selecionaDominio(String dominio){
        try{
            wait.until(ExpectedConditions.visibilityOf(caixaSelecaoDominio));
            caixaSelecaoDominio.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(dominio)));
            WebElement valorDominio = driver.findElement(By.linkText(dominio));
            valorDominio.click();
        }catch (Exception e){
            log.error(Mensagem.getMensagemElementoNaoEncontrado(dominio), e);
        }
    }

    public Boolean validaTelaListagem(){
        if (identificadorPaginaConsulta.getText().contains("Listagem"))
        {
            result = true;
        }else{
            log.error("O elementonão contém o nome informado.");
        }
        return result;
    }

    public Boolean validaConteudoCampoNome(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Nome")));
            WebElement nome = driver.findElement(By.id("Nome"));
            if (nome.getText().equals("")) {
                result = true;
            }else{
                log.error("O Valor do campo nome não foi apagado após o clique no botão 'limpar'.");
            }
        }catch (Exception e) {
            log.error(Mensagem.getMensagemElementoNaoEncontrado("Campo Nome"), e);
        }
        return result;
    }

    public Boolean validaIndependenciaDominio(){
        try{
            wait.until(ExpectedConditions.visibilityOf(caixaSelecaoDominio));
            caixaSelecaoDominio.click();
        }catch (Exception e){
            return result;
        }
        return result;
    }

    public void selecionaPrograma(String nomePrograma){
        try{
            wait.until(ExpectedConditions.visibilityOf(caixaSelecaoPrograma));
            caixaSelecaoPrograma.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(nomePrograma)));
            WebElement programa = driver.findElement(By.linkText(nomePrograma));
            programa.click();
        }catch (Exception e){
            log.error(Mensagem.getMensagemElementoNaoEncontrado(nomePrograma), e);
        }
    }

    public void selecionaProjeto(String nomeProjeto){
        try{
            wait.until(ExpectedConditions.visibilityOf(caixaSelecaoProjeto));
            caixaSelecaoProjeto.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(nomeProjeto)));
            WebElement projeto = driver.findElement(By.linkText(nomeProjeto));
            projeto.click();
        }catch (Exception e){
            log.error(Mensagem.getMensagemElementoNaoEncontrado(nomeProjeto), e);
        }
    }

}
