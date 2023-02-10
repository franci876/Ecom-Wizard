package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utilities.CommonUtilities;


public class Login
{
	WebDriver driver;
	
    String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";

    //Call read file method of the class to read data

    
    CommonUtilities	xcl = new CommonUtilities();
	@BeforeTest
		
	public void beforetest() throws IOException
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		FileReader fr=new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\data\\data.properties");
		Properties p =new Properties();
	    

		p.load(fr);
		//System.out.println(p.getProperty("URL"));
		
		driver.get(p.getProperty("URL"));
			  
	}
	
	@Test
	public void loginoperation() throws InterruptedException, IOException
	{

		LoginPage page = new LoginPage(driver);
						
		page.login(xcl.getCellData("Login","User Name"), xcl.getCellData("Login","Password"));		
  				
	}
	
	@AfterTest
	public void aftertest()
	{
		driver.quit();
	}
	

}
