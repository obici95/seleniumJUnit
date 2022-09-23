package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBaseBeforeAfter { // bu class'tan obje olusturulmamasi icin de abstract class yaptim
    protected WebDriver driver; // en alt duzeyde erisilebilen protected oldugu icin protected yaptim

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup(); // boni garcia'ya selam
        driver=new ChromeDriver();
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
      //  driver.quit();
    }
}
