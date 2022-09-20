package day10;

import org.junit.Test;
import utilities.TestBaseBeforClassAfterClass;

public class C02_IlkTestBaseClass extends TestBaseBeforClassAfterClass {

    @Test
    public void test01(){
        driver.get("https://amazon.com");
    }

}
