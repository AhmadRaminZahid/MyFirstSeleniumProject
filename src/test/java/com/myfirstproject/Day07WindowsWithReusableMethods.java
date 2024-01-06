package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class Day07WindowsWithReusableMethods extends TestBase {
    @Test
    public void windowsTest() throws InterruptedException {
//        Go to https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
//        Assert if the window 1 title equals “The Internet”
        Assertions.assertTrue(driver.getTitle().equals("The Internet"));
        Thread.sleep(2000);
//        Click on the link
        driver.findElement(By.linkText("Click Here")).click();
        // let get the handle of this window first
        String window1Handle = driver.getWindowHandle();
        System.out.println("window1Handle = " + window1Handle);
        Thread.sleep(2000);
        // New window opened but the driver is still on the previous window
        // so we have to switch first
//       driver.switchTo().window(); // at this point we don't have hashcode for the new window so we can't provide that in window()
        // so we use getWindowHandles() to get all hashcodes and then we loop through it.
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("allWindowHandles = " + allWindowHandles);  // returns all window handles / hashcodes
        // No need to create the loop again because now we have a REUSABLE METHOD which takes care of the loop and how to get handles inside that loop
        switchNewWindowByIndex(1);  // switching window by index using REUSABLE METHOD
//        switchNewWindowByTitle("New Window");  // switching window by title using REUSABLE METHOD
//        Assert if the window 2 title equals “New Window”
        Assertions.assertTrue(driver.getTitle().equals("New Window"));
        Thread.sleep(2000);
//        Switch back to window 1 title and assert if URL contains “windows”
        switchNewWindowByIndex(0);  // using REUSABLE METHOD
        Thread.sleep(2000);
        Assertions.assertTrue(driver.getCurrentUrl().contains("windows"));
//        And assert if the URL doesn’t contain ‘new’
//        assertTrue(!driver.getCurrentUrl().contains("new")); // OR
        Assertions.assertFalse(driver.getCurrentUrl().contains("new"));
//        Switch back to window 2
        switchNewWindowByIndex(1);  // using REUSABLE METHOD
        Thread.sleep(2000);
//        Switch back to window 1
        driver.switchTo().window(window1Handle);
    }
}
