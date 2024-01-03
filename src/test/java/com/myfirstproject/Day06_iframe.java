package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day06_iframe extends TestBase {
    //  Go to https://testpages.herokuapp.com/styled/frames/frames-test.html
//    Then Assert that "Left List Item 29" is the last element in the "Left"
//    And Assert that "Middle List Item 39" is the last element in the "Middle"

     /*
    NOTES:
    - There are 3 ways to switch to frames : index, id or name, xpath
         1. driver.switchTo().frame(1);  // by index
         2. driver.switchTo().frame("left"); // by name or id
         3. driver.switchTo().frame("//frame[@name='left']"); // by xpath
    - When you want to switch to sibling frame (non-child), you need to switch to parent and then to the sibling frame

     */


    @Test
    public void iframeTest() {
//    Go to https://testpages.herokuapp.com/styled/frames/frames-test.html
        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
//    Then Assert that "Left List Item 29" is the last element
//        "Left List Item 29" element is INSIDE an iframe. So we need to SWITCH TO IFRAME FIRST
        driver.switchTo().frame(1);  // by index
//        driver.switchTo().frame("left"); // by name or id
//        driver.switchTo().frame("//frame[@name='left']"); // by xpath

        // NOW WE ARE INSIDE THE IFRAME
//        driver.findElement(By.id("left29"));
//       driver.findElement(By.xpath("//li[@id='left29']")); // hard way of testing if the last item in the list is "left29"
        String lastElement = driver.findElement(By.xpath("//li[last()]")).getText();
        // last() returns the last element every time. This way the xpath is more dynamic
        System.out.println(lastElement);
        Assertions.assertTrue(lastElement.equals("Left List Item 29"));


//    And Assert that "Middle List Item 39" is the last element in the "Middle"
//        At this point, driver is inside the "left" frame, we need to switch to parent frame
//        or default page level to switch to the "middle" frame
        driver.switchTo().parentFrame();  // OR
//       driver.switchTo().defaultContent();
        driver.switchTo().frame("middle"); // switching to the middle frame
        // now locate the last item
        String middleFrameLastItem = driver.findElement(By.xpath("//li[last()]")).getText();
        System.out.println("middleFrameLastItem = " + middleFrameLastItem);

        Assertions.assertTrue(middleFrameLastItem.equals("Middle List Item 39"));
    }
}
