package day08_Allerts;

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

public class C02_Allerts {
    /*
    Bir web sirtesine girdimizde karsimiza bir uyari mesaji yada bir butona tikladigimizda bir uyari(alert)
    cikabilir. Eger bu uyarıya incele(sag tik-inspect) yaoabiliyorsak bu tur alertt'lere HTML alert denir
    ve istedigimiz locate'i alabiliriz fakat gelen uyari kutusuna mudahale (sag tik-incele) edemiyorsak
    bu tur alert'lere jd alert denir. js alert'lere mudahale edebilmek icin
    - tamam yada ok icin --> driver.switchTo().alert().accept() kullanilir
    - iptal icin --> driver.switchTo().alert().dismiss() kullanilir
    - Alert icindekiğ mesaji almak icin --> driver.switchTo().alert().getText() kullanilir
    - Alert bizde bir metin istiyorsa --> driver.switchTo().alert().sendKeys() kullanilir
 */

  // ● Bir class olusturun: Alerts
    // ● Bir class olusturun: Alerts
    // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //             ● Bir metod olusturun: acceptAlert
    // ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    // “You successfully clicked an alert” oldugunu test edin.
    // ● Bir metod olusturun: dismissAlert
    // ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    // “successfuly” icermedigini test edin.
    // ● Bir metod olusturun: sendKeysAlert
    //  ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    // tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

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
    public void test01() throws InterruptedException {
       // ● Bir class olusturun: Alerts
        // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //             ● Bir metod olusturun: acceptAlert
        // ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        String expectedResult="You successfully clicked an alert";
        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void test02() throws InterruptedException {
        // ● Bir metod olusturun: dismissAlert
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        // “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        //Allert uzerindeki yaziyi yazdirin
        System.out.println("2. method'un alert mesaji "+driver.switchTo().alert().getText());

        // uyarıdaki Cancel butonuna tıklayın
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        //ve result mesajının “successfuly” icermedigini test edin.
        String beklenmeyenMesaj="successfuly";
        String asilMesaj=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertFalse(asilMesaj.contains(beklenmeyenMesaj));

    }

    @Test
    public void test03(){
        // ● Bir metod olusturun: sendKeysAlert
        //  ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        // tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Baki Tatli");
        driver.switchTo().alert().accept();

        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult="Baki Tatli";
        Assert.assertTrue(actualResult.contains(expectedResult));

        //https protokolu



    }


}
