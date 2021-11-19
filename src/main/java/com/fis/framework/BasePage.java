package main.java.com.fis.framework;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Service;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.com.fis.utils.Constants;

public class BasePage extends AbstractTestNGSpringContextTests {

    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;


    @BeforeTest
    public void beforeTest(){
        htmlReporter=new ExtentHtmlReporter (System.getProperty ("user.dir")+File.separator+"reports"+File.separator+
                "AutomationReport.html");
        htmlReporter.config ().setEncoding ("utf-8");
        htmlReporter.config ().setDocumentTitle ("Automation Report");
        htmlReporter.config ().setReportName ("Automation Test Results");
        htmlReporter.config ().setTheme (Theme.DARK);
        extent=new ExtentReports ();
        extent.attachReporter (htmlReporter);
        extent.setSystemInfo ("Automation Tester","Sanjeev");
    }

    @BeforeMethod
    @Parameters(value="browserName")
    public void beforeMethod(String browserNames, Method testMethod){
        String browserName=Constants.browser;
        setupDriver (browserName);
        logger=extent.createTest (testMethod.getName ());
        driver.manage ().window ().maximize ();

        driver.get(Constants.url);

    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus ()==ITestResult.SUCCESS){
            String methodName=result.getMethod ().getMethodName ();
            String logText="Test Case"+methodName +"Passed";
            Markup markup= MarkupHelper.createLabel (logText, ExtentColor.GREEN);
            logger.log(Status.PASS,markup);
        }
        else if(result.getStatus ()==ITestResult.FAILURE){
            String methodName=result.getMethod ().getMethodName ();
            String logText="Test Case"+methodName +"Failed";
            Markup markup= MarkupHelper.createLabel (logText, ExtentColor.RED);
            logger.log(Status.FAIL,markup);
        }
        if(result.getStatus ()==ITestResult.SKIP){
            String methodName=result.getMethod ().getMethodName ();
            String logText="Test Case"+methodName +"Skipped";
            Markup markup= MarkupHelper.createLabel (logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP,markup);
        }


        driver.quit ();
    }

    @AfterTest
    public void afterTest(){
      extent.flush ();
    }

    public void setupDriver(String browserName){
        if(browserName.equalsIgnoreCase ("chrome")){
            System.setProperty ("webdriver.chrome.driver",
                    System.getProperty ("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver.exe");
            driver=new ChromeDriver ();
            driver.manage ().timeouts ().implicitlyWait (30, TimeUnit.SECONDS);

        }
        else if(browserName.equalsIgnoreCase ("firefox")){
            System.setProperty ("webdriver.gecko.driver",
                    System.getProperty ("user.dir")+ File.separator+"drivers"+File.separator+"firefoxdriver.exe");
            driver=new FirefoxDriver ();
            driver.manage ().timeouts ().implicitlyWait (30, TimeUnit.SECONDS);
        }
        else{
            System.setProperty ("webdriver.chrome.driver",
                   System.getProperty ("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver.exe");
            driver=new ChromeDriver ();
        }

      //driver.manage ().timeouts ().implicitlyWait (30,TimeUnit.SECONDS);
    }
}
