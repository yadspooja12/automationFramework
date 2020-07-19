package com.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader  {

	
	static Properties property;
	BufferedReader reader;
	String filePath = System.getProperty("user.dir")+ "\\configs\\configuration.Properties";
	
	public ConfigFileReader() {
		
		try {
	    System.out.println(System.getProperty("user.dir")+ "\\configs\\configuration.Properties");
	    reader = new BufferedReader(new FileReader(filePath));
		//fs = new FileInputStream (System.getProperty("user.dir")+ "\\configs\\configuration.Properties");
		property= new Properties();	
		property.load(reader);
		//property.load(fs);
		//fs.close();
		reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
		/*public static String getDriverPath() {
			System.out.println(property.getProperty("driverPath"));
			String driverpath = property.getProperty("driverPath");
			if(driverpath != null) return driverpath;
			else throw new RuntimeException("driverpath is not specified in the configuration.Properties file.");
		}*/
		
		public static String getImplicitWait () {
			String implicitWait = property.getProperty("implicitWait");
			if(implicitWait != null) return implicitWait;
			else throw new RuntimeException("ImplicitWait is not specified in the configuration.Properties file.");	
		}
		
		public static String getApplicationUrl() {
			String url = property.getProperty("url");
			if(url != null) return url;
			else throw new 	RuntimeException("driverpath is not specified in the configuration.Properties file.");	
		}
		
		public static String getNewValue () {
			System.out.println(property.getProperty("browser"));
			String BR= property.getProperty("browser");
			if(BR!= null) return BR;
		    else throw new RuntimeException("browser is not specified in the configuration.Properties file.");
		}
}

