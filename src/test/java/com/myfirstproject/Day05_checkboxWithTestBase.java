package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Day05_checkboxWithTestBase extends TestBase {


@Test
    public void checkBox() throws InterruptedException {
        //go to the website
        driver.navigate().to("https://testcenter.techproeducation.com/index.php?page=checkboxes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
// locate the checkbox elements
    WebElement checkbox1= driver.findElement(By.id("box1"));
    WebElement checkbox2= driver.findElement(By.id("box2"));
    //select box1 if not selected
if (!checkbox1.isSelected()){
    checkbox1.click();
}
Thread.sleep(5000);
    //select box2 if not selected
if (!checkbox2.isSelected()){
    checkbox2.click();
}
Thread.sleep(5000);
    //verify that box1 is selected
    Assertions.assertTrue(checkbox1.isSelected());
    //verify that box2 is selected
Assertions.assertTrue(checkbox2.isSelected());
    }
}
