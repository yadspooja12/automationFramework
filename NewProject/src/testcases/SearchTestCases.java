package testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageobject.Search;

/**
 * Date: 23/03/2019
 * 
 * @author dell Search Scenarios
 */
public class SearchTestCases {

	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterSuite
	public void closeDriver() {
		driver.close();
	}

	@Test(description = "Verify correct product can be search")
	public void searchProduct() {
		driver.get("https://www.xyz.com/");
		Search Testcase = new Search(driver);
		Testcase.search("women jeans");
		String productName = Testcase.WomenJeans.getText();
		Assert.assertEquals(productName, "WOMEN JEANS", "Mismatch Text");

	}

	@Test(description = "Verify product is searchable if product name entered in lower case")
	public void searchLowerCase() {
		// System.setProperty("webdriver.chrome.driver",
		// "D:\\chromedriver_win32\\chromedriver.exe");
		// driver = new ChromeDriver();
		driver.get("https://www.xyz.com/");
		Search Testcase = new Search(driver);
		Testcase.search("women kurtas");
		String Totalproducts = Testcase.ProductCount.getText();
		Assert.assertEquals(Totalproducts, "2892  PRODUCTS", "Product list mismatch");
	}

	@Test(description = "Verify product is searchable if product name is entered in upper case")
	public void searchUpperCase() {
		// System.setProperty("webdriver.chrome.driver",
		// "D:\\chromedriver_win32\\chromedriver.exe");
		// driver = new ChromeDriver();
		driver.get("https://www.xyz.com/");
		Search Testcase = new Search(driver);
		Testcase.search("WOMEN KURTAS");
		String Totalproducts = Testcase.ProductCount.getText();
		Assert.assertEquals(Totalproducts, "2892 PRODUCTS", "Product list mismatch");
		driver.close();
	}

	/*
	 * @Test public void searchCaseInsensitive() {
	 * driver.get("https://www.jabong.com/"); Search Testcase = new Search(driver);
	 * Testcase.search("jacket"); WebDriverWait wait=new WebDriverWait (driver,4);
	 * wait.until(ExpectedConditions.visibilityOf(Testcase.Label1));
	 * Testcase.Label1.click();
	 * 
	 * List<WebElement> Locators= Testcase.jacketsLink; List<String> ProductsName=
	 * new ArrayList<String>(); for(WebElement a:Locators) {
	 * 
	 * String name= a.getText().toLowerCase(); ProductsName.add(name); }
	 * 
	 * Collections.sort(ProductsName);
	 * 
	 * 
	 * Testcase.search("JACKET");
	 * wait.until(ExpectedConditions.visibilityOf(Testcase.Label1));
	 * Testcase.Label1.click();
	 * 
	 * List<WebElement> Locator1= Testcase.jacketsLink; List<String> ProductName1=
	 * new ArrayList<String>(); for(WebElement c:Locator1) {
	 * 
	 * String name1= c.getText().toLowerCase(); ProductName1.add(name1); }
	 * 
	 * Collections.sort(ProductName1); Assert.assertEquals(ProductsName,
	 * ProductName1, "mismatch products");
	 * 
	 * }
	 */

	/*
	 * Boolean b= name.contains("jacket"); if(b==true) { ProductsName.add(name); }
	 * 
	 * Testcase.search("JACKET"); Testcase.Label1.click();
	 * 
	 * List<WebElement> Locator1= Testcase.jacketsLink; List<String> ProductName1=
	 * new ArrayList<String>(); for(WebElement c:Locator1) {
	 * 
	 * String name1= c.getText().toLowerCase(); Boolean d= name1.contains("jacket");
	 * if(d==true) { ProductName1.add(name1); } } } Assert. }
	 * 
	 * @Test public void searchCaps() { driver.get("https://www.jabong.com/");
	 * Search Testcase2 = new Search(driver); Testcase2.search("caps"); String
	 * getname= Testcase2.caps.getText(); Assert.assertEquals(getname, "Caps",
	 * "mismatch Text"); driver.close(); }
	 */

}
