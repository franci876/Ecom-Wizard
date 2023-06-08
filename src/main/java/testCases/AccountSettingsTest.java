package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.AccountSettingsPage;
import pages.loginPage;
import utilities.BaseClass;
import utilities.CommonUtilities;

@Listeners({utilities.AllureListners.class})
public class AccountSettingsTest extends BaseClass
	{
		public WebDriver driver;
		CommonUtilities	xcl = new CommonUtilities();
		@BeforeTest
		public void beforetest()
		{
			BaseClass bs= new BaseClass();
			driver = bs.initialize_driver();
	    	driver.get("http://ecompartner.digitalmesh.co.in/");
		}
		@Test(priority=1)
		@Description("TestCase : To verify account activation")
		public void accountSettings() throws Exception
		{
			loginPage lp =new loginPage(driver);
			lp.loginClick(xcl.getCellData("Login","Email"), xcl.getCellData("Login","Password_Record"));
			AccountSettingsPage asp =new AccountSettingsPage(driver);
			asp.navigateToSettings();
			asp.deactivateAccount();
			Thread.sleep(2000);
			asp.verifyDeactivateAccount();
			asp.activateAccount();
			Thread.sleep(2000);
			asp.verifyActivateAccount();
		}
}
