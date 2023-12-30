package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_FirefoxTest {

    public static void main(String[] args) throws InterruptedException {
        //        1. Set up
        WebDriverManager.firefoxdriver().setup();

//        2. Create the driver
        WebDriver driver = new FirefoxDriver();

        //3. Maximise the window
        driver.manage().window().maximize();
        Thread.sleep(2000);

//        4. Now that driver is ready, automate the function that we want to perform
        driver.get("https://www.amazon.com");
//        5. Close the browser
        driver.quit();
    }
}