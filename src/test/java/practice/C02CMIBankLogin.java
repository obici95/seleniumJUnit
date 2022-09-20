package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02CMIBankLogin {

    public static void main(String[] args) {
        // https://www.gmibank.com/ adresine gidin

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // 1- https://www.gmibank.com/ adresine gidin
        driver.get("https://www.gmibank.com/");

        // 2- sign in butonuna tiklayin
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();

        // 3- User name: Batch81, Password: Batch81+
        WebElement usarName= driver.findElement(By.xpath("//input[@name='username']"));
        usarName.sendKeys("Batch81");
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Batch81+");
        driver.findElement(By.xpath("(//span[text()='Sign in'])[3]")).click(); // sign in butonuna click yaptim
    }


}
