package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * 16/07/2020
 * @author Pooja
 * Breadcrumb Tests
 *
 */

public class YourLogoTestBase {

	      ConfigFileReader config;
          public WebDriver driver;
          public WebDriverWait wait;
          String browser;
          
         
         public void initialize () {
        	 //System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        	 config= new ConfigFileReader();
        	 browser=config.getDriver();
        	 
        	 if (browser.equals("chrome")) {
        	 WebDriverManager.chromedriver().setup();
        	 this.driver= new ChromeDriver();
        	 }
        	 else if (browser.equals("IE")) {
        	 WebDriverManager.iedriver();
        	 this.driver = new InternetExplorerDriver();
        	 }
        	 else if(browser.equals("firefox")) {
              WebDriverManager.firefoxdriver();
              this.driver= new FirefoxDriver();
        	 }
        	 
        	  this.wait= new WebDriverWait (driver, config.getImplicitWait());
        	 driver.get(config.getApplicationUrl());
         }
}
