package Practice;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day20Q2_hardWait extends TestBase {
    //    Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
//    Click on "click me" button
//    Verify that "Event Triggered"

    @Test
    public void test() throws InterruptedException {

//    Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

//    Click on "click me" button
        WebElement button = driver.findElement(By.id("growbutton"));
        Thread.sleep(4000); // HARD WAIT => because the button is not clickable immediately. it needs time
        // so we make our driver wait for 4 seconds
        button.click();

//    Verify that "Event Triggered"
        Assertions.assertTrue(driver.findElement(By.id("growbuttonstatus")).isDisplayed());

    }
}
