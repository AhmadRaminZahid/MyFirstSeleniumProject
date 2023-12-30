package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
       // WebDriverManager.edgedriver().setup();
       // WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new ChromeDriver();
        //WebDriver driver2 = new EdgeDriver();
       // WebDriver driver3 = new FirefoxDriver();
        //maximize the window
        driver.manage().window().minimize();
        Thread.sleep(3000);
        //go to facebook.com
        driver.get("https://www.facebook.com");
        Thread.sleep(3000); //hard java wait method
        //go to another website, staying at the same tab
        driver.get("https://www.techproeducation.com");
        Thread.sleep(3000);
        //go back to previous page
        driver.navigate().back();
        Thread.sleep(3000);
        //go forward to the other page
        driver.navigate().forward();
        Thread.sleep(3000);
        //refresh the page
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.close();

        /*
        NOTES:
1. How do you go to a page in Selenium?
- I use get() or navigate() method. get() is more commonly used.
2. What is the difference between get() and navigate() method?
- both are used to go to a page
- get is shorter than navigate method
- navigate() allows you to go forward,back and refresh the page
- get method accepts String only as parameter, navigate() accepts string and url
3. What's the difference between quit() and close()?
close() method closes the current active window, whereas quit() method closes all opened windows
4. What is Thread.sleep()?
- it is JAVA wait. we call it HARD WAIT as well.
         */
    }
}
