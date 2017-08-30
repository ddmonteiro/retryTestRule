package com.app.android.shared;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class BaseTest {

    public class Retry implements TestRule {
        private int retryCount;

        public Retry(int retryCount) {
            this.retryCount = retryCount;
        }

        public Statement apply(Statement base, Description description) {
            return statement(base, description);
        }

        private Statement statement(final Statement base, final Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    //If we want to annotate just specific tests to repeat please uncomment the code
                    //commented and use the tag @FlakyTest in the respective test to repeat when it fails
                    //if (description.getAnnotation(FlakyTest.class) != null) {
                        Throwable caughtThrowable = null;

                        // implement retry logic here
                        for (int i = 0; i < retryCount; i++) {
                            try {
                                base.evaluate();
                                return;
                            } catch (Throwable t) {
                                caughtThrowable = t;
                                System.err.println(description.getDisplayName() + ": run " + (i+1) + " failed");
                            }
                        }
                        System.err.println(description.getDisplayName() + ": giving up after " + retryCount + " failures");
                        throw caughtThrowable;
                    }
                    //base.evaluate();
                //}
            };
        }
    }
}
