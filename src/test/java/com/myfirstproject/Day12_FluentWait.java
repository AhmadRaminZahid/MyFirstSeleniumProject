package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Day12_FluentWait extends TestBase {
    @Test
    public void explicitWaitTest() {
//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//    When a user clicks on the Start button
        WebElement startButton = driver.findElement(By.xpath("//*[text()='Start']"));   //
        // div[@id='start']//button  OR //div//button  OR //*[text()='Start']  OR //button[text()='Start']
        startButton.click();
//        NOTE: The driver is unable to locate the successMessage element because it's not synchronized with the element ...
//        successMessage element needs time to load and be available for the driver to see
//        WebElement successMessage = driver.findElement(By.xpath("//div[@id='finish']//h4"));
//        Assertions.assertTrue(successMessage.getText().contains("Hello World!"));

        //SOLUTION: Add FLUENT WAIT for this element only and this makes the driver pool in (peep in) after every 2 seconds
        //(or given time), if the element is available/loaded/ driver will perform its function and move on


        /*
       1. Create the wait object
       2. Pass the webElement / locator in the ExpectedConditions. Whatever method you need
        */

        //1. Create the wait object
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) //max time out
                .pollingEvery(Duration.ofSeconds(2)) //poll every 2 seconds (time-interval between every check)
                .withMessage("Ignore the NoSuchElementException") //OPTIONAL Message
                .ignoring(NoSuchElementException.class); //OPTIONAL

        //The Rest is the same as EXPLICIT WAIT
        // 2. Pass the webElement / locator in the ExpectedConditions. Whatever method you need
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));


        //    Then verify the 'Hello World!' Shows up on the screen
        Assertions.assertTrue(successMessage.getText().contains("Hello World!"));






    }
}
