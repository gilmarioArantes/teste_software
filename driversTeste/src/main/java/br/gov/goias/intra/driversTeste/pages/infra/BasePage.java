package br.gov.goias.intra.driversTeste.pages.infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Classe definida para encapsular de forma genérica os métodos para
 * clicar, ler e escrever texto nos elementos constantes das páginas
 * do sistema. E também, método para a manipulação de janelas popup.
 */
public class BasePage extends PageGenerator{

    /**
     * Construtor parametrizado com o driver do selenium.
     * @param driver
     */
    public BasePage(WebDriver driver){
        super(driver);
    }

    //If we need we can use custom wait in BasePage and all page classes
    WebDriverWait wait = new WebDriverWait(this.driver,20);

    /**
     * Método Click usando JAVA Generics (pode ser usado tanto "By" quanto
     * "Webelement")
     * @param elementAttr
     * @param <T>
     */
    public <T> void click(T elementAttr){
        if(elementAttr.getClass().getName().contains("By")){
            driver.findElement((By) elementAttr).click();
        }else{
            ((WebElement) elementAttr).click();
        }

    }

    /**
     * Método para escrita de texto usando JAVA Generics (pode ser usado tanto "By" quanto
     *      * "Webelement")
     * @param elementAttr
     * @param text
     * @param <T>
     */
    public <T> void writeText(T elementAttr, String text){
        if(elementAttr.getClass().getName().contains("By")){
            driver.findElement((By) elementAttr).sendKeys(text);
        }else{
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

    /**
     * Método para leitura de texto usando JAVA Generics (pode ser usado tanto "By" quanto
     * "Webelement")
     * @param elementAttr
     * @param <T>
     * @return
     */
    public <T> String readText(T elementAttr){
        if(elementAttr.getClass().getName().contains("By")){
            return driver.findElement((By) elementAttr).getText();
        }else{
            return ((WebElement) elementAttr).getText();
        }
    }


    /**
     * Método definido para efetuar o fechamento de janelas popup, caso
     * existam.
     * @param by
     * @throws InterruptedException
     */
    public void holdPopUp(By by) throws InterruptedException{
        List<WebElement> popup = driver.findElements(by);
        if(!popup.isEmpty()){
            popup.get(0).click();
            Thread.sleep(200);
        }
    }
}
