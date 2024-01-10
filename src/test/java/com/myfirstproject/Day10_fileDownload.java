package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day10_fileDownload extends TestBase {
    @Test
    public void fileDownloadtest(){
//        Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
//        Download evening.png  file
//        Locate the element first
        driver.findElement(By.linkText("evening.png")).click();
//        To let the download complete, we add some time
        waitFor(5);  // REUSABALE METHOD
        String  pathOfDownloadedFile = System.getProperty("user.home") + "/Download/evening.png";
        System.out.println("pathOfDownloadedFile = " + pathOfDownloadedFile);

//        Then verify if the file downloaded successfully
//        Assertions.assertTrue(Files.exists(Paths.get(pathOfDownloadedFile)));

//        If test fails, we get the failure message
        Assertions.assertTrue(Files.exists(Paths.get(pathOfDownloadedFile)), "Download failed "+pathOfDownloadedFile+ " doesn't exist");

    }
}
