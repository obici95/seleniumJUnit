package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class C09_Pdf_Sayfa125 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
            driver.get("https://the-internet.herokuapp.com/download");

        //3. test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();


        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
    }
}
