package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExists {
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir")); // C:\Users\90505\IdeaProjects\com.Batch81JUnit
                                                           //Su anki icinde bulundugum yolu gosterir

        System.out.println(System.getProperty("user.home")); // C:\Users\90505
                                                             // kullanıcı klasörünü verir
        /*
        //diyelim ki masaustune dosya olusturduk ben bu dosyanin yerini dogrulayabilmem icin uzun yontem:
        String farkliBolum=System.getProperty("user.home");
        String ortakBolum="\\90505\\Desktop.text.txt";

        String masaustuDosyaYolu=farkliBolum+ortakBolum ;//Masaustundeki dosya yolunu gosterir

        System.out.println(masaustuDosyaYolu); // C:\Users\90505\90505\Desktop.text.txt
        System.out.println(Files.exists(Path.of(masaustuDosyaYolu)));
        Assert.assertTrue(Files.exists(Path.of(masaustuDosyaYolu)));

         */

       // Dosya yolu icin Shit tusuna basili tutup sag click yapiyoruz
        //Bastan ve sonra slash(/) isaretlerini siliyoruz ve asagidaki hale getiriyoruz.

        String dosyaYolu = "C:\\Users\\90505\\Desktop\\Text.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
          Bir websitesinden indirdigimiz ya da windows icinde olusturdugumuz dosyanin indigini ya da orda oldugunu
          test edebilmem icin o dosyanin uzerine shift tusuna basili olarak sag click yapip dosyanin yolunu kopyalayip
          bir string degiskene atariz ve dosyayi dogrulamak icin yani
          Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
          bu method'u kullaniriz.dogru dosyaysa zaten Test Passed yazar.

          sout icinde dogrulama yaptigimiz zaman ,dosya benim dedigim dosyaysa TRUE degilse FALSE doner.
          Masaüstündeki text.txt dosyasını oradan silersek veya adını değiştirirsek; FALSE yazar ve Test FAILED olur...
         */


    }
}
