package br.gov.goias.intra.driversTeste.pages.genericas;

import br.gov.goias.intra.driversTeste.pages.infra.BasePage;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Mensagem;

/**
 * Classe definida para encapsular atributos e métodos que são compartilhados
 * (estão presentes em / são acessados por) várias classes (páginas) do sistema.
 */
@Log4j
public class PaginaInicial extends BasePage {

    protected WebDriverWait wait;
    protected Boolean result;

    //@FindBy(how =  How.LINK_TEXT, using = "Salvar")
    @FindBy(how =  How.ID, using = "btnBotaoSalvarNovo")
    private WebElement botaoSalvarNovo;

    @FindBy(how =  How.ID, using = "btnBotaoSalvarContinuar")
    private WebElement botaoSalvarContinuar;

    @FindBy(how =  How.ID, using = "Nome")
    WebElement campoNome;

    @FindBy(how =  How.ID, using = "Descricao")
    WebElement campoDescricao;

    @FindBy(how = How.CSS, using = "button.btn.btn-success")
    private WebElement botaoFiltrar;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Novo Item')]")
    private WebElement botaoNovoItem;

    @FindBy(how = How.XPATH, using = "//div[@id='row0gridListagem']/div[2]/div")
    private WebElement primeiroElementoGrid;

    @FindBy(how = How.XPATH, using = ".//*[@id='containerfiltro'/div[1]/div/div/button")
    private WebElement caixaSelecaoDominio;

    @FindBy(how = How.ID, using = "btnExcluir")
    private WebElement botaoExcluir;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div[4]/div/div[1]/div[2]/div/div[4]/a[2]")//@FindBy(how = How.CSS, using = "div.widget.containerConteudo")
    private WebElement botaoConfirmacaoExclusao;

    @FindBy(how = How.LINK_TEXT, using = "Voltar")
    private WebElement botaoVoltar;

