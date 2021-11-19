package test.java.com.fis.tests;



import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import main.java.com.fis.framework.BasePage;
import main.java.com.fis.pages.LoginPage;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-test-config.xml")
public class HomePageTest extends BasePage {

    //ApplicationContext context=new ClassPathXmlApplicationContext ("spring-test-config.xml");
    //LoginPage loginPage=context.getBean("loginPage",LoginPage.class);
    //@Autowired

    //private HomePage homePage;
    private static final Logger logger= LoggerFactory.getLogger(HomePageTest.class);


    @Autowired
   private LoginPage loginPage;

    //LoginPage loginPage=new LoginPage ();
@Test(dataProviderClass= HomePageDataProvider.class,dataProvider = "loginDetails")
public void verifyProjectLogin(String uname,String pwd){
    //PropertyConfigurator.configure("D:\\fisproject\\src\\main\\resources\\log4j.properties");
    DOMConfigurator.configure("D:\\fisproject\\src\\main\\resources\\logback.xml");

    logger.info("Hellooooooooo");

    logger.info("Enter a method 1  :"+loginPage.getClass ().getName () );


    logger.info("Username is :"+uname);

    logger.info("Password is :"+pwd);

    loginPage.loginFaceBook (uname, pwd);


    //loginPage.loginFaceBook ("sanjeevkmr531@gmail.com","s9949424394");
    //loginPage.verifyText ("Sign-In");
 }
@Test(dependsOnMethods = { "verifyProjectLogin" })
public void VerifyFacebookLogin(){
    logger.info("This will execute second (SignIn)");

}
@Test(groups = {"demo" },priority = 1,enabled =true,description = "This is dummy testcase")
public void VerifyFacebookLogin1(){
        //System.out.println("This will execute Third (SignIn)");
        Assert.assertEquals (1,1);
}

@Test(groups = {"demo" },dataProviderClass = HomePageDataProvider.class,dataProvider = "loginInformation",enabled =
        true)
public void ReadDataFromTXT(String usname, String pswd) {
    logger.info("Say Hi'''''" );
    loginPage.loginFaceBook (usname, pswd);
    logger.info("End Testcase" );

}

}
