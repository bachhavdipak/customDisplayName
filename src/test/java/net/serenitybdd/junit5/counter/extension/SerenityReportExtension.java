package net.serenitybdd.junit5.counter.extension;

import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.reports.AcceptanceTestReporter;
import net.thucydides.core.reports.ReportService;
import net.thucydides.core.steps.BaseStepListener;
import net.thucydides.core.steps.StepEventBus;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SerenityReportExtension implements AfterAllCallback {

    List<TestOutcome> testOutput = null;


    @Override
    public void afterAll(@NotNull ExtensionContext context) throws Exception {
        BaseStepListener baseStepListener = StepEventBus.getEventBus().getBaseStepListener();

        generateReports(baseStepListener);

    }

    // net.serenitybdd.junit.runners.SerenityRunner.generateReports
    protected void generateReports(BaseStepListener baseStepListener) {
        generateReportsFor(baseStepListener.getTestOutcomes());
    }

    // net.serenitybdd.junit.runners.SerenityRunner.generateReportsFor

    /**
     * @param testOutcomeResults the test results from the previous test run.
     */
    private void generateReportsFor(final List<TestOutcome> testOutcomeResults) {

        for (TestOutcome output : testOutcomeResults) {

            if (output.getStepCount() != 0) {


                List<TestOutcome> outcomes= new ArrayList<>();
                outcomes.add(output);
                final ReportService reportService = new ReportService(getOutputDirectory(), getDefaultReporters());
                reportService.generateReportsFor(outcomes);
                reportService.generateConfigurationsReport();
            }
        }
    }

    /**
     * @return The default reporters applicable for standard test runs.
     */
    protected Collection<AcceptanceTestReporter> getDefaultReporters() {
        return ReportService.getDefaultReporters();
    }

    public File getOutputDirectory() {
        return ConfiguredEnvironment.getConfiguration().getOutputDirectory();
    }

}
