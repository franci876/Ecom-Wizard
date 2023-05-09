package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.ReportsPage;
import pages.loginPage;
import utilities.BaseClass;
import utilities.CommonUtilities;
@Listeners({utilities.AllureListners.class})
public class ReportsTest extends BaseClass
{
	
			public WebDriver driver;
			CommonUtilities	xcl = new CommonUtilities();
			
			@BeforeTest
			public void beforetest()
			{
				BaseClass bs= new BaseClass();
				driver = bs.initialize_driver();
		    	driver.get("http://ecompartner.digitalmesh.co.in/");
			}
			@Test(priority=1)
			@Description("TestCase : To verify profile edit")
			//Login
			public void login()
			{
				loginPage lp =new loginPage(driver);
				
				lp.loginClick(xcl.getCellData("Login","Email"), xcl.getCellData("Login","Password_Record"));	
			}
			@Test(priority=2)
			@Description("TestCase : To verify marketplace sales reports")
			public void marketPlaceSalesReports() throws Exception
			{
				ReportsPage rp = new ReportsPage(driver);
				rp.marketPlaceSalesReport();
				rp.verifyMarketplace();
			}
			@Test(priority=3)
			@Description("TestCase : To verify category sales reports")
			public void categorySales() throws Exception
			{
				ReportsPage rp = new ReportsPage(driver);
				rp.categorySales();
				rp.verifyCategory();
			}
			@Test(priority=4)
			@Description("TestCase : To verify top selling products reports")
			public void topSellingProducts() throws Exception
			{
				ReportsPage rp = new ReportsPage(driver);
				rp.topSellingProducts();
				rp.verifyProduct();
			}

}
