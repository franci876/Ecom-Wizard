package pages;

import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class OrdersPage 
{
	public	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	CommonUtilities	cu = new CommonUtilities();
	public OrdersPage(WebDriver driver)
		    {
		        this.driver = driver;
		        
		    }
	//navigate to orders
	By ordernav = By.cssSelector(".nav-item:nth-child(3) > #navbarDropdown");
	By orderdash = By.cssSelector(".show > .dropdown-item");
	//verify heading
	By orderdashHeading = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[1]/div/div/div[1]/h1");	
	//filter by month
	By month = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/form/div[3]/div/div[2]/div/div/div/div/span[2]");
	//By monthsel = By.cssSelector("div[title='This Week']");

	By searchBtn = By.name("search");
	//order id
	By orderId = By.id("keyword");
	By orderLoc = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/table/tbody/tr/td[2]");
	//back button
	By backBtn =By.cssSelector(".anticon-arrow-left > svg");
	String drpsel="//div[8]/div";
	//locateOrder
	By locateOrder = By.xpath("//td[2]/a");
	By orderVeri =By.cssSelector(".ant-page-header-heading-sub-title");
	
	By searchBy = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/form/div[1]/div/div[2]/div/div/div/div/span[2]");
	//find sku
	By findSKU = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/div/div/div/div/div/table/tbody/tr/td[2]");
	By odHeading = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div/div/span[1]");
	//marketplaces
	By marketplace =By.id("filterByMarketplaces");
	By selMarketPlace = By.xpath("//div[2]/div/div/div/div[2]/div");
	By marketPlaceOut = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[1]");
	
	By marketplaceVeri = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/table/tbody/tr/td[4]");
	By orderStatus = By.id("filterByOrderStatus");
	By mkpver = By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div/div[2]/div");
	
	By marketplaceclear = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/form/div[4]/div/div[2]/div/div/div/span/span");
	By orderstatusclear = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/form/div[5]/div/div[2]/div/div/div/span/span");
	By mpoidsearchbtn = By.cssSelector(".ant-table-cell:nth-child(3) .ant-dropdown-trigger svg");
	By mpoidinput = By.cssSelector(".ant-table-filter-dropdown .ant-input");
	By mpoidsearch = By.cssSelector(".ant-btn-primary > span:nth-child(2)");
	By mpoidReset = By.xpath("//div[2]/button");
	
	By custsearch = By.cssSelector(".ant-table-cell:nth-child(5) .ant-dropdown-trigger svg");
	By custnminput = By.cssSelector("input.ant-input[placeholder='Search Customer']"); 
	By custsearchbtn = By.cssSelector(".ant-btn-primary > span:nth-child(2)");
	By custReset = By.xpath("/html/body/div[9]/div/div/div/div/div/div[2]/button");
	
	By shipTypeFil = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/table/thead/tr/th[6]/div/span[2]");
	By shipTypeSel = By.xpath("//li[2]/span/label/span/input");
	By shipOkBtn = By.xpath("//span[contains(.,'OK')]");
	
	public void navigateToOrderPage()
	{
		driver.findElement(ordernav).click();
		Allure.step("Clicked on order button at navigation bar");
		driver.findElement(orderdash).click();
		Allure.step("Clicked on order dashboard");
		String ActHead =driver.findElement(orderdashHeading).getText();
		String ExpHead = "Order Dashboard";
		softAssert.assertEquals(ActHead, ExpHead, "Field Data Mismatched");
		Allure.step("Verified order dashboard heading");
		softAssert.assertAll();
	
	}
	public void searchByOrder() throws Exception
	{
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(month);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	Thread.sleep(3000);
    	
		driver.findElement(month).click();
		Thread.sleep(2000);
		selectDateFromDropdown();
	    
		Allure.step("Month is selected from dropdown to filter");
		driver.findElement(searchBtn).click();
		Allure.step("Clicked on search button");
		driver.findElement(orderId).sendKeys(cu.getCellData("OrderDetails", "Order_Id"));
		Allure.step("Search with order id :-"+cu.getCellData("OrderDetails", "Order_Id"));
		driver.findElement(searchBtn).click();
		Allure.step("Clicked on search button");
		
		driver.findElement(orderLoc).click();
		Allure.step("Go to orders details page");
		
		String actOrderStatusVal =driver.findElement(orderVeri).getText();
		 String expOrderStatusVal = cu.getCellData("OrderDetails", "Order_Id");
		 softAssert.assertEquals(actOrderStatusVal, expOrderStatusVal, "Field Data Mismatched");
		 Allure.step("Selected order id is verified ");
		
		
		driver.findElement(backBtn).click();
		Thread.sleep(2000);
		
		
		
	}
	
	
	public void selectDateFromDropdown() throws Exception
	{
		By monthsel = By.cssSelector("div[title='"+cu.getCellData("OrderDetails", "Select_Month")+"']");
		Thread.sleep(3000);
		driver.findElement(monthsel).click();
		Allure.step("Month is selected from dropdown");
		
	}
	public void selectMarketPlaceFromDropdown() throws Exception
	{
		By marketsel = By.cssSelector("div[title='"+cu.getCellData("OrderDetails", "Select_Marketplace")+"']");
		Thread.sleep(3000);
		driver.findElement(marketsel).click();
		Allure.step("Marketplace is selected from dropdown");
	}
	public void selectOrderStatusFromDropdown() throws Exception
	{
		By orderstatusSel = By.cssSelector("div[title='"+cu.getCellData("OrderDetails", "Order_Status")+"']");
		Thread.sleep(3000);
		driver.findElement(orderstatusSel).click();
		Allure.step("Order status is selected from dropdown");
	}
	public void searchBy() throws Exception
	
	{
		By orderstatusSel = By.cssSelector("div[title='"+cu.getCellData("OrderDetails", "Search_By")+"']");
		Thread.sleep(3000);
		driver.findElement(orderstatusSel).click();
		Allure.step("Order status is selected from dropdown");
	}
	
	public void searchBySku() throws Exception
	{
		Thread.sleep(4000);
		driver.findElement(orderId).clear();
		driver.findElement(month).click();
		Allure.step("Order date is selected");
		Thread.sleep(2000);
		selectDateFromDropdown();
		
		driver.findElement(searchBy).click();
		searchBy();
		Thread.sleep(2000);
		driver.findElement(orderId).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	   
		driver.findElement(orderId).sendKeys(cu.getCellData("OrderDetails","SKU_ID"));
		Allure.step("SKU ID is entered");
		driver.findElement(searchBtn).click();
		Allure.step("Searched with SKU ID");
		Thread.sleep(2000);
		driver.findElement(locateOrder).click();
		Allure.step("Go to orders details page");
		//verify sku id
		Thread.sleep(2000);
		String ActSKUID = driver.findElement(findSKU).getText();
		String ExpSKUrID = cu.getCellData("OrderDetails","SKU_ID");
		softAssert.assertEquals(ActSKUID, ExpSKUrID, "Field Data Mismatched");
		Allure.step("Verified SKU ID");
		
		//verify order details heading
		String ActOdHead =driver.findElement(odHeading).getText();
		String ExpOdHead = "Order Details";
		softAssert.assertEquals(ActOdHead, ExpOdHead, "Field Data Mismatched");
		
		//softAssert.assertAll();
		driver.findElement(backBtn).click();
	}
	public void searchByMarketplace() throws Exception
	{
		driver.findElement(marketplace).click();
		Allure.step("Clicked on marketplace");
		Thread.sleep(1000);
		selectMarketPlaceFromDropdown();
		driver.findElement(month).click();
		Allure.step("Order date is selected");
		Thread.sleep(2000);
		selectDateFromDropdown();
	    Thread.sleep(1000);
	    driver.findElement(searchBtn).click();
		Allure.step("Searched with marketplace is completed");
		
		findMarket();
		
	}
	public void findMarket()
    {

		WebElement table = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/table")); 

		String headerName = "Marketplace"; 

		int columnIndex = -1; // initialize column index to -1

		List<WebElement> headerCells = table.findElements(By.tagName("th")); // get all the header cells

		for (int i = 0; i < headerCells.size(); i++) {

			if (headerName.equals(headerCells.get(i).getText())) {

				columnIndex = i; // update the column index when header name matches
				System.out.println("Number of coloumn : "+columnIndex);
				break; // exit the loop once the header name is found

			}

		}

	List<WebElement> rows = table.findElements(By.tagName("tr")); // get all the rows in the table

	for(WebElement row : rows)
	{
		List<WebElement> cells = row.findElements(By.tagName("td")); // get all the cells in each row
		if (columnIndex < cells.size()) 
		{ 
			// check if the column index is within bounds
			String cellText = cells.get(columnIndex).getText().toString();
			System.out.println("values found : "+cellText);
		
			String actMarketPlaceVal =cellText;
			String expMarketPlaceVal = cu.getCellData("OrderDetails", "Select_Marketplace");
			softAssert.assertEquals(actMarketPlaceVal, expMarketPlaceVal, "Field Data Mismatched");
			Allure.step("Selected Marketplace is verified ");
		}
		
		

	}
	//softAssert.assertAll();
	
	
  }
	public void searchByOrderStatus() throws Exception
	{
		Thread.sleep(1000);
		driver.findElement(orderStatus).click();
		selectOrderStatusFromDropdown();
		 driver.findElement(searchBtn).click();
		 Allure.step("Searched with orderstatus");
		 findOrderStatus();
		
	}
	public void findOrderStatus()
    {

		WebElement table = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/table")); 

		String headerName = "Status"; 

		int columnIndex = -1; // initialize column index to -1

		List<WebElement> headerCells = table.findElements(By.tagName("th")); // get all the header cells

		for (int i = 0; i < headerCells.size(); i++) {

			if (headerName.equals(headerCells.get(i).getText())) {

				columnIndex = i; // update the column index when header name matches
				System.out.println("Number of coloumn : "+columnIndex);
				break; // exit the loop once the header name is found

			}

		}

	List<WebElement> rows = table.findElements(By.tagName("tr")); // get all the rows in the table

	for(WebElement row : rows)
	{
		List<WebElement> cells = row.findElements(By.tagName("td")); // get all the cells in each row
		if (columnIndex < cells.size()) 
		{ 
			// check if the column index is within bounds
			String cellText = cells.get(columnIndex).getText().toString();
			System.out.println("values found : "+cellText);
		
			 String actOrderStatusVal =cellText;
			 String expOrderStatusVal = cu.getCellData("OrderDetails", "Order_Status").toUpperCase();
			 softAssert.assertEquals(actOrderStatusVal, expOrderStatusVal, "Field Data Mismatched");
			 Allure.step("Selected order status is verified ");
		}
		
		

	}
	//softAssert.assertAll();
	
	
  }
	public void findMPOID()
    {

		WebElement table = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/table")); 

		String headerName = "Marketplace Order-ID"; 

		int columnIndex = -1; // initialize column index to -1

		List<WebElement> headerCells = table.findElements(By.tagName("th")); // get all the header cells

		for (int i = 0; i < headerCells.size(); i++) {

			if (headerName.equals(headerCells.get(i).getText())) {

				columnIndex = i; // update the column index when header name matches
				System.out.println("Number of coloumn : "+columnIndex);
				break; // exit the loop once the header name is found

			}

		}

	List<WebElement> rows = table.findElements(By.tagName("tr")); // get all the rows in the table

	for(WebElement row : rows)
	{
		List<WebElement> cells = row.findElements(By.tagName("td")); // get all the cells in each row
		if (columnIndex < cells.size()) 
		{ 
			// check if the column index is within bounds
			String cellText = cells.get(columnIndex).getText().toString();
			System.out.println("values found : "+cellText);
		
			 String actOrderStatusVal =cellText;
			 String expOrderStatusVal = cu.getCellData("OrderDetails", "MarketPlace_Order_ID");
			 softAssert.assertEquals(actOrderStatusVal, expOrderStatusVal, "Field Data Mismatched");
			 Allure.step("Selected market place order id is verified ");
		}
		
		

	}
	//softAssert.assertAll();
	
	
  }
	public void searchByMarketplaceOrderId() throws Exception
	{
		driver.findElement(marketplaceclear).click();
		driver.findElement(orderstatusclear).click();
		Thread.sleep(2000);
		driver.findElement(searchBtn).click();
		Thread.sleep(2000);
		driver.findElement(mpoidsearchbtn).click(); //market place order id -MPOID
		Allure.step("Clicked on search button at market place order id ");
		Thread.sleep(2000);
		driver.findElement(mpoidinput).sendKeys(cu.getCellData("OrderDetails", "MarketPlace_Order_ID"));
		Allure.step("Entered marketplace order id");
		driver.findElement(mpoidsearch).click();
		Allure.step("Search with marketplace order id");
		findMPOID();
		driver.findElement(mpoidsearchbtn).click();
		Thread.sleep(2000);
		driver.findElement(mpoidReset).click();
		Allure.step("Clicked on reset button at marketplace order id");
	}
	public void findCustomer()
    {

		WebElement table = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/table")); 

		String headerName = "Customer"; 

		int columnIndex = -1; // initialize column index to -1

		List<WebElement> headerCells = table.findElements(By.tagName("th")); // get all the header cells

		for (int i = 0; i < headerCells.size(); i++) {

			if (headerName.equals(headerCells.get(i).getText())) {

				columnIndex = i; // update the column index when header name matches
				System.out.println("Number of coloumn : "+columnIndex);
				break; // exit the loop once the header name is found

			}

		}

	List<WebElement> rows = table.findElements(By.tagName("tr")); // get all the rows in the table

	for(WebElement row : rows)
	{
		List<WebElement> cells = row.findElements(By.tagName("td")); // get all the cells in each row
		if (columnIndex < cells.size()) 
		{ 
			// check if the column index is within bounds
			String cellText = cells.get(columnIndex).getText().toString();
			System.out.println("values found : "+cellText);
		
			 String actOrderStatusVal =cellText;
			 String expOrderStatusVal = cu.getCellData("OrderDetails", "Customer_Name");
			 softAssert.assertEquals(actOrderStatusVal, expOrderStatusVal, "Field Data Mismatched");
			 Allure.step("Selected customer name is verified ");
		}

	}
	//softAssert.assertAll();
  }
	public void searchByCustomer() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(searchBtn).click();
		driver.findElement(custsearch).click();
		Thread.sleep(2000);
		driver.findElement(custnminput).sendKeys(cu.getCellData("OrderDetails", "Customer_Name"));
		Allure.step("Entered customer name");
		Thread.sleep(2000);
		
		driver.findElement(custsearchbtn);
		
		List<WebElement> elements = driver.findElements(custsearchbtn);
		int elementsCount = elements.size();
		System.out.println("Count of elemnts :"+elementsCount);
		elements.get(1).click();
		Allure.step("Clicked on search button to filter with customer name");
		findCustomer();
		//click reset button
		driver.findElement(custsearch).click();
		Thread.sleep(1000);
		driver.findElement(custReset).click();
		Allure.step("Clicked on reset button");
	
	}
	public void shipTypeSelect() throws Exception
	{
		
		driver.findElement(shipTypeFil).click();
		Thread.sleep(2000);
		

		List<WebElement> elements = driver.findElements(shipTypeSel);
		int elementsCount = elements.size();
		System.out.println("Count of elemnts :"+elementsCount);
		elements.get(0).click();
		Allure.step("Clicked on search button to filter with customer name");
		
		//driver.findElement(shipTypeSel).click();
		
		Thread.sleep(2000);
		driver.findElement(shipOkBtn).click();
		findShipType();
		
	}
	public void findShipType()
    {

		WebElement table = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/table")); 

		String headerName = "Ship Type"; 

		int columnIndex = -1; // initialize column index to -1

		List<WebElement> headerCells = table.findElements(By.tagName("th")); // get all the header cells

		for (int i = 0; i < headerCells.size(); i++) {

			if (headerName.equals(headerCells.get(i).getText())) {

				columnIndex = i; // update the column index when header name matches
				System.out.println("Number of coloumn : "+columnIndex);
				break; // exit the loop once the header name is found

			}

		}

	List<WebElement> rows = table.findElements(By.tagName("tr")); // get all the rows in the table

	for(WebElement row : rows)
	{
		List<WebElement> cells = row.findElements(By.tagName("td")); // get all the cells in each row
		if (columnIndex < cells.size()) 
		{ 
			// check if the column index is within bounds
			String cellText = cells.get(columnIndex).getText().toString();
			System.out.println("values found : "+cellText);
			 String actOrderStatusVal =cellText;
			 String expOrderStatusVal = cu.getCellData("OrderDetails", "Ship_Type");
			 softAssert.assertEquals(actOrderStatusVal, expOrderStatusVal, "Field Data Mismatched");
			 Allure.step("Selected ship type is verified ");
		}

	}
	softAssert.assertAll();
  }
}	
