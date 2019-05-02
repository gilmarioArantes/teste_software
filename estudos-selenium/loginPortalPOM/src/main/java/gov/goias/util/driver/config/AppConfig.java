package gov.goias.util.driver.config;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = "gov.goias")
public class AppConfig {

    @Bean
    @Lazy
    public ChromeDriver chromeDriver(DesiredCapabilities desiredCapabilities){
        System.setProperty("webdriver.chrome.driver", "/home/gilmario/worspaces/drivers/chromedriver");
        return new ChromeDriver(desiredCapabilities);
    }

    @Bean
    public DesiredCapabilities desiredCapabilities(){
        return new DesiredCapabilities();
    }

    @Bean
    public ChromeOptions chromeOptions(){
        return new ChromeOptions();
    }

    @Bean
    public LoggingPreferences loggingPreferences(){
        return new LoggingPreferences();
    }

    @Bean
    public DriverManagerFactory factory(){
        return new DriverManagerFactory();
    }

}
