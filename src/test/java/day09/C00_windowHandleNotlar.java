package day09;

public class C00_windowHandleNotlar {
    /*
        1) *** windowHandle() nedir?   -- bir tur hashCodu'dur. uygulamanin verdigi her sekmeye ozel handle kodudur.
       -- driver.getWindowHandle(); -- Icinde oldugumuz sayfanin window handle degerini ALMA. Handle değerini verir.
       -- driver.switchTo().window(sayfa1HandleDegeri); -- --Pencereler arasında gecis yapmak icin window handle degerini kullaniriz.
        Pencereler arasında geçiş yapma  switchTo() ile olur.

        *** switchTo() -- 3 farkli elementte kullanilir. 1)windows 2) Alert  3)iframe

         **** windowHandles() nedir?  --- actığımız sekmelerin driver.getWindowHandles(); -- birden fazla sekmenin handle değerini almak için.
                1) Set atip ordan alip kullanmak için ;

                Set<String> windowHandleseti= driver.getWindowHandles(); --> setin içine attık
                System.out.println(windowHandleseti);
                String ikinciSayfaWindowHandleDegeri="";

                 for (String each: windowHandleseti
                    ) {
                    if (!each.equals(ilkSayfaWindowHandleDegeri)){
                        ikinciSayfaWindowHandleDegeri=each;  }
                        }

                2) ArrayList'e atarak kullanmak - Listin ilk indexi ilk acilan sayfadir. buna gore acilan sekmelerin
                handle degerlerini kolayca bulabiliriz.
                List<String> windowHandleDegerleriList = new ArrayList<>(driver.getWindowHandles());
                String ikinciSyfhandleDegeri=driver.switchTo().window(windowHandleDegerleriList.get(1);

                 driver.switchTo().window(windowHandleDegerleriList.get(1)); --> ikinci index ikinci sayfa/sekme


        2)  ChromeDriver ile yeni sekme açma-
        driver.switchTo().newWindow(WindowType.TAB) --> driver ile yeni sekme açar
        driver.switchTo().newWindow(WindowType.WINDOW) --- driver ile yeni pencere açar.

        driver.switchTo().newWindow(WindowType.TAB) kodunu yazdiktan sonra driver.get(__url_) ile sayfaya gidip,
        arzu edilen işlemler yapılabilir.


        3) bir linke bağlı olan webElemente tıkladiğimizda yeni sekme açarsa, açılan sekmeye nasil ulaşırız?
            driver.getWindowHandles(_____); --> açık olan sayfalarin handle değerlerini verdiigi için, burdan istedigimiz degeri
            almak için Liste atayip kullanabiliriz.

          *** switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
          biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
          ve yeni sayfa ile ilgili hicbir islem yapamaz
          yeni sayfada driver'i calistirmak isterseniz
          once driver'i yeni sayfaya yollamalisiniz

         -1. sekmedeyken
         List<String> windowHandleDegerleriList = new ArrayList<>(driver.getWindowHandles());

         String ikinciSyfhandleDegeri = windowHandleDegerleriList.get(1);
         driver.switchTo().window(windowHandleDegerleriList.get(1));

 */
}
