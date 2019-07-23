package examples;

import com.intuit.karate.junit5.Karate;


public class ExamplesTest {
    // this will run all *.feature files that exist in sub-directories
    // refer to https://github.com/intuit/karate#naming-conventions
    // for folder-structure recommendations and naming conventions

    /*@Karate.Test
    Karate testSample() {
        return new Karate().feature("classpath:examples/users").relativeTo(getClass());
    }*/

   /* @Karate.Test
    Karate testTags() {
        return new Karate().feature("users").tags("@first").relativeTo(getClass());
    }*/

/*    @Karate.Test
    Karate testFullPath() {
        return new Karate()
                .feature("classpath:examples/users")
                .tags("@first,@second");
    }*/
}