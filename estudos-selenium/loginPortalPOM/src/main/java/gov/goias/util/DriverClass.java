package gov.goias.util;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author User
 */
public class DriverClass {

    private String baseUrl;
    private String driverPath;
    private String driverName;
    private static WebDriver driver;
    private static DriverClass driverClass;

    private DriverClass() {
        try {
            baseUrl     = "https://testeap.intra.goias.gov.br/pas-acesso-app/";
            driverPath  = "/home/gilmario/workspaces/drivers/chromedriver";
            driverName  = "webdriver.chrome.driver";

            //Set the location of the ChromeDriver
            System.setProperty(driverName, driverPath);
            //Create a new desired capability
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            // Create a new proxy object and set the proxy
            Proxy proxy = new Proxy();
            proxy.setHttpProxy("10.6.60.56:2303");
            proxy.setSocksUsername("admin");
            proxy.setSocksPassword("admin");
            //Add the proxy to our capabilities
            capabilities.setCapability("proxy", proxy);
            //Start a new ChromeDriver using the capabilities object we created and added the proxy to
            driver = new ChromeDriver(capabilities);

            //Navigation to a url and a look at the traffic logged in fiddler
            driver.navigate().to(baseUrl);


            //            System.setProperty(driverName, driverPath);
            //            driver = new ChromeDriver();
            //            driver.get(baseUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}