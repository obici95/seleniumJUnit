package practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class asd extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iFrame= driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iFrame);

        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // tüm hayvan emojilerine tıklayın
        List <WebElement> animals=driver.findElements(By.xpath("//div[@id='nature']//img"));
      // for (WebElement w:animals
      //      ) {
      //     w.click();
      // }
        animals.forEach(t->t.click());

        // formu doldurun (dilediğinizi yazabilirsiniz) //input[@id='text']
        driver.switchTo().defaultContent();

        List <WebElement> boxes=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List <String> isimler=new ArrayList<>(Arrays.asList("ali","veli","ahmet","huseyin","kemal","canan","ebru","filiz","zeynep","hasan","mehmet"));
        for (int i = 0; i <boxes.size() ; i++) {
            boxes.get(i).sendKeys(isimler.get(i));
        }

        // apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();

    }
}
