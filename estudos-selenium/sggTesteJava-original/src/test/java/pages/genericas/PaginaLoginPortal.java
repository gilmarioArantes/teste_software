package pages.genericas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaginaLoginPortal extends SuperPagina {

    @FindBy(how = How.ID, using = "Login")
    private WebElement userName;

    @FindBy(how = How.ID, using = "Senha")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    private WebElement loginButton;

    public PaginaLoginPortal(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //este método é utilizado por aplicações dotNet
    public boolean loginPortal(String url, String usuario, String senha){
        driver.get(url);
        userName.sendKeys(usuario);
        password.sendKeys(senha);
        loginButton.click();
        liberaTour();
        return capturaElementoPaginaInicial();
    }

    public boolean capturaElementoPaginaInicial(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[4]/div/div/h1")));
        WebElement elemento = driver.findElement(By.xpath("/html/body/div[3]/div/div[4]/div/div/h1"));
        return elemento != null;
    }

    public void liberaTour(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Use-o!')]")));
        WebElement tour = driver.findElement(By.xpath("//a[contains(text(),'Use-o!')]"));
        if(tour != null){
            tour.click();
        }
    }
}
