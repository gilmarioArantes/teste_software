package pages.genericas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Mensagem;

public class PaginaAlteracaoExclusao extends PaginaInicial {

    private PaginaConfirmacaoExclusao pce;

    private PaginaConsulta pc;

    @FindBy(how = How.XPATH, using = "//option[@value='EM_ANDAMENTO'")
    private WebElement emAndamento;

    @FindBy(how = How.XPATH, using = "//option[@value='CONCLUÍDO'")
    private WebElement concluido;

    @FindBy(how = How.XPATH, using = "//option[@value='ABERTO'")
    private WebElement aberto;

    @FindBy(how = How.XPATH, using = "//option[@value='CANCELADO'")
    private WebElement cancelado;

    @FindBy(how = How.XPATH, using = "//option[@value='RESOLVIDO'")
    private WebElement resolvido;

    @FindBy(how = How.ID, using = "DescricaoMotivoSituacao")
    private WebElement descricaoSituacao;

    @FindBy(how = How.ID, using = "btnExcluir")
    private WebElement botaoExcluir;

    @FindBy(how = How.ID, using = "Situacao")
    private WebElement caixaSelecaoSituacao;

    @FindBy(how = How.ID, using = "dataSituacao")
    private WebElement dataSituacao;

    public PaginaAlteracaoExclusao(WebDriver driver){
        super(driver);
        pc = new PaginaConsulta(driver);
        pce = new PaginaConfirmacaoExclusao(driver);
        PageFactory.initElements(driver, this);
    }

    public void alteraDescricao(String descricaoAlterada) throws InterruptedException{
        setDescricao(descricaoAlterada);
        salvar();
    }

    public void alteraNome(String nomeAlterado) throws InterruptedException{
        setNome(nomeAlterado);
        salvar();
    }

    public void excluir() throws InterruptedException{
        clicaBotaoExcluir();
        //driver.switchTo().window(pce.toString());
        pce.confirmaExclusao();
    }

    public void clicaBotaoExcluir() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoExcluir));
        botaoExcluir.click();
    }

    public Boolean excluirFalha() {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnExcluir")));
            WebElement botaoExcluir = driver.findElement(By.id("btnExcluir"));
            if (botaoExcluir.isEnabled()) {
                result = true;
            }
        }catch (Exception e){
            log.error(Mensagem.getMensagemElementoNaoEncontrado("btnExcluir"));
            return result;
        }
        return result;
    }

    public Boolean validaCampoDominioHabilitado() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DominioGovernanca_Nome")));
            WebElement dominio = driver.findElement(By.id("DominioGovernanca_Nome"));
            if (!dominio.getAttribute("readonly").contains("true")) {
                result = true;
            }
        }catch (Exception e) {
            log.error(Mensagem.getMensagemElementoNaoEncontrado("Domínio"));
        }

        return result;
    }

    public void alterarSituacao() throws InterruptedException{
        Thread.sleep(1000);
        setSituacao();
        salvar();
    }

    public void removerIndicador(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3/div[2/div/div/div[3/div")));
            WebElement indicadorRemover = driver.findElement(By.xpath("//div[3/div[2/div/div/div[3/div"));
            indicadorRemover.click();
            clicaBotaoRemover();
        } catch (Exception e) {
            log.error(Mensagem.getMensagemElementoNaoEncontrado("Indicador para Remoção"));
        }
    }


    public void setDataSituacao(String data){
        wait.until(ExpectedConditions.visibilityOf(dataSituacao));
        dataSituacao.clear();
        dataSituacao.sendKeys(data);
    }

    public void setDescricaoSituacao(String descricao){
        wait.until(ExpectedConditions.visibilityOf(descricaoSituacao));
        descricaoSituacao.clear();
        descricaoSituacao.sendKeys(descricao);
    }

    public void selecionaSituacaoAberto(){
        wait.until(ExpectedConditions.visibilityOf(caixaSelecaoSituacao));
        caixaSelecaoSituacao.click();
        aberto.click();
    }

    public void selecionaSituacaoCancelado(){
        wait.until(ExpectedConditions.visibilityOf(caixaSelecaoSituacao));
        caixaSelecaoSituacao.click();
        cancelado.click();
    }

    public void selecionaSituacaoResolvido(){
        wait.until(ExpectedConditions.visibilityOf(caixaSelecaoSituacao));
        caixaSelecaoSituacao.click();
        resolvido.click();
    }

    public void selecionaSituacaoEmAndamento(){
        wait.until(ExpectedConditions.visibilityOf(caixaSelecaoSituacao));
        caixaSelecaoSituacao.click();
        emAndamento.click();
    }

    public void selecionaSituacaoConcluido(){
        wait.until(ExpectedConditions.visibilityOf(caixaSelecaoSituacao));
        caixaSelecaoSituacao.click();
        concluido.click();
    }
}
