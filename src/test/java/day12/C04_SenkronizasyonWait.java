package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C04_SenkronizasyonWait extends TestBaseBeforeAfter {
    // 1. Bir class olusturun : EnableTest
    // 2. Bir metod olusturun : isEnabled()
    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Textbox’in etkin olmadigini(enabled) dogrulayın
    // 5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    // 6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    // 7. Textbox’in etkin oldugunu(enabled) dogrulayın


    @Test
    public void isEnableTest01() {
     //   1. Bir class olusturun : EnableTest
     //   2. Bir metod olusturun : isEnabled()
     //   3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

     //   4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

     //   5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement eneblaTextBox=wait.until(ExpectedConditions.elementToBeClickable(textBox));
        Assert.assertTrue(eneblaTextBox.isEnabled());

     //   6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnabledYazisi.isDisplayed());

     //   7. Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(textBox.isEnabled());
    }
}
