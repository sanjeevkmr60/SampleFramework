package test.java.com.fis.tests;

import java.io.File;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import main.java.com.fis.framework.User;

public class YamlTesting {

@Test
    public void yamlTesting()
{
    ObjectMapper mapper=new ObjectMapper (new YAMLFactory ());
    try{
   User user=mapper.readValue(new File ("D:\\fisproject\\src\\main\\resources\\testdata\\user.yaml"), User.class);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                System.out.println (ReflectionToStringBuilder.toString (user, ToStringStyle.JSON_STYLE));
    }
    catch(Exception e){
        e.printStackTrace ();
    }
}


    
}
