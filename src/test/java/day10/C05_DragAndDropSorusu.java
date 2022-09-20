package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_DragAndDropSorusu extends TestBaseBeforeAfter {
    //  Yeni bir class olusturalim: MouseActions2
    //  1 https://demoqa.com/droppable adresine gidelim
    //  2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //  3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01(){
     //  Yeni bir class olusturalim: MouseActions2
     //  1 https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

     //  2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeButon=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereButon=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMeButon,dropHereButon).perform();

     //  3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());

    }
}
