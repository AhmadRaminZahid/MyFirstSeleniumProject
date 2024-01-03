package com.myfirstproject;

import Utilities.TestBase;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class PracticeDay05 extends TestBase {
//go to https://testcenter.techproeducation.com/index.php?page=checkboxes

    //make sure box1 is selected
    //make sure box2 is not selected
    //then verify
@Test
public void checkbox(){
    //step 1:
    driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    //step 2 :
   WebElement box1= driver.findElement(By.xpath("//input[@id='box1']"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //make sure it is selected
    if (!box1.isSelected()){
        box1.click();
    }

    WebElement box2 = driver.findElement(By.xpath("//input[@id='box2']"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    if (box2.isSelected()){
        box2.click();
    }
    //verify
    Assertions.assertTrue(box1.isSelected());
    Assertions.assertFalse(box2.isSelected());
    Assertions.assertTrue(!box2.isSelected());

}
}
