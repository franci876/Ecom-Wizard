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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class AddProductsPage extends CommonUtilities 
{

private static final boolean True = true;
WebDriver driver;
	
	public AddProductsPage(WebDriver driver)
	{
		this.driver = driver;		
	}
	By coredata =By.xpath("/html/body/div[2]/ul/li[2]/a");
	By products = By.xpath("/html/body/div[2]/ul/li[2]/ul/li[7]/a");	
	By addnewproduct = By.xpath("/html/body/div[3]/div[1]/a");
	//Setting random name for product name 
	By prodname = By.id("prod_name");
	String productnm="Test Product "+RandomStringUtils.randomAlphabetic(5);
	
	By casNum =By.id("prod_cas_number");
	By prodDivi=By.xpath("//div[2]/div/a/span");
	By prodDiv=By.xpath("//li[contains(.,'FEED')]");
	//click on dropbox business type
	By businesstype = By.xpath("//div[3]/div[2]/div/a/span");
	By businesstpe = By.xpath("/html/body/div[3]/div[1]/form/div[2]/div/fieldset/div[3]/div[2]/div/div/div/input");
	By businesstp =By.xpath("//li[contains(.,'MAN')]");
	
	By addprodtyp =By.xpath("//div[3]/input");
	
	By mltngpointfr =By.id("prod_melt_point_from");
	By mltngpointto =By.id("prod_melt_point_to");
	
	By boilngpointfr =By.id("prod_boil_point_from");
	By boilngpointto =By.id("prod_boil_point_to"); 
	By sgtemp =By.id("prod_sg_temperature");
	By phval=By.id("prod_ph_value");
	
	By heattyp =By.xpath("//div[3]/div/fieldset/div[5]/div/div/a/span");
	By heattype = By.xpath("//li[contains(.,'Low Pressure Steam')]");
	
	By heatmin	=By.id("prod_heat_min");
	By heatmax =By.id("prod_heat_max");
	
	By flashpointc =By.xpath("//div[7]/div/div/a");
	By flashpointdg =By.xpath("//div[@id='prod_flash_point_symbol_chosen']/div/ul/li[2]");
	
	By flashpoint= By.id("prod_flash_point");
	
	//click on dropbox product appearance
	By prodappearance = By.id("prod_appearance");
	By prodsg = By.id("prod_sg");
	//click on dropbox tank type
	
	String path= "#prod_tank_type_desc_chosen span";
	By tanktype = By.cssSelector(path);
	By tank= By.xpath("//li[contains(.,\'T4\')]");
	
	By prodrts =By.cssSelector("#prod_regulated_transport_status_chosen span");
	By prodrts2 =By.xpath("/html/body/div[3]/div[1]/form/div[4]/div/fieldset/div[2]/div[1]/div/div/div/input");
    By prodrts3 =By.xpath("//div/div/ul/li[3]");
    
	By unno =By.id("prod_unno");
	By pkgrp =By.id("prod_pk_grp");
	By adrcode = By.id("prod_adr_code");
	By adrno = By.id("prod_addr_no");
	By emsImdg =By.id("prod_imdg");
	
	By hcdg = By.xpath("/html/body/div[3]/div[1]/form/div[4]/div/fieldset/div[7]/div[1]/input");
	By marinepol =By.xpath("//div[4]/div/fieldset/div[5]/div/input");
	By showsp386 =By.id("prod_show_sp386");
	By sp386cbtn =By.xpath("//div[3]/div/div/button");
	
	By shipname = By.id("prod_ship_name");
	//click on dropbox secondary class
	By secondarycls =By.xpath("/html/body/div[3]/div[1]/form/div[4]/div/fieldset/div[4]/div[1]/div");
	By secondaryclass = By.xpath("//div[@id='prod_secondary_class_chosen']/div/ul/li[7]");	
	//click on dropbox primary class
	By primarycls = By.xpath("//div[4]/div/fieldset/div[3]/div[2]/div/a/span");
	By primarycs =By.xpath("(//input[@type='text'])[28]");
	By primaryclass = By.xpath("//div[@id='prod_primary_class_chosen']/div/ul/li[5]");
	//click on dropbox tertiary class
	By tertiarycls = By.xpath("//div[@id='prod_tertiary_class_chosen']/a/span");
	By tertiaryclass = By.xpath("//div[@id='prod_tertiary_class_chosen']/div/ul/li[7]");
	
	
	By imdg = By.xpath("//div[3]/div/div/button");
	By adr = By.xpath("//input[@id='prod_dg_regulation_adr']");
	By dot = By.xpath("//fieldset/fieldset/div/div[3]/input");
	By inertAtmReq = By.xpath("//div[5]/div/fieldset/div/div/input");
	By lachrymator = By.xpath("//div[5]/div/fieldset/div[2]/div/input");
	By idtf = By.xpath("//div[5]/div/fieldset/div[3]/div/input");
	By idtfRefNo = By.id("idtf_ref_no");
	By corrosiveToMetal = By.xpath("//div[5]/div/fieldset/div/div[2]/input");
	
	By customercls =By.xpath("//div[2]/div/button/span");
	By customer =By.xpath("//div[2]/div/ul/li[3]/a/label");
	
	By msdsValiddt= By.xpath("/html/body/div[3]/div[1]/form/div[6]/div/fieldset/div[3]/div[1]/div/span/span");
	By msdsValiddtf = By.xpath("/html/body/div[5]/div/div/select[2]");
	By msdsValiddtf2 = By.xpath("/html/body/div[5]/div/div/select[2]/option[13]");
	By msdsValiddtf3 = By.xpath("/html/body/div[5]/div/div/select[1]");
	By msdsValiddtf4 = By.xpath("/html/body/div[5]/div/div/select[1]/option[2]");
	By msdsValiddtf5 =By.xpath("/html/body/div[5]/table/tbody/tr[2]/td[2]/a");
	
	By msdsValiddtt = By.xpath("/html/body/div[3]/div[1]/form/div[6]/div/fieldset/div[3]/div[2]/div/span");
	By msdsValiddto2 = By.xpath("/html/body/div[5]/div/div/select[2]");
	By msdsValiddto3 = By.xpath("/html/body/div[5]/div/div/select[2]/option[11]");
	By msdsValiddto4 =By.xpath("/html/body/div[5]/div/div/select[1]");
	By msdsValiddto5 = By.xpath("/html/body/div[5]/div/div/select[1]/option[2]");
	By msdsValiddto6 = By.xpath("/html/body/div[5]/table/tbody/tr[3]/td[3]/a");
			
	By synonym = By.xpath("/html/body/div[3]/div[1]/form/div[7]/div/fieldset/div[2]/div/div[1]/input");
	By synadd = By.id("synonym-add-btn-1");
	By productNote = By.id("prod_specific_note");
	By qssheNote = By.id("product_qsshe_note");
	
	By prodSoluInWater =By.xpath("//div[10]/div/fieldset/div/div/input");
	By prodSoluInSolv =By.xpath("//div[10]/div/fieldset/div/div[2]/input");
	
	By safetyTempCtrl =By.xpath("//div[8]/div/fieldset/div/div/input");
	By prodCtrl =By.id("prod_control_temp");
	By prodEmerCtrl = By.id("prod_emergency_temp");
	By saptCtrl =By.id("prod_sapt_temp");
	By sadtCtrl =By.id("prod_sadt_temp");
	
	
	By qualityTempCtrl = By.xpath("//div[8]/div/fieldset/div[3]/div/input");
	By lowestTemp1 = By.xpath("//div[4]/div/div/div/a/span");
	//By lowestTemp2 = By.xpath("//div[8]/div/fieldset/div/div/input");
	By maxTemp1 = By.xpath("//div[4]/div/div[2]/div/a/span");
	By maxTemp2 = By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[1]/div[2]/div/div/div/input");
	
	By fstWarLow1 =By.xpath("//div[4]/div[2]/div/div/a/span");
	By fstWarLow2 =By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[2]/div[1]/div/div/div/input");
	By fstWarmax1 =By.xpath("//div[4]/div[2]/div[2]/div/a/span");
	By fstWarmax2 =By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[2]/div[2]/div/div/div/input");
	
	By secwarlow1 =By.xpath("//div[4]/div[3]/div/div/a/span");
	By secwarlow2 =By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[3]/div[1]/div/div/div/input");
	By secwarmax1 =By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[3]/div[2]/div/a");
	By secwarmax2 =By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[3]/div[2]/div/div/div/input");
	
	By criticTempLow1 =By.xpath("//div[4]/div[4]/div/div/a/span");
	By criticTempLow2 =By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[4]/div[1]/div/div/div/input");
	By criticTempMax1 =By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[4]/div[2]/div/a");
	By criticTempMax2 =By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[4]/div[2]/div/div/div/input");
	
	By loadTempMin1 = By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[5]/div[1]/div/a");
	By loadTempMin2 = By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[5]/div[1]/div/div/div/input");
	By loadTempMax1 = By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[5]/div[2]/div/a");
	By loadTempMax2 = By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[5]/div[2]/div/div/div/input");
	
	By disTempLow1 =By.xpath("//div[6]/div/div/a/span");
	By disTempLow2 =By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[6]/div[1]/div/div/div/input");
	By disTempMax1 =By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[6]/div[2]/div/a");
	By disTempMax2 =By.xpath("/html/body/div[3]/div[1]/form/div[8]/div/fieldset/div[4]/div[6]/div[2]/div/div/div/input");
	
	
	//create product
	By create = By.xpath("/html/body/div[3]/div[1]/form/div[12]/button");
	//filter product by name
	By prodNameFilter =By.id("prod-name-filter");
	By prodFilter = By.xpath("//button[@type='submit']");
	//delete added product
	By deletebtn =By.xpath("/html/body/div[3]/div[1]/div[6]/table/tbody/tr[1]/td[9]/a[4]");
	By deleteconfirm = By.xpath("//button[contains(.,'OK')]");
	
	//edit added product
	By editbtn =By.xpath("/html/body/div[3]/div[1]/div[6]/table/tbody/tr[1]/td[9]/a[1]");
	By updatebtn = By.xpath("/html/body/div[3]/div[1]/form/div[14]/button");
	
	CommonUtilities objCU = new CommonUtilities();
	
	public void clickcoredata()
	{
		
		driver.findElement(coredata).click();	
		driver.findElement(products).click();
		driver.findElement(addnewproduct).click();
		Allure.step("Add new product button is clicked");
	}

	public void tankType(String tnktp, By tankn) throws Exception
	{
          dropdownmethod(driver,path);
		
		driver.findElement(tanktype).click();;
		Thread.sleep(4000);
		
		//String jbn="//li[contains(.,\'"+tnktp+"\')]";
		//By tankn= By.xpath(jbn);
		
	    driver.findElement(tankn).click();
	    Allure.step("Tank type is selected from dropdown");
	  
	}
	public void casNumber(String csnm)
	{
		driver.findElement(casNum).sendKeys(csnm);
		Allure.step("CasNum value is entered");
	}
	public void prodsg(String sg)
	{
		driver.findElement(prodsg).sendKeys(sg);
		Allure.step("Product SG value is entered");
	}
	public void primarykey(String pk) throws Exception
	{
		driver.findElement(primarycls).click();
		Thread.sleep(4000);
	}
	public void prodAppearance(String pa)
	{
		driver.findElement(prodappearance).sendKeys(pa);
		Allure.step("Product appearance is entered");
	}
	public void testShipNm(String snm)
	{
		driver.findElement(shipname).sendKeys(snm);
		Allure.step("Ship name is entered");
	}
	
	public void createproduct() throws Exception
	{     	
		objCU.dropDownClick(driver, tanktype, objCU.getCellData("Products","Tank Type Desc"));
		Allure.step("Tank type is selected from dropdown");
		Thread.sleep(4000);
		objCU.dropDownClick(driver, secondarycls, "4.1:Flammable solid");
		Allure.step("Secondary class is selected from dropdown");
		objCU.dropDownClick(driver, primarycls, "4.1:Flammable solid");
		Allure.step("Primary class is selected from dropdown");
		//objCU.dropDownEnter(driver, primarycls, objCU.getCellData("Products","Primary Class"),primarycs);
		Thread.sleep(4000);
		objCU.dropDownClick(driver, customercls, " 24/7 Logistic Solutions B.V. (247LOGIS)");
		Allure.step("Customer is selected from dropdown");
		//objCU.dropDownClick(driver, tertiarycls, "5.1:Oxidizing agent");
		//objCU.dropDownClick(driver, businesstype, "MAN");
		objCU.dropDownEnter(driver, businesstype,objCU.getCellData("Products","Business Type"),businesstpe);
		Allure.step("Business type is selected from dropdown");
		driver.findElement(prodDivi).click();
		Thread.sleep(4000);
		dropdownmethod(driver,path);
		driver.findElement(prodDiv).click();
		Allure.step("Product Division is selected from dropdown");
		driver.findElement(prodname).sendKeys(productnm);
		Allure.step("Product name is entered");
	    Thread.sleep(4000);
		driver.findElement(addprodtyp).click();
		Allure.step("Add product type is clicked");
		driver.findElement(mltngpointfr).sendKeys("200");
		Allure.step("Melting point from is entered");
		driver.findElement(mltngpointto).sendKeys("230");
		Allure.step("Melting point to is entered");
		driver.findElement(boilngpointfr).sendKeys("85");
		Allure.step("Boiling point from is entered");
		driver.findElement(boilngpointto).sendKeys("100");
		Allure.step("Boiling point to is entered");
		driver.findElement(sgtemp).sendKeys("80");
		Allure.step("SG temperature is entered");
		driver.findElement(phval).sendKeys("14");
		Allure.step("PH value is entered");
		
		driver.findElement(heattyp).click();
		driver.findElement(heattype).click();
		Allure.step("Heat Type is selected");
		driver.findElement(heatmin).sendKeys("10");
		Allure.step("Heat Min is entered");
		driver.findElement(heatmax).sendKeys("60");
		Allure.step("Heat Max is entered");
		
		objCU.dropDownEnter(driver, prodrts,objCU.getCellData("Products","Regulated Transport Status"),prodrts2);
		
		Allure.step("Regulated for Transport Status dropdown is selected");
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
		Allure.step("Tertiary class dropdown is selected");
		
		driver.findElement(flashpointc).click();
		Thread.sleep(5000);
		driver.findElement(flashpointdg).click();
		Allure.step("Flash Point dropdown is selected");
		driver.findElement(flashpoint).sendKeys("30");
		Allure.step("Flash Point (°C) is entered");
		driver.findElement(adrcode).sendKeys("code 334");
		Allure.step("Emergency Action Code (ADR) is entered");
		driver.findElement(adrno).sendKeys("3434");
		Allure.step("Hazard Identification Number (ADR) is entered");
		driver.findElement(emsImdg).sendKeys("Ems Imdg");
		Allure.step("Emergency Action Schedule (IMDG) is entered");
		
		driver.findElement(unno).sendKeys("554");
		Allure.step("UN Number is entered");
		Thread.sleep(2000);
		driver.findElement(pkgrp).sendKeys("A_Group");
		Allure.step("Packing Group is entered");
		Thread.sleep(2000);
		driver.findElement(hcdg).click();
		Allure.step("High Consequence Dangerous Goods checkbox is selected");
		driver.findElement(marinepol).click();
		Allure.step("Marine Pollutant checkbox is selected");
		driver.findElement(showsp386).click();
		Thread.sleep(2000);
		driver.findElement(sp386cbtn).click();
		Allure.step("Show SP386 checkbox is selected");
		
		driver.findElement(imdg).click();
		Allure.step("IMDG checkbox is selected");
		Thread.sleep(2000);
		driver.findElement(adr).click();
		Allure.step("Adr checkbox is selected");
		driver.findElement(dot).click();
		Allure.step("Dot checkbox is selected");
		driver.findElement(inertAtmReq).click();
		Allure.step("Inert Atmosphere Req checkbox is selected");
		driver.findElement(lachrymator).click();
		Allure.step("Lachrymator checkbox is selected");
		driver.findElement(idtf).click();
		Allure.step("IDTF database checked and approved- Checkbox is selected");
		driver.findElement(idtfRefNo).sendKeys("655");
		Allure.step("IDTF reference number is entered");
		driver.findElement(corrosiveToMetal).click();
		Allure.step("Corrosive to metals : H290? Checkbox is selected");
		
		driver.findElement(msdsValiddt).click();
		Thread.sleep(2000);
		driver.findElement(msdsValiddtf).click();
		driver.findElement(msdsValiddtf2).click();
		driver.findElement(msdsValiddtf3).click();
		driver.findElement(msdsValiddtf4).click();
		driver.findElement(msdsValiddtf5).click();
		Allure.step("MSDS Valid From Date is Selected");
		
		driver.findElement(msdsValiddtt).click();
		Thread.sleep(2000);
		driver.findElement(msdsValiddto2).click();
		driver.findElement(msdsValiddto3).click();
		driver.findElement(msdsValiddto4).click();
		driver.findElement(msdsValiddto5).click();
		driver.findElement(msdsValiddto6).click();
		Allure.step("MSDS Valid To Date is Selected");
		Thread.sleep(500);
		//driver.findElement(customer).click();
		driver.findElement(synonym).sendKeys("Test Synonym");
		Allure.step("Synonym is entered");
		driver.findElement(synadd).click();
		Allure.step("Synonym add button is clicked");
		
		driver.findElement(safetyTempCtrl).click();
		Allure.step("Checked Safety Critical temperature controls checkbox");
		Thread.sleep(500);
		
		driver.findElement(prodCtrl).sendKeys("100");
		Allure.step("Control temperature is added");
		driver.findElement(prodEmerCtrl).sendKeys("150");
		Allure.step("Emergency temperature is added");
		driver.findElement(saptCtrl).sendKeys("82");
		Allure.step("SAPT temperature is added");
		driver.findElement(sadtCtrl).sendKeys("64");
		Allure.step("SADT temperature is added");
		
		Thread.sleep(2000);
		
		driver.findElement(qualityTempCtrl).click();
		Allure.step("Checked Customer / Quality temperature controls checkbox");
		
		objCU.dropDownClick(driver, lowestTemp1, "-9");
		Allure.step("Selected Nominal Temperature - Lowest(°C) dropdown");
		//objCU.dropDownClick(driver, maxTemp1, " -9");
		objCU.dropDownEnter(driver, maxTemp1,objCU.getCellData("Products","Nominal Temp Max"),maxTemp2);
		Allure.step("Selected Nominal Temperature - Max(°C) dropdown");
		objCU.dropDownEnter(driver, fstWarLow1,objCU.getCellData("Products","First Warning Temp Min"),fstWarLow2);
		Allure.step("Selected 1st Warning / Monitor / Consider action - Lowest(°C) dropdown");
		objCU.dropDownEnter(driver, fstWarmax1,objCU.getCellData("Products","First Warning Temp Max"),fstWarmax2);
		Allure.step("Selected 1st Warning / Monitor / Consider action - Max(°C) dropdown");
		objCU.dropDownEnter(driver, secwarlow1,objCU.getCellData("Products","Second Warning Temp Min"),secwarlow2);
		Allure.step("Selected 2nd Warning / Immediate action required - Lowest(°C) dropdown");
		objCU.dropDownEnter(driver, secwarmax1,objCU.getCellData("Products","Second Warning Temp Max"),secwarmax2);
		Allure.step("Selected 2nd Warning / Immediate action required - Max(°C) dropdown");
		objCU.dropDownEnter(driver, criticTempLow1,objCU.getCellData("Products","Critical Temp Low"),criticTempLow2);
		Allure.step("Selected Critical / Emergency Response required - Lowest(°C) dropdown");
		objCU.dropDownEnter(driver, criticTempMax1,objCU.getCellData("Products","Critical Temp Max"),criticTempMax2);
		Allure.step("Selected Critical / Emergency Response required - Max(°C) dropdown");
		objCU.dropDownEnter(driver, loadTempMin1,objCU.getCellData("Products","Loading Temp Min"),loadTempMin2);
		Allure.step("Selected Loading Temperature - Lowest(°C) dropdown");
		objCU.dropDownEnter(driver, loadTempMax1,objCU.getCellData("Products","Loading Temp Max"),loadTempMax2);
		Allure.step("Selected Loading Temperature - Max(°C) dropdown");
		objCU.dropDownEnter(driver, disTempLow1,objCU.getCellData("Products","Discharge Temp Min"),disTempLow2);
		Allure.step("Selected Discharge Temperature - Lowest(°C) dropdown");
		objCU.dropDownEnter(driver, disTempMax1,objCU.getCellData("Products","Discharge Temp Max"),disTempMax2);
		Allure.step("Selected Discharge Temperature - Max(°C) dropdown");
		
		driver.findElement(productNote).sendKeys("Test note");
		Allure.step("Product Note is added");
		driver.findElement(qssheNote).sendKeys("Test Qsshe Notes");
		Allure.step("Product Qsshe Note is added");
		driver.findElement(prodSoluInWater).click();
		Allure.step("Checked water(cleaning information) checkbox");
		driver.findElement(prodSoluInSolv).click();
		Allure.step("Checked solvents(cleaning information) checkbox");
		
	}
	public void clickcreateprod() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(create).click();
		Allure.step("Create product button is clicked");
	}
	public void addproducts(String sg,String s,String snm,String tnktp,String pa, String csnm) throws Exception
	{
		this.clickcoredata();
		this.casNumber(csnm);
		this.prodsg(sg);
		Thread.sleep(5000);
		//this.tankType(tnktp);
		this.prodAppearance(s);
        this.testShipNm(snm);		
		this.createproduct();
		this.clickcreateprod();
		Thread.sleep(5000);
		this.filter();
		this.editProduct();
		Thread.sleep(2000);
		this.filter();
		this.deleteproduct();
	}
	
	public void filter() throws Exception 
	{
		driver.findElement(prodNameFilter).clear();
		driver.findElement(prodNameFilter).sendKeys(productnm);
		Allure.step("Enter product name to filter");
		driver.findElement(prodFilter).click();
		Allure.step("Clicked on product search button");
		Thread.sleep(2000);
	}
	
	public void editProduct() throws Exception
	{
		SoftAssert softAssert=new SoftAssert();
		driver.findElement(editbtn).click();
		Allure.step("Clicked on edit button");
		Thread.sleep(2000);
		driver.findElement(heatmin).sendKeys("45");
		Allure.step("Edited heat minimum value");
		driver.findElement(heatmax).sendKeys("125");
		Allure.step("Edited heat maximum value");
		driver.findElement(productNote).sendKeys("Test note new edited");
		Allure.step("Edited test note");
		driver.findElement(qssheNote).sendKeys("Edited Qsshe Notes");
		Allure.step("Edited test Qsshe note");
		
//		boolean abc= driver.findElement(By.xpath("")).isDisplayed();
//		Assert.assertTrue(abc," Element is not displayed");	
		
		String prodappacttext =driver.findElement(prodappearance).getAttribute("value");
		String prodappexcptText = "Test Appearance 1";
		softAssert.assertEquals(prodappacttext, prodappexcptText, "Field Data Mismatched");
		Allure.step("Verified Test Appearance field data");
		
		String sgacttext =driver.findElement(prodsg).getAttribute("value");
		String sgexcptText = "98.0100";
		softAssert.assertEquals(sgacttext, sgexcptText, "Field Data Mismatched");
		Allure.step("Verified Product SG field data");
		
		String shpnmacttext =driver.findElement(shipname).getAttribute("value");
		String shpnmexcptText = "Test Ship Name";
		softAssert.assertEquals(shpnmacttext, shpnmexcptText, "Field Data Mismatched");
		Allure.step("Verified ship name field");
		
		WebElement bsnsElement = driver.findElement(By.cssSelector("#prod_bus_type_chosen span"));
//		String bsnsacttext =bsnsElement.getText();
		String bsnsexcptText = "DED";
//		softAssert.assertEquals(bsnsacttext, bsnsexcptText, "Field Data Mismatched");
		dropdownVerify(driver, bsnsElement, bsnsexcptText);
		Allure.step("Verified business type dropdown");
		
		WebElement tntktyelement = driver.findElement(By.cssSelector("#prod_tank_type_desc_chosen span"));
		String tnktypexcptText = "T6";
		dropdownVerify(driver, tntktyelement, tnktypexcptText);
		Allure.step("Verified tank type desc dropdown");
		
		WebElement prodivelement = driver.findElement(By.cssSelector("#prod_division_chosen span"));
		String prodivexcptText = "FEED";
		dropdownVerify(driver, prodivelement, prodivexcptText);
		Allure.step("Verified product division dropdown");
		
		WebElement addProdTypelement = driver.findElement(By.cssSelector("#abp"));
		boolean addProdTypeacText= addProdTypelement.isSelected();
		boolean addProdTypeexpText =True;
		softAssert.assertEquals(addProdTypeacText, addProdTypeexpText, "Mismatch");
		Allure.step("Verified additional product type selected checkbox");

		String mltngPointFracTxt =driver.findElement(mltngpointfr).getAttribute("value");
		String mltngPointFrExpTxt = "200.00";
		softAssert.assertEquals(mltngPointFracTxt, mltngPointFrExpTxt, "Field Data Mismatched");
		Allure.step("Verified 'melting point from' field data");
		
		String mltngPointToacTxt =driver.findElement(mltngpointto).getAttribute("value");
		String mltngPointToExpTxt = "230.00";
		softAssert.assertEquals(mltngPointToacTxt, mltngPointToExpTxt, "Field Data Mismatched");
		Allure.step("Verified 'melting point to' field data");
		
		String boilngpointfracTxt =driver.findElement(boilngpointfr).getAttribute("value");
		String boilngpointfrExpTxt = "85.00";
		softAssert.assertEquals(boilngpointfracTxt, boilngpointfrExpTxt, "Field Data Mismatched");
		Allure.step("Verified 'boiling point from' field data");
		
		String boilngpointtoacTxt =driver.findElement(boilngpointto).getAttribute("value");
		String boilngpointtoExpTxt = "100.00";
		softAssert.assertEquals(boilngpointtoacTxt, boilngpointtoExpTxt, "Field Data Mismatched");
		Allure.step("Verified 'melting point to' field data");
		
		String sgtempacTxt =driver.findElement(sgtemp).getAttribute("value");
		String sgtempExpTxt = "80.00";
		softAssert.assertEquals(sgtempacTxt, sgtempExpTxt, "Field Data Mismatched");
		Allure.step("Verified S.G temperature field data");
		
		String phvalacTxt =driver.findElement(phval).getAttribute("value");
		String phvalExpTxt = "14.0";
		softAssert.assertEquals(phvalacTxt, phvalExpTxt, "Field Data Mismatched");
		Allure.step("Verified PH Value field data");
		
		String heatminacTxt =driver.findElement(heatmin).getAttribute("value");
		String heatminExpTxt = "10.004";
		softAssert.assertEquals(heatminacTxt, heatminExpTxt, "Field Data Mismatched");
		Allure.step("Verified heat minimum field data");
		
		String heatmaxacTxt =driver.findElement(heatmax).getAttribute("value");
		String heatmaxExpTxt = "60.001";
		softAssert.assertEquals(heatmaxacTxt, heatmaxExpTxt, "Field Data Mismatched");
		Allure.step("Verified heat maximum field data");

		String flashpsacTxt =driver.findElement(flashpoint).getAttribute("value");
		String flashpsExpTxt = "30.00";
		softAssert.assertEquals(flashpsacTxt, flashpsExpTxt, "Field Data Mismatched");
		Allure.step("Verified flash point field data");
		
		String unnoacTxt =driver.findElement(unno).getAttribute("value");
		String unnoExpTxt = "554";
		softAssert.assertEquals(unnoacTxt, unnoExpTxt, "Field Data Mismatched");
		Allure.step("Verified UN Number field data");
		
		WebElement prodrtselement = driver.findElement(By.cssSelector("#prod_regulated_transport_status_chosen span"));
		String prodrtsexcptText = "Regulated for Transport";
		dropdownVerify(driver, prodrtselement, prodrtsexcptText);
		Allure.step("Verified Regulated for Transport Status dropdown");
		
		String shipnmacTxt =driver.findElement(shipname).getAttribute("value");
		String shipnmExpTxt = "Test Ship Name";
		softAssert.assertEquals(shipnmacTxt, shipnmExpTxt, "Field Data Mismatched");
		Allure.step("Verified Proper Shipping Name field data");
		
		WebElement prikeyelement = driver.findElement(By.cssSelector("#prod_primary_class_chosen span"));
		String prikeyexcptText = "4.1:Flammable solid";
		dropdownVerify(driver, prikeyelement, prikeyexcptText);
		Allure.step("Verified primary class dropdown");
		
		WebElement seckeyelement = driver.findElement(By.cssSelector("#prod_secondary_class_chosen span"));
		String seckeyexcptText = "4.1:Flammable solid";
		dropdownVerify(driver, seckeyelement, seckeyexcptText);
		Allure.step("Verified secondary class dropdown");
		
		WebElement terkeyeyelement = driver.findElement(By.cssSelector("#prod_tertiary_class_chosen span"));
		String terkeyexcptText = "4.1:Flammable solid";
		dropdownVerify(driver, terkeyeyelement, terkeyexcptText);
		Allure.step("Verified tertiary class dropdown");
		
		String pkgrpacTxt =driver.findElement(pkgrp).getAttribute("value");
		String pkgrpExpTxt = "A_G";
		softAssert.assertEquals(pkgrpacTxt, pkgrpExpTxt, "Field Data Mismatched");
		Allure.step("Verified packing group field data");
		
		String adrnoacTxt =driver.findElement(adrno).getAttribute("value");
		String adrnoExpTxt = "3434";
		softAssert.assertEquals(adrnoacTxt, adrnoExpTxt, "Field Data Mismatched");
		Allure.step("Verified Hazard Identification Number (ADR) field data");
		
		String adrcodeacTxt =driver.findElement(adrcode).getAttribute("value");
		String adrcodeExpTxt = "code 334";
		softAssert.assertEquals(adrcodeacTxt, adrcodeExpTxt, "Field Data Mismatched");
		Allure.step("Verified Emergency Action Code (ADR) field data");
		
		String emsimdgacTxt =driver.findElement(emsImdg).getAttribute("value");
		String emsimdgExpTxt = "Ems Imdg";
		softAssert.assertEquals(emsimdgacTxt, emsimdgExpTxt, "Field Data Mismatched");
		Allure.step("Verified Emergency Action Schedule (IMDG) field data");
		
		WebElement hcdgelement = driver.findElement(By.cssSelector("#prod_is_hcdg"));
		checkboxVerify(driver, hcdgelement);
		Allure.step("Verified High Consequence Dangerous Goods checkbox");

		WebElement marinepolelement = driver.findElement(By.cssSelector("#prod_marine_pollutant"));
		checkboxVerify(driver, marinepolelement);
		Allure.step("Verified Marine Pollutant checkbox");
		
		WebElement showps386element = driver.findElement(By.cssSelector("#prod_show_sp386"));
		checkboxVerify(driver, showps386element);
		Allure.step("Verified Show SP386 checkbox");
		
		WebElement imdgelement = driver.findElement(By.cssSelector("#prod_dg_regulation_imdg"));
		checkboxVerify(driver, imdgelement);
		Allure.step("Verified IMDG checkbox");
		
		WebElement adrelement = driver.findElement(By.cssSelector("#prod_dg_regulation_adr"));
		checkboxVerify(driver, adrelement);
		Allure.step("Verified ADR checkbox");
		
		WebElement dotelement = driver.findElement(By.cssSelector("#prod_dg_regulation_dot"));
		checkboxVerify(driver, dotelement);
		Allure.step("Verified DOT checkbox");
		
		WebElement atmreqelement = driver.findElement(By.cssSelector("#prod_inert_atm_req"));
		checkboxVerify(driver, atmreqelement);
		Allure.step("Verified Inert Atmosphere Req checkbox");
		
		WebElement lachelement = driver.findElement(By.cssSelector("#prod_lacrimator"));
		checkboxVerify(driver, lachelement);
		Allure.step("Verified Lachrymator checkbox");
		
		WebElement idtfelement = driver.findElement(By.cssSelector("#idtf_database_checked_and_approved"));
		checkboxVerify(driver, idtfelement);
		Allure.step("Verified 'IDTF database checked and approved' checkbox");
		
		String idtfRefNoacTxt =driver.findElement(idtfRefNo).getAttribute("value");
		String idtfRefNoExpTxt = "655";
		softAssert.assertEquals(idtfRefNoacTxt, idtfRefNoExpTxt, "Field Data Mismatched");
		Allure.step("Verified IDTF reference number field data");
		
		WebElement cormelement = driver.findElement(By.cssSelector("#prod_corrosive_to_metals"));
		checkboxVerify(driver, cormelement);
		Allure.step("Verified 'Corrosive to metals : H290?' checkbox");
		
		WebElement custelement = driver.findElement(By.xpath("//div[2]/div/button/span"));
		String custexcptText = " 24/7 Logistic Solutions B.V. (247LOGIS)";
		dropdownVerify(driver, custelement, custexcptText);
		Allure.step("Verified Customer dropdown");
		
		WebElement frdateelement = driver.findElement(By.cssSelector("#from_date"));
		String frdateexcptText = "24/02/2023";
		dropdownVerify(driver, frdateelement, frdateexcptText);
		Allure.step("Verified MSDS Valid From Date dropdown");
		
		WebElement todateelement = driver.findElement(By.cssSelector("#to_date"));
		String todateexcptText = "24/02/2030";
		dropdownVerify(driver, todateelement, todateexcptText);
		Allure.step("Verified MSDS Valid To Date dropdown");
		
		String synonymacTxt =driver.findElement(synonym).getAttribute("value");
		String synonymExpTxt = "Test Synonym";
		softAssert.assertEquals(synonymacTxt, synonymExpTxt, "Field Data Mismatched");
		Allure.step("Verified Synonym field data");
		
		WebElement tempelement = driver.findElement(By.cssSelector("#prod_transit_temp"));
		checkboxVerify(driver, tempelement);
		Allure.step("Verified 'Safety Critical temperature controls' checkbox");
		
		String tempctrlacTxt =driver.findElement(prodCtrl).getAttribute("value");
		String tempctrlExpTxt = "100.00";
		softAssert.assertEquals(tempctrlacTxt, tempctrlExpTxt, "Field Data Mismatched");
		Allure.step("Verified Synonym field data");
		
		String emgtempctrlacTxt =driver.findElement(prodEmerCtrl).getAttribute("value");
		String emgtempctrlExpTxt = "150.00";
		softAssert.assertEquals(emgtempctrlacTxt, emgtempctrlExpTxt, "Field Data Mismatched");
		Allure.step("Verified control temperature field data");
		
		String saptctrlacTxt =driver.findElement(saptCtrl).getAttribute("value");
		String saptExpTxt = "82.00";
		softAssert.assertEquals(saptctrlacTxt, saptExpTxt, "Field Data Mismatched");
		Allure.step("Verified SAPT temperature field data");
		
		String sadtctrlacTxt =driver.findElement(sadtCtrl).getAttribute("value");
		String sadtExpTxt = "64.00";
		softAssert.assertEquals(sadtctrlacTxt, sadtExpTxt, "Field Data Mismatched");
		Allure.step("Verified SADT temperature field data");
		
		WebElement qualitytempelement = driver.findElement(By.cssSelector("#prod_is_quality_temp"));
		checkboxVerify(driver, qualitytempelement);
		Allure.step("Verified Customer / Quality temperature controls checkbox");
		
		WebElement minTempelement = driver.findElement(By.cssSelector("#prod_nominal_temp_min_chosen span"));
		String minTempexcptText = "-9";
		dropdownVerify(driver, minTempelement, minTempexcptText);
		Allure.step("Verified 'Nominal Temperature - Lowest(°C)' checkbox ");
		
		WebElement maxTempelement = driver.findElement(By.cssSelector("#prod_nominal_temp_max_chosen span"));
		String maxTempexcptText = "-8";
		dropdownVerify(driver, maxTempelement, maxTempexcptText);
		Allure.step("Verified 'Nominal Temperature - Max(°C)' checkbox ");
		
		WebElement warMinTempelement = driver.findElement(By.cssSelector("#prod_warning_temp1_min_chosen span"));
		String warMinTempexcptText = "-5";
		dropdownVerify(driver, warMinTempelement, warMinTempexcptText);
		Allure.step("Verified '1st Warning / Monitor / Consider action - Lowest(°C)' checkbox ");
		
		WebElement warMaxTempelement = driver.findElement(By.cssSelector("#prod_warning_temp1_max_chosen span"));
		String warMaxTempexcptText = "-3";
		dropdownVerify(driver, warMaxTempelement, warMaxTempexcptText);
		Allure.step("Verified '1st Warning / Monitor / Consider action - Max(°C)' checkbox ");
		
		WebElement war2MinTempelement = driver.findElement(By.cssSelector("#prod_warning_temp2_min_chosen span"));
		String war2MinTempexcptText = "-4";
		dropdownVerify(driver, war2MinTempelement, war2MinTempexcptText);
		Allure.step("Verified '2nd Warning / Immediate action required - Lowest(°C)' checkbox ");

		WebElement war2MaxTempelement = driver.findElement(By.cssSelector("#prod_warning_temp2_max_chosen span"));
		String war2MaxTempexcptText = "5";
		dropdownVerify(driver, war2MaxTempelement, war2MaxTempexcptText);
		Allure.step("Verified '2nd Warning / Immediate action required - Max(°C)' checkbox ");
		
		WebElement critTempminelement = driver.findElement(By.cssSelector("#prod_critical_temp_min_chosen span"));
		String critTempminexcptText = "-2";
		dropdownVerify(driver, critTempminelement, critTempminexcptText);
		Allure.step("Verified 'Critical / Emergency Response required - Lowest(°C)' checkbox ");
		
		WebElement critTempmaxelement = driver.findElement(By.cssSelector("#prod_critical_temp_max_chosen span"));
		String critTempmaxexcptText = "8";
		dropdownVerify(driver, critTempmaxelement, critTempmaxexcptText);
		Allure.step("Verified 'Critical / Emergency Response required - Max(°C)' checkbox ");
		
		WebElement loadTempMinelement = driver.findElement(By.cssSelector("#prod_load_temp_min_chosen span"));
		String loadTempMinexcptText = "-3";
		dropdownVerify(driver, loadTempMinelement, loadTempMinexcptText);
		Allure.step("Verified 'Loading Temperature - Lowest(°C)' checkbox ");
		
		WebElement loadTempMaxelement = driver.findElement(By.cssSelector("#prod_load_temp_max_chosen span"));
		String loadTempMaxexcptText = "5";
		dropdownVerify(driver, loadTempMaxelement, loadTempMaxexcptText);
		Allure.step("Verified 'Loading Temperature - Max(°C)' checkbox ");
		
		WebElement disempMinelement = driver.findElement(By.cssSelector("#prod_discharge_temp_min_chosen span"));
		String disTempMinexcptText = "-4";
		dropdownVerify(driver, disempMinelement, disTempMinexcptText);
		Allure.step("Verified 'Discharge Temperature - Lowest(°C)' checkbox ");
		
		WebElement disempMaxelement = driver.findElement(By.cssSelector("#prod_discharge_temp_max_chosen span"));
		String disTempMaxexcptText = "2";
		dropdownVerify(driver, disempMaxelement, disTempMaxexcptText);
		Allure.step("Verified 'Discharge Temperature - Max(°C)' checkbox ");
		
		String prodnotacTxt =driver.findElement(productNote).getAttribute("value");
		String prodnotExpTxt = "Test noteTest note new edited";
		softAssert.assertEquals(prodnotacTxt, prodnotExpTxt, "Field Data Mismatched");
		Allure.step("Verified product note field data");
		
		String qsshenotacTxt =driver.findElement(qssheNote).getAttribute("value");
		String qsshenotExpTxt = "Test Qsshe NotesEdited Qsshe Notes";
		softAssert.assertEquals(qsshenotacTxt, qsshenotExpTxt, "Field Data Mismatched");
		Allure.step("Verified Qsshe note field data");
		
		WebElement waterelement = driver.findElement(By.cssSelector("#prod_soluble_in_water"));
		checkboxVerify(driver, waterelement);
		Allure.step("Verified Water(cleaning) checkbox");
		
		WebElement solvempelement = driver.findElement(By.cssSelector("#prod_soluble_in_solvents"));
		checkboxVerify(driver, solvempelement);
		Allure.step("Verified Solvents(cleaning) checkbox");
		
		driver.findElement(updatebtn).click();
		Allure.step("Clicked on Update Button");
		Thread.sleep(2000);
		softAssert.assertAll();
	}
	public void deleteproduct() throws Exception
	{
		driver.findElement(deletebtn).click();
		Allure.step("Clicked on delete button");
		Thread.sleep(4000);
		driver.findElement(deleteconfirm).click();
		Allure.step("Clicked on confirm delete button");
	}
}
