package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * 
 * @author Pooja Yadav
 * Page Objects of Search Page
 */
public class Search {

	WebDriver driver;
	WebDriverWait wait;
	public Search (WebDriver driver) {
		
		this.driver= driver;
		this.wait = new WebDriverWait (driver,4);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="#search")
	 WebElement search;
	
	@FindBy (css=".search-containter")
	 WebElement searchClick;
	
     @FindBy (css= ".prod-heading-ctl")
	public
	WebElement WomenJeans;
     
     
     @FindBy (css=".product-count")
     public
     WebElement ProductCount;	
     
     @FindBy (css=".preference label:nth-of-type(1)")
     public
     WebElement Label1;
     
     @FindBy (css= ".product-info div:nth-of-type(1)")
     public
     List<WebElement> jacketsLink;
     
     @FindBy (css="ol li:nth-of-type(2)")
     public
     WebElement caps;
	
	public void search (String product) {
		search.clear();
		search.click();
		search.sendKeys(product);
		searchClick.click();
		//wait.until(ExpectedConditions.visibilityOf(WomenJeans));
		//String productName = WomenJeans.getText();
		
	}
	
	
	
	
	
}
