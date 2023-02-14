package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utilities.Base;
import utilities.CommonUtilities;


public class Login extends Base
{
	//WebDriver driver;
    
    CommonUtilities	xcl = new CommonUtilities();
	@Test(priority=1)
	public void loginoperation() throws InterruptedException, IOException
	{						
		 LoginPage page = new LoginPage(driver);
		page.login(xcl.getCellData("Login","User Name"), xcl.getCellData("Login","Password"));					  				
	}
	@Test(priority=2)
	public void logoutoperation()
	{
      LoginPage page = new LoginPage(driver);
	  page.clickLogout();
		
	}
}
