package pages;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonUtilities;

public class AddProductsPage extends CommonUtilities 
{
WebDriver driver;
	
	public AddProductsPage(WebDriver driver)
	{
		this.driver = driver;		
	}
	By coredata =By.xpath("/html/body/div[2]/ul/li[2]/a");
	By products = By.xpath("/html/body/div[2]/ul/li[2]/ul/li[7]/a");	
	By addnewproduct = By.xpath("/html/body/div[3]/div[1]/a");
	//Setting random name for product name 
	String productnm="Test Product "+RandomStringUtils.randomAlphabetic(5);
	By prodname = By.id("prod_name");
	//click on dropbox business type
	
	By businesstype = By.xpath("//div[3]/div[2]/div/a/span");
	By businesstp =By.xpath("//div/div/ul/li[2]");
	//click on dropbox product appearance
	By prodappearance = By.id("prod_appearance");
	By prodsg = By.id("prod_sg");
	//click on dropbox tank type
	
	String path= "#prod_tank_type_desc_chosen span";
	By tanktype = By.cssSelector(path);
	By tank= By.xpath("//li[contains(.,\'T4\')]");
	
	
	By shipname = By.id("prod_ship_name");
	//click on dropbox secondary class
	By secondarycls =By.xpath("//div[@id='prod_secondary_class_chosen']/a/span");
	By secondaryclass = By.xpath("//div[@id='prod_secondary_class_chosen']/div/ul/li[7]");	
	//click on dropbox primary class
	By primarycls = By.xpath("//div[4]/div/fieldset/div[2]/div[2]/div/a/span");
	By primarycs =By.xpath("(//input[@type='text'])[28]");
	By primaryclass = By.xpath("//div[@id='prod_primary_class_chosen']/div/ul/li[5]");
	//click on dropbox tertiary class
	By tertiarycls = By.xpath("//div[@id='prod_tertiary_class_chosen']/a/span");
	By tertiaryclass = By.xpath("//div[@id='prod_tertiary_class_chosen']/div/ul/li[6]");
	//create product
	By create = By.xpath("/html/body/div[3]/div[1]/form/div[12]/button");
	//filter product by name
	By prodNameFilter =By.id("prod-name-filter");
	By prodFilter = By.xpath("//button[@type='submit']");
	//delete added product
	By deletebtn =By.xpath("/html/body/div[3]/div[1]/div[6]/table/tbody/tr[1]/td[9]/a[4]");
	By deleteconfirm = By.xpath("//button[contains(.,'OK')]");
	
	CommonUtilities objCU = new CommonUtilities();
	
	public void clickcoredata()
	{
		
		driver.findElement(coredata).click();	
		driver.findElement(products).click();
		driver.findElement(addnewproduct).click();
	}

	public void tankType(String tnktp, By tankn) throws Exception
	{
          dropdownmethod(driver,path);
		
		driver.findElement(tanktype).click();;
		Thread.sleep(4000);
		
		//String jbn="//li[contains(.,\'"+tnktp+"\')]";
		//By tankn= By.xpath(jbn);
		
	    driver.findElement(tankn).click();
	  
	}
	public void prodsg(String sg)
	{
		driver.findElement(prodsg).sendKeys(sg);	
	}
	public void primarykey(String pk) throws Exception
	{
		//click dropdown using sendkeys and enter button
		driver.findElement(primarycls).click();
		Thread.sleep(4000);
//		By primarycs =By.xpath("(//input[@type='text'])[28]");
//		WebElement w= driver.findElement(primarycs);
//		Thread.sleep(4000);
//		w.sendKeys(pk);
//		Thread.sleep(4000);
//		w.sendKeys(Keys.ENTER);	
	}
	public void prodAppearance(String pa)
	{
		driver.findElement(prodappearance).sendKeys(pa);
	}
	public void testShipNm(String snm)
	{
		driver.findElement(shipname).sendKeys(snm);
	}
	
	public void createproduct() throws Exception
	{     	
		objCU.dropDownClick(driver, tanktype, objCU.getCellData("Products","Tank Type Desc"));
		objCU.dropDownClick(driver, secondarycls, "8:Corrosive");
		objCU.dropDownEnter(driver, primarycls, objCU.getCellData("Products","Primary Class"),primarycs);
		//objCU.dropDownClick(driver, tertiarycls, "5.1:Oxidizing agent");
		driver.findElement(prodname).sendKeys(productnm);	
		driver.findElement(businesstype).click();
	    Thread.sleep(4000);
	    driver.findElement(businesstp).click();
		
		//driver.findElement(prodappearance).sendKeys("Test Product appearance");
		//driver.findElement(prodsg).sendKeys("99.1");
		
		//this.tankType("T4");
		//method to select/get/show dropdown values		
		//By tank= By.xpath("//li[contains(.,\'T4\')]");
					
		dropdownmethod(driver,path);
		//driver.findElement(secondarycls).click();
		Thread.sleep(4000);
		//driver.findElement(secondaryclass).click();
		driver.findElement(tertiarycls).click();
		Thread.sleep(4000);
		driver.findElement(tertiaryclass).click();
		//driver.findElement(shipname).sendKeys("Test Ship");
				
	}
	public void clickcreateprod() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(create).click();	
	}
	public void addproducts(String sg,String s,String tnktp, String pk,String pa,String snm) throws Exception
	{
		this.clickcoredata();
		this.prodsg(sg);
		Thread.sleep(5000);
		//this.tankType(tnktp);
		//this.primarykey(pk);
		this.prodAppearance(pa);
        this.testShipNm(snm);		
		this.createproduct();
		this.clickcreateprod();
		Thread.sleep(5000);
		this.filter();
		this.deleteproduct();
	}
	public void filter() throws Exception 
	{
		driver.findElement(prodNameFilter).sendKeys(productnm);
		driver.findElement(prodFilter).click();
		Thread.sleep(2000);
	}
	public void deleteproduct() throws Exception
	{
		driver.findElement(deletebtn).click();
		Thread.sleep(4000);
		driver.findElement(deleteconfirm).click();
	}
}
