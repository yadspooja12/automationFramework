package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Pooja Yadav
 * Page Objects of Login Page
 *
 */
public class LoginPage {

	
	WebDriver driver;
	WebDriverWait wait;
	public  LoginPage (WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait (driver,5);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="signin-parent")
	WebElement signin;
	
	@FindBy(name="email")
	WebElement Email;
	
	@FindBy(id="login-pwd")
	WebElement password;
	
	@FindBy(id="btn-login")
	WebElement signinButton;
	
    @FindBy(linkText= "Hey, Pooja")
	public WebElement  signinName;
	
	
	public void Login(String userEmail, String userPassword) {
		signin.click();
		wait.until(ExpectedConditions.visibilityOf(Email));//visibilityOfElementLocated(Email));
		Email.sendKeys(userEmail);
		password.sendKeys(userPassword);
		signinButton.click();	
		wait.until(ExpectedConditions.visibilityOf(signinName));
	}
	
}