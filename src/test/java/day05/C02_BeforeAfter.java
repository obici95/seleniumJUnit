package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    WebDriver driver;

    @Before
    public void setup(){ //before notasyonu kullanilacaksa genel olarak setup yazilir
                        //before notasyonu her testten once calisir
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void method1(){
        //1 defa before(setup) method'u calisir
        driver.get("https://www.amazon.com");
        //1 defa da after(tearDown) method'u calisir
    }
    @Test
    public void method2(){
        //burda da before after calisiyor
        driver.get("https:www.techproeducation.com");
    }
    @Test
    public void method3(){
        //burda da before after calisiyor
        driver.get("https:www.hepsiburada.com");
    }

    @After
    public void tearDown(){ //After notasyonu da genelde tearDown olarak kullaniliyor
        driver.close();     //After notasyonu her testten sonra calisir
    }


}
