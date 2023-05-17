package pages;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
			    
			    By custRangeBtn = By.xpath("//*[@id=\"range_picker\"]");
			    By startingRage = By.cssSelector("#range_picker");
			    By previousMonth = By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[1]/div/div[1]/button[2]");
			    By startingDate = By.cssSelector(".ant-picker-panel:nth-child(1) tr:nth-child(3) > .ant-picker-cell:nth-child(2) > .ant-picker-cell-inner");
			    By endRange = By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[2]/div/div[2]/table/tbody/tr[2]/td[4]");
			    By previousYear = By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[1]/div/div[1]/button[1]");
			    By nextYear = By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div[2]/div/div[1]/button[4]");
			    By month = By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[1]/div/div[1]/div/button[1]");
			    
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
			    
			    public void marketPlaceSalesRepoFilterByCustomRange() throws Exception
			    {
			    	Thread.sleep(3000);
			    	driver.findElement(reportsNavSel).click();
			    	Allure.step("Clicked on reports menu");
			    	driver.findElement(marketPlaceSalesRepo).click();
			    	Allure.step("Clicked on market place sales report submenu");
			    	
			    	this.filterByDate("Custom Range");
			    	String startDate=cu.getCellData("CustomDate", "StartDate");
			    	String endDate =cu.getCellData("CustomDate", "EndDate");
			    	this.myEcomDateSelection(driver, startDate,  endDate);
			    	Allure.step("From date and to date is selected");
			    	
			    	Thread.sleep(2000);
			    	driver.findElement(searchBtn).click();
			    	Allure.step("Search button is clicked");
			    	
			    	
			    }
			    public void selectDateFromDropdown2() throws Exception
				{
				By monthsel = By.cssSelector("div[title='"+cu.getCellData("Reports", "FilterByDateCustom")+"']");
				Thread.sleep(3000);
				driver.findElement(monthsel).click();
				Allure.step("Filter by date is selected from dropdown");
				}

			    public void filterByDate(String dateRange) throws InterruptedException
			    {
		    		  driver.findElement(By.cssSelector(".ant-select-selection-item")).click();
		    		  Thread.sleep(1000);
		    		  cu.findElementByClassNameAndText("ant-select-item-option-content", dateRange, driver);
			    }
			   //to select custom date from calander  
			    public void myEcomDateSelection(WebDriver driver, String inputDate, String toDate) throws InterruptedException {
					
			    	//	String inputDate = "2021-09-14";

			            // Parse the input date string into a LocalDate object
			            LocalDate date = LocalDate.parse(inputDate);

			            // Format the LocalDate object to the desired output format
			            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy MMM");
			            String outputDate = date.format(outputFormatter);

			            // Extract year, month, and day from the LocalDate object
			            String year = String.valueOf(date.getYear());
			            String month = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
			            String day = String.valueOf(date.getDayOfMonth());
			     
			            LocalDate todate = LocalDate.parse(toDate);

			            // Format the LocalDate object to the desired output format
			            DateTimeFormatter outputFormattert = DateTimeFormatter.ofPattern("yyyy MMM");
			            String outputDatet = todate.format(outputFormattert);

			            // Extract year, month, and day from the LocalDate object
			            String toYear = String.valueOf(todate.getYear());
			            String toMonth = todate.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
			            String toDay = String.valueOf(todate.getDayOfMonth());
			         // Get the current year and month
			            YearMonth currentYearMonth = YearMonth.now();

			            // Extract the current year and month as separate strings
			            String currentYear = String.valueOf(currentYearMonth.getYear());
			            String currentMonth = String.valueOf(currentYearMonth.getMonthValue());
			            currentMonth = currentYearMonth.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
			            

			            
			    		CommonUtilities cu = new CommonUtilities();

			    	
			    		  driver.findElement(By.id("range_picker")).click();
			    		  Thread.sleep(1000);
			    		  cu.findElementByClassNameAndText("ant-picker-year-btn", currentYear, driver);
			    		  Thread.sleep(1000);
			    		  cu.findElementByClassNameAndText("ant-picker-cell-inner",year, driver);
			    		  Thread.sleep(1000);
			    		  
			    		  System.out.println(currentMonth);
			    		  cu.findElementByClassNameAndText("ant-picker-month-btn", currentMonth, driver);
			    		  Thread.sleep(1000);
			    		  cu.findElementByClassNameAndText("ant-picker-cell-inner",month, driver);
			    		  Thread.sleep(1000);
			    		  
			    		  cu.findElementByClassNameAndText("ant-picker-cell-inner", day, driver);
			    		  
			    		  Thread.sleep(1000);
			    		  
			    		  cu.findElementByClassNameAndText("ant-picker-year-btn", year, driver);
			    		  Thread.sleep(1000);
			    		  cu.findElementByClassNameAndText("ant-picker-cell-inner",toYear, driver);
			    		  Thread.sleep(1000);
			    		  cu.findElementByClassNameAndText("ant-picker-month-btn", month, driver);
			    		  Thread.sleep(1000);
			    		  cu.findElementByClassNameAndText("ant-picker-cell-inner",toMonth, driver);
			    		  Thread.sleep(1000);
			    		  
			    		  cu.findElementByClassNameAndText("ant-picker-cell-inner", toDay, driver);
			    		  
			    	}
			    	
			    	
			    public void CategorySalesRepoFilterByCustomRange() throws Exception
			    {
			    	Thread.sleep(3000);
			    	driver.findElement(reportsNavSel).click();
			    	Allure.step("Clicked on reports menu");
			    	driver.findElement(categorySalesRepo).click();
			    	Allure.step("Clicked on market place sales report submenu");
			    	
			    	this.filterByDate("Custom Range");
			    	String startDate=cu.getCellData("CustomDate", "StartDate");
			    	String endDate =cu.getCellData("CustomDate", "EndDate");
			    	this.myEcomDateSelection(driver, startDate,  endDate);
			    	Allure.step("From date and to date is selected");
			    	
			    	Thread.sleep(2000);
			    	driver.findElement(searchBtn).click();
			    	Allure.step("Search button is clicked");
			    	
			    	
			    }
			    public void TopSellingProductsFilterByCustomRange() throws Exception
			    {
			    	Thread.sleep(3000);
			    	driver.findElement(reportsNavSel).click();
			    	Allure.step("Clicked on reports menu");
			    	driver.findElement(topsellingprod).click();
			    	Allure.step("Clicked on market place sales report submenu");
			    	
			    	this.filterByDate("Custom Range");
			    	//String startDate =cu.getCellData("CustomDate", "StartDate");
			    	String startDate=cu.getCellData("CustomDate", "StartDate");
			    	String endDate =cu.getCellData("CustomDate", "EndDate");
			    	this.myEcomDateSelection(driver, startDate,  endDate);
			    	Allure.step("From date and to date is selected");
			    	
			    	Thread.sleep(2000);
			    	driver.findElement(searchBtn).click();
			    	Allure.step("Search button is clicked");
			    	
			    }
			 
}
