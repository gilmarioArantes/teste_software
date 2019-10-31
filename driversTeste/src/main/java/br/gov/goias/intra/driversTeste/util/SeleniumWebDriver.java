package br.gov.goias.intra.driversTeste.util;

import lombok.Data;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

@Data
public class SeleniumWebDriver {

    protected final String OS = System.getProperty("os.name").toLowerCase();
    protected String url;
    protected WebDriver driver;

    public WebDriver getDriver(String browser) throws IOException {

        if(browser.equals("1")){
            url = OS.contains("win") ? PropertiesReader.getProp().getProperty("chromeDriverWindows") : PropertiesReader.getProp().getProperty("chromeDriverLinux");
            driver =  new SeleniumChromeWebDriver().getDriver(url);
        }else if(browser.equals("2")){
            url = OS.contains("win") ? PropertiesReader.getProp().getProperty("firefoxDriverWindows") : PropertiesReader.getProp().getProperty("firefoxDriverLinux");
            driver = new SeleniumFirefoxWebDriver().getDriver(url);
        }else if(browser.equals("3")){
            url = OS.contains("win") ? PropertiesReader.getProp().getProperty("operaDriverWindows") : PropertiesReader.getProp().getProperty("operaDriverLinux");
            driver = new SeleniumOperaWebDriver().getDriver(url);
        }else{
            url = PropertiesReader.getProp().getProperty("edgeDriver");
            driver = new SeleniumEdgeWebDriver().getDriver(url);
        }

        return driver;
    }
}
