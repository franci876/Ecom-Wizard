package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class ReportsPage 
{
	
	SoftAssert softAssert = new SoftAssert();
	CommonUtilities	cu = new CommonUtilities();
		public	WebDriver driver;
			    public ReportsPage(WebDriver driver)
			    {
			        this.driver = driver;
			    }
			   // By reportsNavSel =By.cssSelector(".nav-item:nth-child(5) > #navbarDropdown");
			    By reportsNavSel =By.xpath("//a[contains(text(),'Reports')]");
			    By marketPlaceSalesRepo = By.name("MarketplaceSalesReport");
			    By selFilter = By.xpath("//div/span[2]");
			    By selMarketPlace = By.cssSelector(".ant-select-selection-overflow");
			    By searchBtn = By.cssSelector(".anticon-search > svg");
			    By marketPlace = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/table/tbody/tr/td[1]");
			    
			    By categorySalesRepo = By.name("CategorySalesReport");
			    By selCategory = By.cssSelector(".ant-select-selection-overflow");
			    By category = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/table/tbody/tr/td[1]");
			    
			    By topsellingprod = By.name("TopSellingProducts");
			    By searchProd = By.name("searchBy");
			    By prodNm = By.cssSelector("");
			    
			    
			    
			    public void marketPlaceSalesReport() throws Exception
			    {
			    	Thread.sleep(3000);
			    	driver.findElement(reportsNavSel).click();
			    	Allure.step("Clicked on reports menu");
			    	driver.findElement(marketPlaceSalesRepo).click();
			    	Allure.step("Clicked on market place sales report submenu");
			    	//filter by date 
			    	driver.findElement(selFilter).click();
			    	selectDateFromDropdown();
			    	Allure.step("Date is selected");
			    	driver.findElement(selMarketPlace).click();
			    	selectMarketPlace();
			    	Allure.step("Marketplace is selected");
			    	driver.findElement(searchBtn).click();
			    	Allure.step("Search button is clicked");
			    	
			    	
			    }
			    public void selectDateFromDropdown() throws Exception
				{
				By monthsel = By.cssSelector("div[title='"+cu.getCellData("Reports", "FilterByDate")+"']");
				Thread.sleep(3000);
				driver.findElement(monthsel).click();
				Allure.step("Month is selected from dropdown");
				}
			    public void selectMarketPlace() throws Exception
				{
				By marketplaceselect = By.cssSelector("div[title='"+cu.getCellData("Reports", "MarketPlaces")+"']");
				Thread.sleep(3000);
				driver.findElement(marketplaceselect).click();
				Allure.step("marketplace is selected");
				}
			    public void verifyMarketplace() throws Exception
			    {
			    	Thread.sleep(3000);
			    	String ActMarketPlace = driver.findElement(marketPlace).getText();
			    	String ExpMarketPlace = cu.getCellData("Reports", "MarketPlaces");
			    	softAssert.assertEquals(ActMarketPlace, ExpMarketPlace, "Field Data Mismatched");
			    	Allure.step("Verified marketplace");
			    	softAssert.assertAll();
			    }
			    public void categorySales() throws Exception
			    {
			    	Thread.sleep(2000);
			    	driver.findElement(reportsNavSel).click();
			    	Allure.step("Clicked on reports menu");
			    	driver.findElement(categorySalesRepo).click();
			    	Allure.step("Clicked on category sales report submenu");
			    	driver.findElement(selFilter).click();
			    	selectDateFromDropdown();
			    	Allure.step("Date is selected");
			    	driver.findElement(selCategory).click();
			    	selectCategories();
			    	Allure.step("Category is selected");
			    	driver.findElement(searchBtn).click();
			    	Allure.step("Search button is clicked");
			    }
			    public void selectCategories() throws Exception
				{
				By categorysel = By.cssSelector("div[title='"+cu.getCellData("Reports", "Categories")+"']");
				Thread.sleep(3000);
				driver.findElement(categorysel).click();
				Allure.step("Category is selected");
				}
			    
			    
			    public void verifyCategory()
			    {
			    	WebElement table = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/table"));
		    		String headerName = "Category"; 

		    		int columnIndex = -1; // initialize column index to -1

		    		List<WebElement> headerCells = table.findElements(By.tagName("th")); // get all the header cells

		    		for (int i = 0; i < headerCells.size(); i++) {

		    			if (headerName.equals(headerCells.get(i).getText())) {

		    				columnIndex = i; // update the column index when header name matches
		    				//System.out.println("Number of coloumn : "+columnIndex);
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
		    			String expMarketPlaceVal = cu.getCellData("Reports", "Categories");
		    			softAssert.assertEquals(actMarketPlaceVal, expMarketPlaceVal, "Field Data Mismatched");
		    			Allure.step("Category is verified");
		    		}
		    		
		    	}
		    	softAssert.assertAll();
		    	
		    }
			    
			    
			    
			    public void topSellingProducts() throws Exception
			    {
			    	
			    	Thread.sleep(2000);
			    	driver.findElement(reportsNavSel).click();
			    	Allure.step("Clicked on reports menu");
			    	driver.findElement(topsellingprod).click();
			    	Allure.step("Clicked on top selling products report submenu");
			    	driver.findElement(selFilter).click();
			    	selectDateFromDropdown();
			    	Allure.step("Date is selected");
			    	driver.findElement(searchProd).sendKeys(cu.getCellData("Reports", "ProductName"));;
			    	Allure.step("Product name is entered");
			    	driver.findElement(searchBtn).click();
			    	Allure.step("Search button is clicked");
			    	
			    }

			    
			    public void verifyProduct()
			    {
			    	
			    		WebElement table = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[3]/div/div/div/div/div/div/div/div/div/div/table")); 

			    		String headerName = "Product"; 

			    		int columnIndex = -1; // initialize column index to -1

			    		List<WebElement> headerCells = table.findElements(By.tagName("th")); // get all the header cells

			    		for (int i = 0; i < headerCells.size(); i++) {

			    			if (headerName.equals(headerCells.get(i).getText())) {

			    				columnIndex = i; // update the column index when header name matches
			    				//System.out.println("Number of coloumn : "+columnIndex);
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
			    			String expMarketPlaceVal = cu.getCellData("Reports", "ProductName");
			    			softAssert.assertEquals(actMarketPlaceVal, expMarketPlaceVal, "Field Data Mismatched");
			    			Allure.step("Product is verified");
			    		}
			    		
			    	}
			    	softAssert.assertAll();
			    	
			    }
			  

}
