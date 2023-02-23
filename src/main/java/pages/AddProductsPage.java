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
	By prodname = By.id("prod_name");
	String productnm="Test Product "+RandomStringUtils.randomAlphabetic(5);
	
	By casNum =By.id("prod_cas_number");
	By prodDivi=By.xpath("//div[2]/div/a/span");
	By prodDiv=By.xpath("//li[contains(.,'FEED')]");
	//click on dropbox business type
	By businesstype = By.xpath("//div[3]/div[2]/div/a/span");
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
	By flashpointdg =By.xpath("//li[contains(.,'=')]");
	
	By flashpoint= By.id("prod_flash_point");
	
	//click on dropbox product appearance
	By prodappearance = By.id("prod_appearance");
	By prodsg = By.id("prod_sg");
	//click on dropbox tank type
	
	String path= "#prod_tank_type_desc_chosen span";
	By tanktype = By.cssSelector(path);
	By tank= By.xpath("//li[contains(.,\'T4\')]");
	
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
	public void casNumber(String csnm)
	{
		driver.findElement(casNum).sendKeys(csnm);
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
		Thread.sleep(4000);
		objCU.dropDownClick(driver, secondarycls, "4.1:Flammable solid");
		objCU.dropDownClick(driver, primarycls, "4.1:Flammable solid");
		//objCU.dropDownEnter(driver, primarycls, objCU.getCellData("Products","Primary Class"),primarycs);
		Thread.sleep(4000);
		objCU.dropDownClick(driver, customercls, " 24/7 Logistic Solutions B.V. (247LOGIS)");
		
		//objCU.dropDownClick(driver, tertiarycls, "5.1:Oxidizing agent");
		//objCU.dropDownClick(driver, businesstp, "MAN");
		
		driver.findElement(prodDivi).click();
		Thread.sleep(4000);
		dropdownmethod(driver,path);
		driver.findElement(prodDiv).click();
		driver.findElement(prodname).sendKeys(productnm);
		Thread.sleep(4000);
		driver.findElement(businesstype).click();
	    Thread.sleep(4000);
	    driver.findElement(businesstp).click();
		driver.findElement(addprodtyp).click();
		driver.findElement(mltngpointfr).sendKeys("200");
		driver.findElement(mltngpointto).sendKeys("230");
		driver.findElement(boilngpointfr).sendKeys("85");
		driver.findElement(boilngpointto).sendKeys("100");
		driver.findElement(sgtemp).sendKeys("80");
		driver.findElement(phval).sendKeys("14");
		
		driver.findElement(heattyp).click();
		driver.findElement(heattype).click();
		driver.findElement(heatmin).sendKeys("10");
		driver.findElement(heatmax).sendKeys("60");
		
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
		
		driver.findElement(flashpointc).click();
		Thread.sleep(4000);
		driver.findElement(flashpointdg).click();
		driver.findElement(flashpoint).sendKeys("30");
		
		driver.findElement(adrcode).sendKeys("code 334");
		driver.findElement(adrno).sendKeys("3434");
		driver.findElement(emsImdg).sendKeys("Ems Imdg");
		
		driver.findElement(unno).sendKeys("554");
		driver.findElement(pkgrp).sendKeys("A Group");
		driver.findElement(hcdg).click();
		driver.findElement(marinepol).click();
		driver.findElement(showsp386).click();
		Thread.sleep(5000);
		driver.findElement(sp386cbtn).click();
		
		driver.findElement(imdg).click();
		Thread.sleep(2000);
		driver.findElement(adr).click();
		driver.findElement(dot).click();
		driver.findElement(inertAtmReq).click();
		driver.findElement(lachrymator).click();
		driver.findElement(idtf).click();
		driver.findElement(idtfRefNo).sendKeys("655");
		driver.findElement(corrosiveToMetal).click();
		
		driver.findElement(msdsValiddt).click();
		Thread.sleep(2000);
		driver.findElement(msdsValiddtf).click();
		driver.findElement(msdsValiddtf2).click();
		driver.findElement(msdsValiddtf3).click();
		driver.findElement(msdsValiddtf4).click();
		driver.findElement(msdsValiddtf5).click();
		
		driver.findElement(msdsValiddtt).click();
		Thread.sleep(2000);
		driver.findElement(msdsValiddto2).click();
		driver.findElement(msdsValiddto3).click();
		driver.findElement(msdsValiddto4).click();
		driver.findElement(msdsValiddto5).click();
		driver.findElement(msdsValiddto6).click();
		Thread.sleep(2000);
		//driver.findElement(customer).click();
		driver.findElement(synonym).sendKeys("Test Synonym");
		driver.findElement(synadd).click();
		
		driver.findElement(safetyTempCtrl).click();
		Thread.sleep(2000);
		driver.findElement(prodCtrl).sendKeys("100");
		driver.findElement(prodEmerCtrl).sendKeys("150");
		driver.findElement(saptCtrl).sendKeys("82");
		driver.findElement(sadtCtrl).sendKeys("64");
		
		Thread.sleep(2000);
		
//		driver.findElement(qualityTempCtrl).click();
//		
//		Thread.sleep(2000);
//		objCU.dropDownClick(driver, lowestTemp1, "-9");
//		Thread.sleep(2000);
//		//objCU.dropDownClick(driver, maxTemp1, " -9");
//		objCU.dropDownEnter(driver, maxTemp1,objCU.getCellData("Products","Nominal Temp Max"),maxTemp2);
//		Thread.sleep(2000);
//		//objCU.dropDownClick(driver, fstWarLow1, "-8");
//		objCU.dropDownEnter(driver, fstWarLow1,objCU.getCellData("Products","First Warning Temp Min"),fstWarLow2);
//		Thread.sleep(2000);
//		//objCU.dropDownClick(driver, fstWarmax1, "-3");
//		objCU.dropDownEnter(driver, fstWarmax1,objCU.getCellData("Products","First Warning Temp Max"),fstWarmax2);
//		Thread.sleep(2000);
//		//objCU.dropDownClick(driver, secwarlow1, "-7");
//		objCU.dropDownEnter(driver, secwarlow1,objCU.getCellData("Products","Second Warning Temp Min"),secwarlow2);
//		Thread.sleep(2000);
//		//objCU.dropDownClick(driver, secwarmax1, "-2");
//		objCU.dropDownEnter(driver, secwarmax1,objCU.getCellData("Products","Second Warning Temp Max"),secwarmax2);
//		Thread.sleep(2000);
//		//objCU.dropDownClick(driver, criticTempLow1, "-10");
//		objCU.dropDownEnter(driver, criticTempLow1,objCU.getCellData("Products","Critical Temp Low"),criticTempLow2);
//		Thread.sleep(2000);
//		//objCU.dropDownClick(driver, criticTempMax1, "-1");
//		objCU.dropDownEnter(driver, criticTempMax1,objCU.getCellData("Products","Critical Temp Max"),criticTempMax2);
//		Thread.sleep(2000);
//		//objCU.dropDownClick(driver, loadTempMin1, "-6");
//		objCU.dropDownEnter(driver, loadTempMin1,objCU.getCellData("Products","Loading Temp Min"),loadTempMin2);
//		Thread.sleep(2000);
//		//objCU.dropDownClick(driver, loadTempMax1, "-2");
//		objCU.dropDownEnter(driver, loadTempMax1,objCU.getCellData("Products","Loading Temp Max"),loadTempMax2);
//		Thread.sleep(2000);
//		//objCU.dropDownClick(driver, disTempLow1, "-5");
//		objCU.dropDownEnter(driver, disTempLow1,objCU.getCellData("Products","Discharge Temp Min"),disTempLow2);
//		Thread.sleep(2000);
//		//objCU.dropDownClick(driver, disTempMax1, "-2");
//		objCU.dropDownEnter(driver, disTempMax1,objCU.getCellData("Products","Discharge Temp Max"),disTempMax2);
//		
		
		
		driver.findElement(productNote).sendKeys("Test note");
		driver.findElement(qssheNote).sendKeys("Test Qsshe Notes");
		driver.findElement(prodSoluInWater).click();
		driver.findElement(prodSoluInSolv).click();
		
		
		
		
		//driver.findElement(shipname).sendKeys("Test Ship");
				
	}
	public void clickcreateprod() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(create).click();	
	}
	public void addproducts(String sg,String s,String tnktp,String snm,String pa, String csnm) throws Exception
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
		driver.findElement(prodFilter).click();
		Thread.sleep(2000);
	}
	
	public void editProduct() throws Exception
	{
		SoftAssert softAssert=new SoftAssert();
		driver.findElement(editbtn).click();
		Thread.sleep(2000);
		driver.findElement(heatmin).sendKeys("45");
		driver.findElement(heatmax).sendKeys("125");
		driver.findElement(productNote).sendKeys("Test note new edited");
		driver.findElement(qssheNote).sendKeys("Edited Qsshe Notes");
		
//		boolean abc= driver.findElement(By.xpath("")).isDisplayed();
//		Assert.assertTrue(abc," Element is not displayed");	
		
		String acttext =driver.findElement(prodappearance).getAttribute("value");
		String excptText = "Test Appearance 1";
		softAssert.assertEquals(acttext, excptText, "Field Data Mismatched");
		
		
		
		driver.findElement(updatebtn).click();
		Thread.sleep(2000);
		softAssert.assertAll();
	}
	public void deleteproduct() throws Exception
	{
		
		driver.findElement(deletebtn).click();
		Thread.sleep(4000);
		driver.findElement(deleteconfirm).click();
	}
}
