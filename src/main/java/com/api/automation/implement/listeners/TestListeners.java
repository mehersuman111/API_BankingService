package com.api.automation.implement.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListeners.class);
    public void onStart(ITestContext context) {
        logger.info("Test execution started for test: " + context.getName());
    }
    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getMethod().getMethodName());
    }
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getMethod().getMethodName());
        logger.info("Description: " + result.getMethod().getDescription());
    }
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getMethod().getMethodName());
        logger.error("Error details: ", result.getThrowable());
    }
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getMethod().getMethodName());
    }
}
