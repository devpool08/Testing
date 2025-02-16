package org.example.testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListiner implements ITestListener {

    public void onStart(ITestContext arg) {
        System.out.println("Start Test Execution " + arg.getName());
    }

    public void onFinish(ITestContext arg) {
        System.out.println("Finish Test Execution " + arg.getName());
    }

    public void onTestStart(ITestResult arg) {
        System.out.println("Start Test " + arg.getName());
    }

    public void onTestSuccess(ITestResult arg) {
        System.out.println("Test " + arg.getName() + " passed");
    }

    public void onTestFailure(ITestResult arg) {
        System.out.println("Test " + arg.getName() + " failed");
    }

    public void onTestSkipped(ITestResult arg) {
        System.out.println("Test " + arg.getName() + " skipped");
    }
}
