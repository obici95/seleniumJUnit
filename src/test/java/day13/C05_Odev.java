package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforClassAfterClass;

public class C05_Odev {


    public class HM1_webtables1 extends TestBaseBeforClassAfterClass {
        /*
                Bir class oluşturun : D18_WebTables
            login( ) metodun oluşturun ve oturum açın.
            https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
            Username : manager  ○ Password : Manager1!
            table( ) metodu oluşturun
            Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
            Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
            printRows( ) metodu oluşturun //tr
            table body’sinde bulunan toplam satir(row) sayısını bulun.
            Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
            4.satirdaki(row) elementleri konsolda yazdırın.
            printCells( ) metodu oluşturun //td
            table body’sinde bulunan toplam hücre(cell) sayısını bulun.
            Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
            printColumns( ) metodu oluşturun
            table body’sinde bulunan toplam sutun(column) sayısını bulun.
            Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
            5.column daki elementleri konsolda yazdırın.
         */
        @Test
        public void test01() {
            // Bir class oluşturun : D18_WebTables
            // login( ) metodun oluşturun ve oturum açın.
            //         https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
            // Username : manager  ○ Password : Manager2!
            login();

            //         table( ) metodu oluşturun
            table();
            // printRows( ) metodu oluşturun //tr
            // table body’sinde bulunan toplam satir(row) sayısını bulun.
            //         Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
            // 4.satirdaki(row) elementleri konsolda yazdırın.
            //         printCells( ) metodu oluşturun //td
            // table body’sinde bulunan toplam hücre(cell) sayısını bulun.
            //         Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
            // printColumns( ) metodu oluşturun
            // table body’sinde bulunan toplam sutun(column) sayısını bulun.
            //         Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
            // 5.column daki elementleri konsolda yazdırın.
            //         */
        }

        private void table() {
            // Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
            // Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        }

        private void login() {
            //   https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
            //   Username : manager  ○ Password : Manager2!
            driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");
            WebElement username = driver.findElement(By.xpath("//input[@id='UserName']"));
            username.sendKeys("manager");
            WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
            password.sendKeys("Manager1!");
            driver.findElement(By.className("btn btn-success uppercase")).click();
        }

    }
}