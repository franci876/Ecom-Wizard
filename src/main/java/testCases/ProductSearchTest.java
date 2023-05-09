package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.ProductSearchPage;
import pages.loginPage;
import utilities.BaseClass;
import utilities.CommonUtilities;
@Listeners({utilities.AllureListners.class})

public class ProductSearchTest extends BaseClass
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
		@Description("TestCase : Edit Product")
		public void productEdit() throws Exception
		{
			loginPage lp =new loginPage(driver);
			lp.loginClick(xcl.getCellData("Login", "Partner_Email"), xcl.getCellData("Login", "Patrner_Password_Record"));
			ProductSearchPage pe =new ProductSearchPage(driver);
			pe.gotoProductSearch();
			pe.productSearchBySku();
			pe.verifyProdSearchBySku();
			pe.prodSearchByCategory();
			pe.verifyProdSearchByCategory();
			pe.prodSearchByStock();
			pe.searchByStatus();
			
		
		}
}
