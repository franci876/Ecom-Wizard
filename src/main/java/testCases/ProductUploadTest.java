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
import pages.ProductUpload;
import pages.loginPage;
import utilities.BaseClass;
import utilities.CommonUtilities;

@Listeners({utilities.AllureListners.class})
public class ProductUploadTest  extends BaseClass
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
	@Description("TestCase : Add Product")
	public void productUpload() throws Exception
	{
	
		loginPage lp =new loginPage(driver);
		lp.loginClick(xcl.getCellData("Login", "Partner_Email"), xcl.getCellData("Login", "Patrner_Password_Record"));
		Thread.sleep(2000);
		ProductUpload pu = new ProductUpload(driver);
		pu.goToProductPage();
		pu.fileDownload();
		pu.fileupload();
		pu.filestatusCheck();
	}
}
