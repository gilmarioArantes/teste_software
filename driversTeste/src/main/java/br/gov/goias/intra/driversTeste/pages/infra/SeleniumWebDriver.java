package br.gov.goias.intra.driversTeste.pages.infra;

import lombok.Data;
import org.openqa.selenium.WebDriver;

@Data
public abstract class SeleniumWebDriver {

    protected WebDriver driver;

    public abstract WebDriver getDriver(String browser);
}
