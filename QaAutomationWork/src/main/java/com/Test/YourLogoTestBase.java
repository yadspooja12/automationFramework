package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * 16/07/2020
 * @author Pooja
 * Breadcrumb Tests
 *
 */

public class YourLogoTestBase {

	
          public WebDriver driver;
          public WebDriverWait wait;
          
          
         public YourLogoTestBase () {
        	 //System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        	 WebDriverManager.chromedriver().setup();  
        	 this.driver= new ChromeDriver();
        	 this.wait= new WebDriverWait (driver, 6);
        	 driver.get("http://automationpractice.com/ ");
         }
}
