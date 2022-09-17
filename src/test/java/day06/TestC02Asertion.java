package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestC02Asertion {

    /*
      Amazon sayfasina gidelim
      3 farkli test method'u olusturalim
        a-url'nin amazon icerdigini tes edin
        b-title'in facebook icermedigini test edelim
        c-sol ust kosede amazon logosunun gorundugunu test edelim
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");

    }


    @AfterClass
    public static void tearDown(){
     //   driver.close();


    }

    @Test
    public void test1(){
      //  a-url'nin amazon icerdigini tes edin


    }

    @Test
    public void test2(){
        //   b-title'in facebook icermedigini test edelim
        String expectedUrl = "https://www.facebook.com";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);


    }


    @Test
    public void test3(){
        //   c-sol ust kosede amazon logosunun gorundugunu test edelim


    }





}
