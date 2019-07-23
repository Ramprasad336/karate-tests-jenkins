package examples;


import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;
import com.intuit.karate.Runner;
import com.intuit.karate.Results;
import com.intuit.karate.KarateOptions;


import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static org.testng.AssertJUnit.assertTrue;


public class TestSuiteKaraterunn {


   /* @Test
    public void testParallel() {
        System.setProperty("karate.env", "dev"); // ensure reset if other tests (e.g. mock) had set env in CI
        //System.setProperty("")
        System.setProperty("karate.options", "--tags @first,@second");
        Results results = Runner.parallel(getClass(), 1);
        generateReport(results.getReportDir());
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }*/

    @Test
    public void testParallel() {
        System.setProperty("karate.env", "dev"); // ensure reset if other tests (e.g. mock) had set env in CI
        //System.setProperty("")
        System.setProperty("karate.options", "--tags @first");
        Results results = Runner.parallel(getClass(), 1);
        generateReport(results.getReportDir());
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        /*for (File file : jsonFiles) {
            jsonPaths.add(file.getAbsolutePath());
        }*/
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "AUTHZ");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();

    }


    /*@Test
    public void testSelected() {
        //String[] a = {"@second","@first"};
        //String[] b = {"classpath:examples/users"};
        //List<String> tags = Arrays.asList("~@ignore");
        List<String> tags = new ArrayList<>();
        tags.add("@first,@second");
        //tags.add("@second");
        List<String> features = new ArrayList<>();
        features.add("classpath:examples/users");

        //List<String> features = Arrays.asList(b);
        String karateOutputPath = null;
        Results results = Runner.parallel(tags, features, 1, karateOutputPath);
        generateReport(results.getReportDir());
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }*/

   /* public static void main(String args[])
    {
        TestSuiteKaraterunn obj = new TestSuiteKaraterunn();

        obj.testParallel();
    }*/
}
