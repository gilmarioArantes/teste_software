package gov.goias.util;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class InstanciaDriver {

    private static WebDriver driver;
    private String nomeDriver;
    private String urlDriver;
    private String urlPortal;

    public InstanciaDriver() {
        nomeDriver = "webdriver.chrome.driver";
        urlDriver = "/home/gilmario/workspaces/drivers/chromedriver";
        urlPortal = "https://testeap.intra.goias.gov.br/pas-acesso-app/";
        System.setProperty(nomeDriver, urlDriver);
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
  //      configuraProxy(urlPortal, dc);
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
/*
    private void configuraProxy(String urlTeste, DesiredCapabilities dc) {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("proxy.goias.gov.br:2303");
        proxy.setNoProxy(urlTeste);
        dc.setCapability(CapabilityType.PROXY, proxy);
    }
*/
    public WebDriver getDriver(){
        return driver;
    }
}
