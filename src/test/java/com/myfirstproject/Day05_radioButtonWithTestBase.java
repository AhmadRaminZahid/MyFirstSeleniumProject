package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Day05_radioButtonWithTestBase extends TestBase {


    @Test
    public void radioButtonTest(){
//        Go to https://testcenter.techproeducation.com/index.php?page=radio-buttons

        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");

//        Click on Red if not checked already
        WebElement red = driver.findElement(By.cssSelector("#red"));
        if (!red.isSelected()){
            red.click();
        }

        // Verify if red is selected
        Assertions.assertTrue(red.isSelected());

//        Click on Football if not checked already
        WebElement football = driver.findElement(By.cssSelector("#football"));

        if (!football.isSelected()){
            football.click();
        }

        // Verify if football is selected
        Assertions.assertTrue(football.isSelected());


    }



}
