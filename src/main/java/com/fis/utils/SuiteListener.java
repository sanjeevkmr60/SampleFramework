package main.java.com.fis.utils;



import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import main.java.com.fis.framework.BasePage;

public class SuiteListener implements ITestListener, IAnnotationTransformer , IInvokedMethodListener {
    public void onTestStart(final ITestResult iTestResult) {

    }

    public void onTestSuccess(final ITestResult iTestResult) {

    }

    public void onTestFailure(final ITestResult iTestResult) {
      String fileName=
              System.getProperty ("user.dir")+ File.separator+"screenshots"+ File.separator+iTestResult.getMethod ().getMethodName ();
      File f=((TakesScreenshot)BasePage.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile (f,new File (fileName+".png"));
        } catch (IOException e) {
            e.printStackTrace ( );
        }


    }

    public void onTestSkipped(final ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(final ITestResult iTestResult) {

    }

    public void onStart(final ITestContext iTestContext) {
    iTestContext.setAttribute ("browserName","Chrome");
    }

    public void onFinish(final ITestContext iTestContext) {

    }

    public void transform(
            final ITestAnnotation iTestAnnotation, final Class aClass, final Constructor constructor,
            final Method method) {
        iTestAnnotation.setRetryAnalyzer (RetryAnalyser.class);

    }

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {

    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {

    }

    @Override
    public void beforeInvocation(
            final IInvokedMethod method, final ITestResult testResult, final ITestContext context) {

    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult, final ITestContext context) {

    }
}
