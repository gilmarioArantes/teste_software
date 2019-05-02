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

    @Bean
    public URI urlPortal() throws Exception{
        return new URI("https://testeap.intra.goias.gov.br/pas-acesso-app/");
    }

    @Bean
    public WebDriver driver() {
        WebDriver driver = null;
        try {
            URI urlPortal = urlPortal();
            configuraPropriedadesDriver();
            DesiredCapabilities dc = new DesiredCapabilities();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("test-type");
            options.addArguments("--disable-extensions");
            options.addArguments("-incognito");
            configuraProxy(urlPortal.toString(), dc);
            dc.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(dc);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }


    private void configuraPropriedadesDriver(){
        String tipoDriver = "webdriver.chrome.driver";
        String localDriver = "src/test/resources/chromedriver";
        System.setProperty(tipoDriver,localDriver);
    }

    private static void configuraProxy(String urlTeste, DesiredCapabilities dc){
        String proxyHost = "proxy.goias.gov.br";
        String proxyPort = ":2303";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyHost+proxyPort);
        proxy.setNoProxy(urlTeste);
        dc.setCapability(CapabilityType.PROXY,proxy);
    }

}
