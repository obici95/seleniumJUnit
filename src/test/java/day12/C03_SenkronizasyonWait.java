package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C03_SenkronizasyonWait extends TestBaseBeforeAfter {
    // 1. Bir class olusturun : WaitTest
    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //    Iki metod icin de asagidaki adimlari test edin.
    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Remove butonuna basin.
    // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
    // 6. Add buttonuna basin
    // 7. It's back mesajinin gorundugunu test edin


    @Test
    public void implicitlyWaittest01() {
        // 1. Bir class olusturun : WaitTest
        // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
        /*
            imlicitly kullandigimiz bu method'da sayfadaki butun webelementler icin
            max belirttigimiz sure icinde butun webelementler icin bekler.
         */

        //    Iki metod icin de asagidaki adimlari test edin.
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebElement istGoneYazisi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(istGoneYazisi.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // 7. It's back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());

        //text ile olmayan bazi durumlarda text'e cift tirnak koyarsak bazen sorunu duzeltebiliyoruz
        //orn: //*[text()="It's gone!"] burda da it's derken tek tirnak var o yuzden hata alabiliriz.
    }

    @Test
    public void expilicitlyWaitTest02() {
        // Iki metod icin de asagidaki adimlari test edin.
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));//
        WebElement itsGoneWE= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneWE.isDisplayed());
        /*
         expilicitlyWait'de itsGoneWe elementi gorunur olmasini beklerken o webElementínin locateíni kullanarak
         assert yapmak sorun olur ve exeption firlatir.Henuz gorunmeyen bir webElement'in locate edilmesi de
         otomasyon icin mumkun olmaz.
         Bu durumda bekleme islemi icin expilicitlyWait'i locate ile birlikte kullaniriz.
         */

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();


        // 7. It's back mesajinin gorundugunu test edin
        WebElement itsBackWe=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBackWe.isDisplayed());

        //implicitly wait testten once calsitirilir ve calistirilan testin tamamina etki eder
        //explicitly wait ise once obje olarak olusturulur sonra
        // sadece kullanildigi yerde ve belirlenen sarta gore calisir class yada test in tamamina uygulanmaz
    }
}
