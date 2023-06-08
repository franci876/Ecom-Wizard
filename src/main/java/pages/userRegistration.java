package pages;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class userRegistration
{
	public	WebDriver driver;
	String strvalue1;
	String strvalue;
	String refreshbtn;
	SoftAssert softAssert = new SoftAssert();
	String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO\\";
	String fileName = filePath+"TestData.xlsx";
	
	CommonUtilities	cu = new CommonUtilities();
	public userRegistration(WebDriver driver)
		    {
		        this.driver = driver;
		        
		    }
		    By registerLink =By.xpath("/html/body/div[1]/div/form/div/div/div[2]/div/div/p[2]/a");
		    By firstName =By.xpath("//input[@name='first_name']");
		    By lastName =By.xpath("//input[@name='last_name']");
		    By email =By.xpath("//input[@name='email']");
		    By countrydp =By.xpath("//select[@name='country_id']");
		    By countrydrp =By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/form/div[1]/div/div[4]/div/select/option[103]");
		    By phoneno =By.xpath("//input[@name='phone']");
		    By companyName =By.xpath("//input[@name='company_name']");
		    By privacyPol =By.cssSelector(".ant-checkbox-input");
		    By refreshbutn =By.xpath("//div[2]/button/span");
		    By regBtn =By.xpath("//button[contains(.,'Register')]");
		    
		    By welcom=By.xpath("//div/div/div/div[2]");
		    
		    By firstmail = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[1]/div/div/div[1]/div[2]/div");
		   // By emailtextbox= By.xpath("//*[@id=\"navbar\"]/div/div[3]/form/div/input");
		    By logo =By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/form/div/div[2]/div/div/div[2]/div/input");
		    By logosel =By.xpath("//input[@name=\'logo\']");
		    By logoUpload=By.xpath("");
		    By address1 =By.name("address1");
		    By address2 =By.name("address2");
		    By city =By.name("city");
		    By state =By.name("state");
		    By zipcode =By.name("zipcode");
		    By website =By.name("website");
		    By policylink =By.name("policy_link");
		    By taxid =By.name("tax_id");
		    By nextbtn1 =By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/button");
		    By readterms =By.xpath("//*[@id=\"readterms\"]");
		    By nextbtn2 =By.xpath("/html/body/div[1]/div/div[2]/div/div[5]/button[2]");
		    By chooseplanmonth =By.xpath("//button[contains(.,'6 months')]");
		    By chooseplan =By.xpath("//a[contains(text(),'Choose')]");
		    By nextbtn3 =By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/button[2]");
		    By cardno =By.id("credit-card-number");
		    By year= By.xpath("//input[@id='expiration']");
		    By cvv =By.cssSelector("#cvv");
		    By submit =By.id("submit-button");

		    By verifymail =By.linkText("Verify Email");
		    By createps =By.cssSelector("td:nth-child(1) tr:nth-child(1) table:nth-child(1) a:nth-child(1)");
		    
		    By passwrd =By.name("password");
		    By cnfpasswrd =By.cssSelector(".mt-3 > input");
		    By save =By.xpath("//button[contains(.,'Save')]");
		    
		    //for verification process
		    By profileIcon =By.xpath("//span[contains(.,\'DM Test\')]");
		    By profile =By.linkText("Profile");
		    //By editProfile =By.cssSelector("p:nth-child(2)");
		    
		    By fstName =By.name("first_name");
		    By lstName =By.name("last_name");
		    By vmailid =By.name("email");
		    By cmpnme =By.name("company_name");
		    By numf =By.name("phone");
		   
		    By cmpm =By.name("company_name");
		    By tmco =By.cssSelector(".card-title");
		    By subpln =By.cssSelector(".col-12 > h4");
		    By pspg =By.cssSelector(".h4");
		   // By payh = By.className("card-title.mb-3");
		    By payh = By.cssSelector(".card-title");
		    
		    
		    By firstNameValidMsg = By.cssSelector(".col-12:nth-child(1) > .text-danger");
		    By secondNameValidMsg = By.cssSelector(".col-12:nth-child(2) > .text-danger");
		    By emailValidMsg = By.cssSelector(".col-12:nth-child(3) > .text-danger");
		    By countryValidMsg = By.cssSelector(".col-12:nth-child(4) > .text-danger");
		    By phoneValidMsg = By.cssSelector(".col-12:nth-child(5) > .text-danger");
		    By companyNameValidMSg = By.cssSelector(".col-12:nth-child(6) > .text-danger");
		    By partnerPolicyValidMSg = By.cssSelector(".col-12:nth-child(7) > .text-danger");
		    
		    By emailValidationVerify = By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/span");
		    By logoErrorMsg =By.xpath("//*[@id=\"companyinfodetails\"]/div/div[2]/div/div/div[2]/span");
		    
		    By choosePlanbtn1 = By.cssSelector(".slick-slide:nth-child(1) .btn");
		    By choosePlanbtn2 = By.cssSelector(".slick-slide:nth-child(1) .btn");
		    By choosePlanbtn3 = By.cssSelector(".slick-slide:nth-child(1) .btn");
		    By choosePlanbtn4 = By.cssSelector(".slick-slide:nth-child(1) .btn");
		    By selectPlan =By.cssSelector(".slick-slide:nth-child(2) .btn");
		    By selectedPlanColor =By.xpath("//a[contains(text(),'Selected')]");
		    
		    public void tempMailVerification() throws Exception
		    {
		    	Thread.sleep(4000);
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		    	driver.get("https://maildrop.cc/"); 
		    	Thread.sleep(3000);
		    	WebElement emailtextbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".border-stone-400")));
		    
		    	// WebElement emailtextbox=driver.findElement(By.cssSelector(".border-stone-400"));
		    	emailtextbox.sendKeys("digitalmesh"+RandomStringUtils.randomAlphanumeric(6));
		    	 WebElement viewmail =driver.findElement(By.xpath("//span[contains(.,'View Mailbox')]"));
		    	 viewmail.click();
		    	 //refreshbtn.click();
		    	// WebElement mailidr =driver.findElement(By.xpath(""));
		    	 
		    	  strvalue1= emailtextbox.getAttribute("value");
		    	  strvalue =strvalue1+"@maildrop.cc";
		    	  
		    	 System.out.print("Text Value"+strvalue+"@ maildrop.cc");
		    	 cu.writeToExcels("Login","Partner_Email",strvalue);
		    	 cu.writeToExcels("PartnerDetails","Partner_Email",strvalue);
		    	// cu.setCellData("UserRegistration", "Email", 0, strvalue);
		    	 
		    }
		    //to verify validation messages
		    public void verifyMandatoryFieldsMsg()
		    {
		    	driver.findElement(regBtn).click();
		    	Allure.step("Clicked on register button to verify mandatory fields");
		    	
		    	// verify validation messages for first name
		    	String Actfname ="First Name cannot be blank!";
		    	String Expfname =driver.findElement(firstNameValidMsg).getText();
		    	softAssert.assertEquals(Actfname, Expfname, "Field Data Mismatched");
				Allure.step("Verified First name validation Message");
				// verify validation messages for last name
				String Actlname ="Last Name cannot be blank!";
		    	String Explname =driver.findElement(secondNameValidMsg).getText();
		    	softAssert.assertEquals(Actlname, Explname, "Field Data Mismatched");
				Allure.step("Verified Last name validation Message");
				// verify validation messages for email
				String ActEmail ="Email cannot be blank!";
		    	String ExpEmail =driver.findElement(emailValidMsg).getText();
		    	softAssert.assertEquals(ActEmail, ExpEmail, "Field Data Mismatched");
				Allure.step("Verified email validation Message");
				// verify validation messages for country
				String ActCountry ="Country cannot be blank!";
		    	String ExpCountry =driver.findElement(countryValidMsg).getText();
		    	softAssert.assertEquals(ActCountry, ExpCountry, "Field Data Mismatched");
				Allure.step("Verified country validation Message");
				// verify validation messages for phone
				String ActPhone ="Phone cannot be blank!";
		    	String ExpPhone =driver.findElement(phoneValidMsg).getText();
		    	softAssert.assertEquals(ActPhone, ExpPhone, "Field Data Mismatched");
				Allure.step("Verified phone number validation Message");
				// verify validation messages for company
				String ActCompany ="Company cannot be blank!";
		    	String ExpCompany =driver.findElement(companyNameValidMSg).getText();
		    	softAssert.assertEquals(ActCompany, ExpCompany, "Field Data Mismatched");
				Allure.step("Verified Company name validation Message");
				// verify validation messages for company
				String ActPartnerPolicy ="Please accept the partner policy!";
		    	String ExpPartnerPolicy =driver.findElement(partnerPolicyValidMSg).getText();
		    	softAssert.assertEquals(ActPartnerPolicy, ExpPartnerPolicy, "Field Data Mismatched");
				Allure.step("Verified partner policy validation Message");
				
		    }
		    //test case to register with existing email 
		    //to test is possible to register with existing customer
		    public void registerWithExistingEmail(String fstNm, String lstNm)
		    {
		    	// Get the current window handle
		    	String mainWindow = driver.getWindowHandle();

		    	// Open a new tab
		    	((JavascriptExecutor) driver).executeScript("window.open();");
		    	for (String windowHandle : driver.getWindowHandles()) {
		    	    if (!windowHandle.equals(mainWindow)) {
		    	        driver.switchTo().window(windowHandle);
		    	        break;
		    	    }
		    	}
		    	driver.get("https://ecompartner.digitalmesh.co.in/");

		    	driver.findElement(registerLink).click();
		    	Allure.step("Clicked on registration link");
		    	driver.findElement(firstName).sendKeys(fstNm);
		    	Allure.step("Entered first name");
		    	driver.findElement(lastName).sendKeys(lstNm);
		    	Allure.step("Entered second name");
		    	driver.findElement(email).sendKeys("davi@maildrop.cc");
		    	Allure.step("Email id is entered");
		    	driver.findElement(countrydp).click();
		    	Allure.step("Clicked on country dropdown");
		    	
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(countrydrp));
		    //	Thread.sleep(1000);
		    	
		    	
		    	
		    	driver.findElement(countrydrp).click();
		    	Allure.step("Country name is selected from dropdown");
		    	String nmbr=RandomStringUtils.randomNumeric(10);
		    	driver.findElement(phoneno).sendKeys(nmbr);
		    	Allure.step("Phone number is entered");
		    	cu.writeToExcels("PartnerDetails", "PhoneNmbr", nmbr);
		    	
		    	String cmpnynm=RandomStringUtils.randomAlphabetic(5);
		    	 driver.findElement(companyName).sendKeys(cmpnynm);
		    	Allure.step("Company name is entered");
		    	cu.writeToExcels("PartnerDetails","Company_Name",cmpnynm);
		    	
		    	driver.findElement(privacyPol).click();
		    	Allure.step("Privacy policy is selected");
		    	driver.findElement(regBtn).click();
		    	Allure.step("Clicked on register button");
		    	
		    	String ActEmailValidationMsg = driver.findElement(emailValidationVerify).getText();
		    	String ExpEmailValidMsg = "The email has already been taken.";
		    	softAssert.assertEquals(ActEmailValidationMsg, ExpEmailValidMsg, "Field Data Mismatched");
				Allure.step("Verified not possible to login with registered email id");
		    }
		    
		    public void registerWithoutPrivacyPolicy(String fstNm, String lstNm, String emailid) throws Exception
		    {

		    	// Get the current window handle
		    	String mainWindow = driver.getWindowHandle();

		    	// Open a new tab
		    	((JavascriptExecutor) driver).executeScript("window.open();");
		    	for (String windowHandle : driver.getWindowHandles()) {
		    	    if (!windowHandle.equals(mainWindow)) {
		    	        driver.switchTo().window(windowHandle);
		    	        break;
		    	    }
		    	}
		    	driver.get("https://ecompartner.digitalmesh.co.in/");

		    	driver.findElement(registerLink).click();
		    	Allure.step("Clicked on registration link");
		    	driver.findElement(firstName).sendKeys(fstNm);
		    	Allure.step("Entered first name");
		    	driver.findElement(lastName).sendKeys(lstNm);
		    	Allure.step("Entered second name");
		    	driver.findElement(email).sendKeys(emailid);
		    	Allure.step("Email id is entered");
		    	driver.findElement(countrydp).click();
		    	Allure.step("Clicked on country dropdown");
		    	
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(countrydrp));
		    //	Thread.sleep(1000);
		    	
		    	//select country from dropdown by typing the letters corresponding to country name
		    	driver.findElement(countrydp).sendKeys("India");
		    	Allure.step("Country name is selected");
