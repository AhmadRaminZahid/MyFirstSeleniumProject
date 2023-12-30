package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitleTest {
    public static void main(String[] args) throws InterruptedException {

        //    Set Up
      //  WebDriverManager.chromedriver().setup(); //No need to it any more
        WebDriver driver = new ChromeDriver();

        //    Navigate to amazon homepage
        driver.get("https://www.mazon.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.navigate().refresh();
        Thread.sleep(1000);

        //    Verify if page title is "Amazon.com. Spend less. Smile more."
       String actualTitle= driver.getTitle(); // gets the title of current page
        System.out.println("actualTitle = " + actualTitle);
        //Validation
        if(actualTitle.contains("Amazon")) {
            System.out.println("Test passed");
        }
        else {
            System.out.println("Test failed");
            System.out.println("actualTitle: "+actualTitle+"  Expected Title: Amazon.com. Spend less. Smile more. ");
        }

        //    Close the window
        driver.quit();
        /*
       QUOTE OF THE DAY:

       Testers don't write codes to PASS the test
       Testers write codes to FIND THE BUG / DEFECT
       NOTES:
If my test case fails, I as a tester should NOT fix the code to see my test PASS.
Steps:
1. Communicate with the Team Lead / Test Lead / BA to check if that is a requirement issue
  If it is a requirement issue, BA should fix the AC and then update the backlog/ document
2. If it is actual bug, then I should communicate with my team and see if I need to raise bug ticket
   or create new user story
        */

    }
}
