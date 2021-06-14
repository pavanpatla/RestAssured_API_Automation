package com.api.dummy.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {
    public ExtentReports reports;
    public ExtentTest test;
    public ExtentSparkReporter extentSparkReporter;

    public void onStart(ITestContext testContext) {
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/myReport.html");
        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setReportName("Functional Testing");
        extentSparkReporter.config().setTheme(Theme.STANDARD);

        reports = new ExtentReports();
        reports.attachReporter(extentSparkReporter);
        reports.setSystemInfo("Host name", "localHost");
        reports.setSystemInfo("USer", "Mr. PK");
    }

    public void onTestSuccess(ITestResult testResult) {
        test = reports.createTest(testResult.getName());
        test.log(Status.PASS, "TEST CASE PASSED IS " + testResult.getName());
    }

    public void onTestFailure(ITestResult testResult) {
        test = reports.createTest(testResult.getName());
        test.log(Status.FAIL, "TEST CASE FAILED IS  " + testResult.getName());
        test.log(Status.SKIP, "TEST CASE SKIPPED IS " + testResult.getName());
    }

    public void onFinish(ITestContext testContext) {
        reports.flush();
    }
}
