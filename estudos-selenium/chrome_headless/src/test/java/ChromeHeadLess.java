import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;


public class ChromeHeadLess {

    private WebDriver driver;

    private void configuraDriver(){
        System.setProperty("webdriver.chrome.driver",
                "/home/gilmario/workspaces/drivers/chromedriver");
    }

    private void instanciaDriverComInterfaceGrafica(){
        driver = new ChromeDriver();
    }

    private void instanciaDriverSemInterfaceGrafica(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
    }

    @Test
    public void TestaComInterfaceGrafica(){
        configuraDriver();
        instanciaDriverComInterfaceGrafica();
        preencheFormularioCorreiosBuscaLogradouroPorBairro();
        encerraDriver();
    }

    @Test
    public void TestaSemInterfaceGrafica(){
        configuraDriver();
        instanciaDriverSemInterfaceGrafica();
        preencheFormularioCorreiosBuscaLogradouroPorBairro();
        encerraDriver();
    }

    private void preencheFormularioCorreiosBuscaLogradouroPorBairro() {

        try{

            //visita a página dos correios
            Thread.sleep(5000);
            driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/buscaLogBairro.cfm");
            Thread.sleep(1000);
            Select selectUF = new Select(driver.findElement(By.name("UF")));
            selectUF.selectByVisibleText("RJ");
            Thread.sleep(1000);
            //Preenche a Localidade com o valor "Rio de Janeiro"
            WebElement inputLocalidade = driver.findElement(By.name("Localidade"));
            inputLocalidade.sendKeys("Rio de Janeiro");
            //Preenche o campo bairro com o valor "Copacabana"
            Thread.sleep(1000);
            WebElement inputBairro = driver.findElement(By.name("Bairro"));
            inputBairro.sendKeys("Copacabana");

            //Clica no botão Buscar
            Thread.sleep(1000);
            WebElement buttonBuscar = driver.findElement(By.cssSelector("input[type='submit'"));
            buttonBuscar.click();

            //Verifica se há resultados
            String codigoPagina = driver.getPageSource();
            Thread.sleep(5000);
            assertThat(codigoPagina, CoreMatchers.containsString("DADOS ENCONTRADOS COM SUCESSO"));
            Thread.sleep(5000);
            assertNotNull(driver.findElement(By.cssSelector("table.tmptabela")));
        }catch(Exception e){
            assertTrue(false);
        }
    }

    private void encerraDriver(){
        driver.quit();
    }
}
