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

public class C05_HandleDropdown {

     //  1. http://zero.webappsecurity.com/ Adresine gidin
     //  2. Sign in butonuna basin
     //  3. Login kutusuna “username” yazin
     //  4. Password kutusuna “password.” yazin
     //  5. Sign in tusuna basin
     //  6. Pay Bills sayfasina gidin
     //  7. “Purchase Foreign Currency” tusuna basin
     //  8. “Currency” drop down menusunden Eurozone’u secin
     //  9. “amount” kutusuna bir sayi girin
     //  10. “US Dollars” in secilmedigini test edin
     //  11. “Selected currency” butonunu secin
     //  12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
     //  13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

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
    public void test01() throws InterruptedException {
        //  1. http://zero.webappsecurity.com/ Adresine gidin
        Thread.sleep(500);
        driver.get("http://zero.webappsecurity.com/");

        //  2. Sign in butonuna basin
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //  3. Login kutusuna “username” yazin
        Thread.sleep(500);
        WebElement username= driver.findElement(By.xpath("//input[@id='user_login']"));
        username.sendKeys("username");

        //  4. Password kutusuna “password” yazin
        Thread.sleep(500);
        WebElement password = driver.findElement(By.xpath("//input[@name='user_password']"));
        password.sendKeys("password");

        //  5. Sign in tusuna basin
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();


        //  6. Online banking'e tiklayin ardindan Pay Bills sayfasina gidin
         Thread.sleep(500);
            WebElement onlineBanking=driver.findElement(By.xpath("//li[@id='onlineBankingMenu']"));
            onlineBanking.click();
            WebElement payBills = driver.findElement(By.xpath("//span[text()='Pay Bills']"));
            payBills.click();

        //  7. “Purchase Foreign Currency” tusuna basin
        Thread.sleep(1500);
        WebElement purchaseForeing=driver.findElement(By.linkText("Purchase Foreign Currency"));
        purchaseForeing.click();

        //  8. “Currency” drop down menusunden Eurozone’u secin
        Thread.sleep(500);
            WebElement ddm=driver.findElement(By.xpath("//select[@id='pc_currency']"));
            Select select=new Select(ddm);
            select.selectByVisibleText("Eurozone (euro)");

        //  9. “amount” kutusuna bir sayi girin
        Thread.sleep(500);
        WebElement amount= driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amount.sendKeys("500");

        //  10. “US Dollars” in secilmedigini test edin
        Thread.sleep(500);
        WebElement usDollarsButon=driver.findElement(By.xpath("(//label[@class='radio inline'])[2]"));
        Assert.assertFalse(usDollarsButon.isSelected());

        //  11. “Selected currency” butonunu secin
        Thread.sleep(500);
        driver.findElement(By.id("pc_inDollars_false")).click();


        //  12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        Thread.sleep(500);
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        //  13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        Thread.sleep(500);
        WebElement sonucYazisiWE=driver.findElement(By.xpath("//div[@id='alert_content']"));

        Assert.assertTrue(sonucYazisiWE.isDisplayed());

    }
}
