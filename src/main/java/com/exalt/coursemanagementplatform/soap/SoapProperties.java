package com.exalt.coursemanagementplatform.soap;

import javax.xml.ws.Endpoint;
import java.util.Properties;

/**
 * The SoapProperties is a class for storing and getting properties for SOAP endpoints.
 */
public class SoapProperties {
    private static final String SOAP_URL = "soap.url";
    private static final String FILE_NAME = "app.properties";
    public void init() {
        Endpoint.publish(getSoapUrl(), new Soap());
    }

    private static String getSoapUrl(){
        Properties properties = new Properties();
        try {
           properties.load(SoapProperties.class.getClassLoader().getResourceAsStream(FILE_NAME));
           return properties.getProperty(SOAP_URL);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
