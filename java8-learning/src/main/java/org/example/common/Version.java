package org.example.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Version {
	public static final String UNKNOWN = "UNKNOWN";
    public static final String NAME = "/java8-version.properties";
    public static String VERSION;
    public static String RESOURCES_VERSION;
    public static String BUILD_TIME;
    
    
    static {
    	try (InputStream is = Version.class.getResourceAsStream(NAME)) {
    		Properties properties = new Properties();
    		properties.load(is);
    		Version.VERSION = properties.getProperty("version");
    		Version.BUILD_TIME = properties.getProperty("build-time");
    		
    		System.out.println(VERSION + " : " + BUILD_TIME);
    	} catch (IOException ex) {
    		Version.VERSION = Version.UNKNOWN;
            Version.BUILD_TIME = Version.UNKNOWN;
            System.out.println(VERSION + " : " + BUILD_TIME);
    	}
    }
    
    public static void main(String[] args) {
    	System.out.println("Ok");
    }
}
