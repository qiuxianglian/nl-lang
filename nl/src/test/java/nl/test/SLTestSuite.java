
package nl.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SLTestSuite {

    /**
     * Defines the base path of the test suite. Multiple base paths can be specified. However only
     * the first base that exists is used to lookup the test cases.
     */
    String[] value();

    /**
     * A class in the same project (or .jar file) that contains the {@link #value test case
     * directory}. If the property is not specified, the class that declares the annotation is used,
     * i.e., the test cases must be in the same project as the test class.
     */
    Class<?> testCaseDirectory() default SLTestSuite.class;

    /**
     * The options passed to {@code Context.Builder} to configure the {@code Context} executing the
     * tests. The options are given as an string array containing an option name followed by an
     * option value.
     *
     * @since 20.0.0
     */
    String[] options() default {};
}
