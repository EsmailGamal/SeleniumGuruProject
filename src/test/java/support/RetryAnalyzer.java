package support;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 1; // retry once

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("[RETRY] Retrying test: " + result.getMethod().getMethodName() + " (" + retryCount + "/" + maxRetryCount + ")");
            return true;
        }
        return false;
    }
}


