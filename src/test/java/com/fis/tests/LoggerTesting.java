package test.java.com.fis.tests;


import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LoggerTesting {
    private static final Logger logger= LoggerFactory.getLogger(LoggerTesting.class);
    @Test
    public void loggerTest(){
        //PropertyConfigurator.configure("D:\\fisproject\\src\\main\\resources\\log4j.properties");
        DOMConfigurator.configure("D:\\fisproject\\src\\main\\resources\\logback.xml");
        logger.trace("This is a trace message");
        logger.info("This is an info message");
        logger.warn("This is an warn message");
        logger.error("This is an error message");
        //logger.fatal("This is an fatal message");

    }
}

