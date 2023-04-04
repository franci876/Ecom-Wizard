package testCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilities.CommonUtilities;

public class testsmples {
	CommonUtilities cnj;
	
	public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
   // public XSSFRow row = null;
    public XSSFCell cell = null;
    public FileOutputStream fos = null;
 
	 String filePath = System.getProperty("user.dir")+"\\src\\DataFile\\";
	 String fileName = filePath+"TestData.xlsx";
//	 String historyfilePath = System.getProperty("user.dir")+"\\src\\recordHistory\\";
//	 String hfileName = historyfilePath+"recordHistoryXL.xlsx";
	
	 
	 public static void main(String[] args) {
		 testsmples obj = new testsmples();
		 obj.setCellData("Sheetd5", "first nam", "jibinjj");
		 
		 
		CommonUtilities cnj =new CommonUtilities();
		cnj.setCellDataLC("Login","Name" ,"abcd");	
	 }
	public void setCellData(String sheetName, String clnHeader, String value)
    {
	
        try
        {
            int col_Num = -1;
            
            
        	fis = new FileInputStream(fileName);
    		
            
			workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
 if(sheet==null) {
	 
 sheet = workbook.createSheet(sheetName);
 }
            XSSFRow row = sheet.getRow(0);
            System.out.println(sheet.getLastRowNum());
            if (row==null) {
            	Row header = sheet.createRow(0);
            	Cell headerCell = header.createCell(0);
            }
            row = sheet.getRow(0);
            XSSFRow row1 = sheet.getRow(1);
            Row r = sheet.getRow(0);
            System.out.println(r);
            int maxCell=  r.getLastCellNum();
            col_Num = maxCell;
            
            
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(clnHeader))
                {
                    col_Num = i;
                }
                
                	 
             
            }
           
            sheet.autoSizeColumn(col_Num);
            row = sheet.getRow(0);
        
            
            if(row.getCell(0).getStringCellValue().isEmpty()) {
            	System.out.println("first cell is null");
            	cell = row.getCell(0);
            	 cell.setCellValue(clnHeader);
            	 col_Num = 0;
            }
            else {
                cell = row.createCell(col_Num);
                
               
            cell.setCellValue(clnHeader);
            }
            int lastRowValue =0;
            System.out.println("last row"+sheet.getLastRowNum());
         //   XSSFCell cell1 = row1.createCell(col_Num);
          //  cell1.setCellValue(value);
            for (int j = 0; j <= sheet.getLastRowNum(); j++) {
            	 XSSFRow rowj = sheet.getRow(j);
                if (rowj.getCell(col_Num)==null)
                {
                	System.out.println("test");
                	System.out.println(j);
                	
                    XSSFCell cellj = rowj.createCell(col_Num);
                    
                    
                    cellj.setCellValue(value);
                	 break;
                }
                  
                lastRowValue =j;
             
            }

            if (lastRowValue == sheet.getLastRowNum()) {
            	
                System.out.println("test2");
               // XSSFRow rowjn = sheet.getRow(j+1);
                Row lastRow = sheet.createRow(lastRowValue+1);
                Cell celljn = lastRow.createCell(col_Num);
                
                
                celljn.setCellValue(value);
            }
 
            fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
            workbook.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            
        }
      
    }
}
