package Practice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day07TestBase {
  WebDriver driver;
  @BeforeEach
    public void setup() throws InterruptedException {
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      Thread.sleep(5000);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
  }
  @AfterEach
    public void quit(){
      driver.quit();
  }
}
