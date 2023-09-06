package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static Object[][] readExcel(String excelFile) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./data/"+excelFile+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		short columncount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowcount][columncount];
		
		for(int i = 1 ; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			for( int j = 0; j < columncount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j]=cell.getStringCellValue();
			}
		}
		book.close();
		return data;
	}

}