//		    	driver.findElement(countrydrp).click();
//		    	Allure.step("Country name is selected from dropdown");
		    	String nmbr=RandomStringUtils.randomNumeric(10);
		    	driver.findElement(phoneno).sendKeys(nmbr);
		    	Allure.step("Phone number is entered");
		    	cu.writeToExcels("PartnerDetails", "PhoneNmbr", nmbr);
		    	
		    	String cmpnynm=RandomStringUtils.randomAlphabetic(5);
		    	 driver.findElement(companyName).sendKeys(cmpnynm);
		    	Allure.step("Company name is entered");
		    	cu.writeToExcels("PartnerDetails","Company_Name",cmpnynm);
		    	
		    	//driver.findElement(privacyPol).click();
		    	
		    	driver.findElement(regBtn).click();
		    	Allure.step("Clicked on register button");
		    	
		    	Thread.sleep(2500);
		    	String Actwel =driver.getTitle();
		    	String Expwel ="My E-com Wizard";
		    	softAssert.assertEquals(Actwel, Expwel, "Field Data Mismatched");
				Allure.step("Verified Welcome Message");  
		    	
		    	softAssert.assertAll();
		    }
		    //test to register with incorrect email address
		    public void registerWithIncorrectEmailId(String fstNm, String lstNm, String emailid) throws Exception
		    {
		    	// Get the current window handle
		    	String mainWindow = driver.getWindowHandle();

		    	// Open a new tab
		    	((JavascriptExecutor) driver).executeScript("window.open();");
		    	for (String windowHandle : driver.getWindowHandles()) {
		    	    if (!windowHandle.equals(mainWindow)) {
		    	        driver.switchTo().window(windowHandle);
		    	        break;
		    	    }
		    	}
		    	driver.get("https://ecompartner.digitalmesh.co.in/");

		    	driver.findElement(registerLink).click();
		    	Allure.step("Clicked on registration link");
		    	driver.findElement(firstName).sendKeys(fstNm);
		    	Allure.step("Entered first name");
		    	driver.findElement(lastName).sendKeys(lstNm);
		    	Allure.step("Entered second name");
		    	driver.findElement(email).sendKeys(emailid);
		    	Allure.step("Email id is entered");
		    	driver.findElement(countrydp).click();
		    	Allure.step("Clicked on country dropdown");
		    	
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(countrydrp));
		    //	Thread.sleep(1000);
		    	driver.findElement(countrydrp).click();
		    	Allure.step("Country name is selected from dropdown");
		    	String nmbr=RandomStringUtils.randomNumeric(10);
		    	driver.findElement(phoneno).sendKeys(nmbr);
		    	Allure.step("Phone number is entered");
		    	cu.writeToExcels("PartnerDetails", "PhoneNmbr", nmbr);
		    	
		    	String cmpnynm=RandomStringUtils.randomAlphabetic(5);
		    	 driver.findElement(companyName).sendKeys(cmpnynm);
		    	Allure.step("Company name is entered");
		    	cu.writeToExcels("PartnerDetails","Company_Name",cmpnynm);
		    	
		    	driver.findElement(privacyPol).click();
		    	Allure.step("Privacy policy is selected");
		    	driver.findElement(regBtn).click();
		    	Allure.step("Clicked on register button");
		    	
		    	Thread.sleep(2500);
		    	String Actwel =driver.getTitle();
		    	String Expwel ="My E-com Wizard";
		    	softAssert.assertEquals(Actwel, Expwel, "Field Data Mismatched");
				Allure.step("Verified Welcome Message");  
		    	
		    	softAssert.assertAll();
		    }
		    
	    
		    public void register(String fstNm, String lstNm, String emailid) throws Exception
		    {

		    	// Get the current window handle
		    	String mainWindow = driver.getWindowHandle();

		    	// Open a new tab
		    	((JavascriptExecutor) driver).executeScript("window.open();");
		    	for (String windowHandle : driver.getWindowHandles()) {
		    	    if (!windowHandle.equals(mainWindow)) {
		    	        driver.switchTo().window(windowHandle);
		    	        break;
		    	    }
		    	}
		    	driver.get("https://ecompartner.digitalmesh.co.in/");

		    	driver.findElement(registerLink).click();
		    	Allure.step("Clicked on registration link");
		    	driver.findElement(firstName).sendKeys(fstNm);
		    	Allure.step("Entered first name");
		    	driver.findElement(lastName).sendKeys(lstNm);
		    	Allure.step("Entered second name");
		    	driver.findElement(email).sendKeys(emailid);
		    	Allure.step("Email id is entered");
		    	driver.findElement(countrydp).click();
		    	Allure.step("Clicked on country dropdown");
		    	
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(countrydrp));
		    //	Thread.sleep(1000);
		    	driver.findElement(countrydrp).click();
		    	Allure.step("Country name is selected from dropdown");
		    	String nmbr=RandomStringUtils.randomNumeric(10);
		    	driver.findElement(phoneno).sendKeys(nmbr);
		    	Allure.step("Phone number is entered");
		    	cu.writeToExcels("PartnerDetails", "PhoneNmbr", nmbr);
		    	
		    	String cmpnynm=RandomStringUtils.randomAlphabetic(5);
		    	 driver.findElement(companyName).sendKeys(cmpnynm);
		    	Allure.step("Company name is entered");
		    	cu.writeToExcels("PartnerDetails","Company_Name",cmpnynm);
		    	
		    	driver.findElement(privacyPol).click();
		    	Allure.step("Privacy policy is selected");
		    	driver.findElement(regBtn).click();
		    	Allure.step("Clicked on register button");
		    	
		    	Thread.sleep(2500);
		    	String Actwel =driver.getTitle();
		    	String Expwel ="My E-com Wizard";
		    	softAssert.assertEquals(Actwel, Expwel, "Field Data Mismatched");
				Allure.step("Verified Welcome Message");  
		    	
		    	softAssert.assertAll();
		    }
		    public void Entercompanydetails() throws Exception
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	//Welcome Message Verification
		    	
		    	// Get the current window handle
		    	String mainWindow = driver.getWindowHandle();

		    	// Open a new tab
		    	
		    	for (String windowHandle : driver.getWindowHandles()) {
		    	    if (!windowHandle.equals(mainWindow)) {
		    	        driver.switchTo().window(windowHandle);
		    	        break;
		    	    }
		    	}
		    	
		    	//driver.switchTo().window(mainWindow);
		    	Thread.sleep(10000);
		    	driver.findElement(refreshbutn).click();
		    	//driver.findElement(firstmail).click();
		    	Thread.sleep(6000);
		    	int sizej = driver.findElements(By.tagName("iframe")).size();
		    	System.out.println(sizej);
		    	Thread.sleep(4000);
		    	driver.switchTo().frame(0);
		    	driver.findElement(verifymail).click();
		    	Thread.sleep(6000);
		    	driver.switchTo().defaultContent();
		    	
	    	   ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    	    driver.switchTo().window(tabs2.get(0));
		    	    
		    	    Thread.sleep(3000);
		    	   driver.close();
		    	   Thread.sleep(3000);
		    	   
		    	   ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
		    	   System.out.println(tabs3.size());
		    	    driver.switchTo().window(tabs3.get(1));
		    	   // driver.switchTo().window(tabs2.get(0));
		    	
		    	// Open a new tab
		    	
