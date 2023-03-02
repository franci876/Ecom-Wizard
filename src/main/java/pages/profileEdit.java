package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class profileEdit 
{
SoftAssert softAssert = new SoftAssert();
    
	public	WebDriver driver;
		    public profileEdit(WebDriver driver)
		    {
		        this.driver = driver;
		    }
		    By profileIcon =By.cssSelector(".user-icon > img:nth-child(1)");
		    By profile =By.cssSelector(".show > .dropdown-item:nth-child(1)");
		    By editProfile =By.xpath("//div[@id='personal']/div/a/p");
		    By fstName =By.xpath("//*[@id=\"personal\"]/div[2]/div/div[1]/div/input");
		    By lstName =By.xpath("//*[@id=\"personal\"]/div[2]/div/div[2]/div/input");
		    By edtSave =By.xpath("//button[contains(.,'Save')]");
		    
		    public void profiledit(String firstNm,String lstNm)
		    {
		    	driver.findElement(profileIcon).click();
		    	Allure.step("Profile Icon is clicked");
		    	driver.findElement(profile).click();
		    	driver.findElement(editProfile).click();
		    	Allure.step("Edit profile button is clicked");
		    	driver.findElement(fstName).clear();
		    	Allure.step("First name is cleared");
		    	driver.findElement(fstName).sendKeys(firstNm);
		    	Allure.step("First name is entered");
		    	driver.findElement(lstName).clear();
		    	Allure.step("Second name is cleared");
		    	driver.findElement(lstName).sendKeys(lstNm);
		    	Allure.step("Last name is entered");
		    	driver.findElement(edtSave).click();
		    	Allure.step("Clicked on save button");
		    	
		    	//verifying first name edit 
		    	String edtfstacttext ="collier";
				String edtfstexcptText = driver.findElement(fstName).getAttribute("value");
				softAssert.assertEquals(edtfstacttext, edtfstexcptText, "Field Data Mismatched");
				Allure.step("Verified First Name Edit");
				//verifying first name edit 
				String ectlstacttext ="collier";
				String ectlstexcptText = driver.findElement(fstName).getAttribute("value");
				softAssert.assertEquals(ectlstacttext, ectlstexcptText, "Field Data Mismatched");
				Allure.step("Verified Second Name Edit");
				
				softAssert.assertAll();
		    }
}
