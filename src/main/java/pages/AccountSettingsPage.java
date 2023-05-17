package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class AccountSettingsPage
{
	
SoftAssert softAssert = new SoftAssert();
CommonUtilities	cu = new CommonUtilities();
	public	WebDriver driver;
		    public AccountSettingsPage(WebDriver driver)
		    {
		        this.driver = driver;
		    }
		    By profileIcon =By.cssSelector("img:nth-child(3)");
		    By profile =By.cssSelector(".show > .dropdown-item:nth-child(1)");
		    By accountsSettings = By.name("AccountSettingsPage");
		    By deactiveAccount = By.xpath("//*[@id=\"personal\"]/center/button/span");
		    By logoutBtn = By.xpath("");
		    
		    public void navigateToSettings() throws Exception
		    {
		    	Thread.sleep(4000);
		    	driver.findElement(profileIcon).click();
		    	Allure.step("Profile Icon is clicked");
		    	driver.findElement(profile).click();
		    	driver.findElement(accountsSettings).click();
		    	Allure.step("Account settings is clicked");
		    	
		    }
		    public void deactivateAccount() throws Exception
		    {
		    	Thread.sleep(2000);
		    	driver.findElement(deactiveAccount).click();
		    	Allure.step("Deactivate button is clicked");
		    }
		    public void logOut()
		    {
		    	driver.findElement(profileIcon).click();
		    	Allure.step("Profile Icon is clicked");
		    	//logoutBtn
		    	driver.findElement(logoutBtn).click();
		    	Allure.step("Logout button is clicked");
		    }
		    public void activateAccount()
		    {
		    	
		    }
		    
}
