package testCases;

import org.apache.poi.ss.usermodel.DataFormatter;

import utilities.CommonUtilities;

public class testing {
	
	//CommonUtilities	cu = new CommonUtilities();
	public static void main(String args[])  
	{  // Only need one of these
		DataFormatter fmt = new DataFormatter();

		// Once per cell
		
		
		CommonUtilities	cu = new CommonUtilities();
		
		//String valueAsSeenInExcel = fmt.formatCellValue(cu.getCellData("Add_Products", "Product_Weight"));
	System.out.println(cu.getCellData("Add_Products", "Product_Weight"));
	}

}
