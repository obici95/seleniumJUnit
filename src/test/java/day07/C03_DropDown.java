package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

    }

    @After
    public void tearDown(){
        driver.close();
    }

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

    @Test
    public void test01(){
                /*
        DropDown menuye ulasmak icin select class'indan bir obje olustururuz
        ve locate ettigimiz dropdown webelement'inin select class'ina tanimlariz
        ve getOption methodunu kullanarak dropdown'u bir liste atarak dropdown menunun
        butun elemanlarının sayısına ulasabiliriz
         */

        //https://www.amazon.com/ adresinegidin

       //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
       //oldugunu testedin
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select =new Select(ddm);
        List <WebElement> ddmList=select.getOptions();
        System.out.println(ddmList.get(5).getText());
        System.out.println(ddmList.size());
        int expectedSayi=45;
        int actualSayi=ddmList.size();
        Assert.assertNotEquals(expectedSayi,actualSayi);



    }

    @Test
    public void test02(){
        // 1.Kategori menusunden Books seceneginisecin
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select =new Select(ddm);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Books");


        // 2.Arama kutusuna Java yazin vearatin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);

        // 3.Bulunan sonuc sayisiniyazdirin
        String sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        System.out.println(sonucYazisi);
        String [] sonucSayisi=sonucYazisi.split(" ");
        System.out.println(sonucSayisi[3]+" sonuc bulundu");

        // 4.Sonucun Java kelimesini icerdigini testedin
        String expectedResult="Java";
        Assert.assertTrue(sonucYazisi.contains(expectedResult));

        /*
           Dropdown menude sectigimiz option'a ulasmak istersek select.getFirstSelectedOption()
           methodunu kullaniriz.
         */

    }
}
