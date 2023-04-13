package pages;

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
		    	 
		    	 cu.writeToExcel("Login","Partner_Email",strvalue);
		    	// cu.setCellData("UserRegistration", "Email", 0, strvalue);
		    	 
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
		    	driver.findElement(phoneno).sendKeys(RandomStringUtils.randomNumeric(10));
		    	Allure.step("Phone number is entered");
		    	driver.findElement(companyName).sendKeys(RandomStringUtils.randomAlphabetic(5));
		    	Allure.step("Company name is entered");
		    	driver.findElement(privacyPol).click();
		    	Allure.step("Privacy policy is selected");
		    	driver.findElement(regBtn).click();
		    	Allure.step("Clicked on register button");
		    	
		    	driver.switchTo().window(mainWindow);
		    	Thread.sleep(10000);
		    	//driver.findElement(recentmail).click();
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
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/form/div/div[2]/div/div/div[2]/div/input")));
		        driver.findElement(logo).sendKeys("D:\\dme595\\Downloads\\logo\\hp.jpg");
		    	//driver.findElement(logosel).sendKeys("D:\\dme595\\Downloads\\logo\\hp.jpg");
		    	//driver.findElement(logoUpload).click();
		    	//Thread.sleep(2000);
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
		    	//wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id=\"readterms\"]")));
		    	
		    	driver.findElement(readterms).click();
		    	Allure.step("Terms and conditions checkbox is selected");
		    	driver.findElement(nextbtn2).click();
		    	Allure.step("Next button is clicked");
		    	//Thread.sleep(2000);
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
//		    	String acttext =driver.getCurrentUrl();
//				String excptText ="https://ecompartner.digitalmesh.co.in/partner/complete-profile/payment-complete";
//				softAssert.assertEquals(acttext, excptText, "Field Data Mismatched");
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
			   //String strvalue2=cu.getCellData("UserRegistration", "Email");
		    	 emailtextbox.sendKeys(strvalue1);
		    	 WebElement viewmail =driver.findElement(By.xpath("//span[contains(.,'View Mailbox')]"));
		    	 Thread.sleep(5000);
		    	 viewmail.click();
		    	 Thread.sleep(4000);
		    	 driver.switchTo().frame(0);
			     driver.findElement(createps).click();
			    
			     ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			     driver.switchTo().window(tabs2.get(2));
			     Thread.sleep(4000);
		    	 driver.findElement(passwrd).sendKeys(pswrd+pass);
		    	 driver.findElement(cnfpasswrd).sendKeys(pswrd+pass);
		    	 //to store passwords
		    	 String passRec =null;
		    	 passRec =pswrd+pass;
		    	 cu.writeToExcel("Login", "Patrner_Password_Record",passRec);
		    	 driver.findElement(save).click();
		    	
		    	 //To store all email address
		    	 //cu.setRecordtry("UserRegistration","Email",strvalue);
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
		    
		


