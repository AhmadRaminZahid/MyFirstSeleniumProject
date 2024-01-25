package Practice;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day20HW2 extends TestBase {
    @Test
    public void hw2(){

        //    Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

//    Fill the username, password and textArea comment:
        Faker faker= new Faker();
        WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(faker.name().username());
        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());
        WebElement comment= driver.findElement(By.xpath("//textarea"));
        comment.sendKeys("Hello World!");


//    Choose a file and upload it
    WebElement fileButton= driver.findElement(By.xpath("//input[@name='filename']"));
    String path= "";
    fileButton.click();
//    Select all checkboxes, first radio item and first dropdown

//    Click on submit

//    Verify that uploaded file name is on the Form Details.

    }

}
