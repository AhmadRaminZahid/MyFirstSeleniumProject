package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondTest {
    public static void main(String[] args) {
       // 1. Set the path of the driver
       // System.setProperty("What is it", "where is it");
       // System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");  // MAC
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"); // WINDOWS

        //2. create a driver
        WebDriver driver = new ChromeDriver();

        //3. automate the action to perform
        driver.get("https://youtube.com");
    }
}
