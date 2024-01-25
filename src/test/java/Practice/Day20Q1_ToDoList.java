package Practice;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Day20Q1_ToDoList extends TestBase {

     /*
    Given
 Go to http://webdriveruniversity.com/To-Do-List/index.html
 When
    Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
 And
    Strikethrough all todos.
 And
    Delete all todos.
 Then
    Assert that all todos deleted.
     */

    @Test
    public void toDoList() {
//        Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
//        Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        // First locate the element where you want to send the list of tasks
        WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));

        // Create a list, put all tasks in that list and use a loop to send them all together

        List <String> toDoList = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));

        for (String w: toDoList){
            inputField.sendKeys(w, Keys.ENTER);
        }


//        Strikethrough all todos
        List<WebElement> tasksDone =  driver.findElements(By.xpath("//li"));
//        for (WebElement w : tasksDone){
//            w.click();
//        }

//        LAMBDA is Recommended
        tasksDone.forEach(WebElement::click);

//        Delete all todos
        List<WebElement> deleteOption = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        deleteOption.forEach(WebElement::click);

//        Assert that all todos deleted
        System.out.println("List size = " + tasksDone.size());

        // There is a synchronisation issue here. So we add 2 seconds hard wait allow the driver some time to synchronise with the deleting action that we did
        waitFor(2); // HARD WAIT
        List<WebElement> listAfterDelete = driver.findElements(By.xpath("//li"));
        System.out.println("After deleting: "+ listAfterDelete);
        Assertions.assertTrue(listAfterDelete.isEmpty());

        // OR
//        Assertions.assertTrue(driver.findElements(By.xpath("//li")).isEmpty());

    }
}
