package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class Day05_DropDown extends TestBase {
    @Test
    public void dropdownTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        choose your birthdate  2000-07-07
//        YEAR
//        Step 1: locate the dropdown
        WebElement year = driver.findElement(By.id("year"));
//       Step 2: Create object from Select Class and assign the webElement to it
        Select selectYear = new Select(year);
//        Step 3: Now we have the select object, now we can interact with the dropdown
        selectYear.selectByVisibleText("2000"); // selecting the year by visible text

//        MONTH
        WebElement month = driver.findElement(By.cssSelector("#month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("6");  // selecting month of July by its value

//        DAY
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay = new Select(day);
        selectDay.selectByIndex(6);

//        Assert that year 2000 is selected
        WebElement selectedYear = selectYear.getFirstSelectedOption(); // returns the options that we selected (sent for year)
//        System.out.println("selectedYear = " + selectedYear.getText());
        Assertions.assertTrue(selectedYear.getText().contains("2000"));  // verifying if the selected year as the same as expected

//        Get all months from the dropdown and assert that "October" is an option in the months

        List<WebElement> allMonths = selectMonth.getOptions(); // returns all webElements in the dropDown list

        boolean flag = false;  // declare a boolean variable to use for assertion

        for (WebElement w : allMonths) {
            System.out.println(w.getText());
            if (w.getText().contains("October")) {
                flag = true;
            }

        }
        Assertions.assertTrue(flag);

    }
    // HOMEWORK: State Test

//    Create a new test method stateTest() in this class
//    Then print the total number of states from the dropdown
//    Then print all states from the dropdown
//    Select 'Texas' option using one f the methods
//    Assert if 'Texas' is selected or not
//    Then check if state names are in alphabetical order or not
}
