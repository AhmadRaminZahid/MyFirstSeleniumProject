package Practice;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day20Q4_WaitForClickability extends TestBase {
    /*
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
           Click on Ajax Loader
           Click on "Click Me!" button
           Assert that button is clicked
           Take screenshot after each step

         */
    @Test
    public void test(){

//        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        captureScreenshotOfEntirePage();

//        Click on Ajax Loader
        driver.findElement(By.linkText("CLICK ME!")).click(); // implicit wait from TestBase is allowing to wait for this button to load
        captureScreenshotOfEntirePage();

//        Click on "Click Me!" button
        WebElement button = driver.findElement(By.id("button1"));  // this will not work because of synchronisation issue so we add HARD WAIT
        waitFor(10);
        button.click();
        captureScreenshotOfEntirePage();
//        waitForClickablility(button, 5).click();

//        Assert that button is clicked
        WebElement successPopUp =  driver.findElement(By.xpath("//h4"));
        waitForVisibility(successPopUp, 5);  // we need to wait for the visibility of the success message as well
        System.out.println("success message: " + successPopUp.getText());

        Assertions.assertTrue(successPopUp.getText().contains("Well Done"));
        captureScreenshotOfEntirePage();

//        Take screenshot after each step

        driver.quit();


    }
}
