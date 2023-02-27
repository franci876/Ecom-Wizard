package utilities;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class CommonUtilities {

	
	private static final boolean True = false;
	public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
 
	 String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO\\";
	 String fileName = filePath+"ExportExcel.xlsx";
    
 
    public String getCellData(String sheetName, String colName)
    {
    	int col_Num = 0;
    	 try {
			fis = new FileInputStream(fileName);
		
        
			workbook = new XSSFWorkbook(fis);         
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            fis.close();
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
 
            row = sheet.getRow(2 - 1);
            cell = row.getCell(col_Num);
 
            if(cell.getCellTypeEnum() == CellType.STRING)
                return cell.getStringCellValue();
            else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
            {
                String cellValue = String.valueOf(cell.getNumericCellValue());
                if(HSSFDateUtil.isCellDateFormatted(cell))
                {
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date date = cell.getDateCellValue();
                    cellValue = df.format(date);
                }
                
                return cellValue;
            }else if(cell.getCellTypeEnum() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
            
        }
    	 
                catch(Exception e)
                {
                   // e.printStackTrace();
                	
                	System.out.println("passed");
                    return "row "+2+" or column "+ col_Num  +" does not exist  in Excel";
                }
                       	 
              
     }
   //To get selection for dropdowns  
    public String dropdownmethod(WebDriver driver, String path) throws Exception
    {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(path)));
		WebElement element = driver.findElement(By.cssSelector(path));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		return path; 	
    }    
    
    
    public void dropDownClick(WebDriver driver, By dropDownName, String strDropDownValue ) throws Exception
	{
    	
    	WebElement element = driver.findElement(dropDownName);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	Thread.sleep(500);
         
		
		driver.findElement(dropDownName).click();;
		Thread.sleep(4000);
		
		String jbn="//li[contains(.,\'"+strDropDownValue+"\')]";
		By dropDownValue= By.xpath(jbn);
		
	    driver.findElement(dropDownValue).click();
	  
		
		
	}
    
    public void dropDownEnter(WebDriver driver, By dropDownName, String strDropDownValue, By strDropDownNameTwo) throws Exception
   	{
       	
       	WebElement element = driver.findElement(dropDownName);
       	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
       	Thread.sleep(500); 
              		
   		driver.findElement(dropDownName).click();
   		Thread.sleep(4000);
   		
   		/*String jbn="//li[contains(.,\'"+strDropDownValue+"\')]";
   		By dropDownValue= By.xpath(jbn);  		
   	    driver.findElement(dropDownValue).click();*/
   		    
   	    
   	    WebElement w= driver.findElement(strDropDownNameTwo);
		Thread.sleep(4000);
		Thread.sleep(4000);
		w.sendKeys(strDropDownValue);
		w.sendKeys(Keys.ENTER);	
   	    
   	}
    public void dropdownVerify(WebDriver driver, WebElement path, String exptText)
    {
    	SoftAssert softAssert=new SoftAssert();
		String acttext =path.getText();
		String excptdText = exptText;
		softAssert.assertEquals(acttext, excptdText, "Field Data Mismatched");
    }
    public void checkboxVerify(WebDriver driver, WebElement path)
    {
    	SoftAssert softAssert=new SoftAssert();
		boolean acText= path.isSelected();
		boolean expText =True;
		softAssert.assertEquals(acText, expText, "Mismatch");
    }
}
	
	
	
