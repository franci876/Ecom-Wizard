package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.loginPage;
import pages.userRegistration;
import utilities.BaseClass;
import utilities.CommonUtilities;
@Listeners({utilities.AllureListners.class})
public class UserReg extends BaseClass
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
	@Description("TestCase : User Registration")
	public void userReg() throws Exception {
		
	       // xcl.setRecord("UserRegistration","First Name","gh777b@cc.com");
			userRegistration ur =new userRegistration(driver);
			ur.tempMailVerification();
			
			ur.register(xcl.getCellData("Login", "First Name"),xcl.getCellData("Login", "Last Name"),xcl.getCellData("Login", "Partner_Email"));
			ur.setPasswrd(xcl.getCellData("Login", "Pass"));
			Thread.sleep(3000);
			loginPage lp =new loginPage(driver);
			lp.loginClick(xcl.getCellData("Login", "Partner_Email"), xcl.getCellData("Login", "Patrner_Password_Record"));
			
		}

}
