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
	By prodDesc = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div[5]/div/textarea");
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
//	By prodCategory = By.cssSelector(".ant-select-selector");
	By prodCategory = By.cssSelector(".ant-select-selection-search-input");
	By prodCategory1 = By.cssSelector(".ant-select-item-option-content");
//	By prodCat2 = By.cssSelector(".ant-select-selection-search");
//	By prodCat = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div/div/span[2]");
	
	By prodBulletpoint = By.cssSelector(".bullet-list--input > .w-100");
	By prodImgurl = By.cssSelector(".upload:nth-child(1) input");
	By prodSearchTerms = By.name("searchtearms");
	By prodsave =By.xpath("//a[contains(text(),'Save Changes')]");
	
	//filter
	By searchbar = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div/div/div[1]/div/input");
	By searchBtn = By.xpath("//a[contains(text(),'Search')]");
	By searchclk = By.cssSelector(".text-left > a");
	
	
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
		
		String prodIdfrValue ="ProdId"+RandomStringUtils.randomAlphanumeric(4);
		cu.writeToExcels("Add_Products", "Product_Identifier_Value", prodIdfrValue);
		driver.findElement(prodIdValue).sendKeys(prodIdfrValue);
		Allure.step("Product identifier value is entered");
		driver.findElement(prodDesc).sendKeys(cu.getCellData("Add_Products", "Product_identifier_Description"));
		Allure.step("Product description is entered");
		
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
		
	}
	public void enterProdDimensions()
	{
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
	
	}
	public void enterPckgDimensions() throws Exception
	{

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
	}

	public void prodOtherDetails () throws Exception
	{
		
		driver.findElement(prodCategory).click();
		cu.slowType(driver, prodCategory, "deodorant");
		//driver.findElement(prodCategory).sendKeys("deodorant");
		driver.findElement(prodCategory1).click();
		Allure.step("Product category is selected");
		
		driver.findElement(prodBulletpoint).click();
		driver.findElement(prodBulletpoint).sendKeys(cu.getCellData("Add_Products", "Bullet_Points"));
		Allure.step("Product bullet point is entered");
		
		driver.findElement(prodImgurl).sendKeys(cu.getCellData("Add_Products", "Image_URL"));
		Allure.step("Product Image URL is entered");
		
		driver.findElement(prodSearchTerms).sendKeys(cu.getCellData("Add_Products", "Search_Terms"));
		driver.findElement(prodSearchTerms).sendKeys(Keys.ENTER);
		Allure.step("Product search terms are entered");
		Thread.sleep(2500);
		driver.findElement(prodsave).click();
		Allure.step("Product save button is clicked");
		
	}
	
	public void filterProducts()
	{
		driver.findElement(searchbar).sendKeys(cu.getCellData("Add_Products","SKU"));
		driver.findElement(searchBtn).click();
		
		
	}
	
	public void verifyProdDetails()
	{	
		 driver.findElement(searchclk).click();
		 
		 String ActSku =driver.findElement(sku).getAttribute("value");
		 String ExpSku = cu.getCellData("Add_Products","SKU");
		 softAssert.assertEquals(ActSku, ExpSku, "Field Data Mismatched");
		 Allure.step("Verified Product SKU");
		 
		 String ActProdName =driver.findElement(prodnm).getAttribute("value");
		 String ExpProdName = cu.getCellData("Add_Products","Product_Name");
		 softAssert.assertEquals(ActProdName, ExpProdName, "Field Data Mismatched");
		 Allure.step("Verified Product Name");
		 
		 String ActProdIdnt =driver.findElement(prodIdentifier1).getAttribute("value");
		 String ExpProdIdnt = cu.getCellData("Add_Products","Product_Identifier");
		 softAssert.assertEquals(ActProdIdnt, ExpProdIdnt, "Field Data Mismatched");
		 Allure.step("Verified Product Identifier");
		 
		 String ActProdIdntVal =driver.findElement(prodIdValue).getAttribute("value");
		 String ExpProdIdntVal = cu.getCellData("Add_Products","Product_Identifier_Value");
		 softAssert.assertEquals(ActProdIdntVal, ExpProdIdntVal, "Field Data Mismatched");
		 Allure.step("Verified Product Identifier Value");
		 
		 String ActProdDesc =driver.findElement(prodDesc).getAttribute("value");
		 String ExpProdDesc = cu.getCellData("Add_Products","Product_identifier_Description");
		 softAssert.assertEquals(ActProdDesc, ExpProdDesc, "Field Data Mismatched");
		 Allure.step("Verified Product Description");
		 
		 String ActProdQty =driver.findElement(prodQuantity).getAttribute("value");
		 String ExpProdQty = cu.getCellData("Add_Products","Product_Quantity");
		 softAssert.assertEquals(ActProdQty, ExpProdQty, "Field Data Mismatched");
		 Allure.step("Verified Product Quantity");
		 
		 
		 String ActPrice =driver.findElement(prodPrice).getAttribute("value");
		 String ExpPrice = cu.getCellData("Add_Products","Product_Price");
		 softAssert.assertEquals(ActPrice, ExpPrice, "Field Data Mismatched");
		 Allure.step("Verified Product Price");
		 
		 String ActMsrp =driver.findElement(prodMsrp).getAttribute("value");
		 String ExpMsrp = cu.getCellData("Add_Products","Product_MSRP");
		 softAssert.assertEquals(ActMsrp, ExpMsrp, "Field Data Mismatched");
		 Allure.step("Verified Product MSRP");
		 
		 String ActBrand =driver.findElement(prodBrand).getAttribute("value");
		 String ExpBrand = cu.getCellData("Add_Products","Product_Brand");
		 softAssert.assertEquals(ActBrand, ExpBrand, "Field Data Mismatched");
		 Allure.step("Verified Product Brand");
		 
		 String ActProdDmUnit =driver.findElement(prodDimensnUnit).getAttribute("value");
		 String ExpProdDmUnit = cu.getCellData("Add_Products","Dimension_Unit");
		 softAssert.assertEquals(ActProdDmUnit, ExpProdDmUnit, "Field Data Mismatched");
		 Allure.step("Verified Product Dimensions Unit");
		 
		 String ActProdLength =driver.findElement(PDLength).getAttribute("value");
		 String ExpProdLength = cu.getCellData("Add_Products","Product_Dimension_Length");
		 softAssert.assertEquals(ActProdLength, ExpProdLength, "Field Data Mismatched");
		 Allure.step("Verified Product Length");
		 
		 String ActProdWidth =driver.findElement(PDWidth).getAttribute("value");
		 String ExpProdWidth = cu.getCellData("Add_Products","Product_Dimension_Width");
		 softAssert.assertEquals(ActProdWidth, ExpProdWidth, "Field Data Mismatched");
		 Allure.step("Verified Product Width");
		 
		 String ActProdHeight =driver.findElement(PDHeight).getAttribute("value");
		 String ExpProdHeight = cu.getCellData("Add_Products","Product_Dimension_Height");
		 softAssert.assertEquals(ActProdHeight, ExpProdHeight, "Field Data Mismatched");
		 Allure.step("Verified Product Height");
		 
		 String ActProdWeightUnit =driver.findElement(ProdWeightUnit).getAttribute("value");
		 String ExpProdWeightUnit= cu.getCellData("Add_Products","Product_Weight_Unit");
		 softAssert.assertEquals(ActProdWeightUnit, ExpProdWeightUnit, "Field Data Mismatched");
		 Allure.step("Verified Product Weight Unit");
		 
		 String ActProdWeight =driver.findElement(ProdWeight).getAttribute("value");
		 String ExpProdWeight= cu.getCellData("Add_Products","Product_Weight");
		 softAssert.assertEquals(ActProdWeight, ExpProdWeight, "Field Data Mismatched");
		 Allure.step("Verified Product Weight");
		 
		 String ActPckgDimUnit =driver.findElement(pckgDimensnUnit).getAttribute("value");
		 String ExpPckgDimUnit= cu.getCellData("Add_Products","Package_Dimension_Unit");
		 softAssert.assertEquals(ActPckgDimUnit, ExpPckgDimUnit, "Field Data Mismatched");
		 Allure.step("Verified Package Dimension unit");
		 
		 String ActPckgDLength =driver.findElement(PckgDLength).getAttribute("value");
		 String ExpPckgDLength= cu.getCellData("Add_Products","Package_Dimension_Length");
		 softAssert.assertEquals(ActPckgDLength, ExpPckgDLength, "Field Data Mismatched");
		 Allure.step("Verified Package Dimension Length");
		 
		 String ActPckgDWidth =driver.findElement(PckgWidth).getAttribute("value");
		 String ExpPckgDWidth= cu.getCellData("Add_Products","Package_Dimension_Width");
		 softAssert.assertEquals(ActPckgDWidth, ExpPckgDWidth, "Field Data Mismatched");
		 Allure.step("Verified Package Dimension Width");
		
		 String ActPckgDHeight =driver.findElement(PckgHeight).getAttribute("value");
		 String ExpPckgDHeight= cu.getCellData("Add_Products","Package_Dimension_Height");
		 softAssert.assertEquals(ActPckgDHeight, ExpPckgDHeight, "Field Data Mismatched");
		 Allure.step("Verified Package Dimension Height");
		 
		 String ActPckgDWeightUnit =driver.findElement(PckgWeightUnit).getAttribute("value");
		 String ExpPckgDWeightUnit= cu.getCellData("Add_Products","Package_Weight_Unit");
		 softAssert.assertEquals(ActPckgDWeightUnit, ExpPckgDWeightUnit, "Field Data Mismatched");
		 Allure.step("Verified Package Weight Unit");
		 
		 String ActPckgDWeight =driver.findElement(PckgWeight).getAttribute("value");
		 String ExpPckgDWeight= cu.getCellData("Add_Products","Package_Weight");
		 softAssert.assertEquals(ActPckgDWeight, ExpPckgDWeight, "Field Data Mismatched");
		 Allure.step("Verified Package Weight");
		 
		 String ActPckgBpoint =driver.findElement(prodBulletpoint).getAttribute("value");
		 String ExpPckgBpoint= cu.getCellData("Add_Products","Bullet_Points");
		 softAssert.assertEquals(ActPckgBpoint, ExpPckgBpoint, "Field Data Mismatched");
		 Allure.step("Verified Package Bullet Point");
		 					 
		 softAssert.assertAll();
		 driver.findElement(prodsave).click();
		 Allure.step("Product save button is clicked");
			
		 
	}
	
	
	
}
