package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddProductsPage
{
WebDriver driver;
	
	public AddProductsPage(WebDriver driver)
	{
		this.driver = driver;
		
		
	}
	By products = By.xpath("/html/body/div[2]/ul/li[2]/ul/li[7]/a");
	//By coredata =By.xpath("/html/body/div[2]/ul/li[2]/a");
	//By product = By.xpath("/html/body/div[2]/ul/li[2]/ul/li[7]");
	By addnewproduct = By.xpath("/html/body/div[3]/div[1]/a");
	By prodname = By.id("prod_name");
	By businesstype = By.xpath("/html/body/div[3]/div[1]/form/div[2]/div/fieldset/div[3]/div[2]/div/a/span");
	By prodappearance = By.id("prod_appearance");
	By prodsg = By.id("prod_sg");
	By tanktypedesc = By.xpath("/html/body/div[3]/div[1]/form/div[4]/div/fieldset/div[1]/div[1]/div/div/ul/li[2]");		
	By shipname = By.id("prod_ship_name");
	By secondaryclass = By.xpath("/html/body/div[3]/div[1]/form/div[4]/div/fieldset/div[3]/div[1]/div/div/ul/li[9]");	
	By primaryclass = By.xpath("/html/body/div[3]/div[1]/form/div[4]/div/fieldset/div[2]/div[2]/div/div/ul/li[3]");
	By tertiaryclass = By.xpath("/html/body/div[3]/div[1]/form/div[4]/div/fieldset/div[3]/div[2]/div/div/ul/li[5]");
	By create = By.xpath("/html/body/div[3]/div[1]/form/div[12]/button");
	//By deleteprod = By.xpath("/html/body/div[3]/div[1]/div[6]/table/tbody/tr[1]/td[9]/a[4]");
	
	public void clickcoredata()
	{
		
		//driver.findElement(coredata).click();	
		driver.findElement(products).click();
		driver.findElement(addnewproduct).click();
	}
	public void createproduct()
	{
		driver.findElement(prodname).sendKeys("Test Product 1");
		driver.findElement(businesstype).click();
		driver.findElement(prodappearance).sendKeys("Test Product appearance");
		driver.findElement(prodsg).sendKeys("99.1");
		driver.findElement(tanktypedesc).click();
		driver.findElement(shipname).sendKeys("Test Ship");
		driver.findElement(create).click();
		
	}
	public void deleteproduct()
	{
		//driver.findElement(deleteprod).click();
	}
	public void addproduct()
	{
		this.clickcoredata();
		this.createproduct();
		this.deleteproduct();
	}

}
