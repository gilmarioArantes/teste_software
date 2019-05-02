package gov.goias.util.driver.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class RunChrome {

    @Autowired
    DriverManagerFactory driverManagerFactory;

    DriverManager driverManager;

    @Before
    public void beforeTest(){
        driverManager = driverManagerFactory.getManager(Browser.CH);
    }

    @Test
    public void run(){
        driverManager.getWebDriver().get("http://www.google.com");
    }
}
