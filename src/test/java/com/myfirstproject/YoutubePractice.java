package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YoutubePractice {
    WebDriver driver = new ChromeDriver();
    @BeforeEach
    public void setup() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
   @AfterEach
  public void quit(){
   driver.quit();
   }

    @Test
    public void signIn(){
        driver.findElement(By.xpath("//div[@class='yt-spec-touch-feedback-shape__fill'][1]")).click();


    }
}
