package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Brawser;
import pom.FaceBookLoginPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class Assertions extends BaseTest{
	ExtentReports extentReports;
	ExtentTest test;
	@BeforeTest
	public void configureReports()
	{
		extentReports=Reports.generateReports();
	}
	
	
	@BeforeMethod
	public void brawser()
	{
		driver=Brawser.chrome("https://www.facebook.com/");
	}
	@Test
	public void createNewAccountTest()
	{
		test=extentReports.createTest("createNewAccountTest");
		FaceBookLoginPage facebookloginpage = new FaceBookLoginPage(driver);
		facebookloginpage.clickOnCreateNewAccount();
		facebookloginpage.enterFirstName("priyanka",driver);
	}
	
	@Test
	public void facebookLogoIsVisibleOrNot()
	{
		test=extentReports.createTest("facebookLogoIsVisibleOrNot");
		FaceBookLoginPage facebookloginpage = new FaceBookLoginPage(driver);
		boolean result=facebookloginpage.isLogoDisplayed();
		SoftAssert softassert = new SoftAssert();
		softassert.assertFalse(result);
	    facebookloginpage.enterEmailId("Arise@gmail.com");
		facebookloginpage.enterPassward("4444555666");
		facebookloginpage.clickOnlogin();
		System.out.println("Thank you");
		softassert.assertAll();

	}
	@Test
	
	public void verifyLoginPageTitle()
	{
		test=extentReports.createTest("verifyLoginPageTitle");
		FaceBookLoginPage facebookloginpage = new FaceBookLoginPage(driver);
		String expectedTitle = "Facebook – log in or sign up";
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle,expectedTitle);
		
		System.out.println("My name is priyanka");
	
	}
	@AfterMethod
	public void addTestStatus(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getName());
		}
		else if(result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP,result.getName());
		}
		
	}
	@AfterTest
	public void publishReport()
	{
		extentReports.flush();
	}

}
