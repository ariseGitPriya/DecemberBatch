package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBookLoginPage {
	@FindBy (xpath=("//input[@name='email']"))private WebElement email;
	@FindBy (xpath=("//input[@name='pass']")) private WebElement passward;
	@FindBy (xpath=("//button[@name='login']"))private WebElement login;
	@FindBy (xpath="//a[text()='Forgotten password?']")private WebElement forgotPassward;
	@FindBy (xpath="//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")private WebElement createNewAccount;
	@FindBy (xpath="//a[text()='Create a Page']")private WebElement createPage;
	@FindBy (xpath="//input[@name='firstname']")private WebElement firstname;
	@FindBy (xpath="//img[@class='fb_logo _8ilh img']")private WebElement logo;
	
	public FaceBookLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailId(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void enterPassward(String pass)
	{
		passward.sendKeys(pass);
	}
	
	public void clickOnlogin()
	{
		login.click();
	}
	
	public void clickOnForgotPassward()
	{
		forgotPassward.click();
	}
	
	public void clickOnCreateNewAccount()
	{
		createNewAccount.click();
	}
	
	public void clickOnCreatePage()
	{
		createPage.click();
	}
	public void enterFirstName(String name,WebDriver driver)
	{
		/*
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000)); 
		wait.until(ExpectedConditions.visibilityOf(firstname));
		firstname.sendKeys(name);
		*/
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(3000));
		wait.pollingEvery(Duration.ofMillis(100));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(firstname));
		
		firstname.sendKeys("Priyanka");
	}
	
	public boolean isLogoDisplayed()
	{
		return logo.isDisplayed();
	}
	

}
