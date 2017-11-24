package io.kvlabs.filemock.core.anotation;

import io.kvlabs.filemock.core.mapper.Mapper;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * Mark a field to be mocked from the json data given at the file location.
 *
 * <ul>
 * <li>Allows shorthand mock creation.</li>
 * <li>Minimizes repetitive mock creation code.</li>
 * <li>Makes the test class more readable.</li>
 * <li>Makes the verification error easier to read because the <b>field name</b> is used to identify the mock.</li>
 * </ul>
 *
 * <pre class="code">
 * <code class="java">
 * 
 *   public class SampleTest {
 * 
 *       @MockFromFile(path = "/META-INF/mock/user.json")
 *       User user;
 *       @MockFromFile(path = "/META-INF/mock/item.json",safeMode=false)
 *       Item item;
 *       @MockFromFile(path = "/META-INF/mock/recommendation.json",mapper=Mapper.GSON)
 *       Recommendation recommendation;
 *
 *       @Before 
 *       public void initMocks() {
 *           FileToMockAnnotations.initMocks(this);
 *       }
 *   }
 * </code>
 * </pre>
 *
 * <p>
 * <strong><code>FileToMockAnnotations.initMocks(this)</code></strong> method has to be called to initialize annotated objects.
 * In above example, <code>initMocks()</code> is called in @Before (JUnit4) method of test's base class.
 * For JUnit3 <code>initMocks()</code> can go to <code>setup()</code> method of a base class.
 * <strong>Instead</strong> you can also put initMocks() in your JUnit runner (@RunWith) or use the built-in
 * {@link io.kvlabs.file.mock.runners.FileToMockJUnitRunner}.
 * </p>
 *
 * @see FileToMock#mock(Class)
 * @see FileToMockAnnotations#initMocks(Object)
 * @see io.filemock.FileToMockAnnotations
 * @author kanchana-prasanth
 */
@Documented
@Target(FIELD)
@Retention(RUNTIME)
public @interface MockFile {

    /**
     * If set true json mapper will not through any mapping exception if the
     * json schema have mismatch with the given pojo
     *
     * @return
     */
    boolean safeMode() default true;

    /**
     * Default type of json Mapper
     *
     * @return type of Mapper
     */
    Mapper mapper() default Mapper.JACKSON_1;

    /**
     * Path to json file
     *
     * @return path to json file
     */
    String path();

}
