package gov.goias.util.driver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DriverManagerFactory {

    @Autowired
    @Qualifier("ChromeDriverManager")
    private DriverManager chromeDriverManager;

    public DriverManager getManager(Browser browser){
        DriverManager driverManager;
        switch (browser){
            case CH:
                chromeDriverManager.initializeDriver();
                driverManager = chromeDriverManager;
                break;
            default:
                //todo rest of browsers
                driverManager = null;
        }
        return driverManager;
    }
}
