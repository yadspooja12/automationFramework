package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name='search_query']")
	public WebElement searchTextBox;
	
	@FindBy(css="button[name='submit_search']")
	public WebElement searchButton;
	
	@FindBy(css="div.product-container")
	public List<WebElement> searchedproducts; 
	
	@FindBy(css=".product-container a.product-name")
	public WebElement NameOfFirstItem;
	
	@FindBy(css="div.right-block")
	public WebElement firstProduct;
	
	@FindBy(css="h1[itemprop='name']")
	public WebElement productName;
	

	@FindBy(css="#uniform-selectProductSort")
	public WebElement sortHover;
	
	@FindBy(css="#selectProductSort")
	public WebElement ProductSort;
	
	@FindBy(css="span.price.product-price")
	public List<WebElement> productPrices;
	
	
	
	
	
}
