package utilities;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base 
{
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver initialize_driver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		tdriver.set(driver);
		return getDriver();
	}
	
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
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	
	public void registrationTest()
	{
		throw new SkipException("Skipping this Test");
	}
	@AfterTest
	public void aftertest()
	{
		driver.quit();
	}
	

}
