package com.myfirstproject;

import Utilities.LoggerUtils;
import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class Day14_extentReports extends TestBase {

    @Test
    public void extentReportTest(){
        //examples of extenttest methods  to see how they are used
        extentTest.info("Login should be active after registration");
        extentTest.warning("Pay Attention to the Login Button!!");
        extentTest.fail("Login Button is not interactive");
        extentTest.skip("Registration is skipped for this test.");
        extentTest.pass("Login is successful!!");
//
//        NOTE: These methods works just like System.out.println(); to log the information about a given step in the test case

    }

    @Test
    public void extentReportTest2() throws InterruptedException, IOException {
        LoggerUtils.info("Starting the test case fot auto complete funtionality");

        extentTest
                .info("Navigating to the application home page")
                .assignAuthor("Ramin, Emrey")
                .assignDevice("Windows")
                .assignCategory("Smoke Test")
                .addScreenCaptureFromPath(captureScreenshotOfEntirePageAsString());


//        Given user is on https://testcenter.techproeducation.com/index.php?%20page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?%20page=autocomplete");
        extentTest
                .pass("user is on the home page")
                .addScreenCaptureFromPath(captureScreenshotOfEntirePageAsString());
        waitFor(3);

//        When user type “u” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("u");
        waitFor(3);
        extentTest
                .pass("user types u in the search box")
                .addScreenCaptureFromPath(captureScreenshotOfEntirePageAsString());

//        And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
        waitFor(3);
        extentTest
                .pass("united kingdom is selected from the suggestions")
                .addScreenCaptureFromPath(captureScreenshotOfEntirePageAsString());

//        And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Thread.sleep(1000);
//        Then verify the result contains ‘United Kingdom’
        Assertions.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        waitFor(3);
        extentTest
                .pass("result contains 'United Kingdom")
                .addScreenCaptureFromPath(captureScreenshotOfEntirePageAsString());

        LoggerUtils.info("Test case for auto complete functionality is working fine");


    }

    }
