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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilities {

	
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

//    public String dropdownmethod(String a, String b)
//    {
//		
//		WebDriver driver;
//		
//		By strid = By.cssSelector("strid");
//		By straid= By.xpath("straid");
//		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("strid")));
//		WebElement element = driver.findElement(By.cssSelector("strid"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500); 
//		
//		driver.findElement(strid).click();;
//		Thread.sleep(4000);
//		driver.findElement(straid).click();
//    	return;
//    }
    
}
	
	
	
