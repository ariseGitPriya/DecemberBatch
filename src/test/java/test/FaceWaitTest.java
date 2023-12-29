package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Brawser;
import pom.FaceBookLoginPage;

public class FaceWaitTest {
	WebDriver driver;
	
	@BeforeMethod
	public void brawser()
	{
		driver=Brawser.chrome("https://www.facebook.com/");
	}
	@Test
	public void createNewAccountTest() throws InterruptedException
	{
		
		FaceBookLoginPage facebookloginpage = new FaceBookLoginPage(driver);
		facebookloginpage.clickOnCreateNewAccount();
		facebookloginpage.enterFirstName("priyanka",driver);
	}

}
