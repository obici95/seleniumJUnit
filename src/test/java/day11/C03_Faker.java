package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void test01() {

      // "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

      // “create new account”  butonuna basin
        driver.findElement(By.linkText("Create New Account")).click();

      // “firstName” giris kutusuna bir isim yazin
        Faker faker=new Faker();
        WebElement firsNameTextBox= driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions actions =new Actions(driver);
        String email=faker.internet().emailAddress(); //Formda iki kere mail istedi, bir mail girdigimde 2. maili rastgele girmesin diye ,
                                                    // Ayni mail adresini girmesi icin String bir degiskene atama yaptik.
        /*
        Faker class'ini kullanma amacimiz form doldurmamiz gereken websitelerde defalarca kendi uretecegimiz veriler yerine
        faker bizim icin rastgele veriler uretir dolayisiyla bizim de isimiz kolaylasmis olur.
          Faker class'i kullanmak icin mvnrepostory.com adresinden java-faker kutuphanesini aratir ve en cok kullanilani
          pom.xml dosyamiza ekleriz ve faker class'indan bir obje olusturup :
                email icin--> faker.internet().emailAddress(); method'unu seceriz.bunu bir Stringe de atayabiliriz.
                password icin--> aynisni kullanilir
                isim ve soyisimler icin-->  faker.name().firstName(),faker.name().lastName() methodlarini kullaniriz.
                                            --> sendKeys(faker.name().firstName()) gibi.
         */

        actions.click(firsNameTextBox).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("6")
                .sendKeys(Keys.TAB)
                .sendKeys("5")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


      // Sayfayi kapatin
    }
}
