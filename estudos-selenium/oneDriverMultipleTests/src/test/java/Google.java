import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Google extends BrowserFunctions{

    @Test
    public void google() throws InterruptedException{
        driver.get("https://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst-ib")));

        driver.findElement(By.id("lst-ib")).sendKeys("Bello");
        Thread.sleep(500);
    }
}
