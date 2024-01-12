package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Day11_RobotClass extends TestBase {
    @Test
    public void robotTest() throws AWTException {
//        https://testpages.herokuapp.com/styled/file-upload-test.html
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");

//        First we need to handle the desktop pop-up because Selenium can't deal with Desktop applications directly
        String pathOfFile = System.getProperty("user.home") + "/Desktop/flower.jpeg";  // dynamic way of declaring the path of the file
//        Now we need to locate the webElement
        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@type='file']"));
//        chooseFileButton.click();  // Selenium click didn't work
        clickByJS(chooseFileButton);

//      Then user selects an image from the desktop

//        ROBOT CLASS
        StringSelection ss = new StringSelection(pathOfFile);  // declare the pathOfFile on the clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();

//        Pressing control C  (selecting)
        robot.keyPress(KeyEvent.VK_CONTROL);  // pressing cmd+c
        robot.keyPress(KeyEvent.VK_V);   // pressing cmd+v
        waitFor(2);

//        Pressing control V  (pasting)
        robot.keyRelease(KeyEvent.VK_CONTROL); // releasing cmd+c
        robot.keyRelease(KeyEvent.VK_V);  // releasing cmd+v
        waitFor(2);

//        Press enter
        robot.keyPress(KeyEvent.VK_ENTER);
//        release enter
        robot.keyRelease(KeyEvent.VK_ENTER);
        waitFor(2);

//       And click on the upload button
        WebElement uploadButton = driver.findElement(By.xpath("//input[@type='submit']"));
        uploadButton.click();


//        Then verify the message ‘You uploaded a file. This is the result.’ is displayed
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='explanation']//p")).
                getText().
                contains("You uploaded a file. This is the result."));

    }
}
