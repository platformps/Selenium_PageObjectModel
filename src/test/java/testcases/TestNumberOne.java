package testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.SelectBrowser;
import pages.HomePage;
import pages.SignUpPage;

public class TestNumberOne {
	WebDriver driver;
	HomePage objHomePage;
	SignUpPage objSignUpPage;

	@BeforeTest
	public void browserlauncher() {
		  driver = SelectBrowser.StartBrowser("Chrome");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //	 Load application
		driver.get("https://www.browserstack.com/");
		
	
	}
	
	@Test(priority = 1)
	public void navigate_to_homepage_click_on_getstarted() {
	objHomePage = new HomePage(driver);
	objHomePage.veryHeader();
	objHomePage.clickOnGetStarted();
	System.out.println("Home Page Test is done");
	}

	@Test(priority = 2)
	public void enter_userDetails() throws InterruptedException {
		objSignUpPage = new SignUpPage(driver);
	 	objSignUpPage.veryHeader();
		objSignUpPage.enterFullName("TestUser");
		objSignUpPage.enterBusinessEmail("TestUser@gmail.com");
		objSignUpPage.enterPasswrod("TestUserPassword");
		Thread.sleep(10000);
	}

	@AfterTest
	public void closeBrowser()
	{
	  driver.close();
	}
}
