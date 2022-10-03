package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {
        //Amazon sayfasina gidelin tum sayfanin resmini alalim
        driver.get("https://amazon.com");

        TakesScreenshot ts= (TakesScreenshot) driver;
        /*
         Bir web sayfasinin resmini alabilmek icin TakesScreenshot class'indan obje olusturup
         Gecici bir File class'indan degiskene TakesScreenShot'dan olusturdugum objeden ts.getScreenshotAs(OutputType.FILE);
         method'unu kullanarak gecici bir file olustururuz.
         */

        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/enkranGoruntusu/allPage.jpg")); // bu tarz raporlamalar icin genelde target klasoru kullanilir

        //Once gitmemiz gereken sayfayi yazdik

    }
}
