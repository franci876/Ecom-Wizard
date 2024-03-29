package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class loginPage
{
	SoftAssert softAssert = new SoftAssert();
    
	public	WebDriver driver;
	CommonUtilities	xcl = new CommonUtilities();	    
		    public loginPage(WebDriver driver)
		    {
		        this.driver = driver;
		        
		    }
		    By userNameF =By.name("userName");
		    By passwordF = By.name("password");
		    By rememberMe = By.name("remember_me");
		    By loginBtn = By.xpath("//button[@type='button']");
		    By loginBtnInvalidLogin = By.xpath("//*[@id=\"root\"]/div/div[4]/a");
		    
		    public void loginClick(String userName, String password) 
		    {
		    
		    	driver.findElement(userNameF).clear();
		    	driver.findElement(userNameF).sendKeys(userName);
		    	Allure.step("User name is entered");
		    	driver.findElement(passwordF).clear();
		    	driver.findElement(passwordF).sendKeys(password);
		    	Allure.step("Password is entered");
		    	driver.findElement(rememberMe).click();
		    	Allure.step("Remember me checkbox is clicked");
		    	driver.findElement(loginBtn).click();
		    	Allure.step("Login Button is clicked");
		    	
		    	
		    	//verifying login test
		    	String acttext =driver.getCurrentUrl();
				String excptText = "http://main.stage.bt-ms.co";
				//https://ecompartner.digitalmesh.co.in/partner/dashboard
				softAssert.assertEquals(acttext, excptText, "Login Failed");
				Allure.step("Verified login page");
			    
				//softAssert.assertAll();
			
		    }
		    public void loginfails() throws Exception
		    {
		    	Thread.sleep(2000);
		    	driver.findElement(loginBtnInvalidLogin).click();
		    }
}