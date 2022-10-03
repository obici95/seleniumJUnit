package practice04;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 {

    //Verify that we have pom.xml file in our project => please try in 4 min s


    @Test
    public void test01() {
        String path="C:\\Users\\90505\\IdeaProjects\\com.Batch81JUnit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(path))); // Su yoldan gelen dosya var mi?


    }
}
