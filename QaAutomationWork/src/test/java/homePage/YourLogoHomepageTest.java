package homePage;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Test.YourLogoTestBase;


import pageobjects.HomePageYourLogo;

/**
 * Date: 10/02/2020
 * @author Pooja Yadav
 *
 */

public class YourLogoHomepageTest extends YourLogoTestBase {

	HomePageYourLogo homePage;

	@BeforeMethod
	public void setup() {

		homePage = new HomePageYourLogo(driver);

	}

	public void goToCasualDresses() {
		Actions action = new Actions(driver);
		action.moveToElement(homePage.Women).perform();
		action.moveToElement(homePage.CasualDresses).perform();
		homePage.CasualDresses.click();
	}

	@Test (description="Verify breadcrumb is present when navigated to casual dress")
	public void verifyBreadCrumb() {
		goToCasualDresses();
		Boolean Breadcrumb = homePage.breadcrumb.isDisplayed();
		Assert.assertTrue(Breadcrumb, "result not found");
		// System.out.println(Breadcrum);
	}

	@Test(description="Verify user can go back to dresses if same selected from breadcrumb")
	public void verifyBackButton() {
		goToCasualDresses();
		homePage.BackToDresses.click();
		String nameToBeVerified = homePage.nameDresses.getText();
		Assert.assertEquals(nameToBeVerified, "DRESSES ", "result not found");

	}

	@Test(description="Verify user can go back to home page if same selected from breadcrumb")
	public void backToHome() {
		goToCasualDresses();
		homePage.homeIcon.click();
		Boolean homeLogo = homePage.headerLogo.isDisplayed();
		Assert.assertTrue(homeLogo, "result not found");

	}

	@AfterSuite
	public void closeDriver() {
		driver.close();
	}
}
