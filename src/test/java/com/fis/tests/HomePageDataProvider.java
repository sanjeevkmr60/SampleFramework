package test.java.com.fis.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import main.java.com.fis.locaters.LoginPageLocaters;
import main.java.com.fis.utils.Constants;

public class HomePageDataProvider {

    @DataProvider
    public static Object[][] loginDetails() {


        String username= Constants.username;
        String password=Constants.password;

                return new Object[][]{{username,password}};
    }
    @DataProvider
    public static Object[][] loginInformation() {
//main/resources/logindata.properties
        FileInputStream fis = null;
        try {
            fis = new FileInputStream ("D:\\fisproject\\src\\main\\resources\\logindata.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace ( );
        }
        Properties properties = new Properties ( );
        try {
            properties.load (fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace ( );
        } catch (IOException e) {
            e.printStackTrace ( );
        }

        String usname= properties.getProperty ("username");
        String pswd=properties.getProperty ("password");
        return new Object[][]{{usname, pswd}};
    }

}
