package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {

            /*

            ●https://www.amazon.com/ adresinegidin.
            -Test1
            Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
            oldugunu testedin
            -Test2
            1.Kategori menusunden Books seceneginisecin
            2.Arama kutusuna Java yazin vearatin
            3.Bulunan sonuc sayisiniyazdirin
            4.Sonucun Java kelimesini icerdigini testedin
        */

    static WebDriver driver;


    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){

       // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
       // oldugunu testedin
        List <WebElement> ddm= driver.findElements(By.xpath("//option"));
        System.out.println(ddm.size());
        for (WebElement each:ddm
             ) {
            System.out.println(each.getText());
        }

        int dropDownList=ddm.size();
        int expectedSayi=45;
        Assert.assertNotEquals(expectedSayi,dropDownList);

       // -Test2
       // 1.Kategori menusunden Books secenegini secin
       WebElement ddm1= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
       ddm1.sendKeys("Books");

       // 2.Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);


       // 3.Bulunan sonuc sayisini yazdirin
      List  <WebElement> sonucYazisi=driver.findElements(By.xpath("(//div[@class='sg-col-inner'])[1]"));
      String sonucYazisiStr=sonucYazisi.get(0).getText();
      String [] sonucSayisi=sonucYazisiStr.split(" ");
      System.out.println("Books kategorisinde Java icin bulunan sonuc sayisi : "+sonucSayisi[3]);




       // 4.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime="Java";
        String actualSonucYazisi=sonucYazisiStr;
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));



    }

}
