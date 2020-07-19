package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.LoginPage;

/**
 * Date: 20/03/2019
 * @author Pooja Yadav
 * Scenarios of Login
 * 
 * 
 */
public class LoginTestCases {

	
	@Test (description="Verify successful login to homepage")
	public void validLogin () {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.get("https://www.xyz.com/");
		LoginPage Testcase= new LoginPage(driver);
		Testcase.Login("xxxx@gmail.com", "xxxxx");
		String ExpectedName= Testcase.signinName.getText();
		Assert.assertEquals(ExpectedName, "Hey, Pooja", "Mismatch");
		driver.close();
	}
	
	@Test(description="Verify invalid login")
	public void InvalidPassword () {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.get("https://www.xyz.com/");
		LoginPage Testcase= new LoginPage(driver);
		Testcase.Login("xxxx@gmail.com", "xxxx");
		driver.close();
	}
}
