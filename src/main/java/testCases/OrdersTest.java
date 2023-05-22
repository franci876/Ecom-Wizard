package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.OrdersPage;
import pages.loginPage;
import utilities.BaseClass;
import utilities.CommonUtilities;

@Listeners({utilities.AllureListners.class})
public class OrdersTest
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
	@Test
	@Description("TestCase : Filter Orders")
	public void ordersFilter() throws Exception
	{
		loginPage lp =new loginPage(driver);
		lp.loginClick(xcl.getCellData("Login", "Email"), xcl.getCellData("Login", "Password_Record"));
		OrdersPage op =new OrdersPage(driver);
		Thread.sleep(2000);
		op.navigateToOrderPage();
		Thread.sleep(4000);
		op.searchByOrder();
		op.searchBySku();
		op.searchByMarketplace();
		op.searchByOrderStatus();
		op.searchByMarketplaceOrderId();
		Thread.sleep(2000);
		op.searchByCustomer();
		op.shipTypeSelect();
		op.verifyAllOrderDetails();
		
	        
	}
	
}
