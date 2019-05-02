package org.example.webapp.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ITConfig.class)
public class IndexIT {

    @Autowired
    private WebDriver webDriver;

    @Value("${server.port}")
    private int serverPort;

    @Test
    public void visitIndexPage() throws Exception{

        webDriver.get(String.format("http://localhost:%d/", serverPort));

        WebElement working = webDriver.findElement(By.id("working"));

        Assert.assertThat(working.getText(), is(equalTo("It works!")));
    }
}
