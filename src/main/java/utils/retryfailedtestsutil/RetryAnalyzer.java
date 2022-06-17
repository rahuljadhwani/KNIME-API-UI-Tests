package utils.retryfailedtestsutil;

import constants.GlobalConstants;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int count  = 0;
    @Override
    public boolean retry(ITestResult result) {
        if(count < GlobalConstants.getRETRY_FAILED_TESTS_LIMIT()){
            count++;
            return true;
        }
        return false;
    }
}
