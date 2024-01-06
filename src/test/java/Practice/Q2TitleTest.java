package Practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q2TitleTest {
    @Test
    public void titleTest() throws InterruptedException {
//  Create chrome driver object
        WebDriver driver = new ChromeDriver(); // Selenium Driver
//  Maximize the window
        driver.manage().window().maximize();
//  Open google home page https://www.google.com/
        driver.get("https://www.google.com/");
//  Wait for 3 seconds
        Thread.sleep(3000); //HARD JAVA WAIT
//  Go to the https://techproeducation.com/
        driver.get("https://techproeducation.com/");
//  Get the title and URL of the page
        String techproTitle = driver.getTitle();
        Thread.sleep(3000);
        System.out.println("techproTitle = " + techproTitle);
//  Check if the title contains the word "Bootcamps" print console "Title contains Bootcamps" or "Title does not contain Bootcamps”
        if (techproTitle.contains("Bootcamps")) {
            System.out.println("Title contains Bootcamps");
        } else {
            System.out.println("Title does not contain Bootcamps");
        }
//  Check if the URL contains the word "techpro" print console "URL contains techpro" or "URL does not contain techpro”
        String url = driver.getCurrentUrl();
        Thread.sleep(2000);
//        ternary
        System.out.println(url.contains("techpro") ? "URL contains techpro" : "URL does not contain techpro");
//  Then go to https://medunna.com/
        driver.get("https://medunna.com/");
//  Get the title and check if it contains the word "MEDUNNA" and print "Title contains MEDUNNA" or "Title does not contain MEDUNNA”
        String medunnaTitle = driver.getTitle();
        Thread.sleep(2000);
//        ternary
        System.out.println(medunnaTitle.contains("MEDUNNA") ? "Title contains MEDUNNA" : "Title does not contain MEDUNNA");

//        Assert that title contains "MEDUNNA"
        Assertions.assertTrue(medunnaTitle.contains("MEDUNNA"));

//  Navigate Back to the previous webpage
        driver.navigate().back();
        Thread.sleep(1000);
//  Refresh the page
        driver.navigate().refresh();
        Thread.sleep(1000);
//  Navigate to forward
        driver.navigate().forward();
        Thread.sleep(1000);
//  Wait for 3 seconds
        Thread.sleep(3000);
//  Close the browser
        driver.quit();


    }
}
