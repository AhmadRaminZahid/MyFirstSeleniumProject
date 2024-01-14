package Practice;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day12_Waits extends TestBase {
   /* HW: 1.  ØCreate a class:Synchronization3.
    ØCreate a method: synchronization1
    ØGo to https://the-internet.herokuapp.com/dynamic_controls
    ØClick on remove button
    ØAnd verify the message is equal to “It's gone!”
    ØThen click on Add button
    And verify the message is equal to “It's back!”
            9:42
    HW: 2ØCreate a class:Synchronization4.
    ØCreate a method: isEnabled
    ØGo to https://the-internet.herokuapp.com/dynamic_controls
    ØClick enable Button
    ØAnd verify the message is equal to “It's enabled!”
    ØAnd verify the textbox is enabled (I can type in the box)
    ØAnd click on Disable button
    ØAnd verify the message is equal to “It's disabled!”
    ØAnd verify the textbox is disabled (I cannot type in the box)
    Ø
    ØNOTE: .isEnabled(); is used to check if an element is enabled or not

    */

    @Test
    public void homeWorkTest1(){

//       ØGo to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//       ØClick on remove button
        WebElement remove =driver.findElement(By.xpath("(//button)[1]"));
        remove.click();

//      ØAnd verify the message is equal to “It's gone!”
        WebElement aserrt= driver.findElement(By.id("message"));

        Assertions.assertEquals("It's gone!", aserrt.getText());

//        ØThen click on Add button

        WebElement addButton = driver.findElement(By.xpath("(//button)[1]"));
        addButton.click();

//        And verify the message is equal to “It's back!”

        WebElement aserrt1= driver.findElement(By.id("message"));

        Assertions.assertEquals("It's back!", aserrt1.getText());


    }
    //    HW: 2ØCreate a class:Synchronization4.
//    ØCreate a method: isEnabled

    @Test
    public void seleniumWait() {
//    ØGo to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//    ØClick enable Button
        WebElement clickButton = driver.findElement(By.xpath("(//div//button)[2]"));
        clickButton.click();

//    ØAnd verify the message is equal to “It's enabled!”
        WebElement verifyToEnabled = driver.findElement(By.xpath("//*[@id='message']"));
        Assertions.assertEquals("It's enabled!", verifyToEnabled.getText());

//    ØAnd verify the textbox is enabled (I can type in the box)
        WebElement textboxEnabled = driver.findElement(By.xpath("//*[@type='text']"));
        textboxEnabled.sendKeys("I can type in the box");
        System.out.println(textboxEnabled.getText());
        Assertions.assertTrue(textboxEnabled.isEnabled());

//    ØAnd click on Disable button
        WebElement clickDisableButton =  driver.findElement(By.xpath("(//button)[2]"));
        clickDisableButton.click();

//    ØAnd verify the message is equal to “It's disabled!”
      WebElement verifyToDisabled =  driver.findElement(By.xpath("//*[@id='message']"));
      Assertions.assertEquals("It's disabled!",verifyToDisabled.getText());

//    ØAnd verify the textbox is disabled (I cannot type in the box)
        WebElement textBoxDisabled = driver.findElement(By.xpath("//*[@type='text']"));

        Assertions.assertFalse(textBoxDisabled.isEnabled());

//    ØNOTE: .isEnabled(); is used to check if an element is enabled or not

    }
}
