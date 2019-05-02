package gov.goias.testes;


import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Infra.class)

public abstract class AbstractTest {

    @Autowired
    private URI urlPortal;

    @Autowired
    private WebDriver driver;

    public URI getUrlPortal() {
        return urlPortal;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setUp(){
        getDriver().manage().deleteAllCookies();
        getDriver().get(urlPortal.toString());
    }

}
