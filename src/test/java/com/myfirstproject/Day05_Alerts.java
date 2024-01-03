package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day05_Alerts extends TestBase {
    //    Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
    //    Create setUp method Create 3 test methods:
//    acceptAlert() => click on the first alert, verify the text "I am a JS Alert"
//    click OK
//    and Verify "You successfully clicked an alert"

    //    dismissAlert()=> click on the second alert, verify text "I am a JS Confirm"
//    click cancel
//    and Verify "You clicked: Cancel"
//
//    sendKeysAlert()=> click on the third alert, verify text "I am a JS prompt",
//    type "Hello World", click OK
//    and Verify "You entered: Hello World"
    @Test
    public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//    click on the first alert, verify the text “I am a JS Alert”
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click(); // button is a webElement so we locate it and tell the driver to click on it
//        the window pops up.. which is an alert .. we can NOT locate pop up window (alert) so we need to handle it
//    click OK
        driver.switchTo().alert().accept();
//    and Verify “You successfully clicked an alert”
        WebElement result = driver.findElement(By.id("result"));
        Assertions.assertTrue(result.getText().contains("You successfully clicked an alert"));
    }

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//    click on the second alert, verify text "I am a JS Confirm”
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click(); // clicks on the second button
//        At this point, we see an ALERT on the page, we can NOT locate it, we have to handle it by switchto method
//    click cancel
        driver.switchTo().alert().dismiss();
//    and Verify “You clicked: Cancel”
        Assertions.assertTrue(driver.findElement(By.id("result")).getText().contains("You clicked: Cancel"));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        Thread.sleep(2000);
//    click on the third alert, verify text "I am a JS Prompt”
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click(); // clicks on the second button
        Thread.sleep(2000);
//        At this point, we see an ALERT on the page, we can NOT locate it, we have to handle it by switchto method
//    type “Hello World”, click OK
        driver.switchTo().alert().sendKeys("Hello World");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
//    Verify “You entered: Hello World”
        Assertions.assertTrue(driver.findElement(By.id("result")).getText().contains("You entered: Hello World"));
        Thread.sleep(2000);

    }
}