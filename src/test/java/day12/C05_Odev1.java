package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Odev1 extends TestBaseBeforeAfter {

    // "http://webdriveruniversity.com/Actions" sayfasina gidin
    // "Hover over Me First" kutusunun ustune gelin
    // "Link 1" e tiklayin
    // Popup mesajini yazdirin
    // Popup'i tamam diyerek kapatin
    // "Click and hold" kutusuna basili tutun
    // "Click and hold" kutusunda cikan yaziyi yazdirin
    // "Double click me" butonunu cift tiklayin


    @Test
    public void test01() throws InterruptedException {
        // "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverOverMeFirst).perform();

        // "Link 1" e tiklayin
        Thread.sleep(1300);
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();

        // Popup mesajini yazdirin.
        Thread.sleep(1300);
        System.out.println(driver.switchTo().alert().getText());

        // Popup'i tamam diyerek kapatin
        Thread.sleep(1300);
        driver.switchTo().alert().accept();

        // "Click and hold" kutusuna basili tutun
        Thread.sleep(1300);
        WebElement clickAndHoldWE=driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHoldWE).perform();




        // "Click and hold" kutusunda cikan yaziyi yazdirin
        Thread.sleep(1300);
        System.out.println(clickAndHoldWE.getText());

        // "Double click me" butonunu cift tiklayin
        Thread.sleep(1300);
        WebElement doubleClickWE=driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(doubleClickWE).perform();
    }
}
