package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day09_Actions2 extends TestBase {
    @Test
    public void actionsTest() throws InterruptedException {
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(3000);
//        And user moves the target element(Drag me to my target) in to destination(Drop here)
        switchIframeByIndex(0);// reusable method that we have created in testbase class
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
      //  actions.dragAndDrop(source,target).perform();
       // actions.clickAndHold(source).moveToElement(target).build().perform();
        actions.clickAndHold(source).moveToElement(target).release().build().perform();

//        actions.dragAndDropBy(source,207,267).perform(); // this method works with the given x , y coordinates
        Thread.sleep(2000);
        actions.dragAndDropBy(source,383,-10).perform(); // this method works with the given x , y coordinates,
        // minus sign makes it move along y coordnates (upwards)
        /*
        HW: ØGiven user is on the
https://testcenter.techproeducation.com/index.php?page=context-menu
When user Right-clicks on the box
Then verify the alert message is “You selected a context menu”
Then accept the alert
         */
    }
}
