package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class InstanciaDriver {

    protected static Logger log = Logger.getLogger(InstanciaDriver.class);

    public static WebDriver driver;

    protected WebDriverWait wait;

/*
    public InstanciaDriver(){
        if(driver == null){
            initializeBrowser();
        }
    }
*/
    @BeforeSuite
    public void initializeBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,30);
    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}
