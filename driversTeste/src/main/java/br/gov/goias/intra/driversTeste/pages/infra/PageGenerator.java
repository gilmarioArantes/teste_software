package br.gov.goias.intra.driversTeste.pages.infra;
//https://www.swtestacademy.com/page-factory-selenium-webdriver/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe definida para se comportar com um gerador de instâncias para
 * todas as classes que encapsulam as páginas do sistema.
 */
public class PageGenerator {

    protected WebDriver driver;

    /**
     * Construtor parametrizado com o selenium webdriver.
     * @param driver
     */
    public PageGenerator(WebDriver driver){

        this.driver = driver;

    }


    /**
     * Método definido para criar (usando Java Generics) e retornar uma
     * nova instância de uma página qualquer.
     * @param pageClass
     * @param <TPage>
     * @return
     */
    public <TPage extends  BasePage> TPage getInstance(Class<TPage> pageClass){
        try{
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver, pageClass);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
