package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_NavigateBack {
        /*
    1- Bir class oluşturun: DropDown
    2- https://the-internet.herokuapp.com/dropdown adresine gidin.
    3- Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4- Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    5- Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    6- Tüm dropdown değerleri(value) yazdırın
    7- Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse False yazdırın.
      */
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
       // 2- https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

       // 3- Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

       // 4- Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
       select.selectByValue("2");
       System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=================================");


       // 5- Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=================================");

       // 6- Tüm dropdown değerleri(value) yazdırın
           List <WebElement> tumDegerler=  select.getOptions();

          for (WebElement each:tumDegerler
               ) {
              each.getText();
          }

         //LAMBDA
       //  tumDegerler.forEach(t-> System.out.println(t.getText()));
       // System.out.println(select.getAllSelectedOptions().get(0).getText());



       // 7- Dropdown'un boyutunu bulun (yani kac tane element var), Dropdown'da 4 öğe varsa konsolda True , degilse False yazdırın.
        System.out.println("DropDown boyutu  : "+tumDegerler.size());
          if (tumDegerler.size()==4){
              System.out.println("True");
          }else {
              System.out.println("False");
          }
        Assert.assertNotEquals(tumDegerler.size(),4);

    }

}
