package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class Day06_Windows extends TestBase {

    // Go to https://the-internet.herokuapp.com/windows
//        Assert if the window 1 title equals "The Internet"
//        Click on the link
//        Assert if the window 2 title equals "New Window"
//        Switch back to window 1 title and assert if URL contains "windows"
//        And assert if the URL doesn't contain 'new'

    @Test
    public void windowsTest() throws InterruptedException {

//        Go to https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

//        Assert if the window 1 title equals "The Internet"
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

//         Use a for each loop to get the second window handle

        for (String eachHandle : allWindowHandles) {
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);  // at this point, driver will switch to 2nd window
                break;
            }
        }

//        Assert if the window 2 title equals "New Window"
        Assertions.assertTrue(driver.getTitle().equals("New Window"));
        Thread.sleep(2000);

//        Now that driver is on second window, we can get its handle too
        String window2Handle = driver.getWindowHandle();
        System.out.println("window2Handle = " + window2Handle);
//        Switch back to window 1 title and assert if URL contains "windows"
        driver.switchTo().window(window1Handle);
        Thread.sleep(2000);
        Assertions.assertTrue(driver.getCurrentUrl().contains("windows"));
//        And assert if the URL doesn't contain 'new'
//        assertTrue(!driver.getCurrentUrl().contains("new")); // OR
        Assertions.assertFalse(driver.getCurrentUrl().contains("new"));

//        Switch back to window 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(2000);

//        Switch back to window 1
        driver.switchTo().window(window1Handle);

    }
  /*  HW: When Navigate to https://testpages.herokuapp.com/styled/windows-test.html
    ØWhen Click on "Alerts In A New Window From JavaScript"
    ØAnd Switch to new window
    ØAnd Click on "Show alert box" button
    ØAnd Accept alert
    ØAnd Click on "Show confirm box" button
    ØAnd Cancel alert
    ØThen Assert that alert is cancelled
    ØWhen Click on "Show prompt box" button
    ØAnd Send "Hello World!" to the alert
    ØThen Assert that "Hello World!" is sent*/
}