package gov.goias.paginas;


import org.openqa.selenium.NoSuchElementException;
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
     * Método definido para informar o nome do usuário
     * @param strUserName
     */
    private void setNomeUsuario(String strUserName) throws NoSuchElementException{
        if(username != null){
            username.sendKeys(strUserName);
        }else{
            throw new NoSuchElementException("Elemento [username] não encontrado.");
        }

    }

    /**
     * Método definido para informar a senha
     * @param strPassword
     */
    private void setSenha(String strPassword)throws NoSuchElementException{
        if(password != null){
            password.sendKeys(strPassword);
        }else{
            throw new NoSuchElementException("Elemento [password] não encontrado.");
        }

    }

    /**
     * Método definido para clicar no botão que invoca a operação de login
     */
    private void clicaBotaoEntrar() throws NoSuchElementException{
        if(botaoEntrar != null){
            botaoEntrar.click();
        }else{
            throw new NoSuchElementException("Elemento [botaoEntrar] não encontrado.");
        }
    }

    /**
     * Método definido para efetivar a operação de login.
     * @param strNomeUsuario
     * @param strSenha
     */
    public PaginaPortal logar(String strNomeUsuario, String strSenha) throws Exception{
        //preenche o nome do usuário
        Thread.sleep(1000);
        setNomeUsuario(strNomeUsuario);

        //preenche a senha
        Thread.sleep(1000);
        setSenha(strSenha);

        //clica no botão entrar
        Thread.sleep(1000);
        clicaBotaoEntrar();

        return new PaginaPortal(driver);

    }
}