//		    	WebElement link = driver.findElement(By.linkText("Link Text"));
//
//		        // Use the Actions class to open the link in a new tab
//		        Actions actions = new Actions(driver);
//		        actions.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).perform();
//
//		        // Switch to the new tab
//		        driver.switchTo().window(driver.getWindowHandles().toArray()[1]);
		        
		    	//Thread.sleep(2000);
		    	
		    	String Actcmptitle =driver.getTitle();
			    String Expcmptitle ="My E-com Wizard";
			    softAssert.assertEquals(Actcmptitle, Expcmptitle, "Field Data Mismatched");
				Allure.step("Verified title of company details page"); 
		    	
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/form/div/div[2]/div/div/div[2]/div/input")));
		    	driver.findElement(logo).sendKeys("D:\\dme595\\Downloads\\logo\\hp.jpg");
		    	
		    	
		    	String Actcmp =driver.findElement(cmpm).getAttribute("value");
		    	String Expcmp =cu.getCellData("PartnerDetails","Company_Name");
		    	softAssert.assertEquals(Actcmp, Expcmp, "Field Data Mismatched");
				Allure.step("Verified Company Name"); 
				
		    	driver.findElement(address1).sendKeys("Add"+RandomStringUtils.randomAlphabetic(5));
		    	Allure.step("Address one is entered");
		    	driver.findElement(address2).sendKeys("Addrs"+RandomStringUtils.randomAlphabetic(5));
		    	Allure.step("Address two is entered");
		    	driver.findElement(city).sendKeys(RandomStringUtils.randomAlphabetic(5));
		    	Allure.step("City is entered");
		    	driver.findElement(state).sendKeys(RandomStringUtils.randomAlphabetic(5));
		    	Allure.step("State is entered");
		    	driver.findElement(zipcode).sendKeys(RandomStringUtils.randomNumeric(6));
		    	Allure.step("Zipcode is entered");
		    	driver.findElement(website).sendKeys("https://www.digitalmesh.com/");
		    	Allure.step("Website is entered");
		    	driver.findElement(policylink).sendKeys("https://www.digitalmesh.com/policies");
		    	Allure.step("Policy Link is entered");
		    	driver.findElement(taxid).sendKeys(RandomStringUtils.randomNumeric(4));
		    	Allure.step("Tax ID is entered");
		    	driver.findElement(nextbtn1).click();
		    	Allure.step("Next button is clicked");
		    	Thread.sleep(2000);
		    	softAssert.assertAll();
		    }
		    
		    public void EntercompanydetailsWithInvalidLogo() throws Exception
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	//Welcome Message Verification
		    	
		    	// Get the current window handle
		    	String mainWindow = driver.getWindowHandle();

		    	// Open a new tab
		    	
		    	for (String windowHandle : driver.getWindowHandles()) {
		    	    if (!windowHandle.equals(mainWindow)) {
		    	        driver.switchTo().window(windowHandle);
		    	        break;
		    	    }
		    	}
		    	
		    	//driver.switchTo().window(mainWindow);
		    	Thread.sleep(10000);
		    	driver.findElement(refreshbutn).click();
		    	//driver.findElement(firstmail).click();
		    	Thread.sleep(6000);
		    	int sizej = driver.findElements(By.tagName("iframe")).size();
		    	System.out.println(sizej);
		    	Thread.sleep(4000);
		    	driver.switchTo().frame(0);
		    	driver.findElement(verifymail).click();
		    	Thread.sleep(6000);
		    	driver.switchTo().defaultContent();
		    	
	    	   ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    	    driver.switchTo().window(tabs2.get(0));
		    	    
		    	    Thread.sleep(3000);
		    	   driver.close();
		    	   Thread.sleep(3000);
		    	   
		    	   ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
		    	   System.out.println(tabs3.size());
		    	    driver.switchTo().window(tabs3.get(1));
		    	
		    	
		    	String Actcmptitle =driver.getTitle();
			    String Expcmptitle ="My E-com Wizard";
			    softAssert.assertEquals(Actcmptitle, Expcmptitle, "Field Data Mismatched");
				Allure.step("Verified title of company details page"); 
		    	
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/form/div/div[2]/div/div/div[2]/div/input")));
		    	
		    	//verify logo with file type gif
		    	driver.findElement(logo).sendKeys("D:\\dme595\\Downloads\\car\\car-driving-7.gif");
		    	
		    	//verify logo with file type excel
		    	driver.findElement(logo).sendKeys("D:\\dme595\\Downloads\\Salessummery_01-Nov-2022_13-Jan-2023 (2).xls");
		    	
		    	String ActLogoErrMsg =driver.findElement(logoErrorMsg).getText();
		    	String ExpLogoErrMsg = "Please upload file having extensions: .jpeg/.jpg/.png";
		    	softAssert.assertEquals(ActLogoErrMsg, ExpLogoErrMsg, "Field Data Mismatched");
				Allure.step("Verified file upload with .jpeg/.jpg/.png"); 
		    	
		    	
		    	
		    	
		    	String Actcmp =driver.findElement(cmpm).getAttribute("value");
		    	String Expcmp =cu.getCellData("PartnerDetails","Company_Name");
		    	softAssert.assertEquals(Actcmp, Expcmp, "Field Data Mismatched");
				Allure.step("Verified Company Name"); 
				
				driver.findElement(address1).sendKeys("Add"+RandomStringUtils.randomAlphabetic(5));
		    	Allure.step("Address one is entered");
		    	
		    	//verify address fields with more than 150 characters
		    	driver.findElement(address2).sendKeys("Addrs"+RandomStringUtils.randomAlphabetic(200));
		    	Allure.step("Address two is entered");
		    	Thread.sleep(2000);
		    	String address_two = driver.findElement(address2).getAttribute("value");
		    	// Get the length of typed value
				int size = address_two.length();
				// Assert with expected
				if (size == 150) {
					System.out.println("Max character functionality is working fine.");
				}
		 
				else {
					System.out.println("No limit is set for address two.");
				}
		    	//Verify address two is mandatory or not
				//driver.findElement(address2).sendKeys(" ");
		    	
		    	driver.findElement(city).sendKeys(RandomStringUtils.randomAlphabetic(5));
		    	Allure.step("City is entered");
		    	driver.findElement(state).sendKeys(RandomStringUtils.randomAlphabetic(5));
		    	Allure.step("State is entered");
		    	driver.findElement(zipcode).sendKeys(RandomStringUtils.randomNumeric(6));
		    	Allure.step("Zipcode is entered");
		    	driver.findElement(website).sendKeys("https://www.digitalmesh.com/");
		    	Allure.step("Website is entered");
		    	driver.findElement(policylink).sendKeys("https://www.digitalmesh.com/policies");
		    	Allure.step("Policy Link is entered");
		    	driver.findElement(taxid).sendKeys(RandomStringUtils.randomNumeric(4));
		    	Allure.step("Tax ID is entered");
		    	driver.findElement(nextbtn1).click();
		    	Allure.step("Next button is clicked");
		    	Thread.sleep(2000);
		    	softAssert.assertAll();
		    }
		    
		    
		    
		    
		    
		    
		    
