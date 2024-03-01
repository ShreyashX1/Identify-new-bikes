package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class apache {
	
	public static void Excelutilsheaders(List<WebElement> head) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\xl files\\Cars.xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		//sheet.createRow(t).createCell(0).setCellValue(data);
		
		for(int i=0;i<head.size();i++) {
			HSSFRow row = sheet.createRow(i);
			row.createCell(0).setCellValue(head.get(i).getText());
			
		}
			
		workbook.write(file);
		workbook.close();
		file.close();
		
		
	}
}
