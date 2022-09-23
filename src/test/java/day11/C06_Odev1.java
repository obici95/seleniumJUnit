package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C06_Odev1 extends TestBaseBeforeAfter {
    // Yeni Class olusturun ActionsClassHomeWork
    // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    // 2- Hover over Me First" kutusunun ustune gelin
    // Link 1" e tiklayin
    // Popup mesajini yazdirin
    // Popup'i tamam diyerek kapatin
    // “Click and hold" kutusuna basili tutun
    // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
    // 8- “Double click me" butonunu cift tiklayin

    @Test
    public void test01() throws InterruptedException {
      // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

      // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMe=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverOverMe).perform();


      // Link 1" e tiklayin
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

      // Popup mesajini yazdirin
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());

        // Popup'i tamam diyerek kapatin
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

      // “Click and hold" kutusuna basili tutun
        Thread.sleep(2000);
        WebElement clickAndHoldKutusu=driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHoldKutusu).perform();

      // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        Thread.sleep(2000);
        String cickAndHoldYazisi=clickAndHoldKutusu.getText();
        System.out.println(cickAndHoldYazisi);

      // 8- “Double click me" butonunu cift tiklayin
        Thread.sleep(2000);
        WebElement doubleClickMeButonu=driver.findElement(By.xpath("//h2"));
        actions.doubleClick(doubleClickMeButonu).perform();


    }
}
