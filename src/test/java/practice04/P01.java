package practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {
    // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    // ikinci emojiye tıklayın (hayvan emojisini seçin)
    // tüm hayvan emojilerine tıklayın
    // formu doldurun (dilediğinizi yazabilirsiniz)
    // apply butonuna tıklayın


    @Test
    public void test() {

        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iFrame=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iFrame);

        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
           //NoSuchElementException gordugumuzde aklimiza iframe gelebilir.


        // tüm hayvan emojilerine tıklayın
      List<WebElement> animals= driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img")); //Mumkun mertebe cift slash // kullanmak gerekir
                                                                                                                                  //  Tek slash kabul / edilmez
          // for (WebElement w:animals
          //      ) {
          //     w.click();
          // }
            //2. yol Lambda ile
            animals.forEach(t->t.click());

        // formu doldurun (dilediğinizi yazabilirsiniz)
        driver.switchTo().defaultContent();
       List <WebElement> boxes= driver.findElements(By.xpath("//input[@class='mdl-textfield__input']")); // tum textboxlari bir listin icine koymus oldum

        // bu listi kullanarak her bir webElementi kolayca boxes listinde bulunan webElementlerimize gonderebilecegiz.
       List <String> text =new ArrayList<>(Arrays.asList("bu","listi","kullanarak","her","bir","webelementi","kolayca","boxes","listinde","u","a","e"));

        for (int i = 0; i <boxes.size() ; i++) {
            boxes.get(i).sendKeys(text.get(i));
        }


        // apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();



    }

}
