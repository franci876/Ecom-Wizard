package utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class CommonUtilities {

	
	public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
    public FileOutputStream fos = null;
 
	 String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO\\";
	 String fileName = filePath+"ExportExcel.xlsx";
	 String historyfilePath = System.getProperty("user.dir")+"\\src\\recordHistory\\";
	 String hfileName = historyfilePath+"recordHistoryXL.xlsx";
	 
	 public void setRecord(String sheetName, String clnHeader, String value)
	    {
	        try
	        {
	            int col_Num = -1;
	            
	            
	        	fis = new FileInputStream(hfileName);
	    		
	            
				workbook = new XSSFWorkbook(fis);
	            sheet = workbook.getSheet(sheetName);
	            XSSFRow row;
	           
	            row = sheet.getRow(0);
		        
                //cell = row.createCell(col_Num);
                
        
          //  cell.setCellValue(clnHeader);
	            Row r = sheet.getRow(0);
	            int maxCell=  r.getLastCellNum();
	            col_Num = maxCell;
	            int col_Numj =0;
	            int intCLN = 0;;
	            for (int i = 0; i < row.getLastCellNum(); i++) {
	                if (row.getCell(i).getStringCellValue().trim().equals(clnHeader))
	                {
	                    col_Num = i;
	                }
	                
	                	 
	             
	            }
	            for (int i = 0; i < sheet.getLastRowNum(); i++) {
	            	row = sheet.getRow(i);
	            	 //  if(row != null) {
	            		   
	            		   try
	           	        {
	                if (row.getCell(col_Num).getStringCellValue()!=null)
	                {
	                	System.out.println("NEW");
	                    col_Numj = col_Numj+1;
	                     intCLN = col_Numj;
	                }
	           	     }
	           	        catch (Exception exp)
	           	        {
	           	        	System.out.println("null exp ocurred");
	           	        		           	        	col_Numj = col_Numj+1;
	           	        	break;
	           	        }
	                
	            	   } 
	             
	    //        }
	            XSSFRow frow;
				if (col_Numj>=sheet.getLastRowNum()) {
					col_Numj= col_Numj+1;
	            	frow = sheet.createRow(col_Numj);
	            	frow = sheet.getRow(col_Numj);
	            }
	     
	            else {
	            	frow = sheet.getRow(intCLN);	
	            }
				sheet.autoSizeColumn(col_Num);
					cell = frow.createCell(col_Num);
	  				cell.setCellValue(value);
	            

	 
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
	 
	 
	 
	 // try
	 
	 public boolean setRecordtry(String sheetName, String clnHeader, String value)
	    {
	        try
	        {
	            int col_Num = -1;
	            
	        	fis = new FileInputStream(fileName);
	    		
				workbook = new XSSFWorkbook(fis);
	            sheet = workbook.getSheet(sheetName);
	 
	            row = sheet.getRow(0);
	            XSSFRow row1 = sheet.getRow(1);
	            Row r = sheet.getRow(0);
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
	        
	                cell = row.createCell(col_Num);
	                
	                XSSFCell cell1 = row1.createCell(col_Num);
	            cell.setCellValue(clnHeader);
	            
	            int lastRowNum = sheet.getLastRowNum();

	         // Create a new row at the next available index
	         Row newRow = sheet.createRow(lastRowNum + 1);

	         // Get the last cell in the column
	         Cell lastCell = newRow.createCell(col_Num);
	         lastCell.setCellValue(value);

	            fos = new FileOutputStream(fileName);
	            workbook.write(fos);
	            fos.close();
	            workbook.close();
	        }
	        catch (Exception ex)
	        {
	            ex.printStackTrace();
	            return  false;
	        }
	        return true;
	    }
	 
	 
	 public void setCellDataLC(String sheetName, String clnHeader, String value)
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
	            
	            row = sheet.getRow(0);
	            XSSFRow row1 = sheet.getRow(1);
	            Row r = sheet.getRow(0);
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
	        
	                cell = row.createCell(col_Num);
	                
	                XSSFCell cell1 = row1.createCell(col_Num);
	            cell.setCellValue(clnHeader);
	            cell1.setCellValue(value);
	            

	 
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
	 
	 
		 
	    public boolean setCellData(String sheetName, String colName, int rowNum, String value)
	    {
	        try
	        {
	            int col_Num = -1;
	            
//	            File existingXlsx = new File("c:/Java/poi-3.9/test-data/__theproblem/test2.xlsx");
//	            System.out.println("File Exists: " + existingXlsx.exists());
//
//	            Workbook workbook = WorkbookFactory.create(existingXlsx);
	            //XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(fileName));
	          
	           // sheet = wb.getSheet(sheetName);
	            
	        	fis = new FileInputStream(fileName);
	    		
	            
				workbook = new XSSFWorkbook(fis);
	            sheet = workbook.getSheet(sheetName);
	 
	            row = sheet.getRow(0);
	            for (int i = 0; i < row.getLastCellNum(); i++) {
	                if (row.getCell(i).getStringCellValue().trim().equals(colName))
	                {
	                    col_Num = i;
	                }
	                
	            }
	 
	            sheet.autoSizeColumn(col_Num);
	            row = sheet.getRow(rowNum - 1);
	            if(row==null)
	                row = sheet.createRow(rowNum - 1);
	 
	            cell = row.getCell(col_Num);
	            if(cell == null)
	                cell = row.createCell(col_Num);
	 
	            cell.setCellValue(value);
	            
	            //removes other headings
//	            int lastColumn = sheet.getRow(0).getLastCellNum();
//	            Row row	 = sheet.createRow(0);
//	            Cell newcell = row.createCell(lastColumn);
//	            newcell.setCellValue("EMAIL ID");
//	              
//	            int lastColIndex = sheet.getRow(0).getLastCellNum() - 1;
//	            Row row = sheet.getRow(0);
//	            Cell cell = row.getCell(lastColIndex);
//	            String lastCol= cell.getStringCellValue();
//	            cell.setCellValue("Email ID");
	            
	            
//	            int lastCellIndex = row.getLastCellNum();
//	            Cell cell = row.createCell(lastCellIndex);
//	            cell.setCellValue("EmaiL ID");
	 
	            fos = new FileOutputStream(fileName);
	            workbook.write(fos);
	            fos.close();
	            workbook.close();
	        }
	        catch (Exception ex)
	        {
	            ex.printStackTrace();
	            return  false;
	        }
	        return true;
	    }
	    
	    
	    
	 
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
                workbook.close();
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

  
}
	
	
	/*
	
	 String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
	 String fileName = "ExportExcel.xlsx";

	
	
	 public ArrayList<String> readColumnValue(String sheetName, String colName) throws IOException
	 {

         File file =    new File(filePath+"\\"+fileName);
         String cellValue = null;
          int column =-1 ;;
          int i,j;             
      
          
         ArrayList<String> cellval =new ArrayList<String>();
          
          String rowm =null;
          FileInputStream inputStream = new FileInputStream(file);

         Workbook CommonUtilities = null;

         String fileExtensionName = fileName.substring(fileName.indexOf("."));

          if(fileExtensionName.equals(".xlsx")){

            CommonUtilities = new XSSFWorkbook(inputStream);

         }
          else if(fileExtensionName.equals(".xls")){
            CommonUtilities = new HSSFWorkbook(inputStream);
         }

          
          Sheet Login = CommonUtilities.getSheet(sheetName);
                 Row row = Login.getRow(0);
          Sheet cmSheet = CommonUtilities.getSheet(sheetName);
      
         
          int rowCount = cmSheet.getLastRowNum()-cmSheet.getFirstRowNum();
          Row rown;
        for(i=0;i < rowCount+1; i++)
        {
        	
        	for ( j = 0; j < row.getLastCellNum(); j++) {

              cellValue=row.getCell(j).getStringCellValue();
            
              if(cellValue.equals(colName)) 
              {              
            	  column = j;
            	  rown = Login.getRow(i);
            	  rowm = rown.getCell(column).getStringCellValue().toString();
            	  
            	  Sheet sheet = CommonUtilities.getSheet(sheetName);
            	  DataFormatter formatter = new DataFormatter();
            	  String val = formatter.formatCellValue(sheet.getRow(rown).getCell(column));
            	  cellval.add(rowm);
               
                  

              }
             
              
        	}
        	
        }
       
       
        
      for(int a=0;a<cellval.size();a++)
        {
           // System.out.print(cellval.get(a)+" ");
                   
        }
       System.out.println();
       
       
    return cellval;
         
       

     
	 }
	 
		public void readExcel(String sheetName) throws IOException{

	    //Create an object of File class to open xlsx file

	   
		File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook CommonUtilitiesWorkbok = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    	CommonUtilitiesWorkbok = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of HSSFWorkbook class

	    	CommonUtilitiesWorkbok = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet cmSheet = CommonUtilitiesWorkbok.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = cmSheet.getLastRowNum()-cmSheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	  for (int i = 0; i < rowCount+1; i++) {

	    Row row = cmSheet.getRow(i);
      
	        //Create a loop to print cell values in a row
	        

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console
	        
	        	

	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }
	        
	        
	       
	           //int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        
        //iterate over all the row to print the data present in each cell 
	     
                

	        System.out.println();
	    } 

	    }  

	    
	    public String readExcelValue(String sheetName, int rowNum, int cellNum) throws IOException{

			File file =    new File(filePath+"\\"+fileName);

		    //Create an object of FileInputStream class to read excel file

		    FileInputStream inputStream = new FileInputStream(file);

		    Workbook CommonUtilities = null;

		    //Find the file extension by splitting file name in substring  and getting only extension name

		    String fileExtensionName = fileName.substring(fileName.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    	CommonUtilities = new XSSFWorkbook(inputStream);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of HSSFWorkbook class

		    	CommonUtilities = new HSSFWorkbook(inputStream);

		    }


		    Sheet Login = CommonUtilities.getSheet(sheetName);



		        Row row = Login.getRow(rowNum);

		      
     String cellValue=row.getCell(cellNum).getStringCellValue();
     
   
     
     
     
		            //Print Excel data in console

		         //   System.out.print(row.getCell(cellNum).getStringCellValue()+"|| ");

		        

		     //   System.out.println();
				return cellValue;
		

	    }
	    
	    private void getData() {
			// TODO Auto-generated method stub
			
		}


		//Main function is calling readExcel function to read data from excel file

	    public static void main(String...strings) throws IOException{

	    //Create an object of ReadGuru99ExcelFile class

	    	CommonUtilities objExcelFile = new CommonUtilities();

	    //Prepare the path of excel file

	   // String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";

	    //Call read file method of the class to read data
	  
	    objExcelFile.readExcel("ExportExcel");

	    }
	    
*/

