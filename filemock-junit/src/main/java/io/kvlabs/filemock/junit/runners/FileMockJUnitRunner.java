package io.kvlabs.filemock.junit.runners;

import java.lang.reflect.InvocationTargetException;
import org.junit.internal.runners.InitializationError;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;

/**
 *
 * @author kanchana-prasanth
 */
public class FileMockJUnitRunner extends Runner implements Filterable {

    private static boolean newJUnitVersion;

    static {
        try {
            Class.forName("org.junit.runners.BlockJUnit4ClassRunner");
            newJUnitVersion = true;
        } catch (Throwable t) {
            newJUnitVersion = false;
        }
    }

    private final RunnerExt runner;

    /**
     * Create new instance of FileToMockJUnitRunner
     *
     * @param klass as class type
     * @throws InvocationTargetException
     * @throws InitializationError
     */
    public FileMockJUnitRunner(Class<?> klass) throws InvocationTargetException, InitializationError {
        if (newJUnitVersion) {
            runner = new JUnitOldVersionRunner(klass);
        } else {
            runner = new JUnitOldVersionRunner(klass);
        }
    }

    /**
     * Run the runner
     *
     * @param notifier instance of RunNotifier
     */
    @Override
    public void run(final RunNotifier notifier) {
        runner.run(notifier);
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
     * Remove tests that don't pass the parameter <code>filter</code>.
     *
     * @param filter the {@link Filter} to apply
     * @throws NoTestsRemainException if all tests are filtered out
     */
    @Override
    public void filter(Filter filter) throws NoTestsRemainException {
        //filter is required because without it UnrootedTests show up in Eclipse
        runner.filter(filter);
    }
}
