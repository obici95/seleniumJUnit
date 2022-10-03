package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
        int sonSatir=workbook.getSheet("Sayfa2").getLastRowNum();

        System.out.println(sonSatir);
        int expectedLastRow=6;
        Assert.assertEquals(expectedLastRow,sonSatir+1); // 6 satir var ama index 0'dan basladigi icin sonSatir'a 1 ekledik


        int kullanilanSatir=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows(); //kullanilan satir sayisini bu method ile aliriz.
        System.out.println(kullanilanSatir);

        int expectedKullanilanSatir=4;
        Assert.assertEquals(expectedKullanilanSatir,kullanilanSatir);

     //  lastRow --> en son yazilan satir
     //  Physical --> kullanilan satir sayisi

    }
}
