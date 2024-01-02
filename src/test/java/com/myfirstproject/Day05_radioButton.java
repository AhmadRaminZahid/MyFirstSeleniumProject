package com.myfirstproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day05_radioButton {

    WebDriver driver;

    @BeforeEach   // runs before each test method
    public void setup(){
        driver = new ChromeDriver(); // set up the driver
        driver.manage().window().maximize(); // maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait

    }

    @AfterEach  // runs after each test method
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void radioButtonTest(){
//        Go to https://testcenter.techproeducation.com/index.php?page=radio-buttons

        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");

//        Click on Red if not checked already
        WebElement red = driver.findElement(By.cssSelector("#red"));
        if (!red.isSelected()){
            red.click();
        }

        // Verify if red is selected
        Assertions.assertTrue(red.isSelected());

//        Click on Football if not checked already
        WebElement football = driver.findElement(By.cssSelector("#football"));

        if (!football.isSelected()){
            football.click();
        }

        // Verify if football is selected
        Assertions.assertTrue(football.isSelected());


    }



}
