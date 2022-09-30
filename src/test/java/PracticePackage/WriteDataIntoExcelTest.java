package PracticePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws Throwable, Throwable {
		
		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet("Sheet1");
		Row ro = sh.getRow(0);
		Cell ce = ro.createCell(1);
		ce.setCellValue("Bangalore");
		FileOutputStream fo= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fo);
		wb.close();
		
		

	}

}
