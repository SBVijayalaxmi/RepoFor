package PracticePackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet("Sheet1");
		Row ro = sh.getRow(0);
		String value = ro.getCell(0).getStringCellValue();
		System.out.println(value);
		wb.close();

	}

}
