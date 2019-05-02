import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FB extends BrowserFunctions{

    @Test
    public void fb() throws  InterruptedException{

        driver.get("https://www.fb.com");
        WebDriverWait wait = new WebDriverWait(driver,30);

        Thread.sleep(500);
        System.out.println("Title " + driver.getTitle());
        System.out.println("URL " + driver.getCurrentUrl());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("day")));

        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByVisibleText("10");

        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("Jan");

        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1950");

    }
}
