package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AddUser;
import pages.loginPage;
import utilities.BaseClass;
import utilities.CommonUtilities;

@Listeners({utilities.AllureListners.class})
public class AddUserTest extends BaseClass
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
	@Test
	public void addecomUser() throws Exception
	{
		AddUser ad =new AddUser(driver);
		loginPage lp =new loginPage(driver);
		lp.loginClick(xcl.getCellData("Login","Email"), xcl.getCellData("Login","Password_Record"));
		Thread.sleep(6000);
		ad.adduserinfo();
		ad.tempMailVerification();
		ad.setPassword(xcl.getCellData("Add_User", "UserPass"));
		Thread.sleep(3000);
		loginPage lpe =new loginPage(driver);
		lpe.loginClick(xcl.getCellData("Add_User", "Email_ID"), xcl.getCellData("Add_User", "User_Password"));
		Thread.sleep(1000);
		ad.verifyUser();
	}
	
}
