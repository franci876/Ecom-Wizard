package testCases;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import pages.AddProductsPage;
import pages.LoginPage;
import utilities.Base;
import utilities.CommonUtilities;


public class AddProducts extends Base
{
	    //Call read file method of the class to read data	    
	    CommonUtilities	xcl = new CommonUtilities(); 
	
	@Test(priority=1)
	@Description("Login Operation, Add Products Operation, Edit Products Operation Verify Products Details and Delete Product Operation")
	@Story("Login with correct user name and password and add products with correct data and then edit product with correct data then delete product")
	public void addproductoperation() throws Exception
	{
		driver.manage().window().maximize();
		LoginPage objloginpage = new LoginPage(driver);		
		objloginpage.login(xcl.getCellData("Login","User Name"), xcl.getCellData("Login","Password"));					
		
		//AddProductsPage page = new AddProductsPage(driver);						
		AddProductsPage objaddpg = new AddProductsPage(driver);
		objaddpg.addproducts(xcl.getCellData("Products","S.G"),xcl.getCellData("Products", "Appearance"),xcl.getCellData("Products", "Proper Shipping Name"),xcl.getCellData("Products","Tank Type Desc"),xcl.getCellData("Products", "Appearance"),xcl.getCellData("Products", "caS Number"));
	}
	@AfterTest
	public void aftertest()
	{
		driver.quit();
	}	
}
