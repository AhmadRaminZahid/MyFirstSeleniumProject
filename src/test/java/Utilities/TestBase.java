package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
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
    public void setUp(){
        driver = new ChromeDriver(); // instantiating chrome driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Implicit wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // allows time to the page to load
        driver.manage().window().maximize();
    }
    @AfterEach
    public void tearDown() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Implicit wait if needed
        Thread.sleep(3000);
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
    //ACTIONS_DOUBLE CLICK : doubleClick(buttonElement)
    public static void actionsDoubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }
    //    ACTIONS_HOVER_OVER
    public static void actionsHoverOnElement(WebElement element) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }
    //    ACTIONS_SCROLL_DOWN
    public static void actionsScrollDown() {
        //        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }
    //    ACTIONS_SCROLL_UP
    public static void actionsScrollUp() {
        //        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }
    //    ACTIONS_SCROLL_RIGHT
    public static void actionsScrollRight(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }
    //    ACTIONS_SCROLL_LEFT
    public static void actionsScrollLeft(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }
    //    ACTIONS_DRAG_AND_DROP
    public static void actionsDragAndDrop(WebElement source, WebElement target) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source,target).perform();
    }
    //    ACTIONS_DRAG_AND_DROP_BY
    public static void actionsDragAndDrop(WebElement source, int x, int y) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source,x,y).perform();
    }
    //    JS EXECUTOR METHODS
    /*
    click with JS
    param : WebElement
    action : clicks on the given element
     */
    public static void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }
    //    EXPLICITLY WAIT FOR ELEMENT TO BE VISIBLE, SCROLL INTO THE ELEMENT, THEN CLICK BY JS
    public static void clickWithTimeoutByJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(element,5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }
    /*
    scroll into specific elements
    param : WebElement
    action: scrolls into the given element
     */
    public static void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    /*
    scroll all the way down
     */
    public static void scrollAllDownJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    /*
    scroll all the way UP
     */
    public static void scrollAllUpJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    /*
     locating elements by javascript executor-normally we may not need this at all
    param : id of the element
    return WebElement
     */
    public WebElement locateElementByJS(String id){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return ((WebElement)js.executeScript("return document.getElementById('"+id+"')"));
    }
    /*
    getting the VALUE of elements-useful to get the values of input elements where getText() doesn't work
    param : id of the element
    locating the element and returning the value of the element
    return document.getElementById('"+id+"') -> RETURNS THE ELEMENT BY ID
    return document.getElementById('"+id+"').value -> RETURNS THE VALUE ATTRIBUTE OF THE ELEMENT
    toString() -> RETURN THE VALUE AS STRING
     */
    public static String getValueByJS(String id){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.getElementById('"+id+"').value").toString();
    }
    /*
    @param1 WebElement, @param2 String
    type the string in that input element
     */
    public static void setValueByJS(WebElement inputElement,String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",inputElement);
    }
    /*   HARD WAIT:
    @param : second
  */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*
   SELENIUM WAIT REUSABLE METHODS
    */
    //    DYNAMIC SELENIUM WAITS:
    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    //    ROBOT UPLOAD FILE
    public static void uploadFile(String pathOfFile) {
        // Following try/catch -- all JAVA classes+logic
        try {
            waitFor(1);
//            copy the path of the file that is given on the clipboard (desktop window pop-up
            StringSelection stringSelection = new StringSelection(pathOfFile);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//            creating robot object
            Robot robot = new Robot();
//            press control V = paste
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            waitFor(1);
//            release control V
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            waitFor(1);
//            press enter
            robot.keyPress(KeyEvent.VK_ENTER);
//            release enter
            robot.keyRelease(KeyEvent.VK_ENTER);
            waitFor(1);
            System.out.println("Upload is completed...");
        } catch (Exception e) {
        }

    }
//    SCREENSHOT : capture the screenshot of the entire page

    public void captureScreenshotOfEntirePage(){
//        1. getScreenShotAs method to capture the screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        save the image in a path with a dynamic name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  // To provide Unique name for each screenshot
        String filePath = System.getProperty("user.dir")+"/test-output/Screenshots/"+now+"image.png";
//        save the image in the path
        try {
            FileUtils.copyFile(image, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //    SCREENSHOT : capture the screenshot of the GIVEN Element Only

    public void captureScreenshotOfElement(WebElement element){
//        1. getScreenShotAs method to capture the screenshot
        File image = element.getScreenshotAs(OutputType.FILE);
//        save the image in a path with a dynamic name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  // To provide Unique name for each screenshot
        String filePath = System.getProperty("user.dir")+"/test-output/ElementScreenshot/"+now+"image.png";
//        save the image in the path
        try {
            FileUtils.copyFile(image, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //    SCREENSHOT : capture the screenshot of the entire page  (For EXTENT REPORTS)

    public static String captureScreenshotOfEntirePageAsString(){
//        1. getScreenShotAs method to capture the screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        save the image in a path with a dynamic name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  // To provide Unique name for each screenshot
        String filePath = System.getProperty("user.dir")+"/test-output/Reports/"+now+"image.png";
//        save the image in the path
        try {
            FileUtils.copyFile(image, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new File(filePath).getAbsolutePath();
    }
    /*
 REUSABLE METHOD FOR EXTENT REPORTS
    Create 3 Extent Report objects:
    1. ExtentReports -> creates reports
    2. ExtentHTML Reporter -> provides report templates
    3. ExtentTest -> logs test steps; only THIS WILL BE CALLED IN THE TEST CLASS
     */
protected static ExtentReports extentReports;
protected static ExtentHtmlReporter extentHtmlReporter;
protected static ExtentTest extentTest;
/*
    Create BeforeAll method -- runs the pre-requisites for the Extent Report generation
    AfterAll method generates the reports (using flush(), without this flush,
    we can't create the reports (like perform() in Actions class)
 */
    @BeforeAll
public static void setExtentReports(){
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  // To provide Unique name for each screenshot
        String reportPath = System.getProperty("user.dir")+"/test-output/Reports/"+now+"extent-report.html";

        extentReports= new ExtentReports();
        extentHtmlReporter= new ExtentHtmlReporter(reportPath);

        //*****optional *******
        //Add Custom information regarding your project/ test for Extent Reports
    extentReports.setSystemInfo("Project Name","My Selenium Project");
    extentReports.setSystemInfo("Browser","Chrome");
    extentReports.setSystemInfo("Team Name","B197");
    extentReports.setSystemInfo("QA","Ramin");
    extentReports.setSystemInfo("Environment","UAT");
    //***********Optional******add documents informations related to the project/test to extentHtmlReporter
        extentHtmlReporter.config().setReportName("My First Report");
        extentHtmlReporter.config().setDocumentTitle("My first extent");



//now attach extentReports and extentHtmlReporter
        extentReports.attachReporter(extentHtmlReporter);
//now create extentTest

        extentTest= extentReports.createTest("Login test","Batch197_Smoke test suite");

    }
    @AfterAll
public static void flushExtentReports(){
extentReports.flush();
    }
}
