package Practice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q4Calculate {
    WebDriver driver;  // class level ... larger scope

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Implicit wait
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void additionTest(){

//        Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
//        Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
//        Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("6");
//        Type any number in the second input
        driver.findElement(By.cssSelector("#number2")).sendKeys("8");
//        Click on Calculate
        driver.findElement(By.id("calculate")).click();
//        Get the result
        String result = driver.findElement(By.id("answer")).getText();

//        Verify the result
        Assertions.assertEquals(result, "14");
//        Print the result
        System.out.println("result = " + result);
//        Close the browser by using @AfterEach annotation

    }

    //     HW
    @Test
    public void multiplyTest(){
        //        Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
//        Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
//        Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("6");
//        Type any number in the second input
        driver.findElement(By.cssSelector("#number2")).sendKeys("8");
       WebElement dropdown =driver.findElement(By.xpath("//select[@id='function']"));
        Select multiply= new Select(dropdown);
        multiply.selectByValue("times");
//        Click on Calculate
        driver.findElement(By.id("calculate")).click();
//        Get the result
        String result = driver.findElement(By.id("answer")).getText();

//        Verify the result
        Assertions.assertEquals(result, "48");
//        Print the result
        System.out.println("result = " + result);
//        Close the browser by using @AfterEach annotation

    }
    @Test
    public void subtractTest(){
//        Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
//        Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
//        Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("6");
//        Type any number in the second input
        driver.findElement(By.cssSelector("#number2")).sendKeys("8");
        WebElement dropdown =driver.findElement(By.xpath("//select[@id='function']"));
        Select subtract= new Select(dropdown);
        subtract.selectByValue("minus");
//        Click on Calculate
        driver.findElement(By.id("calculate")).click();
//        Get the result
        String result = driver.findElement(By.id("answer")).getText();

//        Verify the result
        Assertions.assertEquals(result, "-2");
//        Print the result
        System.out.println("result = " + result);
//        Close the browser by using @AfterEach annotation
    }
    @Test
    public void divisionTest(){
//        Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
//        Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
//        Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("6");
//        Type any number in the second input
        driver.findElement(By.cssSelector("#number2")).sendKeys("8");
        WebElement dropdown =driver.findElement(By.xpath("//select[@id='function']"));
        Select divide= new Select(dropdown);
        divide.selectByValue("divide");
//        Click on Calculate
        driver.findElement(By.id("calculate")).click();
//        Get the result
        String result = driver.findElement(By.id("answer")).getText();

//        Verify the result
        Assertions.assertEquals(result, "0.75");
//        Print the result
        System.out.println("result = " + result);
//        Close the browser by using @AfterEach annotation
    }
}
