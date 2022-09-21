package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.security.Key;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test01() {
      //  1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

      //  2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.linkText("Create New Account")).click();

      //  3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
        WebElement firsNameTextBox= driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        actions.click(firsNameTextBox)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Can")
                .sendKeys(Keys.TAB)
                .sendKeys("alibak@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("alibak@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("123456")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("6")
                .sendKeys(Keys.TAB)
                .sendKeys("5")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                        .sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                        .sendKeys(Keys.ENTER).perform();


     // 4- Kaydol tusuna basalim

    }
}
