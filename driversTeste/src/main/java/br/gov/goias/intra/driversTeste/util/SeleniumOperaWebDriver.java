package br.gov.goias.intra.driversTeste.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SeleniumOperaWebDriver extends SeleniumWebDriver{
    @Override
    public WebDriver getDriver(String url) {
        System.setProperty("webdriver.opera.driver", url);
        driver = new OperaDriver();
        return driver;
    }
}
