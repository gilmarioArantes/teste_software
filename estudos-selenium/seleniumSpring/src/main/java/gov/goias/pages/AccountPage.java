package gov.goias.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class AccountPage {
    private WebElement firstName;
    private WebElement lastName;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    public AccountPage firstName(String text) {
        firstName.clear();
        firstName.sendKeys(text);
        return this;
    }

    public AccountPage lastName(String text) {
        lastName.clear();
        lastName.sendKeys(text);
        return this;
    }

    public AccountPage submit() {
        submitButton.click();
        return this;
    }
}
