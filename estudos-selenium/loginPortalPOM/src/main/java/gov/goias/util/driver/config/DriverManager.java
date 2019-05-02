package gov.goias.util.driver.config;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public abstract class DriverManager {

    protected WebDriver webDriver;
    protected abstract void initializeDriver();

    protected void quitDriver(){
        if(webDriver != null){
            webDriver.quit();
        }
        webDriver = null;
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }
}
