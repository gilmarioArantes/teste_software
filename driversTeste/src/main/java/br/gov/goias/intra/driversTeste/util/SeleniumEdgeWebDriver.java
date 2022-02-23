package br.gov.goias.intra.driversTeste.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumEdgeWebDriver extends SeleniumWebDriver{

    public WebDriver getDriver(String url) {
        System.setProperty("webdriver.edge.driver", url);
        driver = new EdgeDriver();
        return driver;
    }
}
