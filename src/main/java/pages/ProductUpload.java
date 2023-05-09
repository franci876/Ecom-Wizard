package pages;

import java.io.File;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;



import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class ProductUpload 
{
	public	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	CommonUtilities	cu = new CommonUtilities();
	public ProductUpload(WebDriver driver)
		    {
		        this.driver = driver;
		        
		    }
	By productmenu = By.cssSelector(".menu:nth-child(2) > #navbarDropdown");
	By prodImportOrExport = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[2]");
	By prodCategoryL1 = By.cssSelector(".list-item:nth-child(6) > a");
	By prodCategoryL2 = By.cssSelector(".multi-level-list-inline-box:nth-child(2) .list-item:nth-child(1) > a");
	By prodCategorySelectBtn = By.cssSelector(".multi-level-list-select-btn");
	
	By uploadfilebtn1 = By.id("rc-tabs-0-tab-2");
	By browseFile = By.cssSelector(".sc-gKPRtg");
	By uploadbtn = By.xpath("//*[@id=\"rc-tabs-0-panel-2\"]/div/div/div/div[2]/div/div[1]/button");
	By closebtn = By.cssSelector(".ant-btn-primary > span");
	By fileUploadVerifyMsg = By.cssSelector(".ant-modal-confirm-body");
	By feedIdCell =By.cssSelector(".ant-table-cell-row-hover:nth-child(1)");
		
	By status = By.cssSelector("#rc-tabs-0-tab-3");
	
	public void goToProductPage()
	{
		driver.findElement(productmenu).click();
		Allure.step("Clicked on product menu");
		driver.findElement(prodImportOrExport).click();
		Allure.step("Clicked on product import or export submenu");
		
		
	}

	public void fileDownload() throws Exception
	{
		String filenm ="D:\\dme595\\Downloads\\Analysis and Strategy.xlsx";
		File fileobj =new File(filenm);
		if(fileobj.exists())
		{
			fileobj.delete();
			System.out.println("File Deleted");
			Allure.step("Existing files are deleted");
		}
       
		Thread.sleep(2000);
		driver.findElement(prodCategoryL1).click();
		Allure.step("Clicked on product category");
		Thread.sleep(3000);
		driver.findElement(prodCategoryL2).click();
		Allure.step("Clicked on product sub category");
		Thread.sleep(2000);
		driver.findElement(prodCategorySelectBtn).click();
		Allure.step("Clicked on select  button to get excel file");
	}
	public void fileupload() throws Exception
	{
		driver.findElement(uploadfilebtn1).click();
		driver.findElement(browseFile).click();
		Allure.step("Clicked on browse file button");
		Thread.sleep(6000);
		
//		String filename ="Analysis and Strategy.xlsx";
//		String pathf = "D:\\dme595\\Downloads\\Analysis and Strategy.xlsx";
//		String filepath = pathf + filename;
		Runtime.getRuntime().exec("C://autoitFiles/fileUpload.exe");
		//path.trim().replaceAll("\\u0020", "%20")
//		System.out.println(filepath);
		
		Thread.sleep(3000);
		driver.findElement(uploadbtn).click();
		Allure.step("File is uploaded");
		Thread.sleep(3000);
		
		String actText = driver.findElement(fileUploadVerifyMsg).getText();
		String exptText = "Feed file uploaded successfully\nYou can check the status of the feed in the Upload Status page";
		softAssert.assertEquals(actText, exptText, "Field Data Mismatched");
		
		driver.findElement(closebtn).click();
	}
	public void filestatusCheck() throws Exception
	{
		Thread.sleep(4000);
		driver.findElement(status).click();
		
		
		
		WebElement table = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[3]/div/div/div/div/div/div/div/div/div/table"));
		String headerName = "Feed-ID"; 

		int columnIndex = -1; 

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
		
			String actMarketPlaceVal =cellText;
			String expMarketPlaceVal = "176";//cu.getCellData("FileUpload", "Feed_ID");
			softAssert.assertEquals(actMarketPlaceVal, expMarketPlaceVal, "Field Data Mismatched");
			Allure.step("Selected Marketplace is verified ");
			break;
	}
		
		

	}
	softAssert.assertAll();
	
	}
}
