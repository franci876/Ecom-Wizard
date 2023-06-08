package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class ChangePasswordPage
{

SoftAssert softAssert = new SoftAssert();
CommonUtilities	cu = new CommonUtilities();
String Lname;
	public	WebDriver driver;
		    public ChangePasswordPage(WebDriver driver)
		    {
		        this.driver = driver;
		    }
		    By profileIcon =By.cssSelector("img:nth-child(3)");
		    By profile =By.cssSelector(".show > .dropdown-item:nth-child(1)");
		    By changeps = By.name("changepassword");
		    By oldps = By.name("old_password");
		    By newpass1 =By.name("new_password");
		    By newpass2 = By.name("new_password_confirmation");
		    By saveBtn = By.xpath("//*[@id=\"change-pass\"]/div/div/form/div/div[4]/button[1]");
		    By passchangeNoti = By.cssSelector(".ant-notification-notice-message");
		    By personaldetails = By.xpath("//*[@id=\"home-tab\"]");
		    By lastNm = By.xpath("//*[@id=\"personal\"]/div[2]/div/div[2]/div/input");
		    By profilEIcon =By.cssSelector(".user-icon > img:nth-child(1)");
		    By logout =By.xpath("/html/body/div[1]/div/header/nav/div/div/div[2]/div/a[2]");
		    
		    public void navigateToEditPage() throws Exception
		    {
		    	Thread.sleep(4000);
		    	driver.findElement(profileIcon).click();
		    	Allure.step("Profile Icon is clicked");
		    	driver.findElement(profile).click();
		    	//to get last name
		    	Thread.sleep(2000);
		    	driver.findElement(personaldetails).click();
		    	Lname=driver.findElement(lastNm).getAttribute("value");
		    	Thread.sleep(2000);
		    	driver.findElement(changeps).click();
		    	Allure.step("Redirected to change password page");
		    	
		    }
		    public void changePassword() throws Exception
		    {
		    	Thread.sleep(2000);
		    	driver.findElement(oldps).sendKeys(cu.getCellData("Login","Password_Record"));
		    	Allure.step("Old password is entered");
		    	
		    	String passNew=Lname+"@"+RandomStringUtils.randomNumeric(3);
		    	//cu.writeToExcels("ChangePassword", "NewPassword", passNew);
		    	cu.writeToExcel("ChangePassword", "NewPassword", passNew);
		    	Thread.sleep(2000);
		    	driver.findElement(newpass1).sendKeys(cu.getCellData("ChangePassword","NewPassword"));
		    	Allure.step("New password is entered");
		    	driver.findElement(newpass2).sendKeys(cu.getCellData("ChangePassword","NewPassword"));
		    	Allure.step("New password is entered again");
		    	driver.findElement(saveBtn).click();
		    	Allure.step("New password is saved");
		    	
		    	//Rewrite new password to login 
		    	cu.writeToExcel("Login", "ChangedPassword", passNew);
		    	
		    	
		    }
		    public void verifyPasswordChange() throws Exception
		    {
		    	Thread.sleep(2000);
		    	String actTextNoti = driver.findElement(passchangeNoti).getText();
		    	String expTextNoti = "Your password has been changed!";	
		    	softAssert.assertEquals(actTextNoti, expTextNoti, "Field Data Mismatched");
				Allure.step("Verified password change"); 
		    }
		    public void logout() throws Exception
		    {
		    	Thread.sleep(5000);
		    	driver.findElement(profilEIcon).click();
		    	Allure.step("Clicked on profile icon");
		    	driver.findElement(logout).click();
		    	Allure.step("Clicked on logout button");
		    }

}
