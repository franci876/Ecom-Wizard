package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		
	}
	By username =By.name("username");
	By password = By.name("password");
	By loginbutton = By.xpath("/html/body/div[3]/div[1]/div[2]/div/form/fieldset/div[2]/div[4]/div[2]/input");
	By profile = By.className("user-icon");
	By logoutbutton = By.className("dropdown-item");
	
	public void enterUserName(String strUserName)
	{
		
		driver.findElement(username).sendKeys(strUserName);
		
	}
	public void enterPassword(String strPassword)
	{
		driver.findElement(password).sendKeys(strPassword);
	}
	public void clickLoginButton()
	{
		driver.findElement(loginbutton).click();		
		driver.findElement(username).clear();
		driver.findElement(password).clear();
		
	}
	
     public  void login(String strUserName, String strPassword)
	{
		try
		{
			this.enterUserName(strUserName);
			this.enterPassword(strPassword);
			this.clickLoginButton();
			
	    }
		catch(Exception e)
		{
			System.out.print("Error"+e.getMessage());
		
		}
	}
	
}
