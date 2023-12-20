
package nl.test;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SLTestRunner.class)
@SLTestSuite({"nl/tests"})
public class SLSimpleTestSuite {

    public static void main(String[] args) throws Exception {
        SLTestRunner.runInMain(SLSimpleTestSuite.class, args);
    }

    /*
     * Our "mx unittest" command looks for methods that are annotated with @Test. By just defining
     * an empty method, this class gets included and the test suite is properly executed.
     */
    @Test
    public void unittest() {
    }
}
