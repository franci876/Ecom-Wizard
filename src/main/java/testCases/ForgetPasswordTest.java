package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.ChangePasswordPage;
import pages.ForgetPasswordPage;
import pages.loginPage;
import utilities.BaseClass;
import utilities.CommonUtilities;

@Listeners({utilities.AllureListners.class})
public class ForgetPasswordTest  extends BaseClass
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
	@Test(priority=1, groups = "Functional")
	@Description("TestCase : To verify profile edit")

	public void forgotpassword() throws Exception
	{
		ForgetPasswordPage cp =new ForgetPasswordPage(driver);
		cp.navigateToForgetPage();
		cp.forgetpass();
		
		
	
	}
	@Test(priority=1, groups = "Functional")
	@Description("TestCase : Verify login after password change")

	public void newLogin() throws Exception
	{
		loginPage lp =new loginPage(driver);
		lp.loginClick(xcl.getCellData("Login","Email"), xcl.getCellData("ForgetPassword", "Password_New"));	
	}
}