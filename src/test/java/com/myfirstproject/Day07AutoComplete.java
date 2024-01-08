package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day07AutoComplete extends TestBase {
    @Test
    public void autocompleteTest() throws InterruptedException {

//        Given user is on https://testcenter.techproeducation.com/index.php?%20page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?%20page=autocomplete");

//        When user type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("u");
        Thread.sleep(1000);

//        And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
        Thread.sleep(1000);
//        And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Thread.sleep(1000);
//        Then verify the result contains ‘United Kingdom’
        Assertions.assertTrue(driver.findElement(By.id("result")).isDisplayed());


    }
}