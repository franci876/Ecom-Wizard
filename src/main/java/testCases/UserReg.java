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
    	//driver.get("https://ecompartner.digitalmesh.co.in/partner/complete-profile/company-info/274%7CVOEJbLb5JAZcAlOkF5d05zvMONRQBNBuzB1w4L0v/BWodd");
    	
	}
	@Test
	@Description("TestCase : User Registration")
	public void userReg() throws Exception {
		
			userRegistration ur =new userRegistration(driver);
			ur.tempMailVerification();
			ur.register(xcl.getCellData("PartnerDetails", "First Name"),xcl.getCellData("PartnerDetails", "Last Name"),xcl.getCellData("PartnerDetails", "Partner_Email"));
			ur.Entercompanydetails();
			ur.termsandcon();
			ur.subPlans();
			ur.subPayment(); 
			ur.setPasswrd(xcl.getCellData("PartnerDetails", "Pass"));
			Thread.sleep(3000);
			loginPage lp =new loginPage(driver);
			lp.loginClick(xcl.getCellData("PartnerDetails", "Partner_Email"), xcl.getCellData("PartnerDetails", "Patrner_Password_Record"));
			ur.verifyPartnerAdded();
		}
	
	//@Test(priority =2, groups ="Regression")
	@Description("TestCase : User Registration2 ")
	public void userRegRegressionTest() throws Exception
	{
		
			userRegistration ur =new userRegistration(driver);
			ur.tempMailVerification();
			
			ur.registerWithExistingEmail(xcl.getCellData("PartnerDetails", "First Name"),xcl.getCellData("PartnerDetails", "Last Name"));
			//ur.verifyMandatoryFieldsMsg();
			ur.registerWithoutPrivacyPolicy(xcl.getCellData("PartnerDetails", "First Name"),xcl.getCellData("PartnerDetails", "Last Name"),xcl.getCellData("PartnerDetails", "Partner_Email"));
			ur.registerWithIncorrectEmailId(xcl.getCellData("PartnerDetails", "First Name"),xcl.getCellData("PartnerDetails", "Last Name"),xcl.getCellData("PartnerDetails", "Partner_Email"));
			ur.EntercompanydetailsWithInvalidLogo();
			ur.tempMailVerification();
			ur.register(xcl.getCellData("PartnerDetails", "First Name"),xcl.getCellData("PartnerDetails", "Last Name"),xcl.getCellData("PartnerDetails", "Partner_Email"));
			ur.EntercompanydetailsWithInvalidLogo();
			ur.Entercompanydetails();
			ur.RegWithoutTermsAndCon();
			ur.subPlansColourVerificationMouseHover();
			ur.subPlansColourChangeAfterSubPlanSelect();
			ur.subPayment(); 
			ur.setPasswrd(xcl.getCellData("PartnerDetails", "Pass"));
			Thread.sleep(3000);
			loginPage lp =new loginPage(driver);
			lp.loginClick(xcl.getCellData("PartnerDetails", "Partner_Email"), xcl.getCellData("PartnerDetails", "Patrner_Password_Record"));
			ur.verifyPartnerAdded();
		}

}
