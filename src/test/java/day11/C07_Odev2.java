package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C07_Odev2 extends TestBaseBeforeAfter {
   // Bir Class olusturalim KeyboardActions2
   // https://html.com/tags/iframe/ sayfasina gidelim
    // 3- video’yu gorecek kadar asagi inin
   // videoyu izlemek icin Play tusuna basin
   // videoyu calistirdiginizi test edin


    @Test
    public void test01() {
        // Bir Class olusturalim KeyboardActions2
        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // 3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // videoyu izlemek icin Play tusuna basin
        WebElement iFrameAlani=driver.findElement(By.xpath("//iframe[@height='315']"));
        driver.switchTo().frame(iFrameAlani);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        // videoyu calistirdiginizi test edin
    }
}
