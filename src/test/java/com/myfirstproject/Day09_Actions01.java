package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Day09_Actions01 extends TestBase {
    @Test
    public void hoverOverTest() throws InterruptedException {
//        Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        Thread.sleep(10000);
//        When user click on “Account” link
        //        We can't see the "Account" link unless we hover over "Account & List" option
//        So we need to create actions object
//        Step 1:
        Actions actions= new Actions(driver);
        //        Step 2: Find the element first and then use moveToElement() from actions class
        WebElement accountListTab= driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountListTab).perform();// moveToElement() makes the driver hover over the given element
        Thread.sleep(3000);
        //        Now we can see "Account" link on the dropdown
        WebElement accountoption= driver.findElement(By.linkText("Account"));
        //        accountOption.click(); // Normal way
        actions.click(accountoption).perform(); // Alternative if normal click() doesn't work
        //        Then verify the page title contains "Your account"
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));
//        Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        actions.moveToElement(amazonMusic).perform();
//        Click on it
        actions.click(amazonMusic).perform();
        Thread.sleep(2000);
//        Then verify Amazon Music page is displayed
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
//        Scroll the page up and down
        actions.sendKeys(Keys.PAGE_DOWN).perform();//scrolls down
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform(); //scrolls up
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);

//        we can also create a chain of functions and it is recommended to use build()
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();

    }
}
