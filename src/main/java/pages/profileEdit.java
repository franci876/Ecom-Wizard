package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class profileEdit 
{
SoftAssert softAssert = new SoftAssert();
CommonUtilities	cu = new CommonUtilities();
	public	WebDriver driver;
		    public profileEdit(WebDriver driver)
		    {
		        this.driver = driver;
		    }
		    By profileIcon =By.cssSelector("img:nth-child(3)");
		    By profile =By.cssSelector(".show > .dropdown-item:nth-child(1)");
		    By editProfile =By.cssSelector("p:nth-child(2)");
		    By fstName =By.xpath("//input[@name='first_name']");
		    By lstName =By.xpath("//input[@name='last_name']");
		    By edtSave =By.xpath("//button[contains(.,'Save')]");
		    By logoSel = By.xpath("//*[@id=\"personal\"]/div[2]/div/div[7]/div");
		    
		    public void profiledit() throws Exception
		    {
		    	
		    	Thread.sleep(4000);
		    	driver.findElement(profileIcon).click();
		    	Allure.step("Profile Icon is clicked");
		    	
		    	driver.findElement(profile).click();
		    	
		    	Actions builder = new Actions(driver); //mouse-over step1
		    	WebElement element = driver.findElement(By.cssSelector(".edit-icon")); //mouse-over step2
		        builder.moveToElement(element).perform(); //mouse-over step3
		    	
		        driver.findElement(editProfile).click();
		    	Allure.step("Edit profile button is clicked");
		    	driver.findElement(fstName).clear();
		    	Allure.step("First name is cleared");
		    	driver.findElement(fstName).sendKeys(cu.getCellData("EditProfile", "FirstName"));
		    	Allure.step("First name is entered");
		    	driver.findElement(lstName).clear();
		    	Allure.step("Last name is cleared");
		    	driver.findElement(lstName).sendKeys(cu.getCellData("EditProfile", "LastName"));
		    	Allure.step("Last name is entered");
		    	
		    	Thread.sleep(3000);
		    	driver.findElement(logoSel).click();
				Allure.step("Clicked on browse file button");
				Thread.sleep(10000);
				Runtime.getRuntime().exec("C://autoitFiles/logoUpload.exe");
				Allure.step("Logo file is uploaded");
				Thread.sleep(3000);
		    	driver.findElement(edtSave).click();
		    	Allure.step("Clicked on save button");
		    	
		    	//verifying first name edit 
		    	String edtfstacttext =cu.getCellData("EditProfile", "FirstName");
				String edtfstexcptText = driver.findElement(fstName).getAttribute("value");
				softAssert.assertEquals(edtfstacttext, edtfstexcptText, "Field Data Mismatched");
				Allure.step("Verified First Name Edit");
				//verifying first name edit 
				String ectlstacttext =cu.getCellData("EditProfile", "LastName");
				String ectlstexcptText = driver.findElement(lstName).getAttribute("value");
				softAssert.assertEquals(ectlstacttext, ectlstexcptText, "Field Data Mismatched");
				Allure.step("Verified Second Name Edit");
				
				Thread.sleep(5000);
				By logoselect = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/div");
				driver.findElement(logoselect).click();
				Thread.sleep(3000);
				Boolean logoPresent = driver.findElement(By.cssSelector(".ant-image-preview-img")).isDisplayed();
				String actImg = " ";
				if (logoPresent) 
				 {
			         System.out.println("Element is displayed");
			         actImg ="Element is displayed";
			        		
			         
			      } else 
			      {
			         System.out.println("Element is not displayed");
			         actImg ="Element is not displayed";
			      }
				String expImg = "Element is displayed";
				softAssert.assertEquals(actImg, expImg, "Field Data Mismatched");
				softAssert.assertAll();
		    }
}