//		    public void clickNextBtn() throws InterruptedException
//		    {
//		    	driver.findElement(nextbtn1).click();
//		    	Allure.step("Next button is clicked");
//		    	Thread.sleep(2000);
//		    	softAssert.assertAll();
//		    }
		    public void termsandcon()
		    {
		    	//wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id=\"readterms\"]")));
		    	
		    	//Verify terms and conditions URL
		    	String Acturltc =driver.getCurrentUrl();
		    	String Expurltc="https://ecompartner.digitalmesh.co.in/partner/complete-profile/terms-and-conditions";
		    	softAssert.assertEquals(Acturltc, Expurltc, "Field Data Mismatched");
				Allure.step("Verified terms and conditions URL");
				
				//verify Terms and Conditions Heading
				String Acttxttc=driver.findElement(tmco).getText();
				String Exptxttc="Terms and Conditions";
				softAssert.assertEquals(Acttxttc, Exptxttc, "Field Data Mismatched");
				Allure.step("Verified Terms and Conditions Heading");
		    	
		    	driver.findElement(readterms).click();
		    	Allure.step("Terms and conditions checkbox is selected");
		    	driver.findElement(nextbtn2).click();
		    	Allure.step("Next button is clicked");
		    	softAssert.assertAll();
		    }
		    public void RegWithoutTermsAndCon()
		    {
		    	
		    	
//		    	driver.findElement(readterms).click();
//		    	Allure.step("Terms and conditions checkbox is selected");
		    	driver.findElement(nextbtn2).click();
		    	Allure.step("Next button is clicked");
		    	softAssert.assertAll();
		    }
		    
		    public void subPlans() throws Exception
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	Thread.sleep(2000);
				
				String ActurlsubH =driver.findElement(subpln).getText();
		    	String ExpurlsubH="Choose your plan";
		    	softAssert.assertEquals(ActurlsubH, ExpurlsubH, "Field Data Mismatched");
				Allure.step("Verified Subscription Plan Heading");
				
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'6 months')]")));
		    	driver.findElement(chooseplanmonth).click();
		    	Allure.step("Plan month is selected");
		    	//Thread.sleep(2000);
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Choose')]")));
		    	driver.findElement(chooseplan).click();
		    	Allure.step("Plan is selected");
		    	driver.findElement(nextbtn3).click();
		    	Allure.step("Next button is clicked");
		    	Thread.sleep(6000);
		    	
		    	//Verify title
		    	String Actsubptitle =driver.getTitle();
		    	String Expsubptitle="My E-com Wizard";
		    	softAssert.assertEquals(Actsubptitle, Expsubptitle, "Field Data Mismatched");
				Allure.step("Verified Subscription Payment URL");
		    	softAssert.assertAll();
		    }
		    
		    public void subPlansColourVerificationMouseHover() throws Exception
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	Thread.sleep(2000);
				
		    	//verify colour change while mouse hover on different subscription plan
		    	driver.findElement(choosePlanbtn3).getCssValue("background-color");
		    	
		    	String ActplanColour=driver.findElement(choosePlanbtn3).getCssValue("background-color");
		    	String ExpplanColour="rgba(189, 211, 204, 1)";
		    	Thread.sleep(2500);
		    	softAssert.assertEquals(ActplanColour, ExpplanColour, "Field Data Mismatched");
				Allure.step("Verified colour change while mouse hover on different subscription plans");
				
				
				
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'6 months')]")));
		    	driver.findElement(chooseplanmonth).click();
		    	Allure.step("Plan month is selected");
		    	//Thread.sleep(2000);
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Choose')]")));
		    	driver.findElement(chooseplan).click();
		    	Allure.step("Plan is selected");
		    	driver.findElement(nextbtn3).click();
		    	Allure.step("Next button is clicked");
		    	Thread.sleep(6000);
		    	
		    	
		    }
		    
		    public void subPlansColourChangeAfterSubPlanSelect() throws Exception
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	Thread.sleep(2000);
				
			
				
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'6 months')]")));
		    	driver.findElement(chooseplanmonth).click();
		    	Allure.step("Plan month is selected");
		    	Thread.sleep(2000);
		    	driver.findElement(selectPlan).click();
		    	Allure.step("Subscription plan is selected");
		    	Thread.sleep(2000);
		    	
		    	//Verify Colour Change
		    	String ActselPlanColor =driver.findElement(selectedPlanColor).getCssValue("background-color");
		    	String ExpselPlanColor="rgba(189, 211, 204, 1)";
		    	softAssert.assertEquals(ActselPlanColor, ExpselPlanColor, "Field Data Mismatched");
				Allure.step("Verified colour of subscription plan which is selected");
		    	
		    	
		    	
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Choose')]")));
		    	driver.findElement(chooseplan).click();
		    	Allure.step("Plan is selected");
		    	driver.findElement(nextbtn3).click();
		    	Allure.step("Next button is clicked");
		    	Thread.sleep(6000);
		    	softAssert.assertAll();
		    	
		    }
		    public void subPlansWithoutSelectingPlan() throws Exception
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	Thread.sleep(2000);
				
				String ActurlsubH =driver.findElement(subpln).getText();
		    	String ExpurlsubH="Choose your plan";
		    	softAssert.assertEquals(ActurlsubH, ExpurlsubH, "Field Data Mismatched");
				Allure.step("Verified Subscription Plan Heading");
				
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'6 months')]")));
		    	driver.findElement(chooseplanmonth).click();
		    	Allure.step("Plan month is selected");
		    	//Thread.sleep(2000);
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Choose')]")));
//		    	driver.findElement(chooseplan).click();
		    	Allure.step("Plan is selected");
		    	driver.findElement(nextbtn3).click();
		    	Allure.step("Next button is clicked");
		    	Thread.sleep(6000);
		    	
		    	
		    	
		    	
		    }
		    public void subPayment() throws InterruptedException
		    {
		    	//driver.switchTo().defaultContent();
		    	String ActpayH =driver.findElement(payh).getText();
		    	System.out.println(ActpayH);
		    	String ExppayH ="Make payment";
		    	softAssert.assertEquals(ActpayH, ExppayH, "Field Data Mismatched");
				Allure.step("Verified Subscription Payment Heading");
				driver.switchTo().frame(0);
		    	driver.findElement(cardno).sendKeys("4111 1111 4555 1142");
		    	Allure.step("Credit card number is entered");
		    	driver.switchTo().defaultContent();
		        driver.switchTo().frame(1);
		    	driver.findElement(year).sendKeys("03 / 2030");
		    	Allure.step("Credit card year is entered");
		    	driver.switchTo().defaultContent();
		        driver.switchTo().frame(2);
		    	driver.findElement(cvv).sendKeys("737");
		    	Allure.step("Credit card cvv number is entered");
		    	driver.switchTo().defaultContent();
		    	driver.findElement(submit).click();
		    	Allure.step("Submit button is clicked");
		    	Thread.sleep(10000);
		    	String acttexttitle =driver.getTitle();
				String excptTexttitle ="My E-com Wizard";
				softAssert.assertEquals(acttexttitle, excptTexttitle, "Field Data Mismatched");
		    	softAssert.assertAll();
		    	Allure.step("Verified Registration");
		    }	
		    String pswrd = "Dm"+RandomStringUtils.randomAlphanumeric(4);	
		   public void setPasswrd(String pass) throws Exception
		   {
			   Thread.sleep(4000);
			   driver.get("https://maildrop.cc/");
			   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			   WebElement emailtextbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".border-stone-400")));
			   Thread.sleep(1000);
			   emailtextbox.clear();
			   Thread.sleep(1000);
			    String strvalue2=cu.getCellData("PartnerDetails", "Partner_Email");
		    	 emailtextbox.sendKeys(strvalue2);
		    	 WebElement viewmail =driver.findElement(By.xpath("//span[contains(.,'View Mailbox')]"));
		    	 Thread.sleep(5000);
		    	 viewmail.click();
		    	 Thread.sleep(4000);
		    	 driver.switchTo().frame(0);
			     driver.findElement(createps).click();
			    
			     ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			     driver.switchTo().window(tabs2.get(2));
			     Thread.sleep(4000);
			     //verify Create Password Heading
			     String Actpstxt = driver.findElement(pspg).getText();
			     String Expstxt ="Create Password";
			     softAssert.assertEquals(Actpstxt, Expstxt, "Field Data Mismatched");
				 Allure.step("Verified  Create Password Heading");

				 driver.findElement(passwrd).sendKeys(pswrd+pass);
		    	 driver.findElement(cnfpasswrd).sendKeys(pswrd+pass);
		    	 //to store passwords
		    	 String passRec =null;
		    	 passRec =pswrd+pass;
		    	 cu.writeToExcels("Login", "Patrner_Password_Record",passRec);
		    	 cu.writeToExcels("PartnerDetails", "Patrner_Password_Record",passRec);
		    	 driver.findElement(save).click();
		    	 
		    	 String acttitleL =driver.getTitle();
				 String excptitleL ="My E-com Wizard";
				 softAssert.assertEquals(acttitleL, excptitleL, "Field Data Mismatched");
			     Allure.step("Verified Login page title ");

			     softAssert.assertAll();
		   }
		   public void verifyPartnerAdded()
		   {

			  WebElement element = driver.findElement(By.cssSelector(".ant-btn"));
			  Actions builder = new Actions(driver);
			  builder.moveToElement(element).perform();
			  
			  driver.findElement(profileIcon).click();
			  Allure.step("Profile Icon is clicked");
			  driver.findElement(profile).click();
			  Allure.step("Profile Button is clicked");
		      
		      String ActfnmTxt =driver.findElement(fstName).getAttribute("value");
			  String ExpfnmTxt = cu.getCellData("PartnerDetails","First Name");
			  softAssert.assertEquals(ActfnmTxt, ExpfnmTxt, "Field Data Mismatched");
			  Allure.step("Verified Added Partner First Name");
			  
			  String ActLnmTxt =driver.findElement(lstName).getAttribute("value");
			  String ExpLnmTxt = cu.getCellData("PartnerDetails","Last Name");
			  softAssert.assertEquals(ActLnmTxt, ExpLnmTxt, "Field Data Mismatched");
			  Allure.step("Verified Added Partner Second Name");
		      
			  String ActemailTxt =driver.findElement(vmailid).getAttribute("value");
			  String ExpemailTxt = cu.getCellData("PartnerDetails","Partner_Email");
			  softAssert.assertEquals(ActemailTxt, ExpemailTxt, "Field Data Mismatched");
			  Allure.step("Verified Added Partner Email ID");
			  
			  String Actcmpnm =driver.findElement(cmpnme).getAttribute("value");
		      String Expcmpnm =cu.getCellData("PartnerDetails","Company_Name");
		      softAssert.assertEquals(Actcmpnm, Expcmpnm, "Field Data Mismatched");
		      Allure.step("Verified Company Name"); 
		      
		      String Actnmbr =driver.findElement(numf).getAttribute("value");
		      String Expnmbr =cu.getCellData("PartnerDetails","PhoneNmbr");
		      softAssert.assertEquals(Actnmbr, Expnmbr, "Field Data Mismatched");
		      Allure.step("Verified Company Name"); 
			  
			  softAssert.assertAll();
		   }
}	    

