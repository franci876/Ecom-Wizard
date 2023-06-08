package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		    By accountsSettings = By.linkText("Account Settings");
		    By deactiveAccount = By.xpath("//*[@id=\"personal\"]/center/button/span");
		    By deactiveYes = By.cssSelector(".ant-btn-primary > span");
		    By activateAccount = By.cssSelector(".ant-btn > span:nth-child(2)");
		    By activateAccountYes =By.cssSelector(".ant-btn-primary > span");
		    By verDeactive = By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div[2]");
		    By verYes = By.cssSelector(".ant-popover-message-title");
		    
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
		    	Thread.sleep(3000);
		    	driver.findElement(deactiveYes).click();
		    	
		    }
		    public void activateAccount() throws Exception
		    {
		    	Thread.sleep(3000);
		    	driver.findElement(activateAccount).click();
		    	
		    	
		    	WebElement yesbtn = driver.findElement(By.cssSelector(".ant-btn-primary > span"));

		    	//Instantiating Actions class
		    	Actions actions = new Actions(driver);

		    	//Hovering on main menu
		    	actions.moveToElement(yesbtn);
		    	
		    	
		    	
		    	//Thread.sleep(2000);
		    	driver.findElement(activateAccountYes).click();
		    	
		    }
		   public void verifyDeactivateAccount()
		   {
			   
			//verify deactivate account
			String actVerDeact = driver.findElement(verDeactive).getText();
			String ExpVerDeact = cu.getCellData("AccountDetails", "DeactivateText");
			softAssert.assertEquals(actVerDeact, ExpVerDeact, "Field Data Mismatched");
			Allure.step("Account deactivation is verified");
		   }
		   public void verifyActivateAccount()
		   {
			//verify Activate account
			String actVerDeact = driver.getCurrentUrl();
			String ExpVerDeact = cu.getCellData("AccountDetails", "URL");
			softAssert.assertEquals(actVerDeact, ExpVerDeact, "Field Data Mismatched");
			Allure.step("Account deactivation is verified");
		   }
		   
}
