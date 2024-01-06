package Utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    //    DROPDOWN
//    Create a reusable method that select dropdown option by index
    public static void dropdownSelectByIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public static void dropdownSelectByIndex(By locator, int index){  // This method will work for any type of locator e.g. name, tagName, linkText, xpath etc.
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public static void dropdownSelectByIndex(String xpath, int index){  // This method will work with xpath only
        WebElement element = driver.findElement(By.xpath(xpath));
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public static void dropdownSelectByVisibleText(WebElement dropdownElement, String text){
        Select select =new Select(dropdownElement);
        for (int i =0;i<select.getOptions().size();i++){
            if(select.getOptions().get(i).getText().equalsIgnoreCase(text)){
                select.getOptions().get(i).click();
                break;
            }
        }
    }
    public static void dropdownSelectByValue(WebElement dropdownElement, String value) {
        Select objSelect = new Select(dropdownElement);
        objSelect.selectByValue(value);
    }
    public static void dropdownSelectCustomMethod(WebElement dropdownElement,String textOfDropdown){
        List<WebElement> options = dropdownElement.findElements(By.tagName("option"));
        for (WebElement option : options){
            System.out.println(option.getText());
            if (option.getText().equals(textOfDropdown)){
                option.click();
                break;
            }
        }
    }
    public static WebElement dropdownSelectRandomly(Select select) {
        Random random = new Random();
        List<WebElement> list = select.getOptions();
        int optionIndex = 1 + random.nextInt(list.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }
    public ArrayList<String> dropdownGetSelectedOptions(WebElement dropdownElement) throws Exception {
        if (dropdownElement!=null){
            Select list = new Select(dropdownElement);
            ArrayList<WebElement> allSelectedOptions = (ArrayList<WebElement>) list.getAllSelectedOptions();
            ArrayList<String> result = new ArrayList<String>();
            for (WebElement eachSelected : allSelectedOptions){
                result.add(eachSelected.getText());
            }
            return result;
        }else {
            throw new Exception("No element is returned");
        }
    }
    //    ALERTS
    public static void alertAccept() {
        driver.switchTo().alert().accept();
    }
    public static void alertDismiss() {
        driver.switchTo().alert().accept();
    }
    public static String alertGetText() {
        return driver.switchTo().alert().getText();
    }
    public static void alertTypeOnAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
    //    IFRAMES
    public static void switchIframeByIndex(int index){
        driver.switchTo().frame(index);
    }
    public static void switchIframeByIdOrName(String idOrName){
        driver.switchTo().frame(idOrName);
    }
    public static void switchIframeByWebElement(WebElement element){
        driver.switchTo().frame(element);
    }
    //    WINDOWS !!!
    //    Switch by page index. INDEX starts at (0) : switchNewWindowByIndex(0)
    public static void switchNewWindowByIndex(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }
    //    Switch by page title : switchNewWindowByTitle("title of the new page");
    public static void switchNewWindowByTitle(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String childWindow : driver.getWindowHandles()) {
            driver.switchTo().window(childWindow);
            if (driver.getTitle().equals(targetTitle)) {
                System.out.println("Switched to the window : "+targetTitle);
                return;
            }
        }
        driver.switchTo().window(origin);
    }

}
