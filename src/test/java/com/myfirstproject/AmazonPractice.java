package com.myfirstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
//go to website
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        Thread.sleep(10000); //give time to enter captcha code manually
        driver.findElement(By.tagName("button")).click();
        //click to verify captcha code and go to the website

        //locate the search box
       WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
        //tagname input?
        if (search.getTagName().equals("input")){
            System.out.println("pass");
        }
        //name attribute= field keyword?
        WebElement search2= driver.findElement(By.id("twotabsearchtextbox"));
        if (search2.getAttribute("name").equals("field-keywords")){
            System.out.println("pass2");
        }
        //amazon sayfasina gittik ve testlerimizi yaptik

    driver.quit();
    }
}
