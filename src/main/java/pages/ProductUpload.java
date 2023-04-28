package pages;

import java.io.File;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
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
	By closebtn = By.xpath("/html/body/div[7]/div/div[2]/div/div[2]/div/div/div[2]/button");
	
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
		Thread.sleep(6000);
		
		String filename ="Analysis and Strategy.xlsx";
		String pathf = "D:\\dme595\\Downloads\\Analysis and Strategy.xlsx";
		String filepath = pathf + filename;
		Runtime.getRuntime().exec("C://autoitFiles/fileUpload.exe");
		//path.trim().replaceAll("\\u0020", "%20")
		System.out.println(filepath);
		
		//Thread.sleep(4000);
		//driver.findElement(uploadbtn).click();
		//Thread.sleep(2000);
		//driver.findElement(closebtn).click();
	}
	
}
