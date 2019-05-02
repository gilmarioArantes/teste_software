package gov.goias.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class Site {

    @Autowired
    private WebDriver driver;

    @Autowired
    private AccountPage accountPage;

    public AccountPage gotoAccountPage() {
        driver.get("http://localhost/account.html");
        return accountPage;
    }
}
