package Utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    /*
   - We keep TestBase class abstract because we don't want to create object from this class
   - TestBase class is used to store repetitive methods which are used as pre-conditions or post-conditions
   - We make WebDriver protected because we want it to be available for all classes within this project

   -TestBase will be extended to classes where test steps are and this class will provide before and after methods automatically

    */
    protected static WebDriver driver;
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }
    @AfterEach
public void tearDown(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.quit();
    }
}
