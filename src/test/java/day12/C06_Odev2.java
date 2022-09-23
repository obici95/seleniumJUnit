package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C06_Odev2 extends TestBaseBeforeAfter {
    // “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    // “Our Products” butonuna basin
    // “Cameras product”i tiklayin
    // Popup mesajini yazdirin
    // “close” butonuna basin
    // "WebdriverUniversity.com (IFrame)" linkini tiklayin
    // "http://webdriveruniversity.com/index.html" adresine gittigini test edin


    @Test
    public void test01() throws InterruptedException {
        // “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // “Our Products” butonuna basin
        Thread.sleep(1300);
        WebElement frameGecis=driver.findElement(By.xpath("//*[@id='frame']"));
        driver.switchTo().frame(frameGecis);
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();

        // “Cameras product”i tiklayin
        Thread.sleep(1300);
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();

        // Popup mesajini yazdirin  //h4[@class='modal-title'] , //div[@class='modal-body']


        Thread.sleep(1300);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='modal-title']"))).getText();
        String popUpMesaji=driver.findElement(By.xpath("//h4[@class='modal-title']")).getText();

        Thread.sleep(1300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']"))).getText();
        String pupUPMesaji2=driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(popUpMesaji+"\n"+pupUPMesaji2);

        // “close” butonuna basin
        Thread.sleep(1300);
        driver.findElement(By.xpath("//*[text()='Close']")).click();


        // "WebdriverUniversity.com (IFrame)" linkini tiklayin
        Thread.sleep(1300);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("WebdriverUniversity.com (IFrame)")));
        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();

        // "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Thread.sleep(1300);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='CONTACT US']")).isDisplayed());
    }
}
