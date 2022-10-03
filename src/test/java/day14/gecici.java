package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class gecici {



    @Test
    public void readTest01() throws IOException {
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

        // getLastRowNum() method'u bize excel sayfasindaki tum satir numarasini verir
        int sonSatirNo=workbook.getSheet("Sayfa1").getLastRowNum();

      //  String turkceBaskentler="Satir sayisi"+sonSatirNo;
      //  for (int i = 1; i <=sonSatirNo ; i++) {
      //      turkceBaskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
      //      System.out.println(i+". baskent : "+turkceBaskentler);
      //  }

        //2. yol LAMBDA ile
        List<String> baskentList=new ArrayList<>();
        for (int i = 1; i <=sonSatirNo ; i++) {
            baskentList.add(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }
        baskentList.forEach(System.out::println);
    }
}
