package testCases;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.AddProductsPage;
import pages.LoginPage;
import utilities.Base;
import utilities.CommonUtilities;


public class AddProducts extends Base
{
	    //Call read file method of the class to read data	    
	    CommonUtilities	xcl = new CommonUtilities(); 
	
	@Test(priority=1)
	public void addproductoperation() throws Exception
	{
		LoginPage objloginpage = new LoginPage(driver);		
		objloginpage.login(xcl.getCellData("Login","User Name"), xcl.getCellData("Login","Password"));					
		AddProductsPage page = new AddProductsPage(driver);						
		page.addproduct();	
	}

	@AfterTest
	public void aftertest()
	{
		driver.quit();
	}	
}
