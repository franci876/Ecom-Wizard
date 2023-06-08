package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import utilities.CommonUtilities;

public class NotificationPage 
{
	SoftAssert softAssert = new SoftAssert();
	public	WebDriver driver;
	CommonUtilities	xcl = new CommonUtilities();	    
		    public NotificationPage(WebDriver driver)
		    {
		        this.driver = driver;
		        
		    }
		    By notificationIcon =By.cssSelector(".anticon-bell > svg");
		    By markread = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[1]/a");
		    By notiMsg = By.xpath("//*[@id=\"notifi-messages--tab\"]");
		    By warningMsg = By.xpath("//*[@id=\"notifi-warnings--tab\"]");
		    By errorMsg = By.xpath("//*[@id=\"notifi-errors--tab\"]");
		    
		    public void notifications() throws Exception
		    {
		    	Thread.sleep(2000);
		    	driver.findElement(notificationIcon).click();
		    	Allure.step("Notification icon is clicked");
		    	//verify page
		    	String acttext =driver.getCurrentUrl();
				String excptText = "https://ecompartner.digitalmesh.co.in/partner/notifications";
				softAssert.assertEquals(acttext, excptText, "Actual and expected values are different");
				Allure.step("Verified notifications page");
				softAssert.assertAll();
				
				Thread.sleep(2000);
				driver.findElement(notiMsg).click();
				Allure.step("Clicked on notification messages tab");
				driver.findElement(markread).click();
				Allure.step("Clicked on mark all as read button");

				
				Thread.sleep(2000);
				driver.findElement(warningMsg).click();
				Allure.step("Clicked on warning messages tab");
				
				Thread.sleep(2000);
				driver.findElement(errorMsg).click();
				Allure.step("Clicked on error messages tab");
		    }
}
