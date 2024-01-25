package Practice;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Day20Q3_ClickTypes extends TestBase {
    //    Go to https://testpages.herokuapp.com/styled/events/javascript-events.html

//    Click all the buttons and verify they are all clicked

    @Test
    public void clickTypesTest() throws InterruptedException {

//    Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        Thread.sleep(3000);
//    Click all the buttons and verify they are all clicked
        WebElement onBlur =  driver.findElement(By.id("onblur"));
        WebElement onClick =  driver.findElement(By.id("onclick"));
        WebElement onContextMenu =  driver.findElement(By.id("oncontextmenu"));
        WebElement onDoubleClick =  driver.findElement(By.id("ondoubleclick"));
        WebElement onFocus =  driver.findElement(By.id("onfocus"));
        WebElement onkeyDown =  driver.findElement(By.id("onkeydown"));
        WebElement onkeyUp =  driver.findElement(By.id("onkeyup"));
        WebElement onkeyPress =  driver.findElement(By.id("onkeypress"));
        WebElement onMouseOver =  driver.findElement(By.id("onmouseover"));
        WebElement onMouseLeave =  driver.findElement(By.id("onmouseleave"));
        WebElement onMouseDown =  driver.findElement(By.id("onmousedown"));

        Actions actions = new Actions(driver);

        actions
                .click(onBlur)
                .pause(1000)
                .click(onClick)// to activate onBlur button
                .pause(1000)
                .click(onClick)// to activate onClick button itself
                .pause(1000)
                .contextClick(onContextMenu)// we need to right click to activate onContextMenu button
                .pause(1000)
                .doubleClick(onDoubleClick)// we need to double click to activate onDoubleClick button
                .pause(1000)
                .click(onFocus)// works like normal click
                .pause(1000)
                .click(onkeyDown).sendKeys(Keys.ARROW_DOWN)// we need to press arrow down from keyboard to activate onkeyDown button
                .pause(1000)
                .click(onkeyUp).sendKeys(Keys.ARROW_UP) // we need to press arrow up from keyboard to activate onkeyUp button
                .pause(1000)
                .click(onkeyPress).sendKeys(Keys.SPACE)// we need to press any key from keyboard to activate onkeyPress button
                .pause(1000)
                .moveToElement(onMouseOver)// need to hover over this button
                .pause(1000)
                .moveToElement(onMouseLeave)// when mouse hovers over but then move away
                .pause(1000)
                .click(onMouseDown)
                .click(onMouseDown)
                .perform();

        // Verify that all events are triggered

        List<WebElement> eventsTriggered = driver.findElements(By.xpath("//p[.='Event Triggered']"));
        System.out.println("Number of events triggered: "+ eventsTriggered.size());

        Assertions.assertEquals(11, eventsTriggered.size());

    }
}
