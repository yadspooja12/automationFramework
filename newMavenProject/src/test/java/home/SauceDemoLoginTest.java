package home;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.ConfigFileReader;
import com.test.SauceTestBase;

import pageobjects.SauceDemoLoginPage;

/**
 * Date: 02/02/2020
 * @author Pooja Yadav
 *
 */
public class SauceDemoLoginTest extends SauceTestBase {

	SauceDemoLoginPage testcase = new SauceDemoLoginPage(driver);

	@AfterSuite
	public void closeDriver() {
		driver.close();
	}
	
	@Test(dataProvider = "getdata", description ="Verify valid and invalid login scenarios")
	public void login(String name, String password, String message) {
		driver.get(ConfigFileReader.getApplicationUrl());
		SauceDemoLoginPage testObject = new SauceDemoLoginPage(driver);
		testObject.ID.click();
		testObject.ID.sendKeys(name);
		testObject.Password.click();
		testObject.Password.sendKeys(password);
		testObject.LoginButton.click();
		if (name.equals("standard_user")) {
			String label = testcase.ProductLabel.getText();
			Assert.assertEquals(label, message, "result not found");
		} else {
			String actualErrorMessage = testcase.ErrorMessage.getText();
			Assert.assertEquals(actualErrorMessage, message);
		}

	}

	@DataProvider(name = "getdata")
	public Object[][] getdataDataProvider() {
		return new Object[][] { { "standard_user", "secret_sauce", "Products" },
				{ "locked_out_user", "secret_sauce", "Epic sadface: User is locked" }, { "standard_use", "secret_sauce",
						"Epic sadface: Username and password do not match any user in this service" } };
	}

}