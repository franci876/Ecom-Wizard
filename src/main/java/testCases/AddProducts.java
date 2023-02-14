package testCases;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AddProductsPage;
import pages.LoginPage;
import utilities.Base;
import utilities.CommonUtilities;


public class AddProducts extends Base
{
	

	    //Call read file method of the class to read data

	    
	    CommonUtilities	xcl = new CommonUtilities();

	//WebDriver driver;   
	
	@Test(priority=1)
	public void addproductoperation() throws InterruptedException, IOException
	{
		LoginPage objloginpage = new LoginPage(driver);
		
		objloginpage.login(xcl.getCellData("Login","User Name"), xcl.getCellData("Login","Password"));	
		
		
		AddProductsPage page = new AddProductsPage(driver);						
		page.clickcoredata();		
		page.createproduct();
		page.deleteproduct();
		page.addproduct();
  				
	}
	
	
	
//	@AfterTest
//	public void aftertest()
//	{
//		driver.quit();
//	}	
//	

}
