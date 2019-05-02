package pages.genericas;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Mensagem;


public class PaginaInicial {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Boolean result;

    protected final static Logger log = Logger.getLogger(PaginaInicial.class);

    @FindBy(how =  How.LINK_TEXT, using = "Salvar")
    private WebElement botaoSalvar;

    @FindBy(how =  How.LINK_TEXT, using = "cancelar")
    private WebElement botaoCancelar;

    @FindBy(how =  How.XPATH, using = ".//*[@ID='formularioPadrao'/div[2/div/label/div/div/span[2")
    private WebElement botaoSituacao;

    @FindBy(how =  How.ID, using = "Nome")
    WebElement campoNome;

    @FindBy(how =  How.ID, using = "Descricao")
    WebElement campoDescricao;

    @FindBy(how =  How.XPATH, using = "//btn[@type='button'")
    private WebElement botaoAdicionar;

    @FindBy(how =  How.XPATH, using = "//btn[2")
    private WebElement botaoRemover;

    @FindBy(how =  How.ID, using = "dataAbertura")
    private WebElement dataAbertura;

    @FindBy(how =  How.ID, using = "DataMeta")
    private WebElement campoDataMeta;

    @FindBy(how =  How.ID, using = "Objetivo")
    private WebElement campoObjetivo;

    @FindBy(how =  How.ID, using = "quantidade")
    private WebElement quantidade;

    @FindBy(how =  How.ID, using = "Titulo")
    private WebElement campoTitulo;

    @FindBy(how =  How.ID, using = "ValorMeta")
    private WebElement campoValorMeta;

    //protected final int tempoEspera = 1000;

    public PaginaInicial(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
        result = false;
        PageFactory.initElements(driver, this);
    }

    public void salvar() throws InterruptedException{
        log.debug("salvar Sucesso");
        //wait.until(ExpectedConditions.elementToBeClickable(botaoSalvar));
        Thread.sleep(1000);
        botaoSalvar.click();
    }

    public Boolean salvarFalha() {
        log.debug("Erro ao salvar");
        wait.until(ExpectedConditions.elementToBeClickable(botaoSalvar));
        if (botaoSalvar.isEnabled()){
            result = true;
        }
        return result;
    }

    public void cancelar(){
        log.debug("cancelar");
        wait.until(ExpectedConditions.elementToBeClickable(botaoCancelar));
        botaoCancelar.click();
    }

    public void setSituacao() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoSituacao));
        botaoSituacao.click();
    }


    public void clicaMenu(String nomeMenu) throws InterruptedException{
        log.debug("Clicar no Menu e Submenu");
        try {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(nomeMenu)));
            Thread.sleep(1000);
            WebElement menu = driver.findElement(By.linkText(nomeMenu));
            menu.click();
        }catch (Exception e) {
            log.error(Mensagem.getMensagemElementoNaoEncontrado(nomeMenu), e);
            throw new InterruptedException(e.getMessage());
        }
    }

    public void setDescricao(String valorCampoDescricao) throws InterruptedException{
        Thread.sleep(1000);
        campoDescricao.clear();
        campoDescricao.sendKeys(valorCampoDescricao);
    }

    public void setNome(String valorCampoNome) throws InterruptedException{
        Thread.sleep(1000);
        campoNome.clear();
        campoNome.sendKeys(valorCampoNome);
    }

    public Boolean validaUsuarioSemAcessoDominio(String Menu, String SubMenu) throws InterruptedException{
        clicaMenu(Menu);
        clicaMenu(SubMenu);
        result = validaMensagemUsuarioSemAcessoDominio();
        return result;
    }

    public Boolean validaMensagemUsuarioSemAcessoDominio() {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@ID='content'/div/div[2/div[1")));
            WebElement elementoMensagem = driver.findElement(By.xpath(".//*[@ID='content'/div/div[2/div[1"));
            String mensagem = elementoMensagem.getText();
            if (mensagem.contains("Usuário não possui nenhum domínio associado."))
            {
                log.info("Usuário não possui nenhum domínio associado.");
                result = true;
            }else{
                log.error("Mensagem de erro não confere!");
            }
        } catch (Exception e) {
            log.error("Usuário sem associação a qualquer domínio.", e);
            return result;
        }
        return result;
    }

    public Boolean validaUsuarioSemPerfilAcessoFuncionalidade(String menuFuncionalidade){
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(menuFuncionalidade)));
            WebElement menu = driver.findElement(By.linkText(menuFuncionalidade));
            menu.click();
            result = true;
        }catch (Exception e){
            log.error(Mensagem.getMensagemElementoNaoEncontrado(menuFuncionalidade) , e);
            return result;
        }
        return result;
    }

    public Boolean dependeDominio(String subMenu)
    {
        result = true;
        if (subMenu.equals("Domínio") || subMenu.equals("Unidade do Indicador"))
        {
            result = false;
        }
        return result;
    }

        /*
        public int getTempoEspera() {
            return tempoEspera;
        }
        */

    public void clicaBotaoAdicionar() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoAdicionar));
        botaoAdicionar.click();
    }

    public void clicaBotaoRemover(){
        wait.until(ExpectedConditions.elementToBeClickable(botaoRemover));
        botaoRemover.click();
    }

    public void setDataAbertura(String data){
        wait.until(ExpectedConditions.visibilityOf(dataAbertura));
        dataAbertura.clear();
        dataAbertura.sendKeys(data);
    }

    public void informarDataMeta(String data){
        wait.until(ExpectedConditions.visibilityOf(campoDataMeta));
        campoDataMeta.clear();
        campoDataMeta.sendKeys(data);
    }

    public void preencheCampoObjetivo(String objetivo){
        wait.until(ExpectedConditions.visibilityOf(campoObjetivo));
        campoObjetivo.clear();
        campoObjetivo.sendKeys(objetivo);
    }

    public void preencheCampoQuantidade(String valorQuantIDade){
        wait.until(ExpectedConditions.visibilityOf(quantidade));
        quantidade.clear();
        quantidade.sendKeys(valorQuantIDade);
    }

    public void setTitulo(String nomeTitulo){
        wait.until(ExpectedConditions.visibilityOf(campoTitulo));
        campoTitulo.clear();
        campoTitulo.sendKeys(nomeTitulo);
    }

    public void informarValorMeta(String valor){
        wait.until(ExpectedConditions.visibilityOf(campoValorMeta));
        campoValorMeta.clear();
        campoValorMeta.sendKeys(valor);
    }

    public boolean validaMensagemSucesso(String mensagemSucesso) throws InterruptedException{
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notifyjs-segplan-base.notifyjs-segplan-success")));
        Thread.sleep(2000);
        String textoElementoSucesso = driver.findElement(By.cssSelector(".notifyjs-segplan-base.notifyjs-segplan-success")).getText();
        return mensagemSucesso.equals(textoElementoSucesso);
    }

    public boolean validaMensagemErro(String mensagemErro) throws InterruptedException{
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notifyjs-segplan-base.notifyjs-segplan-error")));
        Thread.sleep(2000);
        String textoElementoErro = driver.findElement(By.cssSelector(".notifyjs-segplan-base.notifyjs-segplan-error")).getText();
        //String textoElementoErro = driver.findElement(By.cssSelector("div.notifyjs-segplan-base.notifyjs-segplan-success > div")).getText();
        return mensagemErro.equals(textoElementoErro);
    }

    public void abreMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[1]/ul/li/a/i[1]")));
        WebElement botaoAbreMenu = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/ul/li/a/i[1]"));
        botaoAbreMenu.click();
    }


}
