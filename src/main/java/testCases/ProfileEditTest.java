package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.loginPage;
import pages.profileEdit;
import utilities.BaseClass;
import utilities.CommonUtilities;
@Listeners({utilities.AllureListners.class})

public class ProfileEditTest extends BaseClass
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
		@Description("TestCase : To verify profile edit")
		public void editProfile() throws Exception
		{
			loginPage lp =new loginPage(driver);
			lp.loginClick(xcl.getCellData("Login","Email"), xcl.getCellData("Login","Password_Record"));
			profileEdit pe = new profileEdit(driver);
			pe.profiledit();
		}
		
}

