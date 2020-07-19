package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="identifierId")
	public WebElement email;
	
	@FindBy(id="identifierNext")
	public WebElement Next;
	
	@FindBy(css="input[ name='password']")
	public WebElement Password;
	
	@FindBy(id="passwordNext")
	public WebElement PasswordNext;
	
	@FindBy(css=".z0 div")
	 public
	 WebElement ComposeText;
	
	@FindBy(css="o6cuMc")
	public
	WebElement ErrorMessage;
	
	/*public void Login(String name, String password) {
		
		email.click();
		email.sendKeys(name);
		Next.click();
		Password.click();
		Password.sendKeys(password);
		PasswordNext.click();
		
	}*/
	
}
