package com.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	
	static Properties property;
	BufferedReader reader;
	String filePath= System.getProperty("user.dir")+"\\configs\\configuration.Properties";
	
	 public ConfigFileReader () {
		 try {
		 reader= new BufferedReader(new FileReader(filePath));
		 property = new Properties();
		 property.load(reader);
		 reader.close();
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
		 
	 }
		 
	    public static String getApplicationUrl() {
	    	String url= property.getProperty("url");
	    	if (url != null) return url;
	    	else throw new RuntimeException("url is not specified");
	    }
		 
	    
	    public static int getImplicitWait() {
	    	String wait = property.getProperty("implicitWait");
	    	int implicitwait;
	    	if (wait!=null) {
	    	 implicitwait= Integer.parseInt(wait);
	    	 return implicitwait;
	    	}
	    	else throw new RuntimeException("ImlicitWait is not specified");
	    }
	    
	    public static String getDriver() {
	    	String driver= property.getProperty("browser");
	    	if (driver!= null) return driver;
	    	else throw new RuntimeException("Browser is not specified");
	    }
	
}
