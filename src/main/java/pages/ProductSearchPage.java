package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class ProductSearchPage 
{
	public	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	CommonUtilities	cu = new CommonUtilities();
	public ProductSearchPage(WebDriver driver)
		    {
		        this.driver = driver;
		        
		    }
	By productmenu = By.cssSelector(".menu:nth-child(2) > #navbarDropdown");
	By prodcatmen = By.name("ProductCatalog");
	By prodsku = By.xpath("(//input[@value=''])[2]");
	By searchbtn = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div/div/div[4]/div/a[1]");
	By refreshbtn = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div/div/div[4]/div/button");
	By prodCategory =By.cssSelector(".col-12:nth-child(2) > .p-1 > .w-100");
	By prodSelect = By.cssSelector(".text-left > a");
	//By prodFindCat = By.cssSelector(".col-12 > .m-0:nth-child(1)");
	//By prodFindCat = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[3]/div[2]/p[1]");
	
	By prodFindCat = By.cssSelector(".col-12:nth-child(3) .w-100");
	By cancelbtn = By.name("cancel");
	By prodStock = By.xpath("//select[@name='stock']");
	By ProdStatus = By.xpath("//select[@name='Country']");
	By Prodfilter = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[1]/div/div[3]/a");
	

	
	public void gotoProductSearch() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(productmenu).click();
		Allure.step("Clicked on product menu");
		driver.findElement(prodcatmen).click();
		Allure.step("Clicked on product catalog sub menu");
	}
	public void productSearchBySku()
	{
		driver.findElement(prodsku).sendKeys(cu.getCellData("Add_Products", "SKU"));
		Allure.step("Product SKU is entered");
		driver.findElement(searchbtn).click();
		Allure.step("Clicked on search Button");
	}
	public void verifyProdSearchBySku()
	{
		WebElement table = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div/table")); 

		String headerName = "SKU"; 

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
			String expMarketPlaceVal = cu.getCellData("Add_Products", "SKU");
			softAssert.assertEquals(actMarketPlaceVal, expMarketPlaceVal, "Field Data Mismatched");
			Allure.step("Product search is verified");
		}
		
	}
	softAssert.assertAll();
	}
	public void prodSearchByCategory() throws Exception
	{
		driver.findElement(refreshbtn).click();
		Allure.step("Refresh button is clicked");
		//cu.dropDownEnter(driver,prodCategory , "Air Ionizers", prodCategory);
		//cu.slowType(driver, prodCategory, "Air Ionizers");
		driver.findElement(prodCategory).click();
		driver.findElement(prodCategory).sendKeys("Air Ionizers");
		driver.findElement(prodCategory).sendKeys(Keys.ENTER);
		Allure.step("Product category is selected");
		driver.findElement(searchbtn).click();
		Allure.step("Clicked on search Button");
	}
	public void verifyProdSearchByCategory()
	{
		
		WebElement table = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div/table")); 

		String headerName = "SKU"; 

		int columnIndex = -1; // initialize column index to -1

		List<WebElement> headerCells = table.findElements(By.tagName("th")); // get all the header cells

		for (int i = 0; i < headerCells.size(); i++) {

			if (headerName.equals(headerCells.get(i).getText())) {

				columnIndex = i; // update the column index when header name matches
				System.out.println("Number of coloumn : "+columnIndex);
				break; // exit the loop once the header name is found

			}

		}
		for(int j=1;j<=columnIndex;j++)
		{
			driver.findElement(prodSelect).click();
		}
		
		//driver.findElement(prodSelect).click();
		String actText = driver.findElement(prodFindCat).getText();
		String exptText = "Category : Air Ionizers";
		softAssert.assertEquals(actText, exptText, "Field Data Mismatched");
		Allure.step("Verified product category ");
		
		driver.findElement(cancelbtn).click();
		Allure.step("Clicked on cancel button");
		//softAssert.assertAll();
	}
	public void prodSearchByStock() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(prodStock).click();
		driver.findElement(prodStock).sendKeys("High to Low");
		driver.findElement(prodStock).sendKeys(Keys.ENTER);
		Allure.step("Product stock is selected");
		driver.findElement(searchbtn).click();
		Allure.step("Clicked on search Button");
//		driver.findElement(refreshbtn).click();
//		Allure.step("Refresh button is clicked");
	}
	public void searchByStatus()
	{
		driver.findElement(ProdStatus).click();
		driver.findElement(ProdStatus).sendKeys("Active");
		driver.findElement(ProdStatus).sendKeys(Keys.ENTER);
		Allure.step("Product Status is selected");
		driver.findElement(Prodfilter).click();
		Allure.step("Clicked on filter Button");
	}
}
