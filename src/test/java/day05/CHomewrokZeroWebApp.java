package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CHomewrokZeroWebApp {

          // 1. http://zero.webappsecurity.com sayfasina gidin
          // 2. Signin buttonuna tiklayin
          // 3. Login alanine “username” yazdirin
          // 4. Password alanine “password” yazdirin
          // 5. Sign in buttonuna tiklayin
          // 6. Pay Bills sayfasina gidin
          // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
          // 8. tarih kismina “2020-09-10” yazdirin
          // 9. Pay buttonuna tiklayin
          // 10. “The payment was successfully submitted.” mesajinin ciktigini control edin

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
      //  driver.close();
    }

    @Test
    public void test2() throws InterruptedException {
        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        // 3. Login alanine “username” yazdirin
        Thread.sleep(1000);
          WebElement username= driver.findElement(By.xpath("//input[@id='user_login']"));
          username.sendKeys("username");

        // 4. Password alanine “password” yazdirin
        Thread.sleep(1000);
        WebElement password= driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        // 5. Sign in buttonuna tiklayin
        Thread.sleep(1000);
        WebElement sigINButon= driver.findElement(By.xpath("//input[@name='submit']"));
        sigINButon.click();
        driver.navigate().back();

        //ONLINE BANKING yazisina tiklayin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();

        // 6. Pay Bills sayfasina gidin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        Thread.sleep(1000);
        WebElement amount=driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("500");

        // 8. tarih kismina “2020-09-10” yazdirin
        Thread.sleep(1000);
        WebElement date=driver.findElement(By.xpath("//*[@id='sp_date']"));
        date.sendKeys("2020-09-10");

        // 9. Pay buttonuna tiklayin
        Thread.sleep(1000);
        WebElement payButon= driver.findElement(By.id("pay_saved_payees"));
        payButon.click();
        // 10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        String expectedResult="The payment was successfully submitted.";
        String actualResult=driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']")).getText();
     //   String actualResult2=actualResult.getText();
        Assert.assertEquals("Test fail oldu",expectedResult,actualResult);

    }


}
