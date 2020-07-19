package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginPage {

	WebDriver driver;
	
	public  SauceDemoLoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "user-name")
   public  WebElement ID;
	
	@FindBy(id="password")
	public WebElement Password;
	
	@FindBy(css="input[type='submit']")
	public WebElement LoginButton;
	
	@FindBy(css="div[class='product_label']")
	public WebElement ProductLabel;
	
	@FindBy(css="h3[data-test='error']")
	public WebElement ErrorMessage;
	
	
	/*public void home(String name, String password) {
		ID.click();
		ID.sendKeys(name);
		Password.click();
		Password.sendKeys(password);
		LoginButton.click();*/
		
	}
	
	

