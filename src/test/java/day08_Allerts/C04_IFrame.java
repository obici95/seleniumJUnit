package day08_Allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_IFrame {

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
    public void test01() {
        // https://html.com/tags/iframe/ adresine gidiniz
        // YouTube videosunu calistiriniz
        driver.get("https://html.com/tags/iframe/");
        /*
            Bir websitesinde bir video(youtube vb.) varsa ve <iframe> tag'i icerisindeyse bu videoyu direkt locate edip
            calistirmak dinamik olmaz, cunku link degisebilir ve locate'imiz calismaz
            Bunun icin butun frameleri bir arrayList'e atip index ile frame'i secip sonrasinda play tusunu locate edip
            calistirabiliriz.
         */
        List<WebElement> iframeList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0)); //1.iframe'e gecmis oldu.artik youtube videsounun play tusuu locate edip click yapacagim
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();






    }


}