//Gmail -Sign up	

//		    public void gmailSignup()
//		    {
//		    	  driver.get("https://accounts.google.com/signup");
//
//		          WebElement firstName = driver.findElement(By.name("firstName"));
//		          firstName.sendKeys("Digital");
//		          WebElement lastName = driver.findElement(By.name("lastName"));
//		          lastName.sendKeys("Mesh");
//		          WebElement username = driver.findElement(By.name("Username"));
//		          username.sendKeys("digitalmesh"+"");
//		          WebElement password = driver.findElement(By.name("Passwd"));
//		          password.sendKeys("password@123");
//		          WebElement confirmPassword = driver.findElement(By.name("ConfirmPasswd"));
//		          confirmPassword.sendKeys("password@123");
//		          WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
//		          nextButton.click();
//		          // Enter phone number
//		          WebElement phoneNumber = driver.findElement(By.name("phoneNumber"));
//		          phoneNumber.sendKeys("");
//		          // Enter birth date
//		          WebElement birthdate = driver.findElement(By.name("birthDay"));
//		          birthdate.sendKeys("01");
//		          // Select birth month
//		          WebElement birthmonth = driver.findElement(By.name("birthMonth"));
//		          birthmonth.sendKeys("March");
//		          // Enter birth year
//		          WebElement birthyear = driver.findElement(By.name("birthYear"));
//		          birthyear.sendKeys("1990");
//		          // Select gender
//		          WebElement gender = driver.findElement(By.xpath("//label[text()='Gender']//following-sibling::div"));
//		          gender.click();
//		          WebElement genderOption = driver.findElement(By.xpath("//div[text()='Male']"));
//		          genderOption.click();
//		          // Click the "Next" button
//		          WebElement nextButton2 = driver.findElement(By.xpath("//span[text()='Next']"));
//		          nextButton2.click();
//		    }
		    
//Gmail - Login & click on first mail

// 		    public void gmailLogin() throws InterruptedException
//		    {
//		    	driver.get("https://www.gmail.com");
//		    	Thread.sleep(5000);
//		        // Enter email address and click next button
//		        WebElement email = driver.findElement(By.id("identifierId"));
//		        email.sendKeys("digitalmesh2023@gmail.com");
//		        driver.findElement(By.id("identifierNext")).click();
//		        Thread.sleep(2000);
//		        // Enter password and click sign in button
//		        WebElement password = driver.findElement(By.name("Passwd"));
//		        password.sendKeys("francis@1");
//		        driver.findElement(By.id("passwordNext")).click();
//
//		        // Wait for the inbox page to load
//		        WebDriverWait wait = new WebDriverWait(driver, 10);
//		        wait.until(ExpectedConditions.titleContains("Inbox"));
//		        
//		        WebElement firstEmail = driver.findElement(By.xpath("//div[@class='BltHke nH oy8Mbf'][1]"));
//		        firstEmail.click();
//		    }
		    
		


