package main.java.com.fis.pages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.testng.Assert;

;
import main.java.com.fis.framework.ActionEngine;

import main.java.com.fis.framework.BasePage;
import main.java.com.fis.locaters.LoginPageLocaters;

@Service
public class LoginPage  {
    @Autowired
    ActionEngine actionEngine;

   //ActionEngine actionEngine=new ActionEngine ();

    public void loginFaceBook(String username,String password){
        System.out.println ("Enter to Method 2" );

        System.out.println ("Enter a method 1  :"+actionEngine.getClass ().getName () );
        //actionEngine.enter("IDemail",username,"Username Entering");
        //actionEngine.enter("IDpass",password,"Password Entering");
        //actionEngine.click ("IDlogin","Clicking on Login buton");
        //actionEngine.enter ("ID",LoginPageLocaters.USERNAME,username);
        actionEngine.getWebElement ("ID",LoginPageLocaters.USERNAME).sendKeys (username);
        actionEngine.getWebElement ("ID",LoginPageLocaters.PASSWORD).sendKeys (password);
        actionEngine.getWebElement ("NAME",LoginPageLocaters.SIGNIN).click ();
    }
    public void verifyText(String text)
    {
        //String txtVal = actionEngine.getWebElement ("XPATH", LoginPageLocaters.SIGNINTEXT).getText ( );
        //Assert.assertEquals ( txtVal,text);

    }



}
