package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01(){
        // 1-Amazon sayfasina gidelim
        driver.get("https://amazon.com");
        // 2- Account menusunden create a list linkine tiklayalim

        Actions actions=new Actions(driver);
        WebElement account=driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(account).perform();
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();

              /*

          Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
          actions.moveToElement() methodunu kullanmamız gerekir.
          Aksi takdirde html kodları arasında web elementi bulur ama
          ulaşamadığı için ElemenNotInteractableException: element not interactable exception'i fırlatır

         */


    }
}
