package searchcollege1;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{
	public static String getUrl()throws Exception 
	{
		FileInputStream file =new FileInputStream("C:\\Users\\2318453\\eclipse-workspace\\searchcollege\\src\\test\\java\\searchcollege1\\ExcelData\\CollegeSearch.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		String input =  cell.toString();
		return input;
	}
}
