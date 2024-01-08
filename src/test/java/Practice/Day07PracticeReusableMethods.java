package Practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class Day07PracticeReusableMethods extends Day07TestBase{
@Test
    public void bestsellers() throws InterruptedException {
    driver.navigate().to("https://www.kitapyurdu.com/");
    driver.findElement(By.xpath("//span[@title='Söyleme Bilmesinler']"));
    List<WebElement> listsOfBooks = driver.findElements(By.xpath("(//span[@class='name'])[position()>=1 and position()<=10]"));
    System.out.println(listsOfBooks.size());

    for (int i=0;i<listsOfBooks.size();i++){
        String book = listsOfBooks.get(i).getText();
        System.out.println(book);
        WebElement element=listsOfBooks.get(i);
        element.click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
    }

}
}
