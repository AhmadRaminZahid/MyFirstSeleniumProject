package Practice;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3FormFill {
       /*
Create chrome driver by using @BeforeEach annotation and  Selenium WebDriver
Go to url : http://www.gmibank.com/
Click on 'User Icon’
Click on 'Register’
Enter SSN
Enter First Name
Enter Last Name
Enter Address
Enter Phone Number
Enter Username
Enter Email
Enter New password
Enter New password confirmation
Click on Register button
Assert that user registered
Close the browser by using @AfterEach annotation

     */

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
    public void formTest() throws InterruptedException {
        Faker faker = new Faker();
// Go to url : http://www.gmibank.com/
        driver.get("http://www.gmibank.com/");

//Click on 'User Icon’
        WebElement userIcon = driver.findElement(By.id("account-menu"));
        userIcon.click();
//Click on 'Register’
        WebElement registerOption =  driver.findElement(By.linkText("Register"));
        registerOption.click();
//Enter SSN
        driver.findElement(By.id("ssn")).sendKeys("341-56-"+ faker.number().numberBetween(1000,9999));
//        driver.findElement(By.cssSelector("#ssn")).sendKeys("");
//Enter First Name
        driver.findElement(By.id("firstname")).sendKeys(faker.name().firstName());
//Enter Last Name
        driver.findElement(By.cssSelector("#lastname")).sendKeys(faker.name().lastName());
//Enter Address
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys("California, US");
//Enter Phone Number
        driver.findElement(By.id("mobilephone")).sendKeys("123-456-7890");
//Enter Username
        driver.findElement(By.name("username")).sendKeys(faker.name().username());
//Enter Email
        driver.findElement(By.cssSelector("#email")).sendKeys(faker.internet().emailAddress());
//Enter New password
        driver.findElement(By.name("firstPassword")).sendKeys("testing_2024!");
//Enter New password confirmation
        driver.findElement(By.name("secondPassword")).sendKeys("testing_2024!");
        Thread.sleep(2000);
//Click on Register button
        driver.findElement(By.id("register-submit")).click();
        Thread.sleep(2000);
//Assert that user registered
        WebElement toast = driver.findElement(By.xpath("(//div[@role='alert'])[1]"));
        String successMessage =  toast.getText();
        System.out.println("successMessage = " + successMessage);

        Assertions.assertTrue(successMessage.contains("Registration saved!"));

//Close the browser by using @AfterEach annotation

    }
}
