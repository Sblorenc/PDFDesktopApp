package openjfx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
	public List <String> createListOfIndex (File excelFile) {
		List <String> ICIndex = new ArrayList();
		
		try {
			FileInputStream inputStream = new FileInputStream(excelFile);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			for (Row r : sheet) {
				Cell c = r.getCell(0);
				if (c!=null) {
					ICIndex.add(c.getStringCellValue());
					
				}
			}
			inputStream.close();
		} catch (IOException e) {
			ICIndex = null;
		} 
		
		
	return ICIndex;}

}
