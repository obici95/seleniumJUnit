package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_windowHandle {
  // Yeni bir class olusturun: WindowHandle
  // Amazon anasayfa adresine gidin.
  // Sayfa’nin window handle degerini String bir degiskene atayin
  // Sayfa title’nin “Amazon” icerdigini test edin
  // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
  // Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
  // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
  // Sayfa title’nin “Walmart” icerdigini test edin
  // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

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
        // Yeni bir class olusturun: WindowHandle
        // Amazon anasayfa adresine gidin.
        driver.get("https:amazon.com");

        // Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandleDegeri=driver.getWindowHandle();

        // Sayfa title’nin “Amazon” icerdigini test edin
        String arananKelime="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));

        // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");


        // Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String istenenKelime="TECHPROEDUCATION";
        String actualTitle2= driver.getTitle();
        Assert.assertFalse(actualTitle2.contains(istenenKelime));

        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        // Sayfa title’nin “Walmart” icerdigini test edin
        String istenenTitle="Walmart";
        String actualTitle3=driver.getTitle();
        Assert.assertTrue(actualTitle3.contains(istenenTitle));

        // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandleDegeri);
        System.out.println(driver.getCurrentUrl());

    }

  //  Tests package’inda yeni bir class olusturun: WindowHandle2
  //  https://the-internet.herokuapp.com/windows adresine gidin.

  //  Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
  //  Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
  //  Click Here butonuna basın.
  //  Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
  //  Sayfadaki textin “New Window” olduğunu doğrulayın.
  //  Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

    /*
     ---ODEV
     Bir class olusturun: IframeTest02
http://demo.guru99.com/test/guru99home/ sitesine gidiniz

sayfadaki iframe sayısını bulunuz.
ilk iframe'deki (Youtube) play butonuna tıklayınız.
ilk iframe'den çıkıp ana sayfaya dönünüz
ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
tıklayınız
     */

}
