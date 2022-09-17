package day04_VideoTekrarSorulari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Delete10KezTest {

    // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    // 2- Add Element butonuna 10 kez basiniz
    // 3- Add Element butonuna 10 kez basildigini test ediniz
    // 4- Delete butonu gorunmeyene kadar basiniz
    // 5- Delete butonunun gorunmedigini test ediniz
    // 6- Sayfayi kapatiniz

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){

       // driver.close();
    }

    @Test
    public void deleteTesti(){
        // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // 2- Add Element butonuna 10 kez basiniz
        WebElement addElementButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        int count=1;
        while (count<=10){
            addElementButton.click();
            count++;
        }


        // 3- Add Element butonuna 10 kez basildigini test ediniz
        List<WebElement> deleteSayisi = driver.findElements(By.xpath("//button[text()='Delete']"));
        if (deleteSayisi.size()==10){
            System.out.println("10 kez basilmis test PASSED");
        }else {
            System.out.println("10 kez basilmamis FAILED");
        }

        // 4- Delete butonu gorunmeyene kadar basiniz
        WebElement deleteButonu=driver.findElement(By.xpath("(//button[text()='Delete'])[10]"));

        for (WebElement each:deleteSayisi
             ) {
            deleteButonu.click();
        }

        // 5- Delete butonunun gorunmedigini test ediniz
        if (!deleteButonu.isDisplayed()){
            System.out.println("Delete butonu gorunmuyor, test PASSED");
        }

        // 6- Sayfayi kapatiniz

    }











}
