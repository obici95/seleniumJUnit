package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_LoginTest {

    // 1- https://www.koalaresorthotels.com/ sayfasina gidiniz

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
       // driver.close();
    }

    @Test
    public void test01() {
        // 1- https://www.koalaresorthotels.com/ sayfasina gidiniz
        driver.get("https://www.koalaresorthotels.com/");

        //2- Login butonuna tiklayin
        driver.findElement(By.linkText("Log in")).click();

        // 3- Login ekranina girdiginizi 4 farkli WebElement'i kullanarak dogrulayiniz.
             //I
         Assert.assertTrue(driver.getTitle().contains("KoalaResortHotels"));

            // II
        String expectedUrl="https://www.koalaresorthotels.com/Account/Logon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        // III
        WebElement arananKelime=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(arananKelime.isDisplayed());

        //IV
        WebElement homeTusu=driver.findElement(By.id("navRooms"));
        Assert.assertTrue(homeTusu.isEnabled());

    }
}
