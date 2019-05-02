package org.example.webapp.integration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class ITConfig {

    @Autowired
    private Environment env;

    @Bean
    public WebDriver webDriver() throws MalformedURLException {
        setSystemProperties();
        //return new RemoteWebDriver(getRemoteUrl(), getFirefoxDesiredCapabilities());
        return new ChromeDriver();
    }

    private DesiredCapabilities getFirefoxDesiredCapabilities() {
        return DesiredCapabilities.firefox();
    }

    private DesiredCapabilities getGoogleChromeDesiredCapabilities() {
        return DesiredCapabilities.chrome();
    }

    private URL getRemoteUrl() throws MalformedURLException{
        return new URL("http://localhost:4445/wd/hub");
    }

    private String getDriverProperties(){
        return "webdriver.chrome.driver";
    }

    private String getDriverUrl(){
        return "/home/gilmario/workspaces/drivers/chromedriver";
    }

    private void setSystemProperties(){
        System.setProperty(getDriverProperties(), getDriverUrl());
    }
}
