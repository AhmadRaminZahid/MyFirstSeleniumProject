package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class Day07_Authentication extends TestBase {
    @Test
    public void authenticationTest() {
//        username : admin
//        password : admin
//        url	: the-internet.herokuapp.com/basic_auth

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");  // This is used to authentication
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Verify if authentication is successful or not
        Assertions.assertTrue(driver.findElement(By.xpath("//p")).getText().contains("Congratulations"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
}
