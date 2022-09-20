package practice;

import org.junit.*;

public class C03_Junit {
    //JUnitte main method kullanmamiza gerek kalmiyor notasyonlari kullaniyoruz
    // JUnit notasyonlarinda alfabeye gore calistirir.
    //

 // @BeforeClass
 // public static void beforeClass(){
 //     System.out.println("BeforeClass");
 //     //Her class'ta ilk basta bu calisir, 1 defa calisir
 // }

 // @AfterClass
 // public static void beforeClass(){
        System.out.println("AfterClass");
        //En son
   // }

    @Before
    public void before(){
        System.out.println("Before");
        //Her testten once calisir
    }

    @After
    public void after(){
        System.out.println("After");
        //her testten once calisir
    }



    @Test
    public void test01(){
        System.out.println("Test01 calisti");
    }

    @Test
    public void test02(){
        System.out.println("Test02 calisti");
    }

    @Test
    public void best03(){
        System.out.println("Best03 calisti");
    }
}
