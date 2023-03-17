package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class logOut 
{
	 
		public	WebDriver driver;
			    public logOut(WebDriver driver)
			    {
			        this.driver = driver;
			    }
			    By profileIcon =By.cssSelector(".user-icon > img:nth-child(1)");
			    By logout =By.xpath("/html/body/div[1]/div/header/nav/div/div/div[2]/div/a[2]");
			    public void logout()
			    {
			    	driver.findElement(profileIcon).click();
			    	Allure.step("Clicked on profile icon");
			    	driver.findElement(logout).click();
			    	Allure.step("Clicked on logout button");
			    }
}
