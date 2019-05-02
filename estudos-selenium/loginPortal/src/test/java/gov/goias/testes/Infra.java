/**
 * Classe definida para configurar e instanciar ao Webdriver do Selenium.
 * As classes que utilizarão o Webdriver, o receberão por injeção de dependência.
 */
package gov.goias.testes;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Configuration
public class Infra {

    /**
     * URL do portal, onde tudo começa.
     * @return
     * @throws Exception
     */
    @Bean
    public URI urlPortal() throws Exception{
        return new URI("https://testeap.intra.goias.gov.br/pas-acesso-app/");
    }

    /**
     * O Objeto Webdriver, que será a única instância utilizada durante uma seção de testes.
     * @return
     */
    @Bean
    public WebDriver driver() {
        WebDriver driver = null;
        try {
            URI urlPortal = urlPortal();
            configuraPropriedadesDriver();
            DesiredCapabilities dc = new DesiredCapabilities();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("/opt/google/chrome/google-chrome");
            //options.addArguments("--disable-captive-portal-bypass-proxy");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("test-type");
            options.addArguments("--disable-extensions");
            options.addArguments("-incognito");
            options.addArguments("--start-maximized");
            dc.setCapability(ChromeOptions.CAPABILITY, options);
            //configuraProxy(urlPortal.toString(), dc);
            driver = new ChromeDriver(dc);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    /**
     * Configurações do arquivo e do ambiente em que os testes serão executados.
     */
    private void configuraPropriedadesDriver(){
        String tipoDriver = "webdriver.chrome.driver";
        String localDriver = "src/test/resources/chromedriver";
        System.setProperty(tipoDriver,localDriver);
    }

    /**
     * Configurações de exceção de proxy.
     * @param urlTeste
     * @param dc

    private static void configuraProxy(String urlTeste, DesiredCapabilities dc){
        String proxyHost = "proxy.goias.gov.br";
        String proxyPort = "2303";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyHost+":"+proxyPort);
        proxy.setSocksUsername("SEGPLAN\\gilmar-fa");
        proxy.setSocksPassword("F38GTeno");
        //proxy.setNoProxy(urlTeste);
        dc.setCapability(CapabilityType.PROXY,proxy);
    }
     */
}