    /**
     * Construtor parametrizado com o selenium webdriver.
     * @param driver
     */
    public PaginaInicial(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,30);
        result = false;
        this.driver = driver;
    }

    /**
     * Método definido para se clicar sobre o botão salvar, previamente
     * capturado pelo selenium webdriver.
     * @throws InterruptedException
     */
    public void salvarNovo() throws InterruptedException{
        log.info("salvar Sucesso");
        Thread.sleep(1000);
        click(botaoSalvarNovo);
    }

    /**
     * Método definido para se clicar sobre o botão salvar (alteração), previamente
     * capturado pelo selenium webdriver.
     * @throws InterruptedException
     */
    public void salvarContinuar() throws InterruptedException{
        log.info("salvar Sucesso");
        Thread.sleep(1000);
        click(botaoSalvarContinuar);
    }

    /**
     * Método definido para se clicar sobre o menu previamente capturado
     * pelo selenium webdriver.
     * @param nomeMenu
     * @throws InterruptedException
     */
    public void clicaMenu(String nomeMenu) throws InterruptedException{
        log.debug("Clicar no Menu e Submenu");
        try {
            Thread.sleep(1000);
            WebElement menu = driver.findElement(By.linkText(nomeMenu));
            click(menu);
        }catch (Exception e) {
            log.error(Mensagem.getMensagemElementoNaoEncontrado(nomeMenu), e);
            throw new InterruptedException(e.getMessage());
        }
    }

    /**
     * Método definido para se preencher o campo de texto (descrição), previamente
     * capturado pelo selenium webdriver.
     * @param valorCampoDescricao
     * @throws InterruptedException
     */
    public void setDescricao(String valorCampoDescricao) throws InterruptedException{
        Thread.sleep(1000);
        campoDescricao.clear();
        writeText(campoDescricao, valorCampoDescricao);
    }

    /**
     * Método definido para preencher o campo de texto (nome), previamente
     * capturado pelo selenium webdriver.
     * @param valorCampoNome
     * @throws InterruptedException
     */
    public void setNome(String valorCampoNome) throws InterruptedException{
        Thread.sleep(1000);
        campoNome.clear();
        writeText(campoNome, valorCampoNome);
    }

    /**
     * Método definido para avaliar se um objeto depende ou não do domínio.
     * @param subMenu
     * @return
     */
    public Boolean dependeDominio(String subMenu)
    {
        result = true;
        if (subMenu.equals("Domínio") || subMenu.equals("Unidade do Indicador"))
        {
            result = false;
        }
        return result;
    }

    /**
     * Método definido para validar a mensagem de sucesso disparada após
     * a execução de alguma operação.
     * @param mensagemSucesso
     * @return
     * @throws InterruptedException
     */
    public boolean validaMensagemSucesso(String mensagemSucesso) throws InterruptedException{
        Thread.sleep(2000);
        String textoElementoSucesso = driver.findElement(By.cssSelector(".notifyjs-segplan-base.notifyjs-segplan-success")).getText();
        return mensagemSucesso.equals(textoElementoSucesso);
    }

    /**
     * Método definido para validar a mensagem de erro disparada após
     * a execução de alguma operação.
     * @param mensagemErro
     * @return
     * @throws InterruptedException
     */
    public boolean validaMensagemErro(String mensagemErro) throws InterruptedException{
        Thread.sleep(2000);
        String textoElementoErro = driver.findElement(By.cssSelector(".notifyjs-segplan-base.notifyjs-segplan-error")).getText();
        return mensagemErro.equals(textoElementoErro);
    }

    /**
     * Método definido abrir o menu retrátil.
     */
    public void abreMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[1]/ul/li/a/i[1]")));
        WebElement botaoAbreMenu = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/ul/li/a/i[1]"));
        botaoAbreMenu.click();
    }

    /**
     * Método definido para efetuar a consulta individual de um objeto
     * para alteração ou exclusão.
     * @param subMenu
     * @param nomeDominio
     * @param valorCampoPesquisa
     * @throws InterruptedException
     */
    public void consultaIndividualParaAlteracaoExclusao(String subMenu, String nomeDominio, String valorCampoPesquisa) throws InterruptedException{
        if (dependeDominio(subMenu))
        {
            selecionaDominio(nomeDominio);
        }
        setNome(valorCampoPesquisa);
        filtrar();
        selecionaElementoGrid();
    }

    /**
     * Método definido para se clicar sobre o botão "Novo Item", previamente
     * capturado pelo selenium webdriver.
     * @throws InterruptedException
     */
    public void clicaBotaoNovoItem() throws InterruptedException{
        Thread.sleep(1000);
        click(botaoNovoItem);
    }

    /**
     * Método definido para se selecionar um elemento da grid, após uma
     * consulta.
     * @throws InterruptedException
     */
    public void selecionaElementoGrid() throws InterruptedException{
        Thread.sleep(1000);
        click(primeiroElementoGrid);
    }

    /**
     * Método definido para se clicar sobre o botão "Filtrar", após a
     * informação dos parâmetros de uma consulta.
     */
    public void filtrar() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoFiltrar));
        click(botaoFiltrar);
    }

    /**
     * Método definido para se selecionar um domínio para as operações
     * @param dominio
     */
    public void selecionaDominio(String dominio){
        try{
            wait.until(ExpectedConditions.visibilityOf(caixaSelecaoDominio));
            click(caixaSelecaoDominio);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(dominio)));
            WebElement valorDominio = driver.findElement(By.linkText(dominio));
            valorDominio.click();
        }catch (Exception e){
            log.error(Mensagem.getMensagemElementoNaoEncontrado(dominio), e);
        }
    }

    /**
     * Método definido para se alterar a descrição de algum objeto.
     * @param descricaoAlterada
     * @throws InterruptedException
     */
    public void alteraDescricao(String descricaoAlterada) throws InterruptedException{
        setDescricao(descricaoAlterada);
        holdPopUp(By.xpath("/html/body/div[9]/div/div[5]/a"));
        salvarContinuar();
        voltar();
    }

    /**
     * Método definido para se alterar o nome de algum objeto.
     * @param nomeAlterado
     * @throws InterruptedException
     */
    public void alteraNome(String nomeAlterado) throws InterruptedException{
        setNome(nomeAlterado);
        holdPopUp(By.xpath("/html/body/div[10]/div/div[5]/a"));
        salvarContinuar();
        voltar();
    }

    /**
     * Método definido para se excluir os dados cadastrais de algum objeto.
     * @throws InterruptedException
     */
    public void excluir() throws InterruptedException{
        botaoExcluir.click();
        confirmaExclusao();
    }

    /**
     * Método definido para se confirmar a exclusão dos dados cadastrais
     * de algum objeto.
     * @throws InterruptedException
     */
    public void confirmaExclusao() throws InterruptedException{
        Thread.sleep(1000);
        click(botaoConfirmacaoExclusao);
    }

    public void voltar() throws InterruptedException{
        Thread.sleep(1000);
        click(botaoVoltar);
    }
}
