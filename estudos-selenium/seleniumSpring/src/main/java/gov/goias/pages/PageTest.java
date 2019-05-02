package gov.goias.pages;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PageTest extends SeleniumTestCase{
    @Autowired
    private Site site;

    @Test
    public void test() {
        AccountPage accountPage = site.gotoAccountPage();
        accountPage.firstName("Peter").lastName("Kedemo").submit();
    }
}
