package com.myfirstproject;

import Utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day08_Cookies extends TestBase {
    @Test
    public void cookiesTest() throws InterruptedException {
        //        Go to amazon  https://www.google.com/
driver.get("https://www.google.com");
//        Find the total number of cookies
        Set<Cookie> allcookies= driver.manage().getCookies();
        System.out.println("totalcookies= "+allcookies.size());
//        Print all the cookies
for (Cookie eachcookie :allcookies){
    System.out.println("cookie"+eachcookie);
    System.out.println("name"+eachcookie.getName());
    System.out.println("value"+eachcookie.getValue());
}
//        Get the cookies by their name
        System.out.println(driver.manage().getCookieNamed("1P_JAR"));
//        Add new cookie
Cookie myfavcookie= new Cookie("mycookie","login-detail2024");
driver.manage().addCookie(myfavcookie);
for (Cookie each:driver.manage().getCookies()){
    System.out.println(each);
}
//        Delete all cookies
        driver.manage().deleteCookieNamed(myfavcookie.toString());
        driver.manage().deleteAllCookies();

    }
}
