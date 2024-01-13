package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day12_TimeoutException extends TestBase {
    @Test
    public void noSuchElementExceptionTest(){
        driver.get("https://www.amazon.com/");
        waitFor(2);
        driver.navigate().refresh();

//        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));  // correct locator
//        searchBox.sendKeys("porcelain teapot", Keys.ENTER);


//        Let's say, this failure is because of time issue and not locator reason. So we try to add EXPLICIT WAIT (reusable method)

        WebElement searchBox = waitForVisibility(By.id("two tabsearchtextbox"), 10);  // TimeoutException
        searchBox.sendKeys("porcelain teapot", Keys.ENTER);
    }
}
