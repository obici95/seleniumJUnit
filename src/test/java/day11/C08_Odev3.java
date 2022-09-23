package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C08_Odev3 extends TestBaseBeforeAfter {
    // -  amazon gidin
    // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    // dropdown menude 40 eleman olduğunu doğrulayın
    // Test02
    // dropdown menuden elektronik bölümü seçin
    // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    // sonuc sayisi bildiren yazinin iphone icerdigini test edin
    // ikinci ürüne relative locater kullanarak tıklayin
    // ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
    // Test03
    // yeni bir sekme açarak amazon anasayfaya gidin
    // dropdown’dan bebek bölümüne secin
    // bebek puset aratıp bulundan sonuç sayısını yazdırın
    // sonuç yazsının puset içerdiğini test edin
    // 5-üçüncü ürüne relative locater kullanarak tıklayin
    // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
    // 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın


    @Test
    public void test01() {
        // -  amazon gidin
        driver.get("https://www.amazon.com");

        // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select=new Select(dropDownMenu);

        List<WebElement> sonucListesi=select.getOptions();
         // for (WebElement each:sonucListesi
         //      ) {
         //     System.out.println(each.getText());
         // }
         sonucListesi.forEach(System.out::println); // LAMBDA ile

        // dropdown menude 40 eleman olduğunu doğrulayın


    }

    @Test
    public void test02() throws InterruptedException {
        // Test02
        // dropdown menuden elektronik bölümü seçin
        driver.get("https://www.amazon.com");
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
         Select select=new Select(dropDownMenu);
         select.selectByVisibleText("Electronics");

        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        // sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(sonucYazisi.contains("iphone"));

        // ikinci ürüne relative locater kullanarak tıklayin
            WebElement ilkUrun= driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
            WebElement ikinciUrun=driver.findElement(with(By.tagName("img")).toRightOf(ilkUrun));
            ikinciUrun.click();

        // ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String urunTitle=driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String urunFiyat=driver.findElement(By.xpath("(//span[text()='$541.95'])[1]")).getText();
        System.out.println(urunTitle+" "+urunFiyat);
        WebElement urunLokasyonu=driver.findElement(By.id("contextualIngressPtLabel_deliveryShortLine"));
        urunLokasyonu.click();
        WebElement zipKodTextBox=driver.findElement(By.id("GLUXZipUpdateInput"));
        zipKodTextBox.sendKeys("10001");
        Thread.sleep(2500);
        driver.findElement(By.xpath("(//span[@class='a-button-inner a-declarative'])[3]")).click();
        Thread.sleep(2500);
      driver.findElement(By.xpath("(//span[@class='a-button a-column a-button-primary a-button-span4'])[2]")).click();
      Thread.sleep(3000);
      WebElement urunuSepeteEkle=driver.findElement(By.xpath("(//span[@id='submit.add-to-cart'])[1]"));
      urunuSepeteEkle.click();
    }

    @Test
    public void test03() {
        // Test03
        // yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://amazon.com");

        // dropdown’dan bebek bölümüne secin
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropDownMenu);
        select.selectByVisibleText("Baby");

        // baby clothes aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("baby clothes",Keys.ENTER);

        // sonuç yazsının clothes içerdiğini test edin
        String sonucYazisi="clothes";
        WebElement actualSonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(actualSonucYazisi.getText().contains(sonucYazisi));

        // 5-üçüncü ürüne relative locater kullanarak tıklayin
            WebElement ikinciUrun=driver.findElement(By.xpath("(//img[@class='s-image'])[2]"));
            WebElement dorduncuUrun=driver.findElement(By.xpath("(//img[@class='s-image'])[4]"));

            WebElement ucuncuUrun=driver.findElement(with(By.tagName("img")).toRightOf(ikinciUrun).toLeftOf(dorduncuUrun));
            ucuncuUrun.click();

        // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
      //  String urunTitle=driver.findElement(By.className("a-size-large product-title-word-break")).getText();
      //  String urunFiyat=driver.findElement(By.xpath("(//tr)[1]")).getText();
      //  System.out.println(urunTitle+" "+urunFiyat);
//
      //  WebElement sizeDDM=driver.findElement(By.xpath("(//span[@class='a-dropdown-prompt'])[1]"));
      //  Select select1=new Select(sizeDDM);
      //  select1.selectByIndex(2);
//
      //  WebElement addToCard=driver.findElement(By.id("add-to-cart-button"));
      //  addToCard.click();




        // Test 4
        // 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}
