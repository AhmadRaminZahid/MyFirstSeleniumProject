package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day11_FileUpload extends TestBase {
    //    When user goes to
//    https://testpages.herokuapp.com/styled/file-upload-test.html
//    And click on the upload button
//    Then user selects an image from the desktop
//    Then verify the message ‘You uploaded a file. This is the result.’ is displayed

    @Test
    public void fileUploadtest() {
//        https://testpages.herokuapp.com/styled/file-upload-test.html
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");

//        First we need to handle the desktop pop-up because Selenium can't deal with Desktop applications directly
        String pathOfFile = System.getProperty("user.home") + "/Desktop/flower.jpeg";  // dynamic way of declaring the path of the file
//        Now we need to locate the webElement
        WebElement chooseFileButton = driver.findElement(By.id("fileinput"));

//      Then user selects an image from the desktop
        chooseFileButton.sendKeys(pathOfFile);  // provide the path of the image where it is uploaded from
        waitFor(2);
//        Choose the type of image
        driver.findElement(By.id("itsanimage")).click();
        waitFor(2);
//        And click on the upload button
        WebElement uploadButton = driver.findElement(By.xpath("//input[@type='submit']"));
        uploadButton.click();

//        Then verify the message ‘You uploaded a file. This is the result.’ is displayed
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='explanation']//p")).
                getText().
                contains("You uploaded a file. This is the result."));

//        Assertions.assertEquals("You uploaded a filessss. This is the result.",
//                driver.findElement(By.xpath("//div[@class='explanation']//p")).getText(),
//                "File upload is not successful!!" );

    }
}
