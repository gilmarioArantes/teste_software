package gov.goias.paginas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.net.URI;

public class PaginaLogin {
    /**
     * Todos os elementos testados na página de login do portal são identificados pela anotação @FindBy
     */

    /**
     * Driver do selenium, responsável pela localização dos elementos constantes da página.
     */
    private final WebDriver driver;

    /**
     * Endereço para a página de login no portal
     */
    private final URI urlPortal;

    /**
     * Campo de texto que representa o nome do usuário
     */
    @FindBy(id="username")
    WebElement username;

    /**
     * Campo de texto que representa a senha do usuário
     */
    @FindBy(id="password")
    WebElement password;

    /**
     * Botão para disparar a operação de login
     */
    @FindBy(css="button[name=\"submit\"]")
    WebElement botaoEntrar;

    /**
     * Elemento de texto utilizado no teste para validar o carregamento da página.
     */
    @FindBy(linkText="Cadastro")
    WebElement cadastro;

    /**
     * Construtor da página recebendo o driver como parâmetro.
     * @param driver
     */
    public PaginaLogin(WebDriver driver, URI urlPortal){
        this.driver = driver;
        this.urlPortal = urlPortal;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);
        driver.get(urlPortal.toString());
    }

    /**
     * Obtem o campo username para validação do carregamento correto da página.
     * @return
     */
    public String getCadastro(){
        return cadastro.getText();
    }

    /**
     * Método definido para informar o nome do usuário
     * @param strUserName
     */
    public void setNomeUsuario(String strUserName){
        username.sendKeys(strUserName);
    }

    /**
     * Método definido para informar a senha
     * @param strPassword
     */
    public void setSenha(String strPassword){
        password.sendKeys(strPassword);
    }

    /**
     * Método definido para clicar no botão que invoca a operação de login
     */
    public void clicaBotaoEntrar(){

        botaoEntrar.click();
    }

    /**
     * Método definido para efetivar a operação de login.
     * @param strNomeUsuario
     * @param strSenha
     */
    public PaginaPortal logar(String strNomeUsuario, String strSenha){
        //preenche o nome do usuário
        this.setNomeUsuario(strNomeUsuario);

        //preenche a senha
        this.setSenha(strSenha);

        //clica no botão entrar
        this.clicaBotaoEntrar();

        return new PaginaPortal(driver);

    }
}
