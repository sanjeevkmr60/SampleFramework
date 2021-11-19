package main.java.com.fis.pages;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import main.java.com.fis.framework.ActionEngine;
import main.java.com.fis.locaters.HomePageLocaters;
@Service
public class HomePage {


    ActionEngine actionEngine=new ActionEngine ();

    public void clickOnSignInButton(){
        actionEngine.getWebElement ("ID",HomePageLocaters.signInButton);
    }

}
