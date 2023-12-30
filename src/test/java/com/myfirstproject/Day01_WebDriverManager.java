package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day01_WebDriverManager {
    public static void main(String[] args) {

        //1. Set up
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.edgedriver().setup();
        //WebDriverManager.firefoxdriver().setup();

//        2. Create the driver
        WebDriver driver = new ChromeDriver();
        //WebDriver driver2 = new EdgeDriver();
        //WebDriver driver3 = new FirefoxDriver();

//        3. Now that driver is ready, automate the function that we want to perform

        driver.get("https://www.facebook.com");

    }
}
