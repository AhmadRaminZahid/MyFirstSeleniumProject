package com.myfirstproject;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Day04_xpath {

    WebDriver driver;

    @BeforeEach   // runs before each test method
    public void setup() throws InterruptedException {
        driver = new ChromeDriver(); // set up the driver
        driver.manage().window().maximize(); // maximise the window
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait
        Thread.sleep(30);

    }

    @AfterEach  // runs after each test method
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTest() throws InterruptedException {
        //    When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    And enter username
        WebElement username=  driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        Thread.sleep(2000); // HARD Java wait

//    And enter password
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("admin123");
        Thread.sleep(2000);
//    And click on submit button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

//    Then verify the login is successful
//        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));
//        OR
//        Assertions.assertFalse(driver.getCurrentUrl().contains("auth"));
//        OR (2nd way: by core element)
        Assertions.assertTrue(driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed());

//    Get all items in the dropdown list
        List<WebElement> dropdownList = driver.findElements(By.className("//ul[@role='menu']"));

        Thread.sleep(3000);

        for (WebElement w: dropdownList){
            System.out.println(w.getText());
        }

//    Then logout the application
        driver.findElement(By.className("oxd-userdropdown-img")).click();  // clicks on the profile so we can see the logout in dropdown menu
//        Thread.sleep(2000);driver.findElement(By.linkText("Logout")).click(); // this locator works with exact match of the text
        driver.findElement(By.partialLinkText("ogout")).click(); // this locator works with part of the text (but it is case sensitive)

//    Then verify the logout is successful
        Assertions.assertTrue(driver.getCurrentUrl().contains("auth"));

    }
    }