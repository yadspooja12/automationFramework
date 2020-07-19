package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageYourLogo {

	
	WebDriver driver;
	
	public HomePageYourLogo (WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[title='Women']")
	public WebElement Women;
	
	@FindBy(css="a[title='Casual Dresses']")
	public WebElement CasualDresses;
	
	@FindBy(css=".breadcrumb.clearfix")
	public WebElement breadcrumb;
	
	@FindBy(css=".breadcrumb.clearfix a[title='Dresses']")
	public WebElement BackToDresses;
	
	@FindBy(css=".breadcrumb.clearfix .home")
	public WebElement home;
	
	@FindBy(css=".cat-name")
	public WebElement nameDresses;
	
	@FindBy(css=".icon-home")
	public WebElement homeIcon;
	
	@FindBy(css="#header_logo")
	public WebElement headerLogo;
	
	
}
