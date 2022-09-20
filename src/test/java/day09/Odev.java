package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev {

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
     //  ---ODEV

     //  http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
     //  sayfadaki iframe sayısını bulunuz.
        int iframeSayisi=driver.findElements(By.xpath("//iframe")).size();
        System.out.println(iframeSayisi);

     //  ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement ilkFrame= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(ilkFrame);
       WebElement playButton= driver.findElement(By.xpath("//button[@aria-label='Play']"));
       playButton.click();

     //  ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

     //  ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
     //  tıklayınız

    }
}
