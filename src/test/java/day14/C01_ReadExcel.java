package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    //- Dosya yolunu bir String degiskene atayalim
    //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //- WorkbookFactory.create(fileInputStream)
    //- Sheet objesi olusturun workbook.getSheetAt(index)
    //- Row objesi olusturun sheet.getRow(index)
    //- Cell objesi olusturun row.getCell(index)
    //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin


    @Test
    public void readExcelTest01() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis= new FileInputStream(dosyaYolu); // Olusturmus oldugumuz dosyayi sistemde isleme alir.

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); //Workbook objjesi uzerinden fis objesi ile akisa aldigimiz dosyamizla bir excel dosyasi create ettik.


        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");//Excel dosyamizda calismak istedigimiz sayfayi bu sekilde seceriz

        //- Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(3); //Sayfa 1'deki 3. satiri bu sekilde seceriz

        //- Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3); // satir secimi yapildiktan sonra hucre secimi bu sekilde yapilir
        System.out.println(cell);
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);
        Assert.assertEquals(expectedData,cell.getStringCellValue());

     // Ara-->dosyaYolu
     // Windows Gezgini ile ac-->FileInputStream
     // Excel i ac-->Workbook
     // Sayfa1 e git-->Sheet
     // Satiri bul-->Row
     // Sutunu bul-->Cell
    }
}
