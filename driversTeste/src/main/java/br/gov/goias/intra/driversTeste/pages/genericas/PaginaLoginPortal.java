package br.gov.goias.intra.driversTeste.pages.genericas;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Classe definida para encapsular os elementos de interação do sistema
 * com usuário, por ocasião do seu login no portal de sistemas da SEGPLAN.
 */
@Log4j
public class PaginaLoginPortal extends PaginaInicial {

    @FindBy(how = How.ID, using = "Login")
    private WebElement userName;

    @FindBy(how = How.ID, using = "Senha")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    private WebElement loginButton;

    String urlBase = "http://sggteste.intra.goias.gov.br/";

    /**
     * Construtor parametrizado com o selenium webdriver.
     * @param driver
     */
    public PaginaLoginPortal(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    /**
     * Método definido para se acessar a página de login do portal.
     */
    public void goToPortalPage(){
        try{
            driver.get(urlBase);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Método definido para preencher os campos username e password,
     * previamente capturados pelo selenium webdriver.
     * @param usuario
     * @param senha
     */
    public void loginPortal(String usuario, String senha){
        writeText(userName, usuario);
        writeText(password, senha);
        click(loginButton);
        liberaTour();
    }

    /**
     * Método definido para capturar o elemento "Bem-vindos" da página
     * inicial do portal, como garantia do sucesso do login.
     * @return
     */
    public boolean capturaElementoPaginaInicial(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[4]/div/div/h1")));
        WebElement elemento = driver.findElement(By.xpath("/html/body/div[3]/div/div[4]/div/div/h1"));
        return elemento != null;
    }

    /**
     * Método definido para efetuar a liberação do tour.
     */
    public void liberaTour(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Use-o!')]")));
        WebElement tour = driver.findElement(By.xpath("//a[contains(text(),'Use-o!')]"));
        if(tour != null){
            tour.click();
        }
    }
}
