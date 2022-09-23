package net.serenitybdd.junit5.counter.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import net.serenitybdd.junit5.counter.TestCounter;
import net.serenitybdd.junit5.counter.counter.TestCountListener;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.statistics.TestCount;
import net.thucydides.core.steps.StepListener;
import net.thucydides.core.util.EnvironmentVariables;

public class JUnit5Module extends AbstractModule {

    @Override
    protected void configure() {
        bind(StepListener.class)
                .annotatedWith(TestCounter.class)
                .toProvider(TestCountListenerProvider.class)
                .in(Singleton.class);
    }

    public static class TestCountListenerProvider implements Provider<StepListener> {

        public StepListener get() {
            EnvironmentVariables environmentVariables = Injectors.getInjector().getProvider(EnvironmentVariables.class).get() ;
            TestCount testCount = Injectors.getInjector().getInstance(TestCount.class);
            return new TestCountListener(environmentVariables, testCount);
        }
    }
}
