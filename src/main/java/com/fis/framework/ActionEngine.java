package main.java.com.fis.framework;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
public class ActionEngine  {

    public ActionEngine() {

    }
    //public static WebDriver driver;





    public WebElement getWebElement(String locator, String value){

        switch(locator){
            case "ID":
                return BasePage.driver.findElement (By.id (value ));
            case "TAGNAME":
                return BasePage.driver.findElement (By.tagName (value ));
            case "XPATH":
                return BasePage.driver.findElement (By.xpath (value ));
            case "CSS":
                return BasePage.driver.findElement (By.cssSelector(value ));
            case "CLASSNAME":
                return BasePage.driver.findElement (By.className (value ));
            case "NAME":
                return BasePage.driver.findElement (By.name (value ));

            default:
                return null;
        }
    }
   public List<WebElement> getWebElements(String locater, String value){

        switch(locater){
            case "ID":
                return BasePage.driver.findElements (By.id (value ));
            case "TAGNAME":
                return BasePage.driver.findElements (By.tagName (value ));
            case "XPATH":
                return BasePage.driver.findElements (By.xpath (value ));
            case "CSS":
                return BasePage.driver.findElements (By.cssSelector(value ));
            case "CLASSNAME":
                return BasePage.driver.findElements (By.className (value ));
            default:
                return null;
        }
    }



}





