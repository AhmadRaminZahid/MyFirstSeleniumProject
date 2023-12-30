package com.myfirstproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_Css {
    WebDriver driver;

    @BeforeEach   // runs before each test method
    public void setup() {
        driver = new ChromeDriver(); // set up the driver
        driver.manage().window().maximize(); // maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait

    }

    @AfterEach  // runs after each test method
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTestWithCss() throws InterruptedException {

//        User goes to "https://techproeducation.com/"
        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);

//        User clicks on search box
        driver.findElement(By.cssSelector("input#searchHeaderInput")).sendKeys("Automation");
        Thread.sleep(2000);
//        Search for Full Stack Automation Tester Course
        driver.findElement(By.partialLinkText("Automation Tester")).click();
        Thread.sleep(2000);
//        User clicks on Upcoming Programs
        driver.findElement(By.cssSelector("button#menu-btn")).click();


    }
}