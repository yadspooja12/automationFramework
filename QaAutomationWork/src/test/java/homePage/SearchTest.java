package homePage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Test.YourLogoTestBase;

import pageobjects.SearchPage;

public class SearchTest extends YourLogoTestBase{

	
	SearchPage search;
	
	
	@BeforeMethod
	public void setUp() {
		initialize();
		search = new SearchPage(driver);
	}
	
	
	@Test (description="Validate that product seached are displayed on page.")
	public void validSearch() {
		search.searchTextBox.click();
		search.searchTextBox.sendKeys("printed dress");
		search.searchButton.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(search.searchedproducts));
	    int products= search.searchedproducts.size();
	    
	    Assert.assertEquals(products, 5, "products not found");
	    System.out.println(products);
	    
	}
	
	@Test (description="Validate that first product is clickable or not.")
	public void productIsClickable() {
		search.searchTextBox.click();
		search.searchTextBox.sendKeys("printed dress");
		search.searchButton.click();
		String ExpectedName=search.NameOfFirstItem .getText();
		search.firstProduct.click();
		String name= search.productName.getText();
		Assert.assertEquals(name, ExpectedName, "Product not found");
		System.out.println(name);
	}
	
	@AfterMethod
	public void closeDriver() {
		if(driver!=null)
		driver.close();
	}
	
}
