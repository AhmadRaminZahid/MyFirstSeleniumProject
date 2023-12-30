package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyURLTest {
    public static void main(String[] args) {

        //Navigate to Amazon homepage
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
//        Verify if google homepage url is https://www.amazon.com/
        String currentURL = driver.getCurrentUrl();
      System.out.println("currentURL = " + currentURL);

//        VALIDATION
        if (currentURL.contains("https://www.amazon.com/")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

//        Close the window
        driver.quit();

    }
}
