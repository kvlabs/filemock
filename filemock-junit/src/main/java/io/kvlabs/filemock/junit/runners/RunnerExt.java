package io.kvlabs.filemock.junit.runners;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.notification.RunNotifier;

/**
 * Extension of Runner
 *
 * @author kanchana-prasanth
 */
public interface RunnerExt extends Filterable {

    /**
     * Answers with Description
     *
     * @return an instance of Description
     */
    Description getDescription();

    /**
     * Run the runner
     *
     * @param notifier instance of RunNotifier
     */
    void run(RunNotifier notifier);
}
