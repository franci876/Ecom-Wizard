package pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class ForgetPasswordPage
{

SoftAssert softAssert = new SoftAssert();
CommonUtilities	cu = new CommonUtilities();
String Lname;
	public	WebDriver driver;
		    public ForgetPasswordPage(WebDriver driver)
		    {
		        this.driver = driver;
		    }
		    By forgetps =By.name("forgot");
		    By email = By.cssSelector("input");
		    By sendlinkbtn = By.cssSelector(".bg-primary-color");
		    By EmailChangePs = By.linkText("Reset Password");
		    By changepass = By.name("password");
		    By changepassconfirm = By.name("confirm_password");
		    By changepassbtn = By.cssSelector(".bg-primary-color");
		    By invalidmsg = By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div/span");
		    By headingPasChange = By.cssSelector(".h4");
		    
		    public void navigateToForgetPage() throws Exception
		    {
		    	Thread.sleep(2000);
		    	driver.findElement(forgetps).click();
		    	Allure.step("Clicked on forget password"); 
		    	//verify forget password page
		    	
		    	String acttitle = "https://ecompartner.digitalmesh.co.in/forgotPassword";
		    	String exptitle =driver.getTitle();
		    	softAssert.assertEquals(acttitle, exptitle, "Field Data Mismatched");
		    	Allure.step("Verified page title "); 
		    }
		    public void forgetpass() throws Exception 
		    {
		    	//invalid email for verification    	
		    	driver.findElement(email).sendKeys("davisdad@sdd.cc");
		    	Allure.step("Invalid Email id is entered ");
		    	
		    	String actmsg = "Please enter a valid email!";
		    	String expmsg =driver.findElement(invalidmsg).getText();
		    	softAssert.assertEquals(actmsg, expmsg, "Field Data Mismatched");
		    	Allure.step("Verified invalid email id is not accepted"); 
		    	
		    	
		    	driver.findElement(email).clear();
		    	//valid email
		    	driver.findElement(email).sendKeys("davi@maildrop.cc");
		    	
		    	Allure.step("Email id is entered ");
		    	driver.findElement(sendlinkbtn).click();
		    	Allure.step("Forgot password button is clicked");
		    	
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
		    	driver.get("https://maildrop.cc/");
		    	
		    	Thread.sleep(3000);
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		    	WebElement emailtextbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".border-stone-400")));
		    
		    	 emailtextbox.sendKeys("davi");
		    	 WebElement viewmail =driver.findElement(By.xpath("//span[contains(.,'View Mailbox')]"));
		    	 Thread.sleep(3000);
		    	 viewmail.click();
		    	 Allure.step("View mail button is clicked");
		    	
		    	 Thread.sleep(4000);
		    	 driver.switchTo().frame(0);
			     driver.findElement(EmailChangePs).click();
			     Thread.sleep(2000);
			     driver.close();
			     ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    	 driver.switchTo().window(tabs2.get(1));
			     

		    	 String acttitle = "Create Password";
			     String exptitle =driver.findElement(headingPasChange).getText();
			     softAssert.assertEquals(acttitle, exptitle, "Field Data Mismatched");
			     Allure.step("Verified page redirection"); 
		    	 
		    	 driver.findElement(changepass).sendKeys("Dav!@1234");
			     driver.findElement(changepassconfirm).sendKeys("Dav!@1234");
			     driver.findElement(changepassbtn).click();
			     cu.writeToExcels("ForgetPassword", "Password_New", "Dav!@1234");

		    }
		    
		    

}
