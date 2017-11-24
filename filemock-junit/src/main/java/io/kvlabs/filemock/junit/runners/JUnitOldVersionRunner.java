package io.kvlabs.filemock.junit.runners;

import io.kvlabs.filemock.core.anotation.FileMockAnnotations;
import org.junit.internal.runners.InitializationError;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;

/**
 * JUnit runner for older versions 4
 *
 * @author kanchana-prasanth
 */
@SuppressWarnings("deprecation")
public class JUnitOldVersionRunner implements RunnerExt {

    private final JUnit4ClassRunner runner;

    /**
     * Create new instance of JUnit44RunnerImpl
     *
     * @param klass as type of Class
     * @throws InitializationError
     */
    public JUnitOldVersionRunner(Class<?> klass) throws InitializationError {
        this.runner = new JUnit4ClassRunner(klass) {
            @Override
            protected Object createTest() throws Exception {
                Object test = super.createTest();
                //initalize file to mock anotations
                FileMockAnnotations.initMocks(test);
                //return the file
                return test;
            }
        };
    }

    /**
     * Answers with Description
     *
     * @return an instance of Description
     */
    @Override
    public Description getDescription() {
        return runner.getDescription();
    }

    /**
     * Run the runner
     *
     * @param notifier instance of RunNotifier
     */
    @Override
    public void run(RunNotifier notifier) {
        runner.run(notifier);
    }

    /**
     * Remove tests that don't pass the parameter <code>filter</code>.
     *
     * @param filter the {@link Filter} to apply
     * @throws NoTestsRemainException if all tests are filtered out
     */
    @Override
    public void filter(Filter filter) throws NoTestsRemainException {
        runner.filter(filter);
    }
}
