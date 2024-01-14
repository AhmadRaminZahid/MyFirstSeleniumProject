package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day13_CaptureScreenshot_GivenElement extends TestBase {

    @Test
    public void screenshotGivenElementTest(){
        driver.get("https://www.google.com/");

        WebElement image = driver.findElement(By.xpath("//img[@alt='Google']"));
        waitFor(2);
        captureScreenshotOfElement(image);

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iPhone 15");
        waitFor(2);
        captureScreenshotOfElement(searchBox);

    }
}
