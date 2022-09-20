package day09;

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

public class C01_Iframe {

    /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
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
          driver.quit();
    }

    @Test
    public void test01() {

   // ● Bir class olusturun: IframeTest
   // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
   // ● Bir metod olusturun: iframeTest
   //    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        String expectedResult="An iFrame containing";
        String actualResult=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

   //    ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox=driver.findElement(By.id("mce_0_ifr")); //Frame'e gecis yapmadan once orayi id ile locate ederiz
        driver.switchTo().frame(textBox);// Locate ettigimiz frame'e gecmek icin bu method'u kullaniriz.
        WebElement iFrameTextBox=driver.findElement(By.xpath("//p"));

        iFrameTextBox.clear();
        iFrameTextBox.sendKeys("Merhaba Dunya!");

   //    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
   //      dogrulayin ve konsolda yazdirin

        //ana frame'e gecmem gerekiyor
        driver.switchTo().defaultContent();
        WebElement arananKelime= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(arananKelime.isDisplayed());
        System.out.println(arananKelime.getText());


    }

}
