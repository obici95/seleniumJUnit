package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_windowHandle {
    //1- Amazon Sayfasina girelim
    //2- Url'nin amazon içerdiğini test edelim
    //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
    //4- title'in BestBuy içerdiğini test edelim
    //5- İlk sayfaya dönüp sayfada java aratalım
    //6- Arama sonuclarının java içerdiğini test edelim
    //7- Yeniden bestbuy sayfasına gidelim
    //8- Logonun görünürlüğünü test edelim
    //9- Sayfaları Kapatalım


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
      //  driver.close();
    }

    @Test
    public void test01() {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();
        /*
            Eger bize verilen task'de  sayfalar arasi gecis varsa driver.get() methodundan sonra
            driver'in window handle degerini String bir degiskene atariz
            Sonrasinda farkli bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya donmemiz istenirse
            String degiskene atadigimiz windowHanle degerleriyle sayfalar arasi gecis yapabiliriz.

         */

        //2- Url'nin amazon içerdiğini test edelim
        String arananKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle="Best Buy";
        String bestBuyWindowHandle=driver.getWindowHandle();
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));


        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        String  aramaSonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String arananKelime2="java";
        Assert.assertTrue(aramaSonucYazisi.contains(arananKelime2));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);

        //8- Logonun görünürlüğünü test edelim
        WebElement bestBuyLogoWE=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(bestBuyLogoWE.isDisplayed());

        //9- Sayfaları Kapatalım
        driver.quit();

    }



}
