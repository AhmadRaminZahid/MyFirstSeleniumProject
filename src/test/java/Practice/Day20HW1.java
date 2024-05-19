package Practice;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Day20HW1 extends TestBase {
//    HW1: ØGiven
    @Test
    public void hw1() throws InterruptedException {
        //    Go to https://www.facebook.com/
    driver.get("https://www.facebook.com/");
    Thread.sleep(2000);

        //    When
//    Click on "Create New Account"
        Actions actions= new Actions(driver);
        for (int i = 1; i < 5; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }
        Faker faker= new Faker();
        String email= faker.internet().emailAddress();
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        actions.sendKeys(faker.name().firstName()).perform();
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.name().lastName()).perform();
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(email).perform();
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(email).perform();
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.internet().password()).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
        for (int i = 1; i <25 ; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ARROW_RIGHT);
        for (int i = 1; i <6 ; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }
        //iyi ginler nasilsimiz
        //iyi ginler nasilsimiz
        //iyi ginler nasilsimiz
        //iyi ginler nasilsimiz
        //iyi ginler nasilsimiz
        //iyi ginler nasilsimiz
        //iyi ginler nasilsimiz


        Thread.sleep(2000);
        captureScreenshotOfEntirePage();
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);


//    Note: Do not use any locator.
    }

}
