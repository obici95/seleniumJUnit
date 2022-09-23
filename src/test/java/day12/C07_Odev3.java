package day12;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C07_Odev3 extends TestBaseBeforeAfter {
    // 1."http://webdriveruniversity.com/" adresine gidin
    // 2."Login Portal" a  kadar asagi inin
    // 3."Login Portal" a tiklayin  4.Diger window'a gecin
    // 5."username" ve  "password" kutularina deger yazdirin
    // 6."login" butonuna basin
    // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin  8.Ok diyerek Popup'i kapatin
    // Ilk sayfaya geri donun
    // Ilk sayfaya donuldugunu test edin


    @Test
    public void test01() throws InterruptedException {
        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        // 2."Login Portal" a  kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

        // 3."Login Portal" a tiklayin

        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();


        // 4.Diger tab'a gecin

        List<String> handleDegerleri=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handleDegerleri.get(1));




        // 5."username" ve  "password" kutularina deger yazdirin
        Faker faker=new Faker();

        WebElement username=driver.findElement(By.xpath("//input[@id='text']"));
       username.sendKeys(faker.name().firstName());
       actions.sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB,Keys.ENTER).perform();


      // WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
      // username.sendKeys("alican");
      // password.sendKeys("123456");

        // 6."login" butonuna basin
        Thread.sleep(2500);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("login-button")).click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin  8.Ok diyerek Popup'i kapatin
        Assert.assertEquals("validation failed",driver.switchTo().alert().getText());

        // Ilk sayfaya geri donun
        driver.switchTo().window(handleDegerleri.get(0));

        // Ilk sayfaya donuldugunu test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("http://webdriveruniversity.com/"));

    }
}
