package io.kvlabs.filemock.junit.runners;

import io.kvlabs.filemock.core.anotation.FileMockAnnotations;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.junit.runners.model.InitializationError;

/**
 * JUnit runner for older versions 4
 *
 * @author kanchana-prasanth
 */
@SuppressWarnings("deprecation")
public class JUnitNewVersionRunner implements RunnerExt {

    private final BlockJUnit4ClassRunner runner;

    /**
     * Create new instance of JUnit44RunnerImpl
     *
     * @param klass as type of Class
     * @throws InitializationError
     */
    public JUnitNewVersionRunner(Class<?> klass) throws InitializationError {
        runner = new BlockJUnit4ClassRunner(klass) {
            @Override
            protected Statement withBefores(FrameworkMethod method, Object target,
                    Statement statement) {
                // init annotated mocks before tests
                FileMockAnnotations.initMocks(target);
                return super.withBefores(method, target, statement);
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
