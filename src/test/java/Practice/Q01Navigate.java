package Practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01Navigate {
     /*
Set Driver Path (Traditional way)
Create chrome driver object
Maximize the window
Open google home page https://www.google.com/
Navigate to techproeducation home page https://techproeducation.com/
Navigate back to google
Navigate forward to techproeducation
Refresh the page
Close/Quit the browser
And last step : print "ALL OK" on console
     */

    @Test
    public void navigateTest() throws InterruptedException {

//        Set Driver Path (Traditional way)
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");  // MAC
//        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");  // WINDOWS

//        Create chrome driver object
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Implicit wait
//        Maximize the window
        driver.manage().window().maximize();
//        Open google home page https://www.google.com/
        driver.get("https://www.google.com/");
        Thread.sleep(2000); // HARD JAVA WAIT
//        Navigate to techproeducation home page https://techproeducation.com/
        driver.get("https://techproeducation.com/");
        Thread.sleep(2000);
//        Navigate back to google
        driver.navigate().back();
        Thread.sleep(2000);
//        Navigate forward to techproeducation
        driver.navigate().forward();
        Thread.sleep(2000);
//        Refresh the page
        driver.navigate().refresh();
        Thread.sleep(2000);
//        Close/Quit the browser
//        driver.close();  // closes only the current window where the driver is
        driver.quit();  // closes all open windows
//        And last step : print "ALL OK" on console
        System.out.println("ALL OK :) ");
//


    }
}
