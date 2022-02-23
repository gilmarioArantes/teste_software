package br.gov.goias.intra.driversTeste.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class SeleniumChromeWebDriver extends SeleniumWebDriver{

    public WebDriver getDriver(String url) throws IOException {
        System.setProperty("webdriver.chrome.driver", url);
        driver = new ChromeDriver();
        return driver;
    }


}
