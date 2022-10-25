package com.gitlab.helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class GetTestProperties {
    /**
     * This method returns the input values provided in config value
     * @param propName
     * @return the properties
     */
    public String getValue(String propName){
        try{
            Properties prop = new Properties();
            FileInputStream in = new FileInputStream("src/main/resources/config.properties");
            prop.load(in);
            return prop.getProperty(propName);

        }catch (Exception e){
            return "Property Not Found";
        }
    }
}
