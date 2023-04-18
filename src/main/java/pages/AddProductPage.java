package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class AddProductPage 
{
	public	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	CommonUtilities	cu = new CommonUtilities();
	public AddProductPage(WebDriver driver)
		    {
		        this.driver = driver;
		        
		    }
	By productmenu = By.cssSelector(".menu:nth-child(2) > #navbarDropdown");
	By prodcatmen = By.name("ProductCatalog");
	By addProdScroll =By.xpath("//button[contains(.,'Add Product')]");
	By addProdBtn = By.xpath("//li[contains(.,'Add Product')]");
	By sku = By.name("sku");
	By prodnm = By.name("title");
	By prodIdentifier1 = By.name("identifier_unit");
	By prodIdValue = By.name("identifier_value");
	By prodDesc = By.name("description");
	By prodQuantity = By.id("qty");
	By prodPrice = By.name("price");
	By prodMsrp = By.name("msrp");
	By prodBrand = By.name("brand_name");
	By prodCountry = By.name("country_id");
	By prodDimensnUnit = By.name("dimension_unit");
	By PDLength = By.name("dimension_length");
	By PDWidth =By.name("dimension_width");
	By PDHeight = By.name("dimension_height");
	By ProdWeightUnit = By.name("weight_unit");
	By ProdWeight = By.name("weight");
	
	By pckgDimensnUnit = By.name("package_unit");
	By PckgDLength = By.name("package_length");
	By PckgWidth =By.name("package_width");
	By PckgHeight = By.name("package_height");
	
	By PckgWeightUnit = By.name("package_weight_type");
	By PckgWeight = By.name("package_weight");
	By prodCategory = By.xpath("//*[@id=\"rc_select_2\"]");
	By prodCategory1 = By.xpath("/html/body/div[6]/div/div/div/div[2]/div[1]/div/div/div[2]");
	
	By prodBulletpoint = By.cssSelector(".bullet-list--input > .w-100");
	By prodImgurl = By.cssSelector(".upload:nth-child(1) input");
	By prodSearchTerms = By.name("searchtearms");
	By prodsave =By.xpath("//a[contains(text(),'Save Changes')]");
	
	
	public void goToProd() throws Exception
	{
		driver.findElement(productmenu).click();
		Allure.step("Clicked on product menu");
		driver.findElement(prodcatmen).click();
		Allure.step("Clicked on product catalog sub menu");
		Thread.sleep(2000);
		driver.findElement(addProdScroll).click();
		Allure.step("Clicked on add product dropdown");
		Thread.sleep(2000);
		driver.findElement(addProdBtn).click();
		Allure.step("Clicked on add product button");
		
		
	}
	public void enterProdDetails()
	{
		String sku1 ="Ecom"+RandomStringUtils.randomAlphanumeric(4);
		driver.findElement(sku).sendKeys(sku1);
		Allure.step("SKU entered is"+sku1);
		cu.writeToExcel("Add_Products", "SKU ", sku1);
		driver.findElement(prodnm).sendKeys(cu.getCellData("Add_Products","Product_Name"));
		Allure.step("Product Name entered is"+cu.getCellData("Add_Products","Product_Name"));
		
		driver.findElement(prodIdentifier1).click();
		String prodidtfr =cu.getCellData("Add_Products", "Product_Identifier");
		driver.findElement(prodIdentifier1).sendKeys(prodidtfr);
		Allure.step("Product identifier is selected from dropdown ");
		
		driver.findElement(prodIdValue).sendKeys(cu.getCellData("Add_Products", "Product_identifier_value"));
		Allure.step("Product identifier value is entered");
		driver.findElement(prodDesc).sendKeys(cu.getCellData("Add_Products", "Product_identifier_Description"));
		Allure.step("Product identifier description is entered");
		driver.findElement(prodQuantity).sendKeys(cu.getCellData("Add_Products", "Product_Quantity"));
		Allure.step("Product quantity is entered");
		
		driver.findElement(prodPrice).sendKeys(cu.getCellData("Add_Products", "Product_Price"));
		Allure.step("Product price is entered");
		driver.findElement(prodMsrp).sendKeys(cu.getCellData("Add_Products", "Product_MSRP"));
		Allure.step("Product MSRP is entered");
		
		driver.findElement(prodBrand).sendKeys(cu.getCellData("Add_Products","Product_Brand"));
		Allure.step("Product Brand is entered");
		
		driver.findElement(prodCountry).click();
		driver.findElement(prodCountry).sendKeys(cu.getCellData("Add_Products","Country"));
		Allure.step("Product country is selected");
		
		driver.findElement(prodDimensnUnit).click();
		driver.findElement(prodDimensnUnit).sendKeys(cu.getCellData("Add_Products", "Dimension_Unit"));
		Allure.step("Product dimension unit is selected");
		
		driver.findElement(PDLength).sendKeys(cu.getCellData("Add_Products", "Product_Dimension_Length"));
		Allure.step("Product dimension length is entered");
		driver.findElement(PDWidth).sendKeys(cu.getCellData("Add_Products", "Product_Dimension_Width"));
		Allure.step("Product dimension width is entered");
		driver.findElement(PDHeight).sendKeys(cu.getCellData("Add_Products", "Product_Dimension_Height"));
		Allure.step("Product dimension height is entered");
		
		driver.findElement(ProdWeightUnit).click();
		driver.findElement(ProdWeightUnit).sendKeys(cu.getCellData("Add_Products", "Product_Weight_Unit"));
		Allure.step("Product weight unit is entered");
		
		driver.findElement(ProdWeight).sendKeys(cu.getCellData("Add_Products", "Product_Weight"));
		Allure.step("Product weight is entered");
		
		//package dimension
		driver.findElement(pckgDimensnUnit).click();
		driver.findElement(pckgDimensnUnit).sendKeys(cu.getCellData("Add_Products", "Package_Dimension_Unit"));
		Allure.step("Package dimension unit is selected");
		
		driver.findElement(PckgDLength).sendKeys(cu.getCellData("Add_Products", "Package_Dimension_Length"));
		Allure.step("Package dimension length is entered");
		driver.findElement(PckgWidth).sendKeys(cu.getCellData("Add_Products", "Package_Dimension_Width"));
		Allure.step("Package dimension width is entered");
		driver.findElement(PckgHeight).sendKeys(cu.getCellData("Add_Products", "Package_Dimension_Height"));
		Allure.step("Package dimension height is entered");
		
		driver.findElement(PckgWeightUnit).click();
		driver.findElement(PckgWeightUnit).sendKeys(cu.getCellData("Add_Products", "Package_Weight_Unit"));
		Allure.step("Package weight unit is entered");
		
		driver.findElement(PckgWeight).sendKeys(cu.getCellData("Add_Products", "Package_Weight"));
		Allure.step("Package weight is entered");
		
		driver.findElement(prodCategory).click();
		driver.findElement(prodCategory1).click();
		Allure.step("Product category is selected");
		
		driver.findElement(prodBulletpoint).click();
		driver.findElement(prodBulletpoint).sendKeys(cu.getCellData("Add_Products", "Bullet_Points"));
		Allure.step("Product bullet point is entered");
		
		driver.findElement(prodImgurl).sendKeys(cu.getCellData("Add_Products", "Image_URL"));
		Allure.step("Product Image URL is entered");
		driver.findElement(prodSearchTerms).sendKeys(cu.getCellData("Add_Products", "Search_Terms"));
		Allure.step("Product search terms are entered");
		
		driver.findElement(prodsave).click();
		Allure.step("Product save button is clicked");
		
		
	}
	
	
}
