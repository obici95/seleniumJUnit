package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C01_GetscreenShotWE extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {
        //Amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //Nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);


        //Arama sonucunun resmini alalim
        WebElement aramaSonucu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu=aramaSonucu.getScreenshotAs(OutputType.FILE);

        //Sadece WebElement'in resmini alacaksak TakeScreenShot class'ini kullanmaya gerek yok
        //Locate ettigimiz webelementi direkt gecici bir file'a atip FileUtils ile copyalayip yolunu(path) belirtiriz
        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekranGoruntusuWE/WebElementSS.jpg"));

    }
}
