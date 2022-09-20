package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_ActionsSoruCozumu extends TestBaseBeforeAfter {
    // 1 Yeni bir class olusturalim: MouseActions1
    // 2 https://the-internet.herokuapp.com/context_menu sitesine gidelim
    // 3 - Cizili alan uzerinde sag click yapalim
    // 4  Alert’te cikan yazinin “You selected a context menu” oldugunu
    //  test edelim.
    // 5 Tamam diyerek alert’i kapatalim
    // 6 Elemental Selenium linkine tiklayalim
    // 7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test01(){
      // 1 Yeni bir class olusturalim: MouseActions1
      // 2 https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

      // 3 - Cizili alan uzerinde sag click yapalim
        Actions actions =new Actions(driver);
        WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan).perform();


      // 4  Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
            // String beklenenAlertYazisi="You selected a context menu";
            // String actualAlertYazisi=  driver.switchTo().alert().getText();
            //   Assert.assertEquals(beklenenAlertYazisi,actualAlertYazisi);
        //2. yol
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

      // 5 Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

      // 6 Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());// Bu iki kisim ile 2 tane window handle degerini arrayListe attim
        driver.switchTo().window(windowList.get(1));// index0'daki 1. sayfa, index1'deki ikinci sayfa olmus oluyor


      // 7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String expectedResult="Elemental Selenium";
        String actualResult=driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedResult,actualResult);

        //2.yol
     //   Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());

    }


}
