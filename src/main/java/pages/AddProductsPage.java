package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductsPage
{
WebDriver driver;
	
	public AddProductsPage(WebDriver driver)
	{
		this.driver = driver;		
	}
 
	By coredata =By.xpath("/html/body/div[2]/ul/li[2]/a");
	By products = By.xpath("/html/body/div[2]/ul/li[2]/ul/li[7]/a");	
	By addnewproduct = By.xpath("/html/body/div[3]/div[1]/a");
	By prodname = By.id("prod_name");
	
	By businesstype = By.xpath("//div[3]/div[2]/div/a/span");
	By businesstp =By.xpath("//div/div/ul/li[2]");
	
	By prodappearance = By.id("prod_appearance");
	By prodsg = By.id("prod_sg");
	
	By tanktype = By.cssSelector("#prod_tank_type_desc_chosen span");
	By tank= By.xpath("//li[contains(.,\'T4\')]");
	
	By shipname = By.id("prod_ship_name");
	
	By secondarycls =By.xpath("//div[@id='prod_secondary_class_chosen']/a/span");
	By secondaryclass = By.xpath("//div[@id='prod_secondary_class_chosen']/div/ul/li[7]");	
	
	By primarycls = By.xpath("//div[4]/div/fieldset/div[2]/div[2]/div/a/span");
	By primaryclass = By.xpath("//div[@id='prod_primary_class_chosen']/div/ul/li[5]");
	
	By tertiarycls = By.xpath("//div[@id='prod_tertiary_class_chosen']/a/span");
	By tertiaryclass = By.xpath("//div[@id='prod_tertiary_class_chosen']/div/ul/li[6]");
	
	
	By create = By.xpath("/html/body/div[3]/div[1]/form/div[12]/button");
	
	public void clickcoredata()
	{
		
		driver.findElement(coredata).click();	
		driver.findElement(products).click();
		driver.findElement(addnewproduct).click();
	}
	public void createproduct() throws Exception
	{
		driver.findElement(prodname).sendKeys("Test Product 1");
		driver.findElement(businesstype).click();
		Thread.sleep(4000);
		driver.findElement(businesstp).click();
		driver.findElement(prodappearance).sendKeys("Test Product appearance");
		driver.findElement(prodsg).sendKeys("99.1");
		
		Thread.sleep(4000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#prod_tank_type_desc_chosen span")));
		WebElement element = driver.findElement(By.cssSelector("#prod_tank_type_desc_chosen span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		
		driver.findElement(tanktype).click();;
		Thread.sleep(4000);
		driver.findElement(tank).click();	
		driver.findElement(primarycls).click();
		Thread.sleep(4000);
		driver.findElement(primaryclass).click();
		Thread.sleep(4000);
		
		driver.findElement(secondarycls).click();;
		driver.findElement(secondaryclass).click();;
	
		driver.findElement(tertiarycls).click();
		Thread.sleep(4000);
		driver.findElement(tertiaryclass).click();
		driver.findElement(shipname).sendKeys("Test Ship");
		
		Thread.sleep(5000);
		driver.findElement(create).click();		
	}
	public void deleteproduct()
	{
		//driver.findElement(deleteprod).click();
	}
	public void addproduct() throws Exception
	{
		this.clickcoredata();
		this.createproduct();
		this.deleteproduct();
	}
}
