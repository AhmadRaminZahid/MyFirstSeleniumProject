package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day05_Practice02 extends TestBase {
    // HOMEWORK: State Test

    //    Create a new test method stateTest() in this class

//    Then print the total number of states from the dropdown

//    Then print all states from the dropdown
//    Select 'Texas' option using one f the methods
//    Assert if 'Texas' is selected or not
//    Then check if state names are in alphabetical order or not
    @Test
    public void stateTest() throws InterruptedException {
driver.navigate().to("https://testcenter.techproeducation.com/index.php?page=dropdown");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Then print the total number of states from the dropdown
WebElement states= driver.findElement(By.xpath("//select[@id='state']"));
Thread.sleep(10000);
        Select statesList= new Select(states);
        List<WebElement> list1 = statesList.getOptions();
        list1.remove(0);// removed the option "select a state"
        System.out.println(list1.size());
//    Then print all states from the dropdown
        for (WebElement w: list1){
            System.out.println(w.getText());
        }
        Thread.sleep(5000);
        //    Select 'Texas' option using one f the methods
        statesList.selectByValue("TX");
Thread.sleep(10000);
        //    Assert if 'Texas' is selected or not

Assertions.assertTrue(statesList.getFirstSelectedOption().getAttribute("value").equals("TX"));
      //    Then check if state names are in alphabetical order or not
       Collections.sort(list1, Comparator.comparing(WebElement::getText));
     List<WebElement> sortedList= new ArrayList<>(list1);
      Assertions.assertTrue(list1.equals(sortedList));
    }
    }
