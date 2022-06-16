package listeners;

import org.testng.*;
import reports.ExtentLogger;
import reports.ExtentReportsImplementation;
import java.util.Arrays;

/**
 * This class is responsible for adding logs to reports according to tests' results
 *
 */
public class ITestListenerImplementation implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportsImplementation.createTest(result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getDescription()+" has passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
         if(Arrays.asList(result.getMethod().getGroups()).contains("API")){
             ExtentLogger.fail(result.getMethod().getMethodName()+" has failed");
         }else ExtentLogger.failWithScreenshot(result.getMethod().getMethodName()+" has failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName()+" was skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override
    public void onStart(ISuite suite) {
        ExtentReportsImplementation.initExtentReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReportsImplementation.flushReports();
    }
}
