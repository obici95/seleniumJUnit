package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C04_ReadExcel {
    @Test
    public void readExcelTes01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook=WorkbookFactory.create(fis);


        //-Turkce baskentler sutununu yazdiralim
          //burda for dongusu yapmamiz gerek cunku butun baskentleri yazmamiz gerek
          //getLastRowNumber methodunu kullancagiz , bize son satirin kacinci satir oldugunu index (index 0'dan baslar)olarak verir.
        int sonSatirNo=workbook.getSheet("Sayfa1").getLastRowNum();
        // getLastRowNum() method'u bize excel sayfasindaki tum satir numarasini verir
        System.out.println(sonSatirNo);

        String turkceBaskentler ="Satir sayisi "+sonSatirNo;
        for (int i = 0; i <=sonSatirNo ; i++) {
            turkceBaskentler=workbook.getSheet("Sayfa1")
                    .getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);
        }

        // LAMBDA ile
        List<String> list=new ArrayList<>();
        for (int i = 0; i <=sonSatirNo ; i++) {
            list.add(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }
        list.forEach(t-> System.out.println(t));
    }
}
