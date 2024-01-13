package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day12_StaleElementException extends TestBase {
    @Test
    public void staleElementTest(){
        driver.get("https://www.amazon.com/");
        waitFor(2);
        driver.navigate().refresh();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));  // correct locator
        searchBox.sendKeys("porcelain teapot", Keys.ENTER);
        waitFor(2);
        driver.navigate().to("https://www.google.com");
        waitFor(2);
        driver.navigate().back();  //  back to amazon
        waitFor(2);
//        searchBox.sendKeys("iPhone 15");  //  StaleElementReferenceException .. Test fails here
//        waitFor(2);

//        SOLUTION
//        You have to refresh the reference of that element (in this case searchBox element)
        searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone 15");

//        ALTERNATIVELY
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 15");


    }
}
