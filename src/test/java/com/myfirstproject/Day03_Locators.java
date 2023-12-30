package com.myfirstproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_Locators {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        Thread.sleep(5000); // Hard Java wait  => It will wait for 2 seconds NO matter what.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Implicit wait- Recommended  because it will wait as long as it need to.
        // If the page is loaded earlier and element is available before the given time,
        // driver will not wait any more and perform the given function
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginTest() throws InterruptedException {
//    When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    And enter username
        driver.findElement(By.name("username")).sendKeys("Admin");
//    And enter password
        driver.findElement(By.name("password")).sendKeys("admin123");
//    And click on submit button
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);
//    Then verify the login is successful

        /*
        1. way: using url

        https://opensource-demo.orangehrmlive.com/web/index.php/auth/login  // before login
        https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index  // after login is successful

        if current URL contains the word "dashboard", then it means login is successful
        if current URL contains the word "auth", then it means login is not successful

        2. way: by using any core element
        We can locate any core element like profile pic or dashboard  and verify if it is displayed or not

         */

//        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));
//        OR
//        Assertions.assertFalse(driver.getCurrentUrl().contains("auth"));
//        OR (2nd way: by core element)
        Assertions.assertTrue(driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed());

//    Then logout the application
        driver.findElement(By.className("oxd-userdropdown-img")).click();  // clicks on the profile so we can see the logout in dropdown menu
//        Thread.sleep(2000);driver.findElement(By.linkText("Logout")).click(); // this locator works with exact match of the text
        driver.findElement(By.partialLinkText("ogout")).click(); // this locator works with part of the text (but it is case sensitive)

//    Then verify the logout is successful
        Assertions.assertTrue(driver.getCurrentUrl().contains("auth"));

    }
}