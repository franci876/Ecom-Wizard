package testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utilities.CommonUtilities;


public class Login
{
	WebDriver driver;
	
    String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";

    //Call read file method of the class to read data
  
    CommonUtilities	xcl = new CommonUtilities();
	@BeforeTest
	public void beforetest()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://main.stage.bt-ms.com/erp.php/login");
			  
	}
	
	@Test
	public void loginoperation() throws InterruptedException, IOException
	{

		LoginPage page = new LoginPage(driver);
						
		page.login(xcl.getCellData("Login","User Name"), xcl.getCellData("Login","Password"));		
  				
	}
	
	@AfterTest
	public void aftertest()
	{
		driver.quit();
	}
	

}
