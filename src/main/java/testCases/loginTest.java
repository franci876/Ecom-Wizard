package testCases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.logOut;
import pages.loginPage;
import pages.profileEdit;
import pages.userRegistration;
import utilities.BaseClass;
import utilities.CommonUtilities;
@Listeners({utilities.AllureListners.class})
public class loginTest extends BaseClass
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
	@Description("TestCase : To verify login Testcase")
	//Login
	public void login()
	{
		loginPage lp =new loginPage(driver);
		
		
		lp.loginClick(xcl.getCellData("Login","Email"), xcl.getCellData("Login","Password_Record"));	
	}
	
	
	@Test(priority=2)
	@Description("TestCase : Logout Function")
	public void logoutuser()
	{
		logOut lg =new logOut(driver);
		lg.logout();
	}
	
	@Test(priority=3)
	@Description("TestCase : Login Negative case with wrong credentials")
	public void loginNeg1() throws Exception
	{
		loginPage lp =new loginPage(driver);
		lp.loginClick(xcl.getCellData("Login","EmailNegCase1"), xcl.getCellData("Login","PassNegCase1"));
		lp.loginfails();
	}
	@Test(priority=4)
	@Description("TestCase : Login Negative case with no email id")
	public void loginNeg2() throws Exception
	{
		loginPage lp =new loginPage(driver);
		lp.loginClick(" ", xcl.getCellData("Login","PassNegCase2"));

	}
	@Test(priority=5)
	@Description("TestCase : Login Negative case with wrong email id")
	public void loginNeg3() 
	{
		loginPage lp =new loginPage(driver);
		lp.loginClick(xcl.getCellData("Login","EmailNegCase3"), xcl.getCellData("Login","PassNegCase3"));	
	}
	@Test(priority=6)
	@Description("TestCase : Login Negative case with blank space as password")
	public void loginNeg4() 
	{
		loginPage lp =new loginPage(driver);
		lp.loginClick(xcl.getCellData("Login","Email"), " ");	
	}
	
	@AfterTest
	public void afterTest()
	{
		//driver.quit();
	}
}
