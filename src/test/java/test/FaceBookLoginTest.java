package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Brawser;
import pom.FaceBookLoginPage;

@Listeners(test.Listeners.class)
public class FaceBookLoginTest extends BaseTest{
	
	
	@BeforeMethod
	public void openBrawser()
	{
		 driver=Brawser.chrome("https://www.facebook.com/");
	}
	
	@Test
	public void loginWithValidUserNameAndPassward()
	{
		
		FaceBookLoginPage facebookLoginpage = new FaceBookLoginPage(driver);
		facebookLoginpage.enterEmailId("Arise@gmail.com");
		facebookLoginpage.enterPassward("333444555");
		facebookLoginpage.clickOnlogin();
	}
	
	@Test
	public void loginWithInvalidUserNameAndValidPassward()
	{
		
		FaceBookLoginPage facebookLoginpage = new FaceBookLoginPage(driver);
		facebookLoginpage.enterEmailId("Goodluck@gmail.com");
		facebookLoginpage.enterPassward("333444555");
	
	}
	
	@Test
	public void loginWithValidUserNameAndInvalidPassward()
	{
		
		FaceBookLoginPage facebookLoginpage = new FaceBookLoginPage(driver);
		facebookLoginpage.enterEmailId("Arise@gmail.com");
		facebookLoginpage.enterPassward("776665555");
		
		
	}
	
	@AfterMethod
	public void closeBrawser()
	{
		driver.close();
	}
	

}
