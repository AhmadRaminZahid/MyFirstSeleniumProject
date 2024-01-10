package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Day10_jsExecutor extends TestBase {
    @Test
    public void jsExecutorTest() throws InterruptedException {
//        Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        driver.navigate().refresh(); // This will resolve the captcha issue (hopefully)
        Thread.sleep(15000);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

//        When user click on "Account" link
//        We can't see the "Account" link unless we hover over "Account & List" option
//        So we need to create actions object
//        Step 1:
        Actions actions = new Actions(driver);
//        Step 2: Find the element first and then use moveToElement() from actions class
        Thread.sleep(4000);
        WebElement accountListTab = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountListTab).perform();  // moveToElement() makes the driver hover over the given element
        Thread.sleep(4000);
//        Now we can see "Account" link on the dropdown
        WebElement accountOption =  driver.findElement(By.linkText("Account"));
//        accountOption.click(); // Normal way
      //  actions.click(accountOption).perform();  // Alternative if normal click() doesn't work
        //if both click methods do not work which happens rarely, we use jsexecuter method to click.
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",accountOption,accountListTab);

        Thread.sleep(5000);
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));
//        Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        actions.moveToElement(amazonMusic).perform();
        Thread.sleep(5000);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//        Click on it
       // actions.click(amazonMusic).perform();
        js.executeScript("arguments[0].click();",amazonMusic);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        Thread.sleep(10000);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//        Then verify Amazon Music page is displayed
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
//        Scroll the page up and down
        js.executeScript("window.scrollTo(0, 250);" );  // Scroll Down
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, -250);" );  // Scroll Up
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);" );  // Scroll Down
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);" );  // Scroll Up
//locate the search input at music page using JSExecutor method
        waitFor(4);

WebElement searchInput = locateElementByJS("navbarSearchInput");
//using resuable methods for JSExecutor in TestBase class
   //send the text POP in the search input
        searchInput.sendKeys("POP");// the normal way

        setValueByJS(searchInput,"POP");
        String inputValue= getValueByJS("navbarSearchInput");
        Assertions.assertTrue(inputValue.contains("POP"));

    }
}
