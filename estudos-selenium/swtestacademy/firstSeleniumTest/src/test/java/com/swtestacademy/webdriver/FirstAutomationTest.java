package com.swtestacademy.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAutomationTest {
    //We should add @Test annotation that JUnit will run below method

    @Test
    //Start to write our test method. It should ends with "Test"
    public void firstTest(){

        //Step 1- Driver Instantiation: Instantiate driver object as ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/home/gilmario/workspaces/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Step 2- Navigation: Open a website
        driver.navigate().to("https://www.google.com/");

        //Step 3- Assertion: Check its title is correct
        //assertEquals method Parameters: Message, Expected Value, Actual Value
        Assert.assertEquals("Title check passed!", "Google", driver.getTitle());

        //Step 4- Close Driver
        driver.close();

        //Step 5- Quit Driver
        driver.quit();
    }
}
