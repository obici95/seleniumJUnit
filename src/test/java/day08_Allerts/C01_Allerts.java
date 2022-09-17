package day08_Allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {
      /*
       -  https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        - Click for JsAlert'e butonuna tiklayalim
        - tikladikdan sonra cikan uyari mesajina(allert'e) tamam diyelim.
        -
       */

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
       // -  https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

       // - Click for JsAlert'e butonuna tiklayalim
        Thread.sleep(2000);
           driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

       // - tikladikdan sonra cikan uyari mesajina(allert'e) tamam diyelim.
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
}
