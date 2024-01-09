package Practice;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day09_Actionspractice extends TestBase {
    @Test
    public void actions() throws InterruptedException {

        // go to the https://www.kitapyurdu.com/kitap/soyleme-bilmesinler/668247.html website
        Thread.sleep(5000);

        driver.get("https://www.kitapyurdu.com");
        Thread.sleep(15000);
        //hover over on yeni cikan kitaplar
        WebElement yenikitaplar= driver.findElement(By.xpath("(//li/span)[12]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(yenikitaplar).perform();
        Thread.sleep(5000);

        //click on son 60 gunde cikanlar
        WebElement son60= driver.findElement(By.xpath("(//a//strong)[17]"));
        actions.click(son60).perform();
        Thread.sleep(5000);
        //click on Lili ve Didi’nin Maceraları 3
        WebElement didi=driver.findElement(By.xpath("(//div//a//span)[2]"));
        actions.click(didi).perform();
        //print the name of book
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        //scroll down and find akil defteri
        actions.moveToElement(driver.findElement(By.linkText("Akıl Defteri"))).perform();
        //click on it
        actions.click(driver.findElement(By.linkText("Akıl Defteri"))).perform();
        //verify its title
        Assertions.assertTrue(driver.getTitle().contains("Akıl Defteri"));
        //scroll down
        actions.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(3000);
        //scroll up
        actions.sendKeys(Keys.PAGE_UP);
        Thread.sleep(5000);

    }
}
