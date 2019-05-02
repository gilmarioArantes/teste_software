package gov.goias.testes;


import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public abstract class AbstractTest {

    @Autowired
    private URI siteBase;

    @Autowired
    private WebDriver driver;

    public URI getSiteBase() {
        return siteBase;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setUp(){
        getDriver().manage().deleteAllCookies();
        getDriver().get(siteBase.toString());
    }
}
