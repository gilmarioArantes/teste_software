package br.gov.goias.intra.driversTeste.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumFirefoxWebDriver extends SeleniumWebDriver{

    @Override
    public WebDriver getDriver(String url) {
        System.setProperty("webdriver.gecko.driver", url);
        driver = new FirefoxDriver();
        return driver;
    }
}
