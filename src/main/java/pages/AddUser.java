package pages;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class AddUser 
{
	
	public	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO\\";
	String fileName = filePath+"ExportExcel.xlsx";
	
	CommonUtilities	cu = new CommonUtilities();
	public AddUser(WebDriver driver)
		    {
		        this.driver = driver;
		        
		    }
		    By account =By.linkText("Account");
		    By manageuser= By.xpath("//a[contains(text(),'Manage Users')]");
		    By useradd =By.xpath("//button[contains(.,'Add User')]");
		    By name =By.id("user-info_name");
		    By email=By.id("user-info_email");
		    By role=By.id("user-info_role");
		    By invitebtn =By.xpath("//*[@id=\"user-info\"]/div[1]/div[2]/div[4]/div/div/div[1]/button/span[2]");
		    By passwrd =By.name("password");
		    By cnfpasswrd =By.cssSelector(".mt-3 > input");
		    By save =By.xpath("//button[contains(.,'Save')]");
		    
		    By vname=By.cssSelector(".user-icon > span");
		    String emailid;
		    String pswrd = "Dm"+RandomStringUtils.randomAlphanumeric(4);	
		   public void adduserinfo() throws Exception
		   {
		       emailid ="digitalmesh"+RandomStringUtils.randomAlphanumeric(6)+"@maildrop.cc";
			   WebDriverWait wait = new WebDriverWait(driver, 10);
			   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(account));
			   Allure.step("After login redirected to WebPartner home page");
			   driver.findElement(account).click();
			   Allure.step("Clicked on account button");
			   driver.findElement(manageuser).click();
			   Allure.step("Clicked on manager user");
			   driver.findElement(useradd).click();
			   Allure.step("Add user button is clicked");
			   //Random Name Generator
			   Faker faker = new Faker();
			   String fullName = faker.name().fullName();
//			   String firstName = faker.name().firstName();
//			   String lastName = faker.name().lastName();
//			   String streetAddress = faker.address().streetAddress();
			   driver.findElement(name).sendKeys(fullName);
			   Allure.step("User name entered is :"+fullName);
			   driver.findElement(email).sendKeys(emailid);
			   Allure.step("Email id entered is :"+emailid);
			   driver.findElement(role).sendKeys("Customer Service"+Keys.ENTER);
			   Allure.step("Role is selected from dropdown");
			   driver.findElement(invitebtn).click();
			   Allure.step("User invite button is clicked");
			   cu.writeToExcel("Add_User","Full_Name", fullName);
			   cu.writeToExcelH("Add_User","Full_Name_History", fullName);
			  // cu.writeToExcel("Add_User","Email_ID", emailid);
			   cu.writeToExcels("Add_User","Email_ID", emailid);
			   
			 
		   }
		   public void tempMailVerification() throws Exception
		    {
		    	Thread.sleep(4000);
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		    	driver.get("https://maildrop.cc/"); 
		    	 Allure.step("Redirected to mailbox to verify email");
		    	Thread.sleep(3000);
		    	WebElement emailtextbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".border-stone-400")));
		    
		    	emailtextbox.sendKeys(emailid);
		    	 WebElement viewmail =driver.findElement(By.xpath("//span[contains(.,'View Mailbox')]"));
		    	 viewmail.click();
		    	 Thread.sleep(4000);
		    	 driver.switchTo().frame(0);
		    	 WebElement verifybtn =driver.findElement(By.xpath("//a[contains(.,'Create your password')]"));
		    	 verifybtn.click();
		    	 Allure.step("Clicked on verify button from email");
		    	
		    }
		   public void setPassword(String pass) throws Exception
		   {
			   Thread.sleep(2000);
			   ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			   
			     driver.switchTo().window(tabs2.get(1));
			     Thread.sleep(2000);
		    	 driver.findElement(passwrd).sendKeys(pswrd+pass);
		    	 Allure.step("Password is entered");
		    	 driver.findElement(cnfpasswrd).sendKeys(pswrd+pass);
		    	 Allure.step("Password is entered again to confirm");
		    	
		    	 //to store passwords
		    	 String passRec =null;
		    	 passRec =pswrd+pass;
		    	 //cu.writeToExcel("Login", "User_Password_Record",passRec);
		    	 cu.writeToExcels("Add_User", "User_Password", passRec);
		    	 //cu.writeToExcelH("Login", "User_Password_Record_History",passRec);
		    	 driver.findElement(save).click();
		    	
		   }
		   public void verifyUser()
		   {
			   String ActnmTxt =driver.findElement(vname).getText();
			   String ExpnmTxt = cu.getCellData("Add_User","Full_Name");
			   softAssert.assertEquals(ActnmTxt, ExpnmTxt, "Field Data Mismatched");
			   Allure.step("Verified Added User Name");  		   
			   
			   
			   String Acturl ="https://ecompartner.digitalmesh.co.in/partner/dashboard";
			   String Expurl=driver.getCurrentUrl();
			   softAssert.assertEquals(Acturl, Expurl, "Field Data Mismatched");
			   Allure.step("Verified URL");  
			  
			   softAssert.assertAll();
		   }

}
