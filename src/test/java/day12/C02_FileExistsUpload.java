package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_FileExistsUpload extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // chooseFile butonuna basalim
      WebElement dosyaSec = driver.findElement(By.id("file-upload"));

      /*
        Dosya sec butonuna direkt click yapinca hata alabiliriz
        cunku windows'a mudahaele edemeyebiliriz.
        Bu yuzden dosyasec butoununu direkt locate edip
        sendKeys() method'u ile String degiskene atadigimiz dosya yolumuzu gonrediriz
       */

        // Yuklemek istediginiz dosyayi secelim.
        String yuklenecekDosya="C:\\Users\\90505\\Desktop\\Text.txt";
        dosyaSec.sendKeys(yuklenecekDosya);

        // Upload butonuna basalim.
        driver.findElement(By.className("button")).click();

        // “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());


    }
}
