package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import pageobjects.SauceDemoLoginPage;


public class SauceTestBase{

	//"D:\\chromedriver_win32\\chromedriver.exe"
	ConfigFileReader config;
	public WebDriver driver;
	String driverpath= System.getProperty("user.dir")+ "\\Browsers";
	String browser;
	
	public SauceTestBase()  {		
		config= new ConfigFileReader();
		browser=config.getNewValue();
		
		if (browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",driverpath + "\\chromedriver.exe");
		this.driver = new ChromeDriver();
		}else if (browser.equals("IE"))
        {System.setProperty("webdriver.ie.driver", driverpath + "\\IEDriverServer.exe");
		this.driver = new InternetExplorerDriver();
		}else {System.setProperty("webdriver.gecko.driver", driverpath + "\\geckodriver.exe");
		 this.driver= new FirefoxDriver ();
		}
		
	}
	
	public void login(String name, String password) {
		SauceDemoLoginPage testObject= new SauceDemoLoginPage (driver);
		testObject.ID.click();
		testObject.ID.sendKeys(name);
		testObject.Password.click();
		testObject.Password.sendKeys(password);
		testObject.LoginButton.click();
	}
}
