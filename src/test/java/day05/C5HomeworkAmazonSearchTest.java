package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C5HomeworkAmazonSearchTest {

      //  Class Work Amazon Search Test
      //  1 https://www.amazon.com/ sayfasina gidelim
      //  2 arama kutusunu locate edelim
      //  3 “Samsung headphones” ile arama yapalim
      //  4 Bulunan sonuc sayisini yazdiralim
      //  5 Ilk urunu tiklayalim
      //  6 Sayfadaki tum basliklari yazdiralim



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
    public void test01(){

    //  1 https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

    //  2 arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

    //  3 “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

    //  4 Bulunan sonuc sayisini yazdiralim
       List  <WebElement> sonucYazisi=  driver.findElements(By.xpath("//div[@class='sg-col-inner'][1]"));
        String sonuclar=sonucYazisi.get(0).getText();
        String [] sonucSayisi = sonuclar.split(" ");
        System.out.println("Samsung headphones icin sonuc sayisi : "+sonucSayisi[2]);


        //  5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("//div[@class='aok-relative'][1]")).click();

    //  6 Sayfadaki tum basliklari yazdiralim
        System.out.println(driver.findElement(By.xpath("//span[@id='productTitle']")).getText());

    }


}
